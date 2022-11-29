package edu.pnu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import edu.pnu.memberVO.MemberVO;

@Repository("MemberDaoLinkImpl")
public class MemberDaoLinkImpl implements MemberDao {
	
	List<MemberVO> list = new ArrayList<MemberVO>();
	
	@Autowired
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
		// list를 '순회하면서' 매개변수랑 같은 memberDTO가 있으면 걔를 반환해라.
		for (MemberVO m : list)
		if (m.getId().equals(id)) {
			return m;
		}
		return null;
	}

	@Override
	public MemberVO addMemberLink(MemberVO memberVO) {
		// postman에 입력한 거를 list에 add하고 그 값을 반환해줘라.
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return memberVO;
	}

	@Override
	public MemberVO updateMembersLink(MemberVO memberVO) {
		// memberVO를 돌면서 id랑 같은 게 있으면 pass, name을 postman에 넣은 대로 set 해줘라.
		for (MemberVO m : list)
		if (m.getId().equals(memberVO.getId())) {
			m.setPass(memberVO.getPass());
			m.setName(memberVO.getName());
		}
		return memberVO;
	}

	@Override

	public MemberVO removeMemberLink(String id) {
		// memberVO를 돌면서 id가 같은 게 있으면 그거를 list에서 삭제해줘라.
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
