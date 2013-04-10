package com.marv.persistence.mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.marv.business.entities.DomainObject;
import com.marv.persistence.core.MysqlConnection;
import com.marv.util.operationalmanagement.ApplicationException;

/**
 * This class implements the logic of mapping domain objects to the database tables.
 */
public abstract class AbstractMapper {
	
	/**
	 * Connection to the database.
	 */
	protected MysqlConnection mysqlConnection;

	protected Map<Long, DomainObject> loadedMap = new HashMap<Long, DomainObject>();
	
	protected abstract String findStatement();
	
	protected abstract DomainObject doLoad(Long id, ResultSet rs) throws SQLException;
	
	public abstract DomainObject find(long id);
	
	protected DomainObject abstractFind(Long id) {
		DomainObject result = (DomainObject) loadedMap.get(id);
		if(result != null) {
			return result;
		}
		PreparedStatement findStatement = null;
		try {
			findStatement = getConnection().prepareStatement(findStatement());
			findStatement.setLong(1, id.longValue());
			ResultSet rs = findStatement.executeQuery();
			rs.next();
			result = load(rs);
			return result;
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			cleanUp(findStatement);
		}
	}
	
	protected DomainObject load(ResultSet rs) throws SQLException {
		Long id = new Long(rs.getLong(1));
		if(loadedMap.containsKey(id)) {
			return (DomainObject) loadedMap.get(id);
		}
		DomainObject result = doLoad(id, rs);
		loadedMap.put(id, result);
		return result;
	}
	
	private Connection getConnection() {
		return MysqlConnection.getInstance().getConnection();
	}

	/**
	 * Releases this PreparedStatement object's database and
	 * JDBC resources immediately instead of waiting for this
	 * to happen when it is automatically closed.
	 * 
	 * @param statement
	 */
	private void cleanUp(PreparedStatement statement) {
		try {
			if(statement != null){
				statement.close();
			}
		} catch(SQLException e) {
			throw new ApplicationException(e);
		}
	}
}
