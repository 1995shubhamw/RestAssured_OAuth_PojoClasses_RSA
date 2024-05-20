package pojo;
import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;

public class OAuth_GetCourse 
{

	public static void main(String[] args) 
	{
		
		//To get accessToken
		
		
String response=given().log().all().formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
		.then().extract().asString();
	
	     System.out.println(response);
	     
	     JsonPath js=new JsonPath(response);
	    String accessToken= js.getString("access_token");
	    
	    System.out.println(accessToken);
	    
	    
	    //use access token to get course details
	    
	    String courseDetails=given().log().all().queryParam("access_token",accessToken)
	    .when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails")
	    .then().extract().asString();
	    
	    System.out.println(courseDetails);
	    

	}
}
