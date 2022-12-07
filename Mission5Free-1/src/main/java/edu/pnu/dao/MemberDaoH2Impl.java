package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.pnu.domain.MemberVO;

@Repository("MemberDaoH2Impl")
public class MemberDaoH2Impl implements MemberDao {

	public Connection con;
	public Statement smt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public MemberDaoH2Impl() {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
			System.out.println("MemberDao DB");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<MemberVO> getMembers() {
		List<MemberVO> list = null;
		String query = "select * from member";
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			list = new ArrayList<>();
			while (rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getString(1));
				m.setPass(rs.getString(2));
				m.setName(rs.getString(3));
				m.setRegidate(rs.getDate(4));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MemberVO> getMember(String id) {
		List<MemberVO> list = null;
		String query = "select * from member where id = ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			rs.next();
			list = new ArrayList<>();
			MemberVO m = new MemberVO();
			m.setId(rs.getString(1));
			m.setPass(rs.getString(2));
			m.setName(rs.getString(3));
			m.setRegidate(rs.getDate(4));
			list.add(m);
			
		} catch (SQLException e) {
			list = null;
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MemberVO> addMember(MemberVO memberVO) {
		List<MemberVO> list = null;
		String query = "insert into member (id, pass, name) values (?, ?, ?)";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, memberVO.getId());
			psmt.setString(2, memberVO.getPass());
			psmt.setString(3, memberVO.getName());
			psmt.executeUpdate();
			
			list = new ArrayList<>();
			MemberVO m = new MemberVO();
			m.setId(memberVO.getId());
			m.setPass(memberVO.getPass());
			m.setName(memberVO.getName());
			list.add(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MemberVO> updateMember(MemberVO memberVO) {
		List<MemberVO> list = getMember(memberVO.getId());
		if (list == null) return null;
		String query = "update member set pass=?, name=? where id=?";
		
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, memberVO.getPass());
			psmt.setString(2, memberVO.getName());
			psmt.setString(3, memberVO.getId());
			psmt.executeUpdate();
			
			list = new ArrayList<>();
			MemberVO m = new MemberVO();
			m.setId(memberVO.getId());
			m.setPass(memberVO.getPass());
			m.setName(memberVO.getName());
			list.add(m);

		} catch (Exception e) {
			list = null;
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<MemberVO> deleteMember(String id) {
		List<MemberVO> list = getMember(id);
		if (list == null) return null;
		String query = "delete from member where id = ?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.executeUpdate();
			
			list = new ArrayList<>();
			MemberVO m = new MemberVO();
			m.setId(id);
			list.add(m);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
