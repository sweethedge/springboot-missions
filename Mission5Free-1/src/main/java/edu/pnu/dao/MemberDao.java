package edu.pnu.dao;

import java.util.List;

import edu.pnu.domain.MemberVO;

public interface MemberDao {

	List<MemberVO> getMembers();

	List<MemberVO> getMember(String id);

	List<MemberVO> addMember(MemberVO memberVO);

	List<MemberVO> updateMember(MemberVO memberVO);

	List<MemberVO> deleteMember(String id);

}