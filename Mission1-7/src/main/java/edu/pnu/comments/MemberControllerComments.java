package edu.pnu.comments;

public class MemberControllerComments {
	// 서비스에 대한 객체를 선언한다.

	// list에 있는 모든 정보를 요청하는 Url
//	@get
//	1. public List<MemberVO> getMembers() {
	// list에 있는 정보들 중에서 id가 {id}인 객체 하나를 요청하는 Url
//	@get
//	2. public MemberVO getMember(String id) {
	

//	@post
	// Postman에서 memberVO의 값을 받아서
	//	3. public MemberVO addMember(MemberVO memberVO) {
	
		// 서비스의 addMember로 날려줘라

	// update : 상기와 같음
//	@put
//	4. public MemberVO updateMember(MemberVO memberVO) {

	// @ 매개변수로서 @PathVariable이 들어온 경우는, 쿼리스트링이 아니라 / 뒤에 바로 들어온 매개변수를 처리해주게 된다.
//	@delete
//	5. public MemberVO removeMember(@PathVariable String id) {
	
	// 6. 매개변수에 id라는 값이 들어왔으면 그것도 이 메서드의 user로서 처리해달라

}