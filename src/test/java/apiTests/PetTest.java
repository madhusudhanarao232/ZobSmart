package apiTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericPetStore.Operations;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetTest {

	@Test(priority=1)
	public void createPet() 
	{
		Response res = Operations.createPet();
        res.then().assertThat().statusCode(200)
        .contentType(ContentType.JSON).log().all();
		// validation
		String exp_Name = "Tommy";
		String act_Name = res.jsonPath().getString("name");
		Assert.assertEquals(act_Name, exp_Name,"\u001B[31m"+"Assertion Failed"+"\u001B[0m");
	}
	@Test(priority=2)
	public void readPetDetails() {
		Response res = Operations.readPet();
		res.then().log().all();
		// validation
		String act_status = res.statusLine();
		Assert.assertEquals(act_status.contains("OK"), true,"\u001B[31m"+"Assertion Failed"+"\u001B[0m");	
	}
	@Test(priority=3)
	public void updatePet()
	{
		Response res = Operations.updatePet();
		res.then().assertThat().statusCode(200)
		 .contentType(ContentType.JSON).log().all();
		// validation
		String exp_Name = "Chinnu";
		String exp_Breed = "Russian_Blue";
		String exp_TagName = "Cats_Army";
		String act_Name = res.jsonPath().getString("name");
		String act_Breed = res.jsonPath().getString("photoUrls[1]");
		String act_TagName = res.jsonPath().get("tags[0].name");
		Assert.assertEquals(act_Name, exp_Name,"\u001B[31m"+"Assertion Failed"+"\u001B[0m");
		Assert.assertEquals(act_Breed, exp_Breed,"\u001B[31m"+"Assertion Failed"+"\u001B[0m");
		Assert.assertEquals(act_TagName, exp_TagName,"\u001B[31m"+"Assertion Failed"+"\u001B[0m");
	}
	@Test(priority=4)
	public void readingAfterUpdating() {
		Response res = Operations.readAfterUpdating();
		res.then().log().all();
		// validation
		String act_status = res.statusLine();
		Assert.assertEquals(act_status.contains("OK"), true,"\u001B[31m"+"Assertion Failed"+"\u001B[0m");	
	}
	@Test(priority=5,dependsOnMethods = "updatePet")
	public void uplioadImg() throws Exception  {
		Response res = Operations.uploadImageInPetStore();
		res.then().log().all();
		// validation
		String img = res.jsonPath().get("message");
		//System.err.println(img);
		res.then().log().all();
		String exp="MADHUSUDHANA RAO 3.1 year exp .pdf";
		Assert.assertEquals(img.contains(exp),true,"\u001B[31m"+"Assertion Failed"+"\u001B[0m");
	}
	@Test(priority=6,dependsOnMethods = "updatePet")
	public void deletePetDetails() {
		Response res = Operations.deletePet();
		res.then().log().all();
		// validation
		int act_status_code = res.statusCode();
		Assert.assertEquals(act_status_code,200,"\u001B[31m"+"Assertion Failed"+"\u001B[0m");	
	}	
}
