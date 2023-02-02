package com.kwon.mini.community;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Community {
	// member
	private String m_id;
	
	// community
	private BigDecimal c_no; // 글 번호
	private String c_txt; // 글 내용
	private Date c_when; // 날짜
	
	private List<Community_comment> c_c; // 댓글들
	public Community() {
		// TODO Auto-generated constructor stub
	}
	public Community(String m_id, BigDecimal c_no, String c_txt, Date c_when, List<Community_comment> c_c) {
		super();
		this.m_id = m_id;
		this.c_no = c_no;
		this.c_txt = c_txt;
		this.c_when = c_when;
		this.c_c = c_c;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public BigDecimal getC_no() {
		return c_no;
	}
	public void setC_no(BigDecimal c_no) {
		this.c_no = c_no;
	}
	public String getC_txt() {
		return c_txt;
	}
	public void setC_txt(String c_txt) {
		this.c_txt = c_txt;
	}
	public Date getC_when() {
		return c_when;
	}
	public void setC_when(Date c_when) {
		this.c_when = c_when;
	}
	public List<Community_comment> getC_c() {
		return c_c;
	}
	public void setC_c(List<Community_comment> c_c) {
		this.c_c = c_c;
	}
	
	
}
