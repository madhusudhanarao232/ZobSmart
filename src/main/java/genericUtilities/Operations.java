package genericUtilities;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclasses.User;

public class Operations {
	
	public static String name = "madhu"+ran();
	
	public static int ran() {
		JavaUtility ju=new JavaUtility();
		return ju.getRandom();	
	}
   public static Response createUser()
   {  
	   User user=new User(name, "test_Engineer");
	   
	   Response res = given()
	   .contentType(ContentType.JSON)
	   .body(user)
	   .when()
	   .post(EndPoints.createProject);
	return res;
   }
   public static Response getUserNotFind()
   {
	   Response res = given().
	   when().get(EndPoints.SingleUserNotFound);
	return res;  
   }
}
