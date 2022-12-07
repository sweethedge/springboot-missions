package edu.pnu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import edu.pnu.memberVO.MemberVO;

public class MemberDaoLinkImpl implements MemberDao {
	
	List<MemberVO> list = new ArrayList<MemberVO>();
	
	public MemberDaoLinkImpl() {
		for (int i = 1; i <= 2; i++) {
			MemberVO m = new MemberVO();
			m.setId("id" + i);
			m.setPass("pass" + i);
			m.setName("name" + i);
			m.setRegidate(new Date());
			list.add(m);
		}
	}
	
	@Override
	public List<MemberVO> getMembersLink() {
		return list;
	}

	@Override
	public MemberVO getMemberLink(String id) {
		// !!!!!!!!!!
		for (MemberVO m : list)
		if (m.getId().equals(id)) {
			return m;
		}
		return null;
	}

	@Override
	public MemberVO addMemberLink(MemberVO memberVO) {
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return memberVO;
	}

	@Override
	public MemberVO updateMembersLink(MemberVO memberVO) {
		for (MemberVO m : list)
		if (m.getId().equals(memberVO.getId())) {
			m.setPass(memberVO.getPass());
			m.setName(memberVO.getName());
		}
		return memberVO;
	}

	@Override
	public MemberVO removeMemberLink(String id) {
		// !!!!!!!!!!
		for (MemberVO m : list) {
			if (m.getId().equals(id)) {
				list.remove(m);
				return m;
			}
		}
		return null;
	}
	
	/* ============================================= */
	
	@Override
	public List<MemberVO> getMembers() {
		return null;
	}

	@Override
	public List<MemberVO> getMember(String id) {
		return null;
	}

	@Override
	public List<MemberVO> addMember(MemberVO memberVO) {
		return null;
	}

	@Override
	public List<MemberVO> updateMember(MemberVO memberVO) {
		return null;
	}

	@Override
	public List<MemberVO> removeMember(String id) {
		return null;
	}

}
