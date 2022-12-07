package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.dao.MemberDao;
import edu.pnu.dao.MemberDaoH2Impl;
import edu.pnu.dao.MemberDaoLinkImpl;
import edu.pnu.dao.log.LogDao;
import edu.pnu.dao.log.LogDaoFileImpl;
import edu.pnu.dao.log.LogDaoH2Impl;
import edu.pnu.memberVO.MemberVO;

public class MemberService {

	// h2 측 객체와 연결되는 변수와 Link쪽 객체와 연결되는 변수 각각의 이름을 dao, dao2라고 이름지어봤다.
	// MemberDao를 인터페이스로 만든 상태에서
	// h2측과 Link측으로 연결되는 메서드를 각각 만들어서 xximpl.java로 갈 수 있게 했다.
	
	// 이 부분을 나중에 log 구현하고 미션 5에서 이게 되는지 생각해 보기로 한다.
//	@Autowired
//	@Qualifier("MemberDaoH2Impl")
//	MemberDao dao;
//	@Autowired
//	@Qualifier("MemberDaoLinkImpl")
//	MemberDao dao2;
	
	
	MemberDao dao = new MemberDaoH2Impl();
	MemberDao dao2 = new MemberDaoLinkImpl();
	private LogDao logDao;
	private LogDaoH2Impl dblogH2;
	List<MemberVO> list = new ArrayList<>();
	String getMembersquery = "select * from member order by id";
	String getMemberquery = "select * from member where id = ?";
	String addMemberquery = "insert into member (id, pass, name) values (?, ?, ?)";
	String updateMemberquery = "update member set pass=?, name=? where id=?";
	String removeMemberquery = "delete from member where id=?";
	
	public MemberService() {
		dblogH2 = new LogDaoH2Impl();
		logDao = new LogDaoFileImpl();
	}

	
	public List<MemberVO> getMembers() {
		logDao.addLog("get", getMembersquery, true);
		dblogH2.addLog("get", getMembersquery, true);
		return dao.getMembers();
	}

	public List<MemberVO> getMember(String id) {
		logDao.addLog("get", getMemberquery, true);
		dblogH2.addLog("get", getMemberquery, true);
		return dao.getMember(id);
	}

	public List<MemberVO> addMember(MemberVO memberVO) {
		logDao.addLog("post", addMemberquery, true);
		dblogH2.addLog("post", addMemberquery, true);
		return dao.addMember(memberVO);
	}

	public List<MemberVO> updateMember(MemberVO memberVO) {
		logDao.addLog("put", updateMemberquery, true);
		dblogH2.addLog("put", updateMemberquery, true);
		return dao.updateMember(memberVO);
	}

	public List<MemberVO> removeMember(String id) {
		logDao.addLog("delete", removeMemberquery, true);
		dblogH2.addLog("delete", removeMemberquery, true);
		return dao.removeMember(id);
	}
	
	/* ===================================== */

	public List<MemberVO> getMembersLink() {
		logDao.addLog("get", getMembersquery, true);
		return dao2.getMembersLink();
	}
	
	public MemberVO getMemberLink(String id) {
		logDao.addLog("get", getMemberquery, true);
		return dao2.getMemberLink(id);
	}

	public MemberVO addMemberLink(MemberVO memberVO) {
		logDao.addLog("get", addMemberquery, true);
		return dao2.addMemberLink(memberVO);
	}

	public MemberVO updateMembersLink(MemberVO memberVO) {
		logDao.addLog("get", updateMemberquery, true);
		return dao2.updateMembersLink(memberVO);
	}

	public MemberVO removeMemberLink(String id) {
		logDao.addLog("get", removeMemberquery, true);
		return dao2.removeMemberLink(id);
	}
}
