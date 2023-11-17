package apiTests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.Operations;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class Testclass {

	 @Test
	 public void testCreate() 
	 {
		 Response res = Operations.createUser();
		 res.then()
		 .contentType(ContentType.JSON)
		 .assertThat()
		 .statusCode(201).log().all();
		 
		 String expName=Operations.name;
		 
		 String actName = res.jsonPath().getString("name");
		 
			//res.prettyPeek();
		
			//Validating using contains function
			Assert.assertEquals(actName.contains("madhu"),true,"\u001B[31m"+"Validation with contains is NOT successfull"+"\u001B[0m");
			// validating with Entire String
			Assert.assertEquals(actName,expName,"\u001B[31m"+"Validation with full String is NOT successfull"+"\u001B[0m");
			
			System.out.println("\u001B[32m"+"Verified......"+"\u001B[0m");
	
			
	 }
	
	 @Test
	 public void testGet() {
		 Response res =Operations.getUserNotFind();
		 res.then().log().all().assertThat().statusCode(404);
		 System.out.println("succes");
	 }
	 @Test
	 public void colorPrinting() {
		 System.out.println("\u001B[1m"+"\u001B[32m"+"MADHUSUDHANA RAO DANDE"+"\u001B[0m");
	 }
	 @Test
	 public void postR() {
		 baseURI="https://reqres.in";
		 JSONObject js=new JSONObject();
		 js.put("name", "madhu"+Operations.ran());
		 js.put("job", "test");
		 given().contentType(ContentType.JSON)
		 .header("MADHU", "DANDE")
		 .body(js.toJSONString())
		 
		 .when().post("/api/users")
		 .then().log().all();
		 
	 }
}
