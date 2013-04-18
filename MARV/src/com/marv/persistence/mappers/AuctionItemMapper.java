package com.marv.persistence.mappers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import com.marv.business.entities.AuctionItem;
import com.marv.business.entities.DomainObject;
import com.marv.business.entities.Institution;
import com.marv.util.operationalmanagement.ApplicationException;

public class AuctionItemMapper extends AbstractMapper {

	/**
	 * List of auction_items table columns.
	 */
	public static final String COLUMNS = "id, auction_category_id, user_id," +
			" name, description, start_price, byout_price, start_date, end_date," +
			" picture, is_sold";
	
	@Override
	protected String findStatement() {
		return "SELECT " + COLUMNS +
				" FROM auction_items" +
				" WHERE id =?";
	}

	@Override
	protected String findAllStatement() {
		return "SELECT " + COLUMNS + 
				" FROM auction_items" +
				" ORDER BY start_date DESC";
	}

	@Override
	protected String updateStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String insertStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String deleteStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected DomainObject doLoad(Long id, ResultSet rs) throws SQLException {
		AuctionItem item = new AuctionItem();
		item.setId(rs.getLong(1));
		item.setAuctionCategoryId(rs.getLong(2));
		item.setUserId(rs.getLong(3));
		item.setName(rs.getString(4));
		item.setDescription(rs.getString(5));
		item.setStartPrice(rs.getDouble(6));
		item.setByoutPrice(rs.getDouble(7));
		Calendar cal = Calendar.getInstance();
		cal.setTime(rs.getDate(8));
		item.setStartDate(cal);
		cal.setTime(rs.getDate(9));
		item.setEndDate(cal);
		item.setPicture(rs.getString(10));
		if(rs.getInt(11) == 1) {
			item.setSold(true);
		} else {
			item.setSold(false);
		}
		return item;
	}

	@Override
	protected void doUpdate(DomainObject o, PreparedStatement s)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doInsert(DomainObject o, PreparedStatement s)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doDelete(DomainObject o, PreparedStatement s)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public AuctionItem find(long id) {
		return (AuctionItem) abstractFind(id);
	}

	public ArrayList<AuctionItem> findAllByCategory(long categoryId) {
		String statement = "SELECT " + COLUMNS + 
				" FROM auction_items" +
				" WHERE auction_category_id=?" +
				" ORDER BY start_date DESC";
		ArrayList<AuctionItem> result = new ArrayList<AuctionItem>();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = getConnection().prepareStatement(statement);
			preparedStatement.setLong(1, categoryId);
			ResultSet resultSet = preparedStatement.executeQuery();
			System.out.println(preparedStatement);
			while (resultSet.next()) {
				AuctionItem item = (AuctionItem) load(resultSet);
				System.out.println(item);
				result.add(item);
			}
		} catch (SQLException e) {
			throw new ApplicationException(e);
		} finally {
			closeStatement(preparedStatement);
		}
		return result;
	}

}
