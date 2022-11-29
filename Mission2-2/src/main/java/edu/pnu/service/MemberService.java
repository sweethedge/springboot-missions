package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDao;
import edu.pnu.memberVO.MemberVO;

public class MemberService {

	MemberDao dao = new MemberDao();
	
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


}
