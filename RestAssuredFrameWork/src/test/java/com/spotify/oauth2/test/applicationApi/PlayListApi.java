package com.spotify.oauth2.test.applicationApi;

import static io.restassured.RestAssured.given;
import com.spotify.oauth2.api.specBuilder;
import com.spotify.oauth2.pojo.PlayList;
import com.spotify.oauth2.utils.configProvider;

import static com.spotify.oauth2.api.Endpoints.PLAYLIST;
import static com.spotify.oauth2.api.Endpoints.USER;
import io.restassured.response.Response;

public class PlayListApi {
	


	public static Response post(PlayList requestBody) {
		
		return RestResource.post(USER + configProvider.getProperty().Post_user_id() +"/playlists", TokenGenerationUtility.get_token(), requestBody);
	
	}
	
	
	
	public static Response get(String playlistId) {
		
		return RestResource.get(PLAYLIST + playlistId , TokenGenerationUtility.get_token());
		
		 
	}
	
	
	public static Response put(PlayList RequestBody , String playlistId) {
		
		return RestResource.put(RequestBody, PLAYLIST + playlistId, TokenGenerationUtility.get_token());
		
		
		
	}
	
}
