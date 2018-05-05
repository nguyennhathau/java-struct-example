package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Country;


public class CountryDB {
	public List<Country> getList(){
		Connection con = ConnectDB.getConnection();
		String sql = "select * from Country";
		ArrayList<Country> listcountry = new ArrayList<>();
		try {
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				int countryID = rs.getInt("CountryID");
				String countryName = rs.getString("CountryName");
				
				listcountry.add(new Country(countryID, countryName));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listcountry;
	}
}
