package com.kwon.mini.community;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwon.mini.member.MemberDAO;

@Controller
public class CommunityController {


	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private CommunityDAO cDAO;
	
	private boolean isFirstReq;

	public CommunityController() {
		isFirstReq = true;
	}
	// 글 보기
	
	@RequestMapping(value = "/community.go", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		if (isFirstReq) {
			cDAO.countAllMsg();
			isFirstReq = false;
		}
		mDAO.loginCheck(req);
		cDAO.searchClear(req);
		cDAO.getMsg(1, req);
		com.kwon.mini.TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "community/community.jsp");
		return "index";
	}
	
	// 글지우기
	@RequestMapping(value = "/community.delete", method = RequestMethod.GET)
	public String snsDelete(Community c, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			cDAO.deleteMsg(c, req);
		}
		cDAO.getMsg(1, req);
		com.kwon.mini.TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "community/community.jsp");
		return "index";
	}
	// 페이지 넘기기
	
	@RequestMapping(value = "/community.page.change", method = RequestMethod.GET)
	public String snsPageChange(HttpServletRequest req) {
		mDAO.loginCheck(req);
		int p = Integer.parseInt(req.getParameter("p"));
		cDAO.getMsg(p, req);
		com.kwon.mini.TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "community/community.jsp");
		return "index";
	}
	
	// 댓글 지우기
	@RequestMapping(value = "/community.comment.delete", method = RequestMethod.GET)
	public String snsCommentDelete(Community_comment cc, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			cDAO.deleteComment(cc, req);
		}
		cDAO.getMsg(1, req);
		com.kwon.mini.TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "community/community.jsp");
		return "index";
	}
	
	// 댓글 쓰기
	@RequestMapping(value = "/community.comment.write", method = RequestMethod.GET)
	public String snsReplyWrite(Community_comment cc, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			cDAO.writeComment(cc, req);
		}
		cDAO.getMsg(1, req);
		com.kwon.mini.TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "community/community.jsp");
		return "index";
	}
	
	// 검색
	@RequestMapping(value = "/community.search", method = RequestMethod.GET)
	public String snsSearch(HttpServletRequest req) {
		mDAO.loginCheck(req);
		cDAO.searchMsg(req);
		cDAO.getMsg(1, req);
		com.kwon.mini.TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "community/community.jsp");
		return "index";
	}

	// 글 업뎃
	@RequestMapping(value = "/community.update", method = RequestMethod.GET)
	public String snsUpdate(Community c, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			cDAO.updateMsg(c, req);
		}
		cDAO.getMsg(1, req);
		com.kwon.mini.TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "community/community.jsp");
		return "index";
	}

	// 글 쓰기
	@RequestMapping(value = "/community.write", method = RequestMethod.GET)
	public String snsWrite(Community c, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			cDAO.writeMsg(c, req);
		}
		cDAO.getMsg(1, req);
		com.kwon.mini.TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "community/community.jsp");
		return "index";
	}


}
