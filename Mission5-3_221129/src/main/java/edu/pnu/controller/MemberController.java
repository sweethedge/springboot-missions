// 동작확인 221129

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
	// 서비스단과 연결하기 위해서 memberService 객체를 생성했다.
	// 밑에서 만든 메서드의 반환값을 모조리 서비스 쪽으로 던졌다.
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
	
	/* ==================================== */
	
	@GetMapping("/memberLink")
	public List<MemberVO> getMembersLink() {
		return ms.getMembersLink();
	}
	
	@GetMapping("/memberLink/{id}")
	public MemberVO getMemberLink(@PathVariable String id) {
		return ms.getMemberLink(id);
		
	}
	
	@PostMapping("/memberLink")
	public MemberVO addMemberLink(MemberVO memberVO) {
		return ms.addMemberLink(memberVO);
		
	}
	
	@PutMapping("/memberLink")
	public MemberVO updateMembersLink(MemberVO memberVO) {
		return ms.updateMembersLink(memberVO);
		
	}
	
	@DeleteMapping("/memberLink")
	public MemberVO removeMemberLink(String id) {
		return ms.removeMemberLink(id);
		
	}

}
