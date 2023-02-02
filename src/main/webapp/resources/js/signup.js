function Join(){
	location.href ="member.join.go";
}

function Infogo(){
	location.href = "member.info.go";
}

function logout(){
	var real = confirm("로그아웃 하시겠습니까?");
	if(real) {
		location.href = "member.logout";
	}
}
function withdraw(){
	var real = confirm("탈퇴를 진행하시겠습니까?");
	if(real){
		location.href = "member.withdraw";
	}
}

function communityWriteCheck(){
	let c_txt = document.communityWriteForm.c_txt;
	if(isEmpty(c_txt)){
		alert("글을 입력하지 않았습니다.")
	}
}

function communityUpdate(c_no,c_txt){
	c_txt = prompt("변경할 내용");
	if(c_txt.length < 250){
		location.href = "community.update?c_no=" + c_no + "&c_txt=" + c_txt;			
	}
}

function communityDelect(c_no){
	let t = confirm("글을 삭제 하시겠습니까?");
	if (t) {
		location.href = "community.delete?c_no=" + c_no;
	}
}

function Community_commentDelete(cc_no){
	let t = confirm("댓글을 삭제 하시겠습니까?");
	if (t) {
		location.href = "community.comment.delete?cc_no=" + cc_no;
	}
}

function Community_commentWriteCheck(re){
	let cc_txt = re.cc_txt;
	if(isEmpty(cc_txt)){
		alert("댓글을 입력하지 않았습니다.")
		return false;
	}
	return true;
}


// id 중복확인
function connectIdCheckEvent(){
	$("#join_m_id").keyup(function() {
		var m_id = $(this).val();
		$.getJSON("member.id.check?m_id="+m_id, function(memberJSON){
			if (memberJSON.member[0] == null) {
				$("#join_m_id").css("color", "black");
			} else {
				$("#join_m_id").css("color", "red");
			}
		});
	});
}

// 주소
function connectSearchAddressEvent() {
	$("#join_m_addr1, #join_m_addr2").click(function() {
		new daum.Postcode({
			oncomplete : function(data) {
				$("#join_m_addr1").val(data.zonecode);
				$("#join_m_addr2").val(data.roadAddress);
			}
		}).open();
	});
}

function signupCheck(){
	let m_id=document.signup.m_id;
	let m_password=document.signup.m_password;
	let m_passwordCh=document.signup.m_passwordCh;
	let m_name=document.signup.m_name;
	let m_phone=document.signup.m_phone;
	let m_addr1=document.signup.m_addr1;
	let m_addr2=document.signup.m_addr2;
	let m_addr3=document.signup.m_addr3;
	let m_email=document.signup.m_email;
	let m_pwchans=document.signup.m_pwchans;
	
	if(isEmpty(m_id)||containsAnother(m_id)){
	alert("id를 다시 입력하세요")
	m_id.focus();
	m_id.value="";
	return false;
	
	}else if(isEmpty(m_password) || notEqualPw(m_password,m_passwordCh)){
	alert("pw를 다시 입력하세요");
	m_password.focus();
	m_password.value="";
	m_passwordCh.value="";
	return false;
	
	} else if(isEmpty(m_name)){
		alert("이름을 다시 입력하세요");
		m_name.focus();
		m_name.value="";
		return false;
		
	} else if(isEmpty(m_phone)){
		alert("전화번호를 다시 입력하세요");
		m_phone.focus();
		m_phone.value="";
		return false;
	} else if(isEmpty(m_addr1)||isEmpty(m_addr2)||isEmpty(m_addr3)){
		alert("주소를 다시 입력하세요");
		m_addr1.focus();
		m_addr1.value="";
		m_addr2.value="";
		return false;
	} else if(isEmpty(m_pwchans)){
		alert("질문의 답변을 입력하세요");
		m_pwchans.focus();
		m_pwchans.value="";
	} else if(isEmpty(m_email)||email(input)){
		alert("이메일을 다시 입력하세요");
		m_email.focus();
		m_email.value="";
		
	}
	
	return true;
}

$(function() {
	connectSearchAddressEvent();
	connectIdCheckEvent();
});
 
function memberUpdateCheck(){
	let m_id=document.memberUpdateCheck.m_id;
	let m_password=document.memberUpdateCheck.m_password;
	let m_passwordCh=document.memberUpdateCheck.m_passwordCh;
	let m_name=document.memberUpdateCheck.m_name;
	let m_phone=document.memberUpdateCheck.m_phone;
	let m_addr1=document.memberUpdateCheck.m_addr1;
	let m_addr2=document.memberUpdateCheck.m_addr2;
	let m_addr3=document.memberUpdateCheck.m_addr3;
	let m_email=document.memberUpdateCheck.m_email;
	let m_pwchans=document.memberUpdateCheck.m_pwchans;
	
	if(isEmpty(m_id)||containsAnother(m_id)){
		alert("id를 다시 입력하세요")
		m_id.focus();
		m_id.value="";
		return false;
		
		}else if(isEmpty(m_password) || notEqualPw(m_password,m_passwordCh)){
		alert("pw를 다시 입력하세요");
		m_password.focus();
		m_password.value="";
		m_passwordCh.value="";
		return false;
		
		} else if(isEmpty(m_name)){
			alert("이름을 다시 입력하세요");
			m_name.focus();
			m_name.value="";
			return false;
			
		} else if(isEmpty(m_phone)){
			alert("전화번호를 다시 입력하세요");
			m_phone.focus();
			m_phone.value="";
			return false;
		} else if(isEmpty(m_addr1)||isEmpty(m_addr2)||isEmpty(m_addr3)){
			alert("주소를 다시 입력하세요");
			m_addr1.focus();
			m_addr1.value="";
			m_addr2.value="";
			return false;
		} else if(isEmpty(m_pwchans)){
			alert("질문의 답변을 입력하세요");
			m_pwchans.focus();
			m_pwchans.value="";
		}
		return true;
		
		
	}
