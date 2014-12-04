import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class RecipeTest {

	@Test
	public void newNameTest() {
		String a = "Recipe1234";
		
		Recipe newRecipe = new Recipe("ID", a);
		assertEquals("Fail - Recipe names should be the same", newRecipe.getRecipeName(),a);		
	}
	@Test
	public void jsonTest() {
		JsonParser parser = new JsonParser();
		JsonObject yummlyJsonObject = (JsonObject) parser.parse("{\"imageUrlsBySize\":{\"90\":\"http://lh3.ggpht.com/PLgp7yDXN5ouTNHx4RP90Sz9H0NwQD47iYuwzKDq8KY0wTSkzyH1bAaQsJI9Yt5fF6Li_oTgbKbCzO8F-_f0-0s=s90-c\"},\"sourceDisplayName\":\"Smitten Kitchen\",\"ingredients\":[\"unsalted butter\",\"confectioners sugar\",\"key lime\",\"lime juice\",\"pure vanilla extract\",\"all-purpose flour\",\"corn starch\",\"salt\"],\"id\":\"Key-lime-meltaways-307136\",\"smallImageUrls\":[\"http://lh6.ggpht.com/uoLs7QcZbf5CBtNQmr4rQ0gSHXgt7uIL-7WETTWJ3UwIkhqGycLDKNUT9H-am6kaQpBfSf2kigLKfeqH2BVqW54=s90\"],\"recipeName\":\"Key Lime Meltaways\",\"totalTimeInSeconds\":5400,\"attributes\":{\"course\":[\"Desserts\"],\"holiday\":[\"Christmas\"]},\"flavors\":{\"sweet\":0.16666666666666666,\"sour\":0.6666666666666666,\"salty\":0.3333333333333333,\"piquant\":0.0,\"meaty\":0.5,\"bitter\":0.16666666666666666},\"rating\":5}");

		Recipe newRecipe = null;
		try {
			newRecipe = new Recipe(yummlyJsonObject);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		assertEquals("Fail - Name does not match", newRecipe.getRecipeName(), "Key Lime Meltaways");
		assertEquals("Fail - Recipe ID does not match", newRecipe.getID(), "Key-lime-meltaways-307136");
		assertNotNull("Fail - Recipe Image URL is NULL", newRecipe.getImageURL());
	}

}
