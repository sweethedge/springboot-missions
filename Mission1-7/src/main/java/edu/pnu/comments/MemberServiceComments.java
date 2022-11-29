package edu.pnu.comments;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

public class MemberServiceComments {
	// 객체들을 저장할 리스트 변수 선언
	
	// 기본 생성자를 개막해서

		// 객체들을 저장할 리스트 객체를 생성해서 list에 할당하고

			// 객체를 하나씩 생성해서

			// 값을 설정한 뒤에

			// 리스트에 저장

//	1. public List<MemberVO> getMembers() {
	// list에 있는 모든 정보를 요청하는 Url


	// list에 있는 정보들 중에서 id가 {id}인 객체 하나를 요청하는 Url
//	2. public MemberVO getMember(@PathVariable String id) {
	
		// list에 있는 객체들을 하나씩 꺼내어서 m에 설정

			// 객체 m의 id와 파라미터로 넘어온 id의 값이 같으면 m을 반환

	// 여기까지 진행되면 찾는 객체가 없다는 의미이므로 null을 리턴


	// 추가하고자 하는 member 정보를 전달, 추가된 객체를 출력
//	3. public MemberVO addMember(MemberVO memberVO) {
		// Date는 새로 set하고

		// list에 memberVO의 값을 add 해서

		// memberVO를 반환해줘라

	// memberVO의 값을 업데이트해서 출력하는 메서드
	//	4. public MemberVO updateMembers(MemberVO memberVO) {
	
		// list를 순회하면서
	
			// list의 id와 매개변수로 들어간 id의 값이 같으면
	
				// pass랑 name을 매개변수에 들어간대로 set 해줘라
	
				// MemberVO를 반환해 줘라
		
	// list에 있는 정보들 중에서 id가 {id}인 객체 하나를 삭제 요청하는 Url
//	5. public MemberVO removeMember(@PathVariable String id) {
	// 삭제하면서 대상 객체를 리턴한다. 없으면 null 리턴
	
}