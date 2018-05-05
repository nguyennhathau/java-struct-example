package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.bean.Country;
import model.bean.Department;

public class DepartmentDB {
	public List<Department> getList(){
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT DepartmentName, DepartmentShortDescription, leadContact, Addressline1, Addressline2,"
				+ " Addressline3, PostCode, Town, County, CountryID, TypeofBusiness, OrganisationName, "
				+ "SICcode, FullDescription, PhoneNumber, Fax, Email, WebAddress, "
				+ "CASE WHEN Active = 1 THEN 'Yes' ELSE 'No' END AS Active FROM Department where Active = 1";
		ArrayList<Department> listDepartment = new ArrayList<>();
		try {
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				String departmentName = rs.getString("departmentName");
				String departmentShortDes = rs.getString("DepartmentShortDescription");
				String leadContact = rs.getString("leadContact");
				String copyAddressFrom = rs.getString("OrganisationName");
				String adddressLine1 = rs.getString("Addressline1");
				String adddressLine2 = rs.getString("Addressline2");
				String adddressLine3 = rs.getString("Addressline3");
				String postcode = rs.getString("PostCode");
				String town = rs.getString("Town");
				String county = rs.getString("County");
				int countryID = rs.getInt("CountryID");
				String typeOfBusiness = rs.getString("TypeofBusiness");
				int sicCode = rs.getInt("SICcode");
				String departmentFullDes = rs.getString("FullDescription");
				String phone = rs.getString("PhoneNumber");
				String fax = rs.getString("Fax");
				String email = rs.getString("Email");
				String webAddress = rs.getString("WebAddress");
				String active = rs.getString("Active");
				listDepartment.add(new Department(departmentName, departmentShortDes, leadContact, copyAddressFrom, 
						adddressLine1, adddressLine2, adddressLine3, postcode, town, county, countryID, typeOfBusiness, sicCode, 
						departmentFullDes, phone, fax, email, webAddress, active));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDepartment;
	}
	
	public List<Department> getListall(){
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT DepartmentName, DepartmentShortDescription, leadContact, Addressline1, Addressline2,"
				+ " Addressline3, PostCode, Town, County, CountryID, TypeofBusiness, OrganisationName, "
				+ "SICcode, FullDescription, PhoneNumber, Fax, Email, WebAddress, "
				+ "CASE WHEN Active = 1 THEN 'Yes' ELSE 'No' END AS Active FROM Department";
		ArrayList<Department> listDepartment = new ArrayList<>();
		try {
			PreparedStatement ps =con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				String departmentName = rs.getString("departmentName");
				String departmentShortDes = rs.getString("DepartmentShortDescription");
				String leadContact = rs.getString("leadContact");
				String copyAddressFrom = rs.getString("OrganisationName");
				String adddressLine1 = rs.getString("Addressline1");
				String adddressLine2 = rs.getString("Addressline2");
				String adddressLine3 = rs.getString("Addressline3");
				String postcode = rs.getString("PostCode");
				String town = rs.getString("Town");
				String county = rs.getString("County");
				int countryID = rs.getInt("CountryID");
				String typeOfBusiness = rs.getString("TypeofBusiness");
				int sicCode = rs.getInt("SICcode");
				String departmentFullDes = rs.getString("FullDescription");
				String phone = rs.getString("PhoneNumber");
				String fax = rs.getString("Fax");
				String email = rs.getString("Email");
				String webAddress = rs.getString("WebAddress");
				String active = rs.getString("Active");
				listDepartment.add(new Department(departmentName, departmentShortDes, leadContact, copyAddressFrom, 
						adddressLine1, adddressLine2, adddressLine3, postcode, town, county, countryID, typeOfBusiness, sicCode, 
						departmentFullDes, phone, fax, email, webAddress, active));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDepartment;
	}
	
	public List<Department> getListByFirstWord(String filter){
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT DepartmentName, DepartmentShortDescription, leadContact, Addressline1, Addressline2,"
				+ " Addressline3, PostCode, Town, County, CountryID, TypeofBusiness, OrganisationName, "
				+ "SICcode, FullDescription, PhoneNumber, Fax, Email, WebAddress, "
				+ "CASE WHEN Active = 1 THEN 'Yes' ELSE 'No' END AS Active FROM Department "
				+ "WHERE DepartmentName like '" + filter + "%'";
		ArrayList<Department> listDepartment = new ArrayList<>();
		try {
//			PreparedStatement ps =con.prepareStatement(sql);
			Statement st=con.createStatement();
//			ps.setString(1, filter);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				String departmentName = rs.getString("departmentName");
				String departmentShortDes = rs.getString("DepartmentShortDescription");
				String leadContact = rs.getString("leadContact");
				String copyAddressFrom = rs.getString("OrganisationName");
				String adddressLine1 = rs.getString("Addressline1");
				String adddressLine2 = rs.getString("Addressline2");
				String adddressLine3 = rs.getString("Addressline3");
				String postcode = rs.getString("PostCode");
				String town = rs.getString("Town");
				String county = rs.getString("County");
				int countryID = rs.getInt("CountryID");
				String typeOfBusiness = rs.getString("TypeofBusiness");
				int sicCode = rs.getInt("SICcode");
				String departmentFullDes = rs.getString("FullDescription");
				String phone = rs.getString("PhoneNumber");
				String fax = rs.getString("Fax");
				String email = rs.getString("Email");
				String webAddress = rs.getString("WebAddress");
				String active = rs.getString("Active");
				listDepartment.add(new Department(departmentName, departmentShortDes, leadContact, copyAddressFrom, 
						adddressLine1, adddressLine2, adddressLine3, postcode, town, county, countryID, typeOfBusiness, sicCode, 
						departmentFullDes, phone, fax, email, webAddress, active));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDepartment;
	}
	
	public List<Department> getListByDempActive(){
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT DepartmentName, DepartmentShortDescription, leadContact, Addressline1, Addressline2,"
				+ " Addressline3, PostCode, Town, County, CountryID, TypeofBusiness, OrganisationName, "
				+ "SICcode, FullDescription, PhoneNumber, Fax, Email, WebAddress, "
				+ "CASE WHEN Active = 1 THEN 'Yes' ELSE 'No' END AS Active FROM Department "
				+ "WHERE Active =1";
		ArrayList<Department> listDepartment = new ArrayList<>();
		try {
//			PreparedStatement ps =con.prepareStatement(sql);
			Statement st=con.createStatement();
//			ps.setString(1, filter);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				String departmentName = rs.getString("departmentName");
				String departmentShortDes = rs.getString("DepartmentShortDescription");
				String leadContact = rs.getString("leadContact");
				String copyAddressFrom = rs.getString("OrganisationName");
				String adddressLine1 = rs.getString("Addressline1");
				String adddressLine2 = rs.getString("Addressline2");
				String adddressLine3 = rs.getString("Addressline3");
				String postcode = rs.getString("PostCode");
				String town = rs.getString("Town");
				String county = rs.getString("County");
				int countryID = rs.getInt("CountryID");
				String typeOfBusiness = rs.getString("TypeofBusiness");
				int sicCode = rs.getInt("SICcode");
				String departmentFullDes = rs.getString("FullDescription");
				String phone = rs.getString("PhoneNumber");
				String fax = rs.getString("Fax");
				String email = rs.getString("Email");
				String webAddress = rs.getString("WebAddress");
				String active = rs.getString("Active");
				listDepartment.add(new Department(departmentName, departmentShortDes, leadContact, copyAddressFrom, 
						adddressLine1, adddressLine2, adddressLine3, postcode, town, county, countryID, typeOfBusiness, sicCode, 
						departmentFullDes, phone, fax, email, webAddress, active));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDepartment;
	}
	
	public List<Department> getListByDempActiveByWord(String filter){
		Connection con = ConnectDB.getConnection();
		String sql = "SELECT DepartmentName, DepartmentShortDescription, leadContact, Addressline1, Addressline2,"
				+ " Addressline3, PostCode, Town, County, CountryID, TypeofBusiness, OrganisationName, "
				+ "SICcode, FullDescription, PhoneNumber, Fax, Email, WebAddress, "
				+ "CASE WHEN Active = 1 THEN 'Yes' ELSE 'No' END AS Active FROM Department "
				+ "WHERE Active =1 AND DepartmentName like '" + filter + "%'";
		ArrayList<Department> listDepartment = new ArrayList<>();
		try {
//			PreparedStatement ps =con.prepareStatement(sql);
			Statement st=con.createStatement();
//			ps.setString(1, filter);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				String departmentName = rs.getString("departmentName");
				String departmentShortDes = rs.getString("DepartmentShortDescription");
				String leadContact = rs.getString("leadContact");
				String copyAddressFrom = rs.getString("OrganisationName");
				String adddressLine1 = rs.getString("Addressline1");
				String adddressLine2 = rs.getString("Addressline2");
				String adddressLine3 = rs.getString("Addressline3");
				String postcode = rs.getString("PostCode");
				String town = rs.getString("Town");
				String county = rs.getString("County");
				int countryID = rs.getInt("CountryID");
				String typeOfBusiness = rs.getString("TypeofBusiness");
				int sicCode = rs.getInt("SICcode");
				String departmentFullDes = rs.getString("FullDescription");
				String phone = rs.getString("PhoneNumber");
				String fax = rs.getString("Fax");
				String email = rs.getString("Email");
				String webAddress = rs.getString("WebAddress");
				String active = rs.getString("Active");
				listDepartment.add(new Department(departmentName, departmentShortDes, leadContact, copyAddressFrom, 
						adddressLine1, adddressLine2, adddressLine3, postcode, town, county, countryID, typeOfBusiness, sicCode, 
						departmentFullDes, phone, fax, email, webAddress, active));
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listDepartment;
	}
	
	public Department getDempByDepmName(String name){
		Connection con = ConnectDB.getConnection();
		Department depm = null;
		String sql = "SELECT DepartmentName, DepartmentShortDescription, leadContact, Addressline1, Addressline2,"
				+ " Addressline3, PostCode, Town, County, CountryID, TypeofBusiness, OrganisationName, "
				+ "SICcode, FullDescription, PhoneNumber, Fax, Email, WebAddress, "
				+ "CASE WHEN Active = 1 THEN 'Yes' ELSE 'No' END AS Active FROM Department "
				+ "WHERE Active =1 AND DepartmentName = '" + name + "'";
		try {
//			PreparedStatement ps =con.prepareStatement(sql);
			Statement st=con.createStatement();
//			ps.setString(1, filter);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()){
				String departmentName = rs.getString("departmentName");
				String departmentShortDes = rs.getString("DepartmentShortDescription");
				String leadContact = rs.getString("leadContact");
				String copyAddressFrom = rs.getString("OrganisationName");
				String adddressLine1 = rs.getString("Addressline1");
				String adddressLine2 = rs.getString("Addressline2");
				String adddressLine3 = rs.getString("Addressline3");
				String postcode = rs.getString("PostCode");
				String town = rs.getString("Town");
				String county = rs.getString("County");
				int countryID = rs.getInt("CountryID");
				String typeOfBusiness = rs.getString("TypeofBusiness");
				int sicCode = rs.getInt("SICcode");
				String departmentFullDes = rs.getString("FullDescription");
				String phone = rs.getString("PhoneNumber");
				String fax = rs.getString("Fax");
				String email = rs.getString("Email");
				String webAddress = rs.getString("WebAddress");
				String active = rs.getString("Active");
				depm = new Department(departmentName, departmentShortDes, leadContact, copyAddressFrom, 
						adddressLine1, adddressLine2, adddressLine3, postcode, town, county, countryID, typeOfBusiness, sicCode, 
						departmentFullDes, phone, fax, email, webAddress, active);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return depm;
	}

	public boolean insertDepm(Department depm) {
		Connection con = ConnectDB.getConnection();
		boolean t = false;
		try {
			// Statement stmt = con.createStatement();
			String query = "insert into Department values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,0)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, depm.getDepartmentName());
			ps.setString(2, depm.getDepartmentShortDes());
			ps.setString(3, depm.getLeadContact());
			ps.setString(4, depm.getCopyAddressFrom());
			ps.setString(5, depm.getAdddressLine1());
			ps.setString(6, depm.getAdddressLine2());
			ps.setString(7, depm.getAdddressLine3());
			ps.setString(8, depm.getPostcode());
			ps.setString(9, depm.getTown());
			ps.setString(10, depm.getCounty());
			ps.setInt(11, depm.getCountryID());
			ps.setString(12, depm.getTypeOfBusiness());
			ps.setInt(13, depm.getSicCode());
			ps.setString(14, depm.getDepartmentFullDes());
			ps.setString(15, depm.getPhone());
			ps.setString(16, depm.getFax());
			ps.setString(17, depm.getEmail());
			ps.setString(18, depm.getWebAddress());
			ps.executeUpdate();
			t = true;
			ps.close();
			con.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	} 
	
	public boolean updateActive(String depmName,String active){
		Connection con = ConnectDB.getConnection();
		boolean t = false;
		int changeActive = 0;
		
		if("No".equals(active)){
			changeActive = 1;
		}
		//" + changeActive + "     " + depmName + "
		try {
			String sql = "UPDATE Department SET Active ="+ changeActive + "  WHERE DepartmentName = '" + depmName+"'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("ok");
			t = true;
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
	
	/*public static void main(String[] args) {
		Connection con = ConnectDB.getConnection();
		
		try {
			String sql = "UPDATE Department SET Active = 1  WHERE DepartmentName = 'AAA123'";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("ok");
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
