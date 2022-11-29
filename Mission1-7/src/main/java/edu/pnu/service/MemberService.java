package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import edu.pnu.domain.MemberVO;

public class MemberService {

	List<MemberVO> list;
	
	public MemberService() {
		list = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			MemberVO m = new MemberVO();
			m.setId("id" + i);
			m.setPass("pass" + i);
			m.setName("name" + i);
			m.setRegidate(new Date());
			/**/ list.add(m);
			
		}
	}
	
	public List<MemberVO> getMembers() {
		return list;
	}
	
	public MemberVO getMember(@PathVariable String id) {
		for (MemberVO m : list) {
			if (m.getId().equals(id)) {
				return m;
			}
		}
		return null;
	}
	
	public MemberVO addMember(MemberVO memberVO) {
		memberVO.setRegidate(new Date());
		list.add(memberVO);
		return memberVO;
	}
	
	public MemberVO updateMembers(MemberVO memberVO) {
		for (MemberVO m : list)
			if (m.getId().equals(memberVO.getId())) {
				m.setName(memberVO.getName());
				m.setPass(memberVO.getPass());
				return m;
			}
		return memberVO;
	}
	
	public MemberVO removeMember(String id) {
		System.out.println("this is MemberService-removeMember");
		for (MemberVO m : list) {
			if (m.getId().equals(id)) {
				list.remove(m);
				return m;
			}
		}
		return null;
	}
}
