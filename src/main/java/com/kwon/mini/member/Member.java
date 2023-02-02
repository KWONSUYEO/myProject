package com.kwon.mini.member;

public class Member {
	private String m_id;
	private String m_password;
	private String m_name;
	private String m_phone;
	private String m_add;
	private String m_email;
	private String m_pwchque;
	private String m_pwchans;
	public Member() {
		// TODO Auto-generated constructor stub
	}
	public Member(String m_id, String m_password, String m_name, String m_phone, String m_add, String m_email,
			String m_pwchque, String m_pwchans) {
		super();
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_name = m_name;
		this.m_phone = m_phone;
		this.m_add = m_add;
		this.m_email = m_email;
		this.m_pwchque = m_pwchque;
		this.m_pwchans = m_pwchans;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_phone() {
		return m_phone;
	}
	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}
	public String getM_add() {
		return m_add;
	}
	public void setM_add(String m_add) {
		this.m_add = m_add;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_pwchque() {
		return m_pwchque;
	}
	public void setM_pwchque(String m_pwchque) {
		this.m_pwchque = m_pwchque;
	}
	public String getM_pwchans() {
		return m_pwchans;
	}
	public void setM_pwchans(String m_pwchans) {
		this.m_pwchans = m_pwchans;
	}
	
}
