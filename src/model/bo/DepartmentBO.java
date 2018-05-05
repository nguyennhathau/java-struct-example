package model.bo;

import java.util.List;

import model.bean.Department;
import model.dao.DepartmentDB;

public class DepartmentBO {
	
	DepartmentDB depmDB = new DepartmentDB();
	
	//list department
	public List<Department> getListDepm() {
		return depmDB.getList();
	}
	
	//list department all
		public List<Department> getListDepmall() {
			return depmDB.getListall();
		}
	
	//list follow first word
	public List<Department> getListByFirstWord(String filter){
		return depmDB.getListByFirstWord(filter);
	}
	
	//list have active
	public List<Department> getListByDempActive(String filter){
		return depmDB.getListByDempActive();
	}
	
	
	// list Active follow word
	public List<Department> getListByDempActiveByWord(String filter){
		return depmDB.getListByDempActiveByWord(filter);
	}
	
	
	// get department by id
	public Department getDepartmentById(String id){
		return depmDB.getDempByDepmName(id);
	}
	
	//insert department
	public boolean insertDepartment(Department depm){
		return depmDB.insertDepm(depm);
	}
	
	//update active
	public boolean changeActive(String depmName, String active){
		return depmDB.updateActive(depmName,active);
	}
}
