// takes input for search
public class Search {
	private String Keywords;
	private int Kcal;
	
	Search(String Keywords){
		Keywords.replaceAll("[^a-zA-Z]", "");
		this.Keywords = Keywords.replace(" ", "%5B"); // Still need to Delete dirty Input!!!!!!
		System.out.println(this.Keywords);
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
	
	
}
