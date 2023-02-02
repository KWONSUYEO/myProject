package com.kwon.mini.community;

import java.util.List;

public interface CommunityMapper {
	// �� ����� ��
	public abstract int deleteCommunity(Community c);
	// ��� ����� ��
	public abstract int deleteCommunity_comment (Community_comment cc);
	// �� ���°�
	public abstract int getAllMsgCount();
	// �� ���°�
	public abstract List<Community> getCom(CommunitySelector cs);
	// ��� ���°�
	public abstract List<Community_comment> getCC(Community c);
	// ������ ���°�
	public abstract int getSearchMsgCount(CommunitySelector cSel);
	// �� ���°�
	public abstract int writeCommunity(Community c);
	// ��� ���°�
	public abstract int writecomment(Community_comment cc);
	// �� ����
	public abstract int updateCommunity(Community c);
	
}
