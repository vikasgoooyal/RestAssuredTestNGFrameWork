package com.spotify.oauth2.test;

import org.testng.annotations.Test;

import com.spotify.oauth2.api.specBuilder;
import com.spotify.oauth2.pojo.PlayList;
import com.spotify.oauth2.test.applicationApi.PlayListApi;
import com.spotify.oauth2.utils.configProvider;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertSame;
import static io.restassured.RestAssured.given;

public class playListTest {	
	
	@Test
	public void testSuccessForCreatingPlayList() {
		
		PlayList requestBody = new PlayList().
				setName("new playlist2").
				setDescription("playlist 2 description").
				setPublic(false);	
		
		
		Response response = PlayListApi.post(requestBody);
		assertSame(response.statusCode(), 201);
		PlayList responseBody = response.as(PlayList.class);
		
		assertSame(responseBody.getName(), requestBody.getName());
		assertSame(responseBody.getDescription(), requestBody.getDescription());
		assertSame(responseBody.getPublic(), requestBody.getPublic());
	}
	
	
	@Test
	public void testSuccesForGetPlayList() {
		
		
		Response response = PlayListApi.get(configProvider.getProperty().get_user_id());
		assertSame(response.statusCode(), 200);
		PlayList responseBody = response.as(PlayList.class);

		assertNotNull(responseBody.getName());
		assertNotNull(responseBody.getDescription());
		assertNotNull(responseBody.getPublic());
	
	} 
	
	@Test
	public void testSuccessPlayListUpdate() {
		
		PlayList requestBody = new PlayList().
				setName("new playlist2 update").
				setDescription("playlist 2 description update").
				setPublic(false);		
		
		
		Response response = PlayListApi.put(requestBody , configProvider.getProperty().put_user_id());
		assertSame(response.statusCode(), 200);
	}
	
	
	@Test
	public void testFailureForBadRequestInPayLoad() {
		
		PlayList requestBody = new PlayList().
				setName("").
				setDescription("playlist 2 description").
				setPublic(false);	
		
		Response response = PlayListApi.post(requestBody);
		assertSame(response.statusCode(), 400);
		
		
		assertSame(response.path("error.message"), "Missing required field: name", "Value notequal");
		
	}
}
