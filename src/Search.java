// takes input for search
public class Search {
	private String Keywords;
	private int Kcal = 2000;
	private int searchType;
	private int cookTime = 0;
	
	Search(String Keywords){
		Keywords.replaceAll("[^a-zA-Z]", "");
		this.Keywords = Keywords.replace(" ", "%5B"); 
		System.out.println(this.Keywords);
	}
	
	// advanced search instantiation (could replace other search)
	Search(String Keywords, int searchType, int Kcal, int cookTime){
		Keywords.replaceAll("[^a-zA-Z]", "");
		this.Keywords = Keywords; 	
		this.Kcal = Kcal == 0 ? Integer.MAX_VALUE : Kcal;
		this.cookTime = cookTime == 0 ? Integer.MAX_VALUE: cookTime;		
		this.searchType = searchType;
	}
	
	public String getKeywords(){
		return this.Keywords;
	}

	public int getKcal() {
		return this.Kcal;
	}

	public void setKcal(int kcal) {
		Kcal = kcal;
	}

	public int getSearchType() {
		return searchType;
	}

	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}

	public int getCookTime() {
		return cookTime;
	}

	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}
	
	
}
