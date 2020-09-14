package br.com.badr.common.entity;

public class Email {

	private String context;
	private String from;
	private String to;
	private String cc;
	private String bcc;
	private String subject;
	private String body;
	private boolean bodyIsHtml;
	
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getBcc() {
		return bcc;
	}
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public boolean isBodyIsHtml() {
		return bodyIsHtml;
	}
	public void setBodyIsHtml(boolean bodyIsHtml) {
		this.bodyIsHtml = bodyIsHtml;
	}
	
}
