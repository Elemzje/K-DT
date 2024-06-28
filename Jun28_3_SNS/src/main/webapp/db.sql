create table jun28_member(
	m_id varchar2(12 char) primary key,
	m_pw varchar2(12 char) not null,
	m_name varchar2(20 char) not null,
	m_phone_no char(13 char) not null,
	m_birthday date not null,
	m_img varchar2(250 char) not null
);
drop table jun28_member;
insert into JUN28_MEMBER values('testid', 'testpw', 'testname', '010-1111-1111', sysdate, 'testimgurl');
select * from JUN28_MEMBER;