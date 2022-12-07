package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository("LogDaoH2Impl")
public class LogDaoH2Impl implements LogDao {

	public Connection con;
	public PreparedStatement psmt;	
	
	public LogDaoH2Impl() {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			System.out.println("LogDaoH2Impl DB");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void addLog(String method, String sqlstring, boolean success) {
		String query = "insert into dblog (method, sqlstring, success) values (?,?,?)";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, method);
			psmt.setString(2, sqlstring);
			psmt.setBoolean(3, success);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
