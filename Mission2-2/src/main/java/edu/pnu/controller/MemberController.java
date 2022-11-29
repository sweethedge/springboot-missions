package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.memberVO.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {

	MemberService ms = new MemberService();

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
	public List<MemberVO> removeMember(@PathVariable String id) {
		return ms.removeMember(id);
	}
}
