package com.kwon.mini.community;

import java.util.List;

public interface CommunityMapper {
	// 글 지우는 거
	public abstract int deleteCommunity(Community c);
	// 댓글 지우는 거
	public abstract int deleteCommunity_comment (Community_comment cc);
	// 글 세는거
	public abstract int getAllMsgCount();
	// 글 보는거
	public abstract List<Community> getCom(CommunitySelector cs);
	// 댓글 보는거
	public abstract List<Community_comment> getCC(Community c);
	// 페이지 세는거
	public abstract int getSearchMsgCount(CommunitySelector cSel);
	// 글 쓰는거
	public abstract int writeCommunity(Community c);
	// 댓글 쓰는거
	public abstract int writecomment(Community_comment cc);
	// 글 업뎃
	public abstract int updateCommunity(Community c);
	
}
