//package br.com.badr.gw.control;
//
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
//import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import br.com.badr.common.ConsumerIf;
//import br.com.badr.common.entity.Message;
//
//@Component
//public class ConsumerComponent implements ConsumerIf<Message> {
//
//	@Bean
//	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//			MessageListenerAdapter listenerAdapter) {
//		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//		container.setConnectionFactory(connectionFactory);
//		container.setQueueNames("gwOut");
//		container.setMessageListener(listenerAdapter);
//		return container;
//	}
//
//	@Bean
//	MessageListenerAdapter listenerAdapter(ConsumerComponent receiver) {
//		return new MessageListenerAdapter(receiver, receiveMessage);
//	}
//
//	@Override
//	public void receiveMessage(Message msg) {
//		PendingRequestControl.get().setResponse(msg.messageReference, msg.obj);
//	}
//	
//}
