import java.net.MalformedURLException;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class RecipeArray extends ArrayList<Recipe>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Recipe Recipes;
	private int TotalMatchCount; 
	
	private static RecipeArray instance = null;
	protected RecipeArray(){
		// defend instantiation
	}
	public static RecipeArray getInstance(){
		if(instance == null) {
			instance = new RecipeArray();
		}
		return instance;
	}

	// Adds element to Singleton Array //
	
	void fillArray(JsonObject yummlyJsonResults){
		this.TotalMatchCount =  Integer.parseInt(yummlyJsonResults.get("totalMatchCount").toString()); // converts match string to int
		JsonArray jsonMatches = yummlyJsonResults.getAsJsonArray("matches");
		
		// print total count and recipe[0] name
	//	System.out.println("\n" + TotalMatchCount + jsonMatches.get(0).getAsJsonObject().get("recipeName").getAsString());

		// Creates array list
		for(int i=0; i < TotalMatchCount && i < 10; ++i){
			if(jsonMatches.get(i).isJsonObject()){
				Recipe addRecipe;
				try {
					if(jsonMatches.get(i).isJsonNull() == false){
						addRecipe = new Recipe(jsonMatches.get(i).getAsJsonObject());
						RecipeArray.getInstance().add(addRecipe);						
					}
					else{
						break;
					}
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
				System.out.println("\n"+RecipeArray.getInstance().get(i).getRecipeName());
			}
		}
	}
	
	int getTotalMatchCount(){
		return TotalMatchCount;
	}
	
	
	int maxIndex(){
		return RecipeArray.getInstance().size();
	}
}
