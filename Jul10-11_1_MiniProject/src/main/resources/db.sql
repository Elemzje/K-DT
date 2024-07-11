create table jul10_member(
	m_id varchar2(12 char) primary key,
	m_pw varchar2(12 char) not null,
	m_affiliation varchar2(20 char) not null
);

select * from jul10_member;

create table jul10_result(
	r_no number(4) primary key,
	r_type varchar2(5 char) not null,
	r_calcstr varchar2(300 char) not null,
	r_when date not null,
	r_user varchar2(12 char) not null,
	constraint jul10_result_fk foreign key(r_user)
		references jul10_member(m_id)
		on delete set null
);

create sequence jul10_result_seq;

select * from jul10_result;
