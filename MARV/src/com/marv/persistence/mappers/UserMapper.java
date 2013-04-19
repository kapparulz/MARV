package com.marv.persistence.mappers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.marv.business.entities.DomainObject;
import com.marv.business.entities.OpenID;
import com.marv.business.entities.User;
import com.marv.business.entities.User.UserType;
import com.marv.util.operationalmanagement.ApplicationException;

public class UserMapper extends AbstractMapper {

	public static final String COLUMNS = "User.id, User.username, User.password," +
			" User.type, User.email, User.phone, User.address, User.first_name," +
			" User.last_name, User.institution_id";

	protected String findStatement() {
		return "SELECT " + COLUMNS + " FROM users AS User" +
				" LEFT JOIN institutions AS Institution" +
					" ON User.institution_id=Institution.id" +
				" WHERE User.id=?" +
				" LIMIT 1";
	}
	
	protected String findByOpenIdStatement() {
		return "SELECT " + COLUMNS + " FROM users AS User" +
				" LEFT JOIN institutions AS Institution" +
					" ON User.institution_id=Institution.id" +
				" LEFT JOIN open_ids AS OpenID" +
					" ON User.id=OpenID.user_id" +
				" WHERE OpenID.identifier=?" +
				" LIMIT 1";
	}

	@Override
	protected String findAllStatement() {
		return "SELECT " + COLUMNS + " FROM users AS User" +
				" LEFT JOIN institutions AS Institution" +
				" ON User.institution_id=Institution.id";
	}

	@Override
	protected String updateStatement() {
		return "UPDATE users SET username =?, password =?, type =?, email =?, " +
				" phone =?, address =?, first_name =?, last_name =?, institution_id =? " +
				" WHERE id=?";
	}

	@Override
	protected String insertStatement() {
		return "INSERT INTO users (username, password, type, email, phone," +
					" address, first_name, last_name, institution_id)" +
				" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	}

	@Override
	protected String deleteStatement() {
		return "DELETE FROM users WHERE id=?";
	}

	public User find(Long id) {
		return (User) abstractFind(id);
	}

	public User find(long id) {
		return (User) abstractFind(id);
	}

	protected DomainObject doLoad(Long id, ResultSet rs) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("User.id"));
		user.setUsername(rs.getString("User.username"));
		user.setPassword(rs.getString("User.password"));
		int type = rs.getInt("User.type");
		if (type == 1) {
			user.setType(UserType.TUTOR);
		} else {
			user.setType(UserType.STUDENT);
		}
		user.setEmail(rs.getString("User.email"));
		user.setPhone(rs.getString("User.phone"));
		user.setAddress(rs.getString("User.address"));
		user.setFirstName(rs.getString("User.first_name"));
		user.setLastName(rs.getString("User.last_name"));
		//int institution = rs.getInt(10);
//		ResultSetMetaData rsmd = rs.getMetaData();
//		int columnCount = rsmd.getColumnCount();
//		// The column count starts from 1
//		for (int i = 1; i < columnCount + 1; i++) {
//			if(rsmd.getTableName(i).equals("open_ids")) {
//				if(rsmd.getColumnName(i).equals("identifier")) {
//					user.addIdentifier(rs.getString(i));
//				}
//			}
//		}
		return user;
	}

	@Override
	protected void doUpdate(DomainObject obj, PreparedStatement s)
			throws SQLException {
		User user = (User) obj;
		s.setString(1, user.getUsername());
		s.setString(2, user.getPassword());
		if (user.getType() == UserType.TUTOR) {
			s.setInt(3, 1);
		} else {
			s.setInt(3, 2);
		}
		s.setString(4, user.getEmail());
		s.setString(5, user.getPhone());
		s.setString(6, user.getAddress());
		s.setString(7, user.getFirstName());
		s.setString(8, user.getLastName());
		
		//s.setLong(10, user.getId());
	}

	@Override
	protected void doInsert(DomainObject obj, PreparedStatement s)
			throws SQLException {
		User user = (User) obj;
		System.out.println(user);
		s.setString(1, user.getUsername());
		s.setString(2, user.getPassword());
		if (user.getType() == UserType.TUTOR) {
			s.setInt(3, 0);
		} else {
			s.setInt(3, 1);
		}
		s.setString(4, user.getEmail());
		s.setString(5, user.getPhone());
		s.setString(6, user.getAddress());
		s.setString(7, user.getFirstName());
		s.setString(8, user.getLastName());
		if (user.getInstitutionId() > 0) {
			s.setLong(9, user.getInstitutionId());
		} else {
			s.setString(9, null);
		}
	}
	
	@Override
	public long insert(DomainObject obj) {
		long userId = super.insert(obj);
		ArrayList<OpenID> openIds = ((User) obj).getOpenIds();
		if (openIds != null) {
			for (int i = 0; i < openIds.size(); i++) {
				OpenID openId = openIds.get(i);
				openId.setUserId(userId);
				getMapper(OpenID.class).insert(openId);
			}
		}
		return userId;
	}

	@Override
	protected void doDelete(DomainObject obj, PreparedStatement s)
			throws SQLException {
		User user = (User) obj;
		s.setLong(1, user.getId());
	}

	public User findByOpenId(String identifier) {
		PreparedStatement statement = null;
		try {
			statement = getConnection().prepareStatement(findByOpenIdStatement());
			statement.setString(1, identifier);
			ResultSet rs = statement.executeQuery();
			if(rs.next()) {
				return (User) load(rs);
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			closeStatement(statement);
		}
	}
}
