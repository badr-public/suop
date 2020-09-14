//package br.com.badr.gw.control;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import br.com.badr.common.entity.Response;
//
//public class PendingRequestControl {
//
//	private Map<String, Response> responses = new HashMap<>();
//	
//	private static PendingRequestControl ich;
//	
//	public static PendingRequestControl get() {
//		if (ich == null) {
//			ich = new PendingRequestControl();
//		}
//		return ich;
//	}
//	
//	public void add(String messageReference, Response response) {
//		responses.put(messageReference, response);
//	}
//	
//	public void setResponse(String messageReference, Object obj) {
//		if (responses.containsKey(messageReference)) {
//			Response response = responses.get(messageReference);
//			response.obj = obj;
//			synchronized (response) {
//				response.notify();
//			}
//		}
//	}
//	
//}
