package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDaoH2Impl;
import edu.pnu.dao.MemberDaoLinkImpl;
import edu.pnu.dao.MemberDao;
import edu.pnu.memberVO.MemberVO;

public class MemberService {

	// h2 측 객체와 연결되는 변수와 Link쪽 객체와 연결되는 변수 각각의 이름을 dao, dao2라고 이름지어봤다.
	// MemberDao를 인터페이스로 만든 상태에서
	// h2측과 Link측으로 연결되는 메서드를 각각 만들어서 xximpl.java로 갈 수 있게 했다.
	MemberDao dao = new MemberDaoH2Impl();
	MemberDao dao2 = new MemberDaoLinkImpl();
	
	public List<MemberVO> getMembers() {
		return dao.getMembers();
	}

	public List<MemberVO> getMember(String id) {
		return dao.getMember(id);
	}

	public List<MemberVO> addMember(MemberVO memberVO) {
		return dao.addMember(memberVO);
	}

	public List<MemberVO> updateMember(MemberVO memberVO) {
		return dao.updateMember(memberVO);
	}

	public List<MemberVO> removeMember(String id) {
		return dao.removeMember(id);
	}
	/* ===================================== */

	public List<MemberVO> getMembersLink() {
		return dao2.getMembersLink();
	}
	
	public MemberVO getMemberLink(String id) {
		return dao2.getMemberLink(id);
	}

	public MemberVO addMemberLink(MemberVO memberVO) {
		return dao2.addMemberLink(memberVO);
	}

	public MemberVO updateMembersLink(MemberVO memberVO) {
		return dao2.updateMembersLink(memberVO);
	}

	public MemberVO removeMemberLink(String id) {
		return dao2.removeMemberLink(id);
	}
}
