package com.spotify.oauth2.test.applicationApi;

import java.util.HashMap;

import com.spotify.oauth2.utils.configProvider;

import io.restassured.response.Response;

public class TokenGenerationUtility {

 public static String get_token() {
		
		
		HashMap<String , Object> formHeaders = new HashMap();
		formHeaders.put("grant_type", configProvider.getProperty().grant_type());
		formHeaders.put("refresh_token", configProvider.getProperty().refresh_token());
		formHeaders.put("client_id", configProvider.getProperty().getClient_id());
		formHeaders.put("client_secret", configProvider.getProperty().client_secret());
		
		
		Response response = RestResource.get_token(formHeaders);
			
		if(response.statusCode() != 200) {
			throw new RuntimeException("Abort !! token generation failed");
		}
		else
			return response.path("access_token");
	}
	
}

