package com.kwon.mini.community;

import java.math.BigDecimal;
import java.util.Date;

public class Community_comment {
	private BigDecimal cc_no;
	private BigDecimal cc_c_no;
	private String cc_owner;
	private String cc_txt;
	private Date cc_when;
public Community_comment() {
	// TODO Auto-generated constructor stub
}
public Community_comment(BigDecimal cc_no, BigDecimal cc_c_no, String cc_owner, String cc_txt, Date cc_when) {
	super();
	this.cc_no = cc_no;
	this.cc_c_no = cc_c_no;
	this.cc_owner = cc_owner;
	this.cc_txt = cc_txt;
	this.cc_when = cc_when;
}
public BigDecimal getCc_no() {
	return cc_no;
}
public void setCc_no(BigDecimal cc_no) {
	this.cc_no = cc_no;
}
public BigDecimal getCc_c_no() {
	return cc_c_no;
}
public void setCc_c_no(BigDecimal cc_c_no) {
	this.cc_c_no = cc_c_no;
}
public String getCc_owner() {
	return cc_owner;
}
public void setCc_owner(String cc_owner) {
	this.cc_owner = cc_owner;
}
public String getCc_txt() {
	return cc_txt;
}
public void setCc_txt(String cc_txt) {
	this.cc_txt = cc_txt;
}
public Date getCc_when() {
	return cc_when;
}
public void setCc_when(Date cc_when) {
	this.cc_when = cc_when;
}


}
