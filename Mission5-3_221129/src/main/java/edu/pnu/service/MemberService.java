// 동작 확인 221129

package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDao;
import edu.pnu.dao.MemberDaoH2Impl;
import edu.pnu.dao.MemberDaoLinkImpl;
import edu.pnu.dao.log.LogDao;
import edu.pnu.dao.log.LogDaoFileImpl;
import edu.pnu.dao.log.LogDaoH2Impl;
import edu.pnu.memberVO.MemberVO;

@Service
public class MemberService {
	// sql query는 동시접속할 때 문제가 될 수 있다고 해서
	// 메서드 밖에서 선언했다.
	String getMembersquery = "select * from member order by id";
	String getMemberquery = "select * from member where id = ?";
	String addMemberquery = "insert into member (id, pass, name) values (?, ?, ?)";
	String updateMemberquery = "update member set pass=?, name=? where id=?";
	String removeMemberquery = "delete from member where id=?";
	
	// h2 측 객체와 연결되는 변수와 Link쪽 객체와 연결되는 변수 각각의 이름을 dao, dao2라고 이름지어봤다.
	// MemberDao를 인터페이스로 만든 상태에서
	// h2측과 Link측으로 연결되는 메서드를 각각 만들어서 xximpl.java로 갈 수 있게 했다.
	
	// autowired이든 qualifier이든 그걸 dao/dao2에 거는 순간 변수가 null이 된다.
	// 그래서 그 변수를 생성자에서 인스턴스화했다.
	// 니가 자주 보는 cannot instantiate the type 어쩌구는 그걸 못하겠다는 뜻이다.
	// 보통 추상클래스는 인스턴스화할 수 없다.
	// auto-wiring을 2개 이상 하고 싶으면 @Qualifier를 써라.
	
	@Qualifier("MemberDaoH2Impl")
	MemberDao dao;
	@Qualifier("MemberDaoLinkImpl")
	MemberDao dao2;
	
	// LogDaoFileImpl.java와 LogDaoH2Impl.java가 LogDao 인터페이스에서 상속받도록 했다.
	private LogDao logDao;
	private LogDaoH2Impl dblogH2;
	List<MemberVO> list = new ArrayList<>();
	
	public MemberService() {
		logDao = new LogDaoFileImpl();
		dblogH2 = new LogDaoH2Impl();
		dao = new MemberDaoH2Impl();
		dao2 = new MemberDaoLinkImpl();
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
		dblogH2.addLog("get", getMembersquery, true);
		return dao2.getMembersLink();
	}
	
	public MemberVO getMemberLink(String id) {
		logDao.addLog("get", getMemberquery, true);
		dblogH2.addLog("get", getMemberquery, true);
		return dao2.getMemberLink(id);
	}

	public MemberVO addMemberLink(MemberVO memberVO) {
		logDao.addLog("get", addMemberquery, true);
		dblogH2.addLog("post", addMemberquery, true);
		return dao2.addMemberLink(memberVO);
	}

	public MemberVO updateMembersLink(MemberVO memberVO) {
		logDao.addLog("put", updateMemberquery, true);
		dblogH2.addLog("put", updateMemberquery, true);
		return dao2.updateMembersLink(memberVO);
	}

	public MemberVO removeMemberLink(String id) {
		logDao.addLog("delete", removeMemberquery, true);
		dblogH2.addLog("delete", removeMemberquery, true);
		return dao2.removeMemberLink(id);
	}
}
