package apiTests;

import static io.restassured.RestAssured.*;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetStore  {
	
	@Test(priority=1)
	public void create()
	{
		baseURI="https://petstore.swagger.io/v2";
		HashMap<String, Object> map=new HashMap<String, Object>();
		
		map.put("id",232);
		map.put("name","BlackDog");
		map.put("status","available");

		Response res = given().contentType(ContentType.JSON).body(map)
		.when().post("/pet");
		 int idno = res.jsonPath().get("id");
		System.err.println(idno);
		res.then().log().all();
	}
	@Test(priority=2)
	public void read()
	{
		baseURI="https://petstore.swagger.io/v2";
		when().get("/pet/232").then().log().all();
	}

	@Test(priority=3)
	public void responseBodyValidation()
	{
		baseURI="https://petstore.swagger.io/v2";
		Response res = when().get("/pet/232");
		int actual = res.jsonPath().get("id");
		System.out.println(actual);
		int Expected=232;
		Assert.assertEquals(actual,Expected);
		System.out.println("its verified");
	}

	@Test(priority=4)
	public void update()
	{
		baseURI="https://petstore.swagger.io/v2";
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("id",232);
		map.put("name","BlackDog");
		map.put("status","out of stock");

		given().contentType(ContentType.JSON).body(map)
		.when().put("/pet")
		.then().log().all();
	}

	@Test(priority=5)
	public void readAfterUpdate()
	{
		baseURI="https://petstore.swagger.io/v2";
		when().get("/pet/232").then().log().all();
	}

	@Test (priority=6)
	public void validateAfterUpdate()
	{
		baseURI="https://petstore.swagger.io/v2";
		Response res = when().get("/pet/232");

		int actual=res.jsonPath().get("id");
		System.out.println(actual);
		int Expected=232;
		Assert.assertEquals(actual, Expected);
		System.out.println("its verified after updation");
	}
	@Test(priority=7)
	public void uploadImage()
	{
		baseURI="https://petstore.swagger.io/v2";
		String image="C:\\Users\\lenovo\\Pictures\\Screenshots\\Screenshots(29).png";
		Response res = given().multiPart("file",image)
		.when().post("/pet/2/uploadImage");
		String img = res.jsonPath().get("message");
		//System.err.println(img);
		res.then().log().all();
		Assert.assertEquals(img.contains("56 bytes"),true);
	}
	@Test(priority=8,dependsOnMethods = {"uploadImage"})
	public void delete()
	{
		baseURI="https://petstore.swagger.io/v2";
		when().delete("/pet/232").then().log().all();
	}






}