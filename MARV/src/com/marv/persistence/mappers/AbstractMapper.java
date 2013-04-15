package com.marv.persistence.mappers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
	
	protected abstract String findAllStatement();
	
	/**
	 * Gets a SQL statement modifying a record in the table.
	 * @return UPDATE statement modifying a row in the table.
	 */
	protected abstract String updateStatement();
	
	/**
	 * Gets a SQL statement inserting a record into the table.
	 * @return INSERT statement creating a new row in the table.
	 */
	protected abstract String insertStatement();
	
	/**
	 * Gets a SQL statement removing a record from the table.
	 * @return DELETE statement removing a row from the table.
	 */
	protected abstract String deleteStatement();
	
	protected abstract DomainObject doLoad(Long id, ResultSet rs) throws SQLException;
	
	/**
	 * Sets UPDATE statement parameters.
	 * @param o modified domain object to be updated in the database.
	 * @param s prepared statement object.
	 * @throws SQLException
	 */
	protected abstract void doUpdate(DomainObject o, PreparedStatement s) throws SQLException;
	
	/**
	 * Sets INSERT statement parameters.
	 * @param o newly created domain object to be saved into the database.
	 * @param s prepared statement object.
	 * @throws SQLException
	 */
	protected abstract void doInsert(DomainObject o, PreparedStatement s) throws SQLException;
	
	/**
	 * Performs any operations after the object has been
	 * saved into the database using its auto-generated id.
	 * Override this method in concrete mapper classes.
	 * 
	 * @param obj 			domain object that has been just saved.
	 * @param lastInsertId	id of the domain object that has been just saved.
	 * @throws DatabaseException 
	 */
	protected void doAfterInsert(DomainObject obj, long lastInsertId) throws SQLException {
	}
	
	/**
	 * Sets DELETE statement parameters.
	 * @param o domain object to be deleted from the database.
	 * @param s prepared statement object.
	 * @throws SQLException
	 */
	protected abstract void doDelete(DomainObject o, PreparedStatement s) throws SQLException;
	
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
	
	public ArrayList<DomainObject> findAll() {
		ArrayList<DomainObject> result = new ArrayList<DomainObject>();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = getConnection().prepareStatement(findAllStatement());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				result.add(load(resultSet));
			}
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			cleanUp(preparedStatement);
		}
		return result;
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

	public int update(DomainObject obj) {
		PreparedStatement statement = null;
		try{
			statement = getConnection().prepareStatement(updateStatement());
			//doBeforeUpdate(obj);
			doUpdate(obj, statement);
			loadedMap.put(obj.getId(), obj);
			//doAfterUpdate(obj);
			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			cleanUp(statement);
		}
	}

	public long insert(DomainObject obj) {
		PreparedStatement insertStatement = null;
		try{
			insertStatement = getConnection().prepareStatement(insertStatement(), Statement.RETURN_GENERATED_KEYS);
			doInsert(obj, insertStatement);
			insertStatement.execute();
			Long lastInsertId = findLastInsertId(insertStatement);
			doAfterInsert(obj, lastInsertId);
			obj.setId(lastInsertId);
			loadedMap.put(lastInsertId, obj);
			return lastInsertId;
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			cleanUp(insertStatement);
		}
	}

	public int delete(DomainObject obj) {
		PreparedStatement statement = null;
		try{
			statement = getConnection().prepareStatement(deleteStatement());
			//doBeforeDelete();
			doDelete(obj, statement);
			if(loadedMap.containsKey(obj.getId())) {
				loadedMap.remove(obj.getId());
			}
			//doAfterDelete();
			return statement.executeUpdate();
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			cleanUp(statement);
		}
	}
	
	/**
	 * Retrieves the id of the last domain object that was saved in the database.
	 * 
	 * @param statement 	prepared statement with result of the INSERT query.
	 * @return				id of the last domain object that was saved in the database.
	 * @throws SQLException
	 */
	private long findLastInsertId(PreparedStatement statement) throws SQLException {
		long autoIncKeyFromApi = -1L;
		ResultSet rs = statement.getGeneratedKeys();
		if(rs.next()) {
			autoIncKeyFromApi = rs.getLong(1);
		}
		return autoIncKeyFromApi;
	}
}
