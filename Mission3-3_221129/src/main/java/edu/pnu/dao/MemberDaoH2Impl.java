package edu.pnu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.pnu.memberVO.MemberVO;

public class MemberDaoH2Impl extends JDBConnectH2 implements MemberDao {

	public MemberDaoH2Impl() {
		super("org.h2.Driver", "jdbc:h2:tcp://localhost/~/test", "sa", "");
	}

	@Override
	public List<MemberVO> getMembers() {
		List<MemberVO> list = new ArrayList<>();
		String query = "select * from member;";
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			
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
		List<MemberVO> list = new ArrayList<>();
		String query = "select * from member where id = ?;";		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			/**/rs.next();
			MemberVO m = new MemberVO();
			m.setId(rs.getString(1));
			m.setPass(rs.getString(2));
			m.setName(rs.getString(3));
			m.setRegidate(rs.getDate(4));
			list.add(m);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<MemberVO> addMember(MemberVO memberVO) {
		List<MemberVO> list = new ArrayList<>();
		String query = "insert into member (id, name, pass) values (?, ?, ?);";
		try {
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, memberVO.getId());
			psmt.setString(2, memberVO.getPass());
			psmt.setString(3, memberVO.getPass());
			psmt.executeUpdate();
			
			MemberVO m = new MemberVO();
			m.setId(memberVO.getId());
			m.setPass(memberVO.getPass());
			m.setName(memberVO.getName());
			list.add(m);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public List<MemberVO> updateMember(MemberVO memberVO) {
		List<MemberVO> list = new ArrayList<>();
		String query = "update member set pass=?, name=? where id = ?;";
		try {
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, memberVO.getPass());
			psmt.setString(2, memberVO.getName());
			psmt.setString(3, memberVO.getId());
			psmt.executeUpdate();
			
			MemberVO m = new MemberVO();
			m.setId(memberVO.getId());
			m.setPass(memberVO.getPass());
			m.setName(memberVO.getName());
			list.add(m);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public List<MemberVO> removeMember(String id) {
		String query = "delete from member where id = ?";

		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			psmt.executeUpdate();
			System.out.println("삭제한 ID: " + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* ================================================= */
	
	@Override
	public List<MemberVO> getMembersLink() {
		return null;
	}

	@Override
	public MemberVO getMemberLink(String id) {
		return null;
	}

	@Override
	public MemberVO addMemberLink(MemberVO memberVO) {
		return null;
	}

	@Override
	public MemberVO updateMembersLink(MemberVO memberVO) {
		return null;
	}

	@Override
	public MemberVO removeMemberLink(String id) {
		return null;
	}
}
