package com.kwon.mini.community;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwon.mini.SiteOption;
import com.kwon.mini.member.Member;

@Service
public class CommunityDAO {
	private int allMsgCount;
	@Autowired
	private SqlSession ss;

	@Autowired
	private SiteOption so;
	
	public void countAllMsg() {
		allMsgCount = ss.getMapper(CommunityMapper.class).getAllMsgCount();
	}
	
	// 검색부분을 지워놓는다
	public void searchClear(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}
	
	public void getMsg(int page, HttpServletRequest req) {
		req.setAttribute("curPage", page);
		String search = (String) req.getSession().getAttribute("search");
		int msgCount = 0;
		
		if (search==null) { // 전체조회됨
			msgCount = allMsgCount;
			search = "";
		} else {
			CommunitySelector cSel1 = new CommunitySelector(search, 0, 0);
			msgCount = ss.getMapper(CommunityMapper.class).getSearchMsgCount(cSel1);
		}
		int allPageCount = (int) Math.ceil((double)msgCount / so.getSnsMsgPerPage());
		req.setAttribute("allPageCount", allPageCount);
		
		int start = (page-1) * so.getSnsMsgPerPage() + 1;
		int end = (page == allPageCount) ? msgCount : start + so.getSnsMsgPerPage()-1;
		
		CommunitySelector cSel = new CommunitySelector(search, start, end);
		List<Community> community = ss.getMapper(CommunityMapper.class).getCom(cSel);
		
		for (Community community1 : community) {
			community1.setC_c(ss.getMapper(CommunityMapper.class).getCC(community1));
		}		
		req.setAttribute("msgs", community);
	}
	
	
	// 글 쓰기
	public void writeMsg(Community c, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			
			String st2 = (String) req.getSession().getAttribute("st");
			
			if (st2 != null && token.equals(st2)) {
				req.setAttribute("r", "글쓰기실패");
				return;
			}
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			c.setM_id(m.getM_id());
			String txt = c.getC_txt();
			txt = txt.replace("/r/n", "<br>");
			c.setC_txt(txt);
			
			if (ss.getMapper(CommunityMapper.class).writeCommunity(c)==1) {
				req.setAttribute("r", "글쓰기 성공");
				req.getSession().setAttribute("st", token);
				allMsgCount++;
			} else {
				req.setAttribute("r", "글쓰기 실패1");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "글쓰기 실패2");
		}
	}

	// 게시글 삭제
	public void deleteMsg(Community c, HttpServletRequest req) {
		try {
			if (ss.getMapper(CommunityMapper.class).deleteCommunity(c)==1) {
				req.setAttribute("r", "게시글 삭제완료");
				allMsgCount--;
			} else {
				req.setAttribute("r", "게시글 삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "게시글 삭제실패");
		}
	}
	
	// 댓글 삭제
	public void deleteComment(Community_comment cc, HttpServletRequest req) {
		try {
			if (ss.getMapper(CommunityMapper.class).deleteCommunity_comment(cc)==1) {
				req.setAttribute("r", "댓글 삭제완료");
			} else {
				req.setAttribute("r", "댓글 삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "댓글 삭제실패");
		}
	}

	// 댓글 쓰기
	public void writeComment(Community_comment cc, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			String st2 = (String) req.getSession().getAttribute("st");
			if (st2 != null && token.equals(st2)) {
				req.setAttribute("r", "댓글쓰기 실패(새로고침)");
				return;
			}
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			cc.setCc_owner(m.getM_id());
			if (ss.getMapper(CommunityMapper.class).writecomment(cc)==1) {
				req.setAttribute("r", "댓글쓰기 성공");
				req.getSession().setAttribute("st", token);
			} else {
				req.setAttribute("r", "댓글쓰기  실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "댓글쓰기 실패");
		}
	}

	// 검색
	public void searchMsg(HttpServletRequest req) {
		String search = req.getParameter("search");
		req.getSession().setAttribute("search",search);
	}
	
	// 글 업뎃
	public void updateMsg(Community c, HttpServletRequest req) {
		try {
			if (ss.getMapper(CommunityMapper.class).updateCommunity(c)==1) {
				req.setAttribute("r", "글 업데이트 완료");
			} else {
				req.setAttribute("r", "글 업데이트 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "글 업데이트 실패");
		}
	}

}
