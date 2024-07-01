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
-------------------------------------------------------
create table jul01_board(
	b_no number(4) primary key,
	b_m_id varchar2(12 char) not null,
	b_content varchar2(200 char) not null,
	b_time date default sysdate,
	constraint jun01_board_fk foreign key(b_m_id)
		references jun28_member(m_id)
		on delete cascade
);

create sequence jul01_board_seq;
drop sequence jul01_board_seq;
drop table jul01_board;
insert into jul01_board values(jul01_board_seq.nextval, 'testid', 'testinput', default);
select * from jul01_board;