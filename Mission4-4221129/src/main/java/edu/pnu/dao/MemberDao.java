package edu.pnu.dao;

import java.util.List;

import edu.pnu.memberVO.MemberVO;

public interface MemberDao {

	List<MemberVO> getMembers();

	List<MemberVO> getMember(String id);

	List<MemberVO> addMember(MemberVO memberVO);

	List<MemberVO> updateMember(MemberVO memberVO);

	List<MemberVO> removeMember(String id);

	List<MemberVO> getMembersLink();

	MemberVO getMemberLink(String id);

	MemberVO addMemberLink(MemberVO memberVO);

	MemberVO updateMembersLink(MemberVO memberVO);

	MemberVO removeMemberLink(String id);

}