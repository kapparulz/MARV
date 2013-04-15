package com.marv.persistence.mappers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.marv.business.entities.DomainObject;
import com.marv.business.entities.User;
import com.marv.business.entities.User.UserType;

public class UserMapper extends AbstractMapper {

	public static final String COLUMNS = "id, username, password, type, email, phone," +
			" address, first_name, last_name, institution_id";

	protected String findStatement() {
		return "SELECT " + COLUMNS + " FROM users" + " WHERE id =?"
				+ " LEFT JOIN institutions"
				+ " ON users.institution_id=institutions.id";
	}

	@Override
	protected String updateStatement() {
		return "UPDATE users SET username =?, password =?, type =?, email =?, " +
				" phone =?, address =?, first_name =?, last_name =?, institution_id =? " +
				" WHERE id=?";
	}

	@Override
	protected String insertStatement() {
		return "INSERT INTO users (username, password, type, email, phone, address, first_name, last_name," +
				" institution_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
		user.setId(rs.getLong(1));
		user.setUsername(rs.getString(2));
		user.setPassword(rs.getString(3));
		int type = rs.getInt(4);
		if (type == 1) {
			user.setType(UserType.TUTOR);
		} else {
			user.setType(UserType.STUDENT);
		}
		user.setEmail(rs.getString(5));
		user.setPhone(rs.getString(6));
		user.setAddress(rs.getString(7));
		user.setFirstName(rs.getString(8));
		user.setLastName(rs.getString(9));
		//int institution = rs.getInt(10);
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
			s.setInt(3, 1);
		} else {
			s.setInt(3, 2);
		}
		s.setString(4, user.getEmail());
		s.setString(5, user.getPhone());
		s.setString(6, user.getAddress());
		s.setString(7, user.getFirstName());
		s.setString(8, user.getLastName());
		s.setLong(9, user.getInstitutionId());
	}

	@Override
	protected void doDelete(DomainObject obj, PreparedStatement s)
			throws SQLException {
		User user = (User) obj;
		s.setLong(1, user.getId());
	}

	@Override
	protected String findAllStatement() {
		// TODO Auto-generated method stub
		return null;
	}
}
