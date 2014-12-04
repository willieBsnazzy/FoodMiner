import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Request {

	String keywords;
	String ingredients[];
	private int Kcal = Integer.MAX_VALUE; 
	private int searchType;
	private int cookTime;
	private String appID = "e4b2cd7b";
	private String appKey = "c279435b2ca7e4448fb40403d380288a";
	private String url = "http://api.yummly.com/v1/api/recipes?";
	private URL RequestURL;
	private HttpURLConnection connection;

	// Basic Search //
	Request( String Ingredients){
		this.keywords = Ingredients;
		this.searchType = 0;
	}
	
	// Advanced Search // Add arguments!!!
	Request( Search searchInput ){
		this.keywords = searchInput.getKeywords();
		this.ingredients = searchInput.getKeywords().split("%5B");
		this.Kcal = searchInput.getKcal();
		this.searchType = searchInput.getSearchType();
		this.cookTime = searchInput.getCookTime();
	}
	
	JsonObject sendPost() throws Exception {
	
		// Keyword Search
		if(searchType == 0){
			
			RequestURL = new URL(url + "&q=" + keywords + "&nutrition.ENERC_KCAL.max=" + Kcal + "&requirePictures=true"); // base URL + basic keywords + pictures required
		}
		// Ingredient allowed search
		else if(searchType == 1){
			String baseURL = url;
			for(int i=0; i < ingredients.length; i++){
				baseURL = baseURL + "&allowedIngredients[]=" + ingredients[i];
			}			
			RequestURL = new URL(baseURL + "&nutrition.ENERC_KCAL.max=" + Kcal + "&requiredPictures=true");
		}
		// Exclude Ingredient search
		else if(searchType == 2){ 
			String baseURL = url;
			for(int i=0; i < ingredients.length; i++){
				baseURL = baseURL + "&excludedIngredients[]=" + ingredients[i];
			}			
			RequestURL = new URL(baseURL + "&nutrition.ENERC_KCAL.max=" + Kcal + "&requiredPictures=true");
		}
		//
		System.out.println(RequestURL.toString());
		connection = (HttpURLConnection) RequestURL.openConnection();  
	
		// Request Header //	
		connection.setRequestMethod("GET");
		connection.addRequestProperty("X-Yummly-App-ID", appID);
		connection.addRequestProperty("X-Yummly-App-Key", appKey);
		System.out.println(connection.getRequestProperties());
		
		// Send GET request
		connection.setDoOutput(true);
		
		int responseCode = connection.getResponseCode();
		System.out.println("\nSending '" + connection.getRequestMethod() + "' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		String jsonString = response.substring(0);
		in.close();
 
		//print result
      
		//System.out.print(jsonString);
		JsonElement jsonRetData = new JsonParser().parse(jsonString);
		
		//Check for valid response 
		if(jsonRetData.isJsonNull() == true){
			System.out.println("Results are Null");
			return null;
		}
		JsonObject jsonRetObject = jsonRetData.getAsJsonObject();
		//System.out.print(jsonRetData);
		return jsonRetObject;
	
	}
		

	
	
	
}
