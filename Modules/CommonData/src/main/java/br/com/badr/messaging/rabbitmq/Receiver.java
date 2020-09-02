//package br.com.badr.messaging.rabbitmq;
//
//import java.util.concurrent.CountDownLatch;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class Receiver {
//
//	private CountDownLatch latch = new CountDownLatch(1);
//
//	public void receiveMessage(MsgTest message) {
//	    System.out.println("Received <" + message.name + ">");
//	    latch.countDown();
//	}
//
//	public CountDownLatch getLatch() {
//	    return latch;
//	}	
//	
//}
