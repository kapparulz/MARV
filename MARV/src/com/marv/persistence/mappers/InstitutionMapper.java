package com.marv.persistence.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.marv.business.entities.DomainObject;
import com.marv.business.entities.Institution;

public class InstitutionMapper extends AbstractMapper {

	public static final String COLUMNS = "id, name";
	
	protected String findStatement() {
		return "SELECT " + COLUMNS +
				" FROM institutions" +
				" WHERE id = ?";
	}
	
	public Institution find(Long id) {
		return (Institution) abstractFind(id);
	}
	
	public Institution find(long id) {
		return (Institution) abstractFind(id);
	}
	
	protected DomainObject doLoad(Long id, ResultSet rs) throws SQLException {
		Institution institution = new Institution();
		institution.setName(rs.getString(2));
		return institution;
	}
}
