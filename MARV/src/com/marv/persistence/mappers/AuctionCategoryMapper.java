package com.marv.persistence.mappers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.marv.business.entities.AuctionCategory;
import com.marv.business.entities.DomainObject;
import com.marv.business.entities.Institution;

public class AuctionCategoryMapper extends AbstractMapper {
	
	/**
	 * List of auction_categories table columns.
	 */
	public static final String COLUMNS = "id, parent_id, name";

	@Override
	protected String findStatement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String findAllStatement() {
		return "SELECT " + COLUMNS + 
				" FROM auction_categories" +
				" ORDER BY parent_id DESC, name DESC";
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
		AuctionCategory category = new AuctionCategory();
		category.setId(rs.getLong(1));
		category.setParentId(rs.getLong(2));
		category.setName(rs.getString(3));
		return category;
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
	public DomainObject find(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DomainObject> findAll() {
		ArrayList<DomainObject> table = super.findAll();
		ArrayList<DomainObject> tree = new ArrayList<DomainObject>();
		for(int i = table.size()-1; i >= 0; i--) {
			if(((AuctionCategory)table.get(i)).getParentId() == 0) {
				tree.add(table.get(i));
			} else {
				parseTree(tree, (AuctionCategory) table.get(i));
			}
		}
		return tree;
	}

	private void parseTree(ArrayList<?> tree, AuctionCategory row) {
		for(Object node : tree) {
			AuctionCategory category = (AuctionCategory) node;
			if(category.getId() == row.getParentId()) {
				if(category.getChildren() == null || !category.getChildren().contains(row)) {
					category.addChild(row);
				}
				return;
			} else if(category.getChildren() != null) {
				parseTree(category.getChildren(), row);
			}
		}
	}
}
