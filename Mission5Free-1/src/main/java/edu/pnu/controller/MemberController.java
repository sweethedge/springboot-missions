package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	MemberService ms;
	
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		return ms.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public List<MemberVO> getMember(@PathVariable String id) {
		return ms.getMember(id);
	}
	
	@PostMapping("/member")
	public List<MemberVO> addMember(MemberVO memberVO) {
		return ms.addMember(memberVO);
	}
	
	@PutMapping("/member")
	public List<MemberVO> updateMember(MemberVO memberVO) {
		return ms.updateMember(memberVO);
	}
	
	@DeleteMapping("/member/{id}")
	public List<MemberVO> deleteMember(@PathVariable String id) {
		return ms.deleteMember(id);
	}
	
	@GetMapping("/memberLink")
	public List<MemberVO> getMembersLink() {
		return ms.getMembersLink();
	}
	
	@GetMapping("/memberLink/{id}")
	public List<MemberVO> getMemberLink(@PathVariable String id) {
		return ms.getMemberLink(id);
	}
	
	@PostMapping("/memberLink")
	public List<MemberVO> addMemberLink(MemberVO memberVO) {
		return ms.addMemberLink(memberVO);
	}
	
	@PutMapping("/memberLink")
	public List<MemberVO> updateMemberLink(MemberVO memberVO) {
		return ms.updateMemberLink(memberVO);
	}
	
	@DeleteMapping("/memberLink/{id}")
	public List<MemberVO> deleteMemberLink(@PathVariable String id) {
		return ms.deleteMemberLink(id);
	}

}
