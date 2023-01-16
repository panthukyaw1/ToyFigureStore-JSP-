package com.hostmdy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class ToyFigureDAO {
	
	private final DataSource dataSource;
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	

	public ToyFigureDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	private void close() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<ToyFigure> getToyFigureList(){
		List<ToyFigure> toyFigureList = new ArrayList<>();
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from toystore");
			
			while (rs.next()) {
				toyFigureList.add(new ToyFigure(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getInt("spareParts"),
						rs.getBoolean("stand"),
						rs.getInt("price")));
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return toyFigureList;
	}
	public ToyFigure getToyFigure(int id){
		ToyFigure toyFigure = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from toystore "
					+ "where id='"+id+"';");
			
			while (rs.next()) {
				   toyFigure=new ToyFigure(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getInt("spareParts"),
						rs.getBoolean("stand"),
						rs.getInt("price"));
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return toyFigure;
	}
		
		public List<ToyFigure> getToyFigure(String query,String value){
			List<ToyFigure> toyFigure = new ArrayList<>();
			try {
				connection = dataSource.getConnection();
				stmt = connection.createStatement();
				rs = stmt.executeQuery("select * from toystore "
						+ "where "+query+"='"+value+"';");
				
				while (rs.next()) {
					   toyFigure.add(new ToyFigure(
							rs.getInt("id"),
							rs.getString("name"),
							rs.getInt("spareParts"),
							rs.getBoolean("stand"),
							rs.getInt("price")));
				}	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close();
			}
			return toyFigure;
	}
		public int searchToyFigure(String name) {
			int rowEffected = 0;
			try {
				connection=dataSource.getConnection();
				pStmt = connection.prepareStatement("search from toystore where name = ?;");
				pStmt.setString(1, name);
				rowEffected=pStmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				close();
			}
			return rowEffected;
		}
	public int creatToyFigure(final ToyFigure toyFigure) {
		int rowEffected = 0;
		try {
			connection=dataSource.getConnection();
			pStmt = connection.prepareStatement("INSERT INTO `toystore` "
					+ "(`name`, `spareParts`, `stand`, `price`) "
					+ "VALUES (?, ?, ?, ?);");
			pStmt.setString(1,toyFigure.getName());
			pStmt.setInt(2, toyFigure.getSpareParts());
			pStmt.setBoolean(3, toyFigure.getStand());
			pStmt.setInt(4, toyFigure.getPrice());
			
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
	}
	public int updateToyFigure(final ToyFigure toyFigure) {
		int rowEffected = 0;
		
		try {
			connection= dataSource.getConnection();
			pStmt = connection.prepareStatement("UPDATE `toystore` SET "
					+ "`name` = ?,"
					+ " `spareParts` = ?,"
					+ " `stand` = ?,"
					+ " `price` = ? WHERE (`id` = ?);");
			pStmt.setString(1,toyFigure.getName());
			pStmt.setInt(2, toyFigure.getSpareParts());
			pStmt.setBoolean(3, toyFigure.getStand());
			pStmt.setInt(4, toyFigure.getPrice());
			pStmt.setInt(5, toyFigure.getId());
			rowEffected = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
	}
	public int deleteToyFigure(int id) {
		int rowEffected = 0;
		try {
			connection=dataSource.getConnection();
			pStmt = connection.prepareStatement("delete from toystore where id = ?;");
			pStmt.setInt(1, id);
			rowEffected=pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
	}

}
