package br.com.badr.common.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.badr.common.entity.Message;
import br.com.badr.common.entity.User;

@Service
public class UserService {
	
	public static final String topicExchangeName = "commonData";
	public static final String queueName = "commonData";
	public static final String newUserKey = "user.new";

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	MessageReferenceService messageReferenceService;

	public String newUser(User user) {
		String messageReference = messageReferenceService.getNewMessageReference();
		rabbitTemplate.convertAndSend(topicExchangeName, newUserKey, new Message(messageReference, user));
		return messageReference;
	}
	
}
