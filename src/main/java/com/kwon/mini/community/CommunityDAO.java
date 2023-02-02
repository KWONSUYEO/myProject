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
	
	// �˻��κ��� �������´�
	public void searchClear(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}
	
	public void getMsg(int page, HttpServletRequest req) {
		req.setAttribute("curPage", page);
		String search = (String) req.getSession().getAttribute("search");
		int msgCount = 0;
		
		if (search==null) { // ��ü��ȸ��
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
	
	
	// �� ����
	public void writeMsg(Community c, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			
			String st2 = (String) req.getSession().getAttribute("st");
			
			if (st2 != null && token.equals(st2)) {
				req.setAttribute("r", "�۾������");
				return;
			}
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			c.setM_id(m.getM_id());
			String txt = c.getC_txt();
			txt = txt.replace("/r/n", "<br>");
			c.setC_txt(txt);
			
			if (ss.getMapper(CommunityMapper.class).writeCommunity(c)==1) {
				req.setAttribute("r", "�۾��� ����");
				req.getSession().setAttribute("st", token);
				allMsgCount++;
			} else {
				req.setAttribute("r", "�۾��� ����1");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "�۾��� ����2");
		}
	}

	// �Խñ� ����
	public void deleteMsg(Community c, HttpServletRequest req) {
		try {
			if (ss.getMapper(CommunityMapper.class).deleteCommunity(c)==1) {
				req.setAttribute("r", "�Խñ� �����Ϸ�");
				allMsgCount--;
			} else {
				req.setAttribute("r", "�Խñ� ��������");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "�Խñ� ��������");
		}
	}
	
	// ��� ����
	public void deleteComment(Community_comment cc, HttpServletRequest req) {
		try {
			if (ss.getMapper(CommunityMapper.class).deleteCommunity_comment(cc)==1) {
				req.setAttribute("r", "��� �����Ϸ�");
			} else {
				req.setAttribute("r", "��� ��������");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "��� ��������");
		}
	}

	// ��� ����
	public void writeComment(Community_comment cc, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			String st2 = (String) req.getSession().getAttribute("st");
			if (st2 != null && token.equals(st2)) {
				req.setAttribute("r", "��۾��� ����(���ΰ�ħ)");
				return;
			}
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			cc.setCc_owner(m.getM_id());
			if (ss.getMapper(CommunityMapper.class).writecomment(cc)==1) {
				req.setAttribute("r", "��۾��� ����");
				req.getSession().setAttribute("st", token);
			} else {
				req.setAttribute("r", "��۾���  ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "��۾��� ����");
		}
	}

	// �˻�
	public void searchMsg(HttpServletRequest req) {
		String search = req.getParameter("search");
		req.getSession().setAttribute("search",search);
	}
	
	// �� ����
	public void updateMsg(Community c, HttpServletRequest req) {
		try {
			if (ss.getMapper(CommunityMapper.class).updateCommunity(c)==1) {
				req.setAttribute("r", "�� ������Ʈ �Ϸ�");
			} else {
				req.setAttribute("r", "�� ������Ʈ ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "�� ������Ʈ ����");
		}
	}

}
