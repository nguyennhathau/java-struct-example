package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DepartmentForm;
import model.bean.Country;
import model.bean.Department;
import model.bean.Organisation;
import model.bo.CountryBO;
import model.bo.DepartmentBO;
import model.bo.OrganisationBO;

public class AddDepartmentAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		DepartmentForm depmForm = (DepartmentForm) form;
		DepartmentBO depmBO = new DepartmentBO();
		CountryBO countryBO = new CountryBO();
		OrganisationBO organBO = new OrganisationBO();
		
		Organisation organ = organBO.getOrganName();
		depmForm.setTypeOfBusiness(organ.getTypeOfBusiness());
		depmForm.setSicCode(organ.getSicCode());
		depmForm.setWebAddress(organ.getWebAddress());
		ArrayList<Country> listCountry = (ArrayList<Country>) countryBO.getListCountry();
		depmForm.setListCountry(listCountry);
		
		
		if ("submit".equals(depmForm.getSubmit())) { // nhan nut Xac nhan them
			String depmName = depmForm.getDepartmentName();
			if (depmBO.getDepartmentById(depmName) != null) {
				String message = "Đã tồn tại code này!";
				depmForm.setMessage(message);
				return mapping.findForward("addError");
			}
			String departmentName = depmForm.getDepartmentName();
			String departmentShortDes = depmForm.getDepartmentShortDes();
			String leadContact = depmForm.getLeadContact();
			String copyAddressFrom = depmForm.getCopyAddressFrom();
			String adddressLine1 = depmForm.getAdddressLine1();
			String adddressLine2 = depmForm.getAdddressLine2();
			String adddressLine3 = depmForm.getAdddressLine3();
			String postcode = depmForm.getPostcode();
			String town = depmForm.getTown();
			String county = depmForm.getCounty();
			int countryID = depmForm.getCountryID();
			String typeOfBusiness = depmForm.getTypeOfBusiness();
			int sicCode = depmForm.getSicCode();
			String departmentFullDes = depmForm.getDepartmentFullDes();
			String phone = depmForm.getPhone();
			String fax = depmForm.getFax();
			String email = depmForm.getEmail();
			String webAddress = depmForm.getWebAddress();
			Department depm = new Department(departmentName, departmentShortDes, leadContact, copyAddressFrom,
					adddressLine1, adddressLine2, adddressLine3, postcode, town, county, countryID, typeOfBusiness,
					sicCode, departmentFullDes, phone, fax, email, webAddress, null);
			depmBO.insertDepartment(depm);
			return mapping.findForward("addok");
		} else {
			// chuyen sang trang Them
			return mapping.findForward("add");
		}
	}

}
