-- 요식업 프랜차이즈 (참조관계 고려 X)

-- 홍콩반점 서초점은 홍길동이 운영하고 100석
-- 홍콩반점 종로점은 김길동이 운영하고 80석
-- 한신포차 강남점은 홍길동이 운영하고 150석
-- 부천포차 부천점은 최길동이 운영하고 130석
create table jun05_franchise(
	f_no number(3) primary key,					-- 식당 번호
	f_name varchar2(10 char) not null,				
	f_location varchar2(10 char) not null,
	f_ceo number(3) not null,					-- 사장님 번호
	f_seat number(3) not null
);
create sequence jun05_franchise_seq;
insert into jun05_franchise values(jun05_franchise_seq.nextval, '홍콩반점', '서초점', 1, 100);
insert into jun05_franchise values(jun05_franchise_seq.nextval, '홍콩반점', '종로점', 2, 80);
insert into jun05_franchise values(jun05_franchise_seq.nextval, '한신포차', '강남점', 3, 150);
insert into jun05_franchise values(jun05_franchise_seq.nextval, '부천포차', '부천점', 4, 130);
select * from jun05_franchise;
----------------------------------------------------------------
-- 홍길동, 1990-03-01일생, 남자 
-- 김길동, 1992-02-01일생, 여자 
-- 홍길동, 1991-12-12일생, 여자 
-- 최길동, 1989-09-01일생, 남자 
create table jun05_ceo(
	c_no number(3) primary key,
	c_name varchar2(10 char) not null,
	c_birthday date not null,
	c_gender char(2 char) not null
);
create sequence jun05_ceo_seq;

insert into jun05_ceo values(jun05_ceo_seq.nextval, '홍길동', to_date('1990-03-01', 'YYYY-MM-DD'), '남자');
insert into jun05_ceo values(jun05_ceo_seq.nextval, '김길동', to_date('1992-02-01', 'YYYY-MM-DD'), '여자');
insert into jun05_ceo values(jun05_ceo_seq.nextval, '홍길동', to_date('1991-12-12', 'YYYY-MM-DD'), '여자');
insert into jun05_ceo values(jun05_ceo_seq.nextval, '최길동', to_date('1989-09-01', 'YYYY-MM-DD'), '남자');
select * from jun05_ceo;
----------------------------------------------------------------
-- 짜장면, 5000원, 홍콩반점 서초점(100석) 에서 파는
-- 불닭발, 12000원, 한신포차 강남점(150석) 에서 파는
--	... 매장당 메뉴 5개 정도씩!
create table jun05_menu(
	m_no number(2) primary key,			-- 메뉴 번호
	m_name varchar2(10 char) not null,
	m_price number(5) not null,
	m_f_no number(3) not null			-- 메뉴를 파는 식당의 번호
);

create sequence jun05_menu_seq;

insert into jun05_menu values(jun05_menu_seq.nextval, '짜장면', 5000, 1);
insert into jun05_menu values(jun05_menu_seq.nextval, '짜장밥', 5500, 1);
insert into jun05_menu values(jun05_menu_seq.nextval, '볶음밥', 6000, 1);
insert into jun05_menu values(jun05_menu_seq.nextval, '유산슬', 14000, 1);
insert into jun05_menu values(jun05_menu_seq.nextval, '멘보샤', 4000, 1);
insert into jun05_menu values(jun05_menu_seq.nextval, '짜장밥', 6000, 2);
insert into jun05_menu values(jun05_menu_seq.nextval, '짬뽕밥', 8000, 2);
insert into jun05_menu values(jun05_menu_seq.nextval, '차돌짬뽕', 10000, 2);
insert into jun05_menu values(jun05_menu_seq.nextval, '고추잡채', 17000, 2);
insert into jun05_menu values(jun05_menu_seq.nextval, '삼선짜장', 13000, 2);
insert into jun05_menu values(jun05_menu_seq.nextval, '불닭발', 12000, 3);
insert into jun05_menu values(jun05_menu_seq.nextval, '계란찜', 6000, 3);
insert into jun05_menu values(jun05_menu_seq.nextval, '모래집', 10000, 3);
insert into jun05_menu values(jun05_menu_seq.nextval, '문어발', 4000, 3);
insert into jun05_menu values(jun05_menu_seq.nextval, '해물떡볶이', 16000, 3);
insert into jun05_menu values(jun05_menu_seq.nextval, '제육볶음', 12000, 4);
insert into jun05_menu values(jun05_menu_seq.nextval, '어묵탕', 10000, 4);
insert into jun05_menu values(jun05_menu_seq.nextval, '콘치즈', 5000, 4);
insert into jun05_menu values(jun05_menu_seq.nextval, '오징어땅콩', 8000, 4);
insert into jun05_menu values(jun05_menu_seq.nextval, '한치', 9000, 4);

select * from jun05_menu;