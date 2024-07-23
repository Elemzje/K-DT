create table jul23_loc(
	l_no number(3) primary key,
	l_location varchar2(30 char) not null,
	l_phone_no varchar2(13 char) not null,
	l_longitude number(9, 6) not null,
	l_latitude number(8, 6) not null
);
select * from jul23_loc
create sequence jul23_loc_seq;

-- NVL 함수 : null일 때 지정한 값으로 대치하는 함수
-- NVL(값, (값이)null일때 대체 값)
select nvl(null,'-'), nvl('null', '-') from dual;

-- NVL2 함수 : null의 여부에 따라서 지정한 값으로 대치하는 함수
-- NVL2(값, 값이 있을때 대체값, 값이 없을때 대체값)
select nvl2(null,'a','b'), nvl2('null','a','b') from dual;