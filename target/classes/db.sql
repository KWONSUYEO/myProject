create table mini_member(
m_id varchar2(10 char) primary key,
m_password varchar2(20 char) not null,
m_name varchar2(10 char) not null,
m_phone varchar2(13 char) not null,
m_add varchar2(100 char) not null,
m_email varchar2(20 char) not null,
m_pwchque varchar2(30 char) not null,
m_pwchans varchar2(30 char) not null
)

select * from mini_member

---------------------
create table community(
	c_no number(4) primary key, 			
	c_owner varchar2(10 char) not null, 	
	c_txt varchar2(300 char) not null,
	c_when date not null
)
create sequence community_seq;
select * from community

insert into COMMUNITY values(community_seq.nextval,'susu','안녕하세요',to_date('2022-11-29', 'YYYY-MM-dd'))
insert into COMMUNITY values(community_seq.nextval,'susu','안녕하세요1',sysdate)

-------------------------------
create table community_comment(
	cc_no number(5) primary key, -- 댓글번호
	cc_c_no number(4) not null, -- 소속된 글 번호
	cc_owner varchar2(10 char) not null,
	cc_txt varchar2(200 char) not null,
	cc_when date not null,
	constraint community_comment1
		foreign key(cc_c_no) references community(c_no)
		on delete cascade
)
select * from community_comment
create sequence community_comment_seq;


