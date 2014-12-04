import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.JsonObject;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public class Recipe {
	
	private String Name;
	private String ID;
	private Array Ingredients;
	private String Cuisine;
	private int Kcal;
	private URL ImageURL;
	private URL RecipeURL;
	private int PrepTime;
	private int index;
	
	Recipe(JsonObject yummlyJsonRecipe) throws MalformedURLException{
		this.Name  = yummlyJsonRecipe.get("recipeName").getAsString();  // Copies recipe name
		this.setImageURL(new URL(yummlyJsonRecipe.getAsJsonObject("imageUrlsBySize").get("90").getAsString())); // copies Image URL
		this.ID = yummlyJsonRecipe.get("id").getAsString();
//		this.PrepTime = 
//		this.Kcal = 
//		this.Cuisine = 
//		while(){
//		this.Ingredients =
//		}
		//this.ImageURL = new URL(yummlyJsonRecipe.getAsJsonArray("smallImageURLs").get(0).getAsString());
	}
	
	Recipe(String ID, String Name){
		this.setID(ID);
		this.Name = Name;
	}

	void setDetails(JsonObject yummlyJsonRecipeDetailed) throws MalformedURLException{
		String URLString = yummlyJsonRecipeDetailed.getAsJsonObject("source").get("sourceRecipeUrl").getAsString();
		this.setRecipeURL(new URL(URLString));
	}
	
	void setName(String Name){
		this.Name = Name;
	}
	
	void setIngredients(Array Ingredients){
		this.Ingredients = Ingredients;
	}
	String getRecipeName(){
		return this.Name;
	}

	public URL getImageURL() {
		return ImageURL;
	}

	public void setImageURL(URL imageURL) {
		ImageURL = imageURL;
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getCuisine() {
		return Cuisine;
	}

	public void setCuisine(String cuisine) {
		Cuisine = cuisine;
	}

	public int getKcal() {
		return Kcal;
	}

	public void setKcal(int kcal) {
		Kcal = kcal;
	}

	public int getPrepTime() {
		return PrepTime;
	}

	public void setPrepTime(int prepTime) {
		PrepTime = prepTime;
	}

	public URL getRecipeURL() {
		return RecipeURL;
	}

	public void setRecipeURL(URL recipeURL) {
		RecipeURL = recipeURL;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}

