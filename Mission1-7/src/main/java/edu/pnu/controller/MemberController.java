package edu.pnu.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {

	MemberService ms = new MemberService();
	
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		return ms.getMembers();
		
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable String id) {
		return ms.getMember(id);
		
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
		return ms.addMember(memberVO);
		
	}
	
	@PutMapping("/member")
	public MemberVO updateMembers(MemberVO memberVO) {
		return ms.updateMembers(memberVO);
		
	}
	
	@DeleteMapping("/member/{id}")
	// @ 매개변수로서 @PathVariable이 들어온 경우는, 쿼리스트링이 아니라 / 뒤에 바로 들어온 매개변수를 처리해주게 된다.
	public MemberVO removeMember(@PathVariable String id) {
		return ms.removeMember(id);
	}
}

// 니가 서비스단에서 dao를 2개 이상 쓰고 싶으면 필드 앞에다가 @Qualifier("연결하고 싶은 이름")을 쓰고, 그 다음 그 연결할 Repo에도 Repository("연결하고 싶은 이름")을 달아라.
// 니가 저번에 했던 거는 니가 손을 댔는지 클래스로 연결이 되어 있고 개판이었다. 천천히 다시 해 봐라.