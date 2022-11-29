package edu.pnu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.pnu.memberVO.MemberVO;

@Repository("MemberDaoH2Impl")
public class MemberDaoH2Impl extends JDBConnectH2 implements MemberDao {

	// JDBC를 이용해서 연결.
	public MemberDaoH2Impl() {
		super("org.h2.Driver", "jdbc:h2:tcp://localhost/~/test", "sa", "");
	}

	@Override
	// 테이블 긁는 메서드
	public List<MemberVO> getMembers() {
		// 리스트 선언해서 쿼리 날리고
		List<MemberVO> list = new ArrayList<>();
		String query = "select * from member;";
		try {
			// 준비한거 rs에 담아서
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			
			// rs가 false가 될 때까지
			while (rs.next()) {
				// DTO 객체 생성해서
				MemberVO m = new MemberVO();
				// set 해주고 리스트에 넣는다
				m.setId(rs.getString(1));
				m.setPass(rs.getString(2));
				m.setName(rs.getString(3));
				m.setRegidate(rs.getDate(4));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 넣은 거 반환
		return list;
	}

	@Override
	// id가 같은 거 찾아주는 메서드
	// 위와 대동소이하다
	public List<MemberVO> getMember(String id) {
		List<MemberVO> list = new ArrayList<>();
		String query = "select * from member where id = ?;";		
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			rs.next();
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
	// 테이블에 insert하는 메서드.
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
