package com.marv.persistence.mappers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.marv.business.entities.DomainObject;
import com.marv.business.entities.Institution;

public class InstitutionMapper extends AbstractMapper {

	public static final String COLUMNS = "id, name";
	
	protected String findStatement() {
		return "SELECT " + COLUMNS +
				" FROM institutions" +
				" WHERE id =?";
	}

	@Override
	protected String updateStatement() {
		return "UPDATE institutions" +
				" SET name =?" +
				" WHERE id=?";
	}

	@Override
	protected String insertStatement() {
		return "INSERT INTO institutions (name) VALUES (?)";
	}

	@Override
	protected String deleteStatement() {
		return "DELETE FROM institutions WHERE id=?";
	}
	
	public Institution find(Long id) {
		return (Institution) abstractFind(id);
	}
	
	public Institution find(long id) {
		return (Institution) abstractFind(id);
	}
	
	protected DomainObject doLoad(Long id, ResultSet rs) throws SQLException {
		Institution institution = new Institution();
		institution.setId(rs.getLong(1));
		institution.setName(rs.getString(2));
		return institution;
	}

	@Override
	protected void doUpdate(DomainObject obj, PreparedStatement s)
			throws SQLException {
		Institution institution = (Institution) obj;
		s.setString(1, institution.getName());
		s.setLong(2, institution.getId());
	}

	@Override
	protected void doInsert(DomainObject obj, PreparedStatement s)
			throws SQLException {
		Institution institution = (Institution) obj;
		s.setString(1, institution.getName());
	}

	@Override
	protected void doDelete(DomainObject obj, PreparedStatement s)
			throws SQLException {
		Institution institution = (Institution) obj;
		s.setLong(1, institution.getId());
	}
}
