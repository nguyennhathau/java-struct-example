package form;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

import model.bean.Country;
import model.bean.Department;

public class DepartmentForm extends ActionForm{
	private ArrayList<Department> depmList;
	private String departmentName;
	private String departmentShortDes;
	private String leadContact;
	private String copyAddressFrom;
	private String adddressLine1;
	private String adddressLine2;
	private String adddressLine3;
	private String postcode;
	private String town;
	private String county;
	private int countryID;
	private String typeOfBusiness;
	private int sicCode;
	private String DepartmentFullDes;
	private String phone;
	private String fax;
	private String email;
	private String webAddress;
	private String active;
	private String pages;
	private int tongsotrang;
	private String submit;
	private String filter;
	private String message;
	private ArrayList<Country> listCountry;
	private String all;
	private Department department;
	
	
	

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}

	public ArrayList<Country> getListCountry() {
		return listCountry;
	}

	public void setListCountry(ArrayList<Country> listCountry) {
		this.listCountry = listCountry;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getSubmit() {
		return submit;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public int getTongsotrang() {
		return tongsotrang;
	}

	public void setTongsotrang(int tongsotrang) {
		this.tongsotrang = tongsotrang;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public ArrayList<Department> getDepmList() {
		return depmList;
	}

	public void setDepmList(ArrayList<Department> depmList) {
		this.depmList = depmList;
	}
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentShortDes() {
		return departmentShortDes;
	}
	public void setDepartmentShortDes(String departmentShortDes) {
		this.departmentShortDes = departmentShortDes;
	}
	public String getLeadContact() {
		return leadContact;
	}
	public void setLeadContact(String leadContact) {
		this.leadContact = leadContact;
	}
	public String getCopyAddressFrom() {
		return copyAddressFrom;
	}
	public void setCopyAddressFrom(String copyAddressFrom) {
		this.copyAddressFrom = copyAddressFrom;
	}
	public String getAdddressLine1() {
		return adddressLine1;
	}
	public void setAdddressLine1(String adddressLine1) {
		this.adddressLine1 = adddressLine1;
	}
	public String getAdddressLine2() {
		return adddressLine2;
	}
	public void setAdddressLine2(String adddressLine2) {
		this.adddressLine2 = adddressLine2;
	}
	public String getAdddressLine3() {
		return adddressLine3;
	}
	public void setAdddressLine3(String adddressLine3) {
		this.adddressLine3 = adddressLine3;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public int getCountryID() {
		return countryID;
	}
	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}
	public String getTypeOfBusiness() {
		return typeOfBusiness;
	}
	public void setTypeOfBusiness(String typeOfBusiness) {
		this.typeOfBusiness = typeOfBusiness;
	}
	public int getSicCode() {
		return sicCode;
	}
	public void setSicCode(int sicCode) {
		this.sicCode = sicCode;
	}
	public String getDepartmentFullDes() {
		return DepartmentFullDes;
	}
	public void setDepartmentFullDes(String departmentFullDes) {
		DepartmentFullDes = departmentFullDes;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebAddress() {
		return webAddress;
	}
	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	
	
	
	
}
