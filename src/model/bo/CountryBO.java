package model.bo;

import java.util.List;

import model.bean.Country;
import model.dao.CountryDB;

public class CountryBO {
	
	CountryDB countrDB = new CountryDB();
	
	//list country
		public List<Country> getListCountry() {
			return countrDB.getList();
		}
}
