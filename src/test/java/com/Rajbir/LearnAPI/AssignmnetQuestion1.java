package com.Rajbir.LearnAPI;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class AssignmnetQuestion1 {
	
	 int id;float price;
	 String name;
	 String type;
	 
	@BeforeMethod
	public void setup() {
		baseURI="http://localhost:3030";
	}

	
	
	@Test(priority =1)
	public void getProducts() {
	given()
	.get("/products")
		.then().statusCode(200).log().all();
		
	}
	
	  @Test (priority=2)
	  public void getProductid() 
	  { 
		  Response response= given()
					.when().get("/products");
					
				id = response.getBody().jsonPath().get("data[1].id");
				 name=response.getBody().jsonPath().get("data[1].name");
			 type=response.getBody().jsonPath().get("data[1].type");
				  price=response.getBody().jsonPath().get("data[1].price");
				
				
	  
	  }
	  @Test (priority=3)
	  public void getSingleProductAndVerifyDetails() 
	  { 
	given().pathParam("id",id)
	  .when().get("/products/{id}") 
	  .then().statusCode(200).log().all()
	   .and().assertThat().body ("id",equalTo(id))
	  .and().assertThat().body ("name",equalTo(name))
	   .and().assertThat().body ("type",equalTo(type))
	   .and().assertThat().body ("price",equalTo(price));
	  
	  
	  }
	 
	  
		

		@Test(priority=4) 
		public void RemoveProducts(){
	     given().pathParam("id",id)
		.delete("/products/{id}")
			.then().statusCode(200).log().all();
			
		}
	  
	 
	


}
