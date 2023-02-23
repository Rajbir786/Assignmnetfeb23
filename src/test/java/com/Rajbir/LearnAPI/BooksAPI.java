package com.Rajbir.LearnAPI;


import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BooksAPI {
	
@BeforeMethod
public void setup() {
	baseURI="https://simple-books-api.glitch.me";
}
@Test
public void getSingleBook() {
	given().pathParam("bookId", 3)
	.when().get("/books/{bookId}")
	.then().statusCode(200).log().all()
	.and().assertThat().body("name",equalTo("The Vanishing Half"))
	.and().assertThat().body("id",notNullValue())
	.and().assertThat().body("available",equalTo(true));
	
	
}
@Test
public void getListOFBook() {
	given().param("type", "fiction")
	.when().get("/books")
	.then().statusCode(200).log().all();
	
	
	
}
@Test
public void ApiAuthentication() {
	
	
}
}