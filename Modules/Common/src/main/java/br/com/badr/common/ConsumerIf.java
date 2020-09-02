package br.com.badr.common;

public interface ConsumerIf<T> {

	public static final String receiveMessage = "receiveMessage";
	
	void receiveMessage(T msg);
	
}
