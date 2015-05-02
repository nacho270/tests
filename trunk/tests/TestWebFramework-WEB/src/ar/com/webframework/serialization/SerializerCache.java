package ar.com.webframework.serialization;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ar.com.webframework.controller.annotations.ControllerOutputType;

public class SerializerCache {

	private static Map<String, ISerializer> serializers = new ConcurrentHashMap<String, ISerializer>();
	
	static{
		serializers.put(ControllerOutputType.JSON, new  JSONSerializer());
		serializers.put(ControllerOutputType.XML, new  XMLSerializer());
	}
	
	public static void registerSerializer(String name, ISerializer serializer){
		serializers.put(name, serializer);
	}
	
	public static ISerializer getSerializer(String name){
		return serializers.get(name);
	}
}
