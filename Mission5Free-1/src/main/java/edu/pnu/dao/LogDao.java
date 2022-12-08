package edu.pnu.dao;

public interface LogDao {

	void addLog(String method, String query, boolean success);
}
