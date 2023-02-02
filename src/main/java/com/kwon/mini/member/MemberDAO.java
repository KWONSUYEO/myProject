package com.kwon.mini.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDAO {
	@Autowired
	private SqlSession ss;
	
	public Members idCheck(Member m) {
		return new Members(ss.getMapper(MemberMapper.class).getMember(m));
	}
	// 로그아웃 먼저
	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}
	
	public boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		if (m != null) {
			req.setAttribute("loginPage", "member/loginSuccess.jsp");
			return true;
		} else {
			req.setAttribute("loginPage", "member/login.jsp");
			return false;
		}
	}
	// 로그인
	public void login(Member m, HttpServletRequest req) {
		try {
			List<Member> ms = ss.getMapper(MemberMapper.class).getMember(m);
			if (ms.size() !=0) {
				Member m1 = ms.get(0);
				if (m1.getM_id().equals(m.getM_id())) {
					req.getSession().setAttribute("loginMember", m1);
					req.getSession().setMaxInactiveInterval(10*120);
					req.setAttribute("r", "로그인 완료");
				} else {
					req.setAttribute("r", "로그인실패(PW오류)");
				}
			} else {
				req.setAttribute("r", "로그인실패(미가입ID)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "로그인 실패(서버오류)");
		}
	}
	
	// 회원가입
	public void join(Member m, HttpServletRequest req) {
		try {
			m.setM_id(req.getParameter("m_id"));
			m.setM_password(req.getParameter("m_password"));
			m.setM_name(req.getParameter("m_name"));
			m.setM_phone(req.getParameter("m_phone"));
			
			String add1 = req.getParameter("m_addr1");
			String add2 = req.getParameter("m_addr2");
			String add3 = req.getParameter("m_addr3");
			String m_add = add2 + "!" + add3 + "!" + add1; // 주소!상세주소!우편번호
			m.setM_add(m_add);
			
			m.setM_email(req.getParameter("m_email"));
			m.setM_pwchque(req.getParameter("m_pwchque"));
			m.setM_pwchans(req.getParameter("m_pwchans"));
			if (ss.getMapper(MemberMapper.class).join(m)==1) {
				req.setAttribute("r", "회원가입성공");
			} 
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "회원가입실패");
		}
	}
	
	// 업데이트
	public void update(Member m, HttpServletRequest req) {
		try {
			m.setM_password(req.getParameter("m_password"));
			m.setM_name(req.getParameter("m_name"));
			m.setM_phone(req.getParameter("m_phone"));
			String add1 = req.getParameter("m_addr1");
			String add2 = req.getParameter("m_addr2");
			String add3 = req.getParameter("m_addr3");
			String m_add = add2 + "!" + add3 + "!" + add1; // 주소!상세주소!우편번호
			m.setM_add(m_add);
			
			m.setM_email(req.getParameter("m_email"));
			m.setM_pwchque(req.getParameter("m_pwchque"));
			m.setM_pwchans(req.getParameter("m_pwchans"));
			if (ss.getMapper(MemberMapper.class).update(m)==1) {
				req.setAttribute("r", "업데이트 성공");
				req.getSession().setAttribute("loginMember", m);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "업데이트 실패");
		}
	}
	
	public void divideAdd(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String add = m.getM_add();
		String[] add2 = add.split("!");
		req.setAttribute("add", add2);
	}
	
	// 탈퇴
	public void withdraw(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			if (ss.getMapper(MemberMapper.class).withdraw(m)==1) {
				req.setAttribute("r", "탈퇴성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "탈퇴실패");
		}
	}
	
	
	
	
}
