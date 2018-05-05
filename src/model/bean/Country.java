package model.bean;

public class Country {
	private int countryID;
	private String countryName;
	
	
	public Country() {
	}


	public Country(int countryID, String countryName) {
		super();
		this.countryID = countryID;
		this.countryName = countryName;
	}


	public int getCountryID() {
		return countryID;
	}


	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	

	
	
	
}
