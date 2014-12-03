import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Request {

	String ingredients;
	int Kcal; 
	private String appID = "e4b2cd7b";
	private String appKey = "c279435b2ca7e4448fb40403d380288a";
	private String url = "http://api.yummly.com/v1/api/recipes?";

	// Basic Search //
	Request( String Ingredients){
		this.ingredients = Ingredients;
	}
	
	// Advanced Search // Add arguments!!!
	Request( String ingredients, int Kcal ){
		this.ingredients = ingredients;
		this.Kcal = Kcal; 
	}
	
	JsonObject sendPost() throws Exception {
	
		//
		URL RequestURL = new URL(url + "&q=" + ingredients + "&requirePictures=true"); // base URL + basic keywords + pictures required
		HttpURLConnection connection = (HttpURLConnection) RequestURL.openConnection();  
	
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
