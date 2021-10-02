package features.api;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class testRestAssure {
	
	final static String url="https://reqres.in";

	public static void main(String[] args) {
		getResponseBody();
	    getResponseStatus();

	}
	
	public static void getResponseBody(){
		given().when().get(url).then().log()
	      .all();
	
		given().queryParam("page","2")
			.when().get("https://reqres.in/api/users").then().assertThat().body(matchesJsonSchemaInClasspath("bodyResponse.json"));
	   }
	
	public static void getResponseStatus(){
		  int statusCode= given().queryParam("page","2")
	           .when().get("https://reqres.in/api/users").getStatusCode();
		  System.out.println("The response status is "+statusCode);

		  given().when().get(url).then().assertThat().statusCode(200);
	  }
}
