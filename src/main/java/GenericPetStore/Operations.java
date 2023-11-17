package GenericPetStore;

import static io.restassured.RestAssured.*;

import java.io.File;

import genericUtilities.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclasses.Category;
import pojoclasses.Pet;
import pojoclasses.Tags;

public class Operations {
	public static int ran() {
		JavaUtility ju=new JavaUtility();
		return ju.getRandom();	
	}
   public static Response createPet()
   {    
	   Category cat=new Category(1, "PETS");
	   Category c=cat;
	   String [] urls= {"Huskey","Lab","German_Sepherd","Rott_KING"};
	   Tags tag=new Tags(1, "TAG NAME");
	   Tags [] t= {tag};
	   Pet pet=new Pet(232, c, "Tommy", urls, t, "Denied");
	   Response res = given().body(pet).contentType(ContentType.JSON)
	   .when().post(Endpoints.postEndpoint);
	return res;
   }
   public static Response readPet() {	   
	   Response res = given().contentType(ContentType.JSON).pathParam("id", 232)
			   .get(Endpoints.getEndpoint+"/{id}");
	   return res; 
   }
   public static Response updatePet() {
	   Category cat=new Category(2, "PET CATS");
	   Category c=cat;
	   String [] urls= {"Scottish_Fold","Russian_Blue","British_Shorthair","American Shorthair"};
	   Tags tag=new Tags(2, "Cats_Army");
	   Tags [] t= {tag};
	   Pet pet=new Pet(310,c,"Chinnu",urls,t,"Available");
	   Response res = given().body(pet).contentType(ContentType.JSON)
			   .when().put(Endpoints.putEndpoint);
			return res;
	   
   }
   public static Response readAfterUpdating() {
	   Response res = given().contentType(ContentType.JSON).pathParam("id", 310)
			   .get(Endpoints.getEndpoint+"/{id}");
	   return res;    
   }
  public static Response uploadImageInPetStore(){
	  baseURI="https://petstore.swagger.io/v2";
		//String image="C:\\Users\\lenovo\\Pictures\\Screenshots\\Screenshots(29).png";
		String fi="C:\\Users\\lenovo\\Desktop\\resumes\\MADHUSUDHANA RAO 3.1 year exp .pdf";
		Response res = given().formParam("additionalMetadata", "\u001B[32m"+"This is .pdf format file"+"\u001B[0m")
		.multiPart("file",new File(fi)).pathParams("rpath","pet","id",310,"img","uploadImage")
		.when().post("/{rpath}"+"/{id}"+"/{img}");
		return res;
  }
  public static Response deletePet() {
	  Response res = given().contentType(ContentType.JSON).pathParam("id", 310)
			   .delete(Endpoints.deleteEndpoint+"/{id}");
	   return res;    
  }
}