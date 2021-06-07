package com.spotify.oauth2.test.applicationApi;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import com.spotify.oauth2.api.specBuilder;
import com.spotify.oauth2.pojo.PlayList;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestResource {
	
//	static String accessToken="BQA4Tgpf8SGOwhqxzgE8QBEO0Z18rr12eYmP4gLa4Vff0t4iGb6yhH1cnGFJKRYwEGlp5BULWNUOBYV_vdlPBg6rhhkQaQrJVUMACNi4E81fhIKW5Bi5wjVAMTiM0OejMJ_PpLbaCqVvIvqUKswwpYdcQ9xZ-mVQq8roeD9SnGbCWIYigVHo3RdU2WBQWBKhNdvK-oeK40hpyWNpgFNxT6iUsITGZVCHAAu610dADnxf";


	public static Response post(String path ,String access_tokn ,  Object requestBody) {
		return given(specBuilder.getRequestSpec()).
				when().
				body(requestBody).
				header("Authorization", "Bearer " + access_tokn).
				post(path).
				then().spec(specBuilder.getResponseSpec()).
				extract().
				response();		
	}
	
	
	
	public static Response get(String path ,String access_tokn) {
		return given(specBuilder.getRequestSpec()).
		when().
		header("Authorization", "Bearer " + access_tokn).
		get(path).
		then().spec(specBuilder.getResponseSpec()).
		extract().
		response();
		 
	}
	
	
	public static Response put(Object RequestBody , String path , String access_tokn) {
		return given(specBuilder.getRequestSpec()).
		when().
		header("Authorization", "Bearer " + access_tokn).
		body(RequestBody).
		put(path).then().extract().response();
		
	}
	
	public static Response get_token(HashMap<String ,Object> formParams) {
		return given(specBuilder.tokenSpec()).
		formParams(formParams).contentType(ContentType.URLENC).
		post().then().log().all().extract().response();
		
	}
}
