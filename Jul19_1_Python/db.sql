create table jul19_weather(
	w_no number(3) primary key,
	w_hour number(2) not null,
	w_temp number(4) not null,
	w_tmx number(4) not null,
	w_wfkor varchar2(10 char) not null,
	w_wdkor varchar2(5 char) not null
);
select * from JUL19_WEATHER;
create sequence jul19_weather_seq;
-----------------------------------------
create table jul19_cityair(
	ca_no number(3) primary key,
	ca_msrste varchar2(5 char) not null,
	ca_pm10 number(4, 1) not null,
	ca_pm25 number(4, 1) not null
);
select * from JUL19_cityair;
create sequence jul19_cityair_seq;
-----------------------------------------
-- (table간 제약조건 고려 X)
-- 학생 : 이름, 생일, 몇 강의장, 중간, 기말
create table jul19_student(
	s_no number(4) primary key,
	s_name varchar2(10 char) not null,
	s_birthday date not null,
	s_class number(1) not null,
	s_mscore number(3) not null,
	s_lscore number(3) not null
);
select * from JUL19_student;
create sequence jul19_student_seq;
-----------------------------------------
-- 강의장 : 몇 강의장, 강의장 위치
-- 1강의장 : 5층 복도 오른쪽
-- 2강의장 : 5층 복도 왼쪽 끝
-- 3강의장 : 5층 복도 왼쪽 첫 번째
-- 4강의장 : 6층 정면
-- 5강의장 : 6층 오른쪽
-- 강의장에 대한 데이터는 여기서 insert
create table jul19_class(
	c_class number(1) primary key,
	c_pos varchar2(16 char) not null
);

insert into jul19_class values(1, '5층 복도 오른쪽');
insert into jul19_class values(2, '5층 복도 왼쪽 끝');
insert into jul19_class values(3, '5층 복도 왼쪽 첫 번째');
insert into jul19_class values(4, '6층 정면');
insert into jul19_class values(5, '6층 오른쪽');

select * from jul19_class;
