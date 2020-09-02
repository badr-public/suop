package br.com.badr.commondata.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.badr.common.ConsumerIf;
import br.com.badr.common.entity.Message;
import br.com.badr.common.entity.User;
import br.com.badr.commondata.repository.UserRepository;

@Component
public class UserConsumer implements ConsumerIf<Message> {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public static final String topicExchangeName = "commonDataBroadcast";
	public static final String queueName = "commonData";
	public static final String newUserKey = "user.new";
	
	private static Map<Integer, User> usersCache = new HashMap<>();

	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames("commonDataUserNew");
		container.setMessageListener(listenerAdapter);
		return container;
	}

	@Bean
	MessageListenerAdapter listenerAdapter(UserConsumer receiver) {
		return new MessageListenerAdapter(receiver, receiveMessage);
	}

	@Override
	public void receiveMessage(Message msg) {
		User user;
		if (msg.obj != null
				&& msg.obj instanceof User) {
			Integer id = ((User) msg.obj).id;
			if (!usersCache.containsKey(id)) {
				user = repository.save((User) msg.obj);
				usersCache.put(user.id, user);
			}
			else {
				user = usersCache.get(id);
			}
			publish(msg.messageReference, user);
		}
	}

	public String publish(String messageReference, User user) {
		rabbitTemplate.convertAndSend(topicExchangeName, newUserKey, new Message(messageReference, user));
		return messageReference;
	}
	
	
	
}
