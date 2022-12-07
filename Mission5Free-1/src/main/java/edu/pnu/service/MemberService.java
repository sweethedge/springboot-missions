package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.pnu.dao.LogDaoH2Impl;
import edu.pnu.dao.MemberDao;
import edu.pnu.dao.MemberDaoH2Impl;
import edu.pnu.dao.MemberDaoLinkImpl;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {
	
	@Autowired @Qualifier("MemberDaoH2Impl")
	MemberDao dao;
	@Autowired @Qualifier("MemberDaoLinkImpl")
	MemberDao dao2;
	@Autowired @Qualifier("LogDaoH2Impl")
	LogDaoH2Impl h2;
	
	String getms = "select * from member";
	String getm = "select * from member where id = ?";
	String addm = "insert into member (id, pass, name) values (?, ?, ?)";
	String updm = "update member set pass=?, name=? where id = ?";
	String delm = "delete from member where id = ?";
	String get = "get";
	String post = "post";
	String put = "put";
	String delete = "delete";
	
	public List<MemberVO> getMembers() {
		List<MemberVO> list = dao.getMembers();
		if (list != null) {
			h2.addLog(get, getms, true);
		} else {
			h2.addLog(get, getms, false);
		}
		return dao.getMembers();
	}

	public List<MemberVO> getMember(String id) {
		List<MemberVO> list = dao.getMember(id);
		if (list != null) {
			h2.addLog(get, getm, true);
		} else {
			h2.addLog(get, getm, false);
		}
		return dao.getMember(id);
	}

	public List<MemberVO> addMember(MemberVO memberVO) {
		List<MemberVO> list = dao.addMember(memberVO);
		if (list != null) {
			h2.addLog(post, addm, true);
		} else {
			h2.addLog(post, addm, false);
		}
		return dao.addMember(memberVO);
	}

	public List<MemberVO> updateMember(MemberVO memberVO) {
		List<MemberVO> list = dao.updateMember(memberVO);
		if (list != null) {
			h2.addLog(put, updm, true);
		} else {
			h2.addLog(put, updm, false);
		}
		return dao.updateMember(memberVO);
	}

	public List<MemberVO> deleteMember(String id) {
		List<MemberVO> list = dao.deleteMember(id);
		if (list != null) {
			h2.addLog(delete, delm, true);
		} else {
			h2.addLog(delete, delm, false);
		}
		return dao.deleteMember(id);
	}

	public List<MemberVO> getMembersLink() {
		return dao2.getMembers();
	}

	public List<MemberVO> getMemberLink(String id) {
		return dao2.getMember(id);
	}

	public List<MemberVO> addMemberLink(MemberVO memberVO) {
		return dao2.addMember(memberVO);
	}

	public List<MemberVO> updateMemberLink(MemberVO memberVO) {
		return dao2.updateMember(memberVO);
	}

	public List<MemberVO> deleteMemberLink(String id) {
		return dao2.deleteMember(id);
	}
}
