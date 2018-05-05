package action;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import atg.taglib.json.util.JSONObject;
import form.OrganisationForm;
import model.bean.Organisation;
import model.bo.OrganisationBO;
import model.dao.OrganisationDB;

public class JsonAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("application/json");

		OrganisationDB organDB = new OrganisationDB();
		Organisation organ = new Organisation();
		organ = organDB.getOrganbyName();
		// String jsonString = JSON.toJSONString(organ);
		OrganisationForm organForm = (OrganisationForm) form;
		// organForm.setJsonString(jsonString.toString());
		organForm.setOrgan(organ);
		return mapping.findForward("setJson");

	}

}
