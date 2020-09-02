//package br.com.badr.messaging.rabbitmq;
//
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Runner implements CommandLineRunner {
//
//  private final RabbitTemplate rabbitTemplate;
//  private final Receiver receiver;
//
//  public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
//    this.receiver = receiver;
//    this.rabbitTemplate = rabbitTemplate;
//  }
//
//  @Override
//  public void run(String... args) throws Exception {
//    System.out.println("Sending message...");
//    for (int i = 0; i < 100000; i++) {
//    	
//    	MsgTest msg = new MsgTest(); 
//    	msg.key = "foo.bar." + (i % 2 != 0 ? 1 : 2);
//    	msg.name = "Hello from RabbitMQ!";
//    	rabbitTemplate.convertAndSend(
//    			MessagingRabbitmqApplication.topicExchangeName, 
//    			msg.key, msg);
//    }
//    receiver.getLatch().await(1000000, TimeUnit.MILLISECONDS);
//  }
//
//}