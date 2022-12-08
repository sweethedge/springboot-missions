package edu.pnu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.pnu.domain.MemberVO;

@Repository("MemberDaoLinkImpl")
public class MemberDaoLinkImpl implements MemberDao {
	List<MemberVO> list = null;
	public MemberDaoLinkImpl() {
		list = new ArrayList<>();
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
	public List<MemberVO> getMembers() {
		return list;
	}

	@Override
	public List<MemberVO> getMember(String id) {
		List<MemberVO> list1 = new ArrayList<>();
		
		for (MemberVO m : list) {
			if (m.getId().equals(id)) {
				list1.add(m);
				return list1;
			}
		}
		return null;
	}

	@Override
	public List<MemberVO> addMember(MemberVO memberVO) {
		MemberVO m = new MemberVO();
		m.setRegidate(new Date());
		list.add(memberVO);
		return list;
	}

	@Override
	public List<MemberVO> updateMember(MemberVO memberVO) {
		for (MemberVO m : list) {
			if (m.getId().equals(memberVO.getId())) {
				m.setPass(memberVO.getPass());
				m.setName(memberVO.getName());
			}
		}
		return list;
	}

	@Override
	public List<MemberVO> deleteMember(String id) {
		for (MemberVO m : list) {
			if (m.getId().equals(id)) {
				list.remove(m);
			}
		}
		return list;
	}

}
