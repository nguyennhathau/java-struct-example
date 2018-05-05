package model.bo;

import java.util.List;

import model.bean.Organisation;
import model.dao.OrganisationDB;

public class OrganisationBO {
	OrganisationDB organDB = new OrganisationDB();

	// list Organisation
	public List<Organisation> getListOrgan() {
		return organDB.getListOrgan();
	}

	// Organisation by name
	public Organisation getOrganName() {
		return organDB.getOrganbyName();
	}
}
