create table jul04_student(
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_nickname varchar2(10 char) not null
);

create sequence jul04_student_seq;

select * from jul04_student;
----------------------------------------------
create table jul04_test(
	t_no number(3) primary key,
	t_subject varchar2(10 char) not null,
	t_date date not null
);

create sequence jul04_test_seq;
insert into jul04_test values(jul04_test_seq.nextval, '주제', sysdate);
select * from jul04_test;
----------------------------------------------