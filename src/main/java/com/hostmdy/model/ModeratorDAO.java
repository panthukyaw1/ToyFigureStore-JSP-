package com.hostmdy.model;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.hostmdy.crypto.PasswordEncoder;
import com.hostmdy.crypto.PasswordValidator;

public class ModeratorDAO {
private final DataSource dataSource;
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	
	public ModeratorDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public void close() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int createAdmin(Moderator moderator) {
		int rowEffected = 0;
		try {
			connection = dataSource.getConnection();
			pStmt = connection.prepareStatement("INSERT INTO `moderator` "
					+ "(`email`, `password`) "
					+ "VALUES (?, ?);"
					);
			pStmt.setString(1, moderator.getEmail());
			String rawPassword = moderator.getPassword();
			String securePassword =null;
			try {
				securePassword = PasswordEncoder.encode(rawPassword);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pStmt.setString(2, securePassword);
			rowEffected=pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return rowEffected;
	}
	public Moderator getAdminByEmail(String email) {
		Moderator moderator = null;
		try {
			connection = dataSource.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from moderator where email='"+email+"';");
			while(rs.next()) {
				moderator = new Moderator(
						rs.getInt("id"),
						rs.getString("email"),
						rs.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return moderator;
	}
	public boolean isValid(String email,String originalPassword) {
		boolean valid = false;
		
		Moderator moderator = getAdminByEmail(email);
		
		if(moderator!= null) {
			String securePassword = moderator.getPassword();
			
			try {
				if(PasswordValidator.validatePassword(originalPassword, securePassword)) {
					valid = true;
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return valid;
		
		
		
	}
}
