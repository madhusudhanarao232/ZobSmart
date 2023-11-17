package GenericPetStore;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoclasses.Category;
import pojoclasses.Pet;
import pojoclasses.Tags;

public class Mapper {

	@Test
	
	public void mapperData() throws JsonGenerationException, JsonMappingException, IOException
	{
		   Category cat=new Category(0, "PETS");
		   //Category cat1=new Category(1, "pets");
		   Category c=cat;
		   String urls[]= {"Cat","Dog","Lion","Tiger"};
		   Tags tag=new Tags(0, "TAG_NAME");
		   Tags tag1=new Tags(1, "TAG_NAME1");
		   Tags [] t= {tag,tag1};
		   Pet pet=new Pet(123, cat, "Tommy", urls, t, "Status_Got");
		  
		   ObjectMapper m = new ObjectMapper();
		      
m.writerWithDefaultPrettyPrinter().writeValue(new File("./Mapper.json"), pet);
	}
}
/*
 * {
  "id": 0,
  "category": {
    "id": 0,
    "name": "string"
  },
  "name": "doggie",
  "photoUrls": [
    "string"
  ],
  "tags": [
    {
      "id": 0,
      "name": "string"
    }
  ],
  "status": "available"
}
*/
