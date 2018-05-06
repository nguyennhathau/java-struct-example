package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DepartmentForm;
import model.bean.Department;
import model.bo.DepartmentBO;

public class DanhSachDepmAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DepartmentForm depmForm = (DepartmentForm) form;

		DepartmentBO depmBO = new DepartmentBO();
		String pages = depmForm.getPages();
		String filter = depmForm.getFilter();
		// phan trang
		int page = 1;
		if (pages != null) {
			page = Integer.parseInt(pages);
		}

		if (filter == null) {
			filter = "all";
		}

		ArrayList<Department> depmList = null;
		if (filter.equals("all")) {
			depmList = (ArrayList<Department>) depmBO.getListDepm();
		} else {
			depmList = (ArrayList<Department>) depmBO.getListByFirstWord(filter);
		}

		int totalDepm = depmList.size();
		int so_dau_trang, so_cuoi_trang, tong_so_trang;

		if (totalDepm % 6 == 0) {
			tong_so_trang = totalDepm / 6;
		} else {
			tong_so_trang = (totalDepm / 6) + 1;
		}
		// int count = 0;
		if (totalDepm < 6) {
			so_dau_trang = 0;
			so_cuoi_trang = totalDepm;
		} else {
			so_dau_trang = (page - 1) * 6;
			so_cuoi_trang = so_dau_trang + 6;
		}
		// ArrayList<May> paniList = (ArrayList<May>)
		// maybo.getPagination(so_dau_trang);
		ArrayList<Department> paniList = new ArrayList<Department>();
		for (int i = so_dau_trang; i < totalDepm && i < so_cuoi_trang; i++) {
			// count++;
			paniList.add(depmList.get(i));
		}
		depmForm.setTongsotrang(tong_so_trang);
		depmForm.setDepmList(paniList);
		depmForm.setPages(Integer.toString(page));
		return mapping.findForward("showListDepm");
	}

}
