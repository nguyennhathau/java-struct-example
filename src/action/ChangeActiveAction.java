package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DepartmentForm;
import model.bean.Department;
import model.bo.DepartmentBO;

public class ChangeActiveAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DepartmentForm depmForm = (DepartmentForm) form;
		DepartmentBO depmBO = new DepartmentBO();
		
		String depmName = depmForm.getDepartmentName();
		String active = depmForm.getActive();
		Department depm = null;
		String message = "";
		if(depmBO.changeActive(depmName,active)){
			depm = depmBO.getDepartmentById(depmName);
			message = "update success.";
		}else{
			message = "update fail.";
		}
		depmForm.setDepartment(depm);
		/*depmForm.setActive(depm.getActive());
		 depmForm.setDepartmentName(depm.getDepartmentName());*/

		depmForm.setMessage(message);
		
		return mapping.findForward("setJsonactive");
	}
	
}
