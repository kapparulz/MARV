package com.marv.persistence.mappers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.marv.business.entities.DomainObject;
import com.marv.business.entities.Institution;

/**
 * Mapper for Institution domain class. Maps Activity objects to the records in
 * MySQL tables.
 */
public class InstitutionMapper extends AbstractMapper {

	/**
	 * List of institutions table columns.
	 */
	public static final String COLUMNS = "id, name";
	
	@Override
	protected String findStatement() {
		return "SELECT " + COLUMNS +
				" FROM institutions" +
				" WHERE id =?";
	}

	@Override
	protected String findAllStatement() {
		return "SELECT " + COLUMNS + 
				" FROM institutions" +
				" ORDER BY id ASC";
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
	
	/**
	 * Wrapper method for "public Institution find(long id)" method.
	 * 
	 * @param id
	 *            value of domain object's id field
	 * @return domain object.
	 */
	public Institution find(Long id) {
		return (Institution) abstractFind(id);
	}
	
	@Override
	public Institution find(long id) {
		return (Institution) abstractFind(id);
	}
	
	@Override
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
