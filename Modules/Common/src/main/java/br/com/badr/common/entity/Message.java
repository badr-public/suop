package br.com.badr.common.entity;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = -1931874881342959150L;

	public String messageReference;
	public String objType;
	public Object obj;

	public Message(String messageReference, Object obj) {
		this.messageReference = messageReference;
		this.obj = obj;
	}
	
}
