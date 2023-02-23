package com.Rajbir.LearnAPI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class JiraAPI {
	String authorization="Basic cmFqYmlyam9nYXIuN0BnbWFpbC5jb206QVRBVFQzeEZmR0YwX0dwVmZvQlpIdWpLWFV4Szl6NTk4dE1VX1hJYUx6S3AzeEl4QUNBamNXeUVMZFpPUjVpWGMzazVXLWhZR204QUJsaEt5R01oc3FCMGI3aVUyWWx6Sk1FbW1NZ0tlZDZydFdSQ3dGeXpVZEs1X2FQZ2lQTlk2S2dmVkpOM1BqM2ZrSGRObXRmajNEUkVDTEhoMmhjRGJHWHdFTDhKTGhzNmdPWEgtLVIyak0wPTdEOEM0REZE";
	@BeforeMethod
	public void setup() {
		baseURI="https://rajbirkaur.atlassian.net";
	}
	@Test
	public void createIssueMetaData() {
		/*
		 * given().header("Authorization",authorization)
		 * .when().get("/rest/api/3/issue/createmeta")
		 * .then().statusCode(200).log().all();
		 */
		Response response=given().header("Authorization",authorization)
				.when().get("/rest/api/3/issue/createmeta");
		String storyId=response.getBody().jsonPath().get("projects[0].issuetypes[0].id");
		System.out.println(storyId);
	}
	
	@Test
	public void createIssue() {
		
	}
	

}
