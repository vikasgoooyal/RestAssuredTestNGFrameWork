package com.spotify.oauth2.utils;

import java.util.Properties;

import javax.management.RuntimeErrorException;

public class configProvider {

	private final Properties properties ; 
	private static configProvider configProvider;
	
	private configProvider() {
		properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
	}
	
	public static configProvider getProperty() {
		if(configProvider == null) {
			configProvider=new configProvider();
		}
		
		return configProvider;
		
	}
	
	public String getClient_id() {
		String prop = properties.getProperty("client_id");
		if(prop != null)
		return prop;
		else
			throw new RuntimeException("property not found");
	}
	
	
	public String client_secret() {
		String prop = properties.getProperty("client_secret");
		if(prop != null)
		return prop;
		else
			throw new RuntimeException("property not found");
	}
	
	public String refresh_token() {
		String prop = properties.getProperty("refresh_token");
		if(prop != null)
		return prop;
		else
			throw new RuntimeException("property not found");
	}
	
	public String grant_type() {
		String prop = properties.getProperty("grant_type");
		if(prop != null)
		return prop;
		else
			throw new RuntimeException("property not found");
	}
	
	public String Post_user_id() {
		String prop = properties.getProperty("Post_user_id");
		if(prop != null)
		return prop;
		else
			throw new RuntimeException("property not found");
	}
	
	public String get_user_id() {
		String prop = properties.getProperty("get_user_id");
		if(prop != null)
		return prop;
		else
			throw new RuntimeException("property not found");
	}
	
	public String put_user_id() {
		String prop = properties.getProperty("put_user_id");
		if(prop != null)
		return prop;
		else
			throw new RuntimeException("property not found");
	}
	
	
}
