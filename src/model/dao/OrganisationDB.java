package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Organisation;

public class OrganisationDB {
	public List<Organisation> getListOrgan(){
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM Organisation";
		ArrayList<Organisation> listOrganisation = new ArrayList<>();
		try {
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				String organisationName = rs.getString("OrganisationName");
				String organisationShortDes = rs.getString("OrganisationShortDescription");
				String leadContact = rs.getString("LeadContact");
				String adddressLine1 = rs.getString("Address1");
				String adddressLine2 = rs.getString("Address2");
				String adddressLine3 = rs.getString("Address3");
				String postcode = rs.getString("PostCode");
				String town = rs.getString("City");
				String county = rs.getString("County");
				int countryID = rs.getInt("CountryID");
				String typeOfBusiness = rs.getString("TypeOfBusiness");
				int sicCode = rs.getInt("SIScode");
				String organisationFullDes = rs.getString("OrganisationFullDescription");
				String phone = rs.getString("PhoneNumber");
				String fax = rs.getString("Fax");
				String email = rs.getString("Email");
				String webAddress = rs.getString("WebAddress");
				listOrganisation.add(new Organisation(organisationName, organisationShortDes, leadContact, adddressLine1, adddressLine2, adddressLine3, postcode, town, county, countryID, typeOfBusiness, 
						sicCode, organisationFullDes, phone, fax, email, webAddress));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOrganisation;
	}
	
	public Organisation getOrganbyName(){
		Organisation organ= null;
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT * FROM Organisation where OrganisationName = 'Nha Nuoc'";
		try {
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				String organisationName = rs.getString("OrganisationName");
				String organisationShortDes = rs.getString("OrganisationShortDescription");
				String leadContact = rs.getString("LeadContact");
				String adddressLine1 = rs.getString("Address1");
				String adddressLine2 = rs.getString("Address2");
				String adddressLine3 = rs.getString("Address3");
				String postcode = rs.getString("PostCode");
				String town = rs.getString("City");
				String county = rs.getString("County");
				int countryID = rs.getInt("CountryID");
				String typeOfBusiness = rs.getString("TypeOfBusiness");
				int sicCode = rs.getInt("SIScode");
				String organisationFullDes = rs.getString("OrganisationFullDescription");
				String phone = rs.getString("PhoneNumber");
				String fax = rs.getString("Fax");
				String email = rs.getString("Email");
				String webAddress = rs.getString("WebAddress");
				organ = new Organisation(organisationName, organisationShortDes, leadContact, adddressLine1, adddressLine2, adddressLine3, postcode, town, county, countryID, typeOfBusiness, 
						sicCode, organisationFullDes, phone, fax, email, webAddress);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return organ;
	}
}
