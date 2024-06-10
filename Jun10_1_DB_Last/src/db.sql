-- 어떤 특정한 식당에 대한 테이블
-- 식당 지점(체인점 지역), 식당 주인(이름), 좌석 수

-- 데이터 2-3개 정도 넣기
create table jun10_restaurant (
	r_location varchar2(10 char) primary key,
	r_owner varchar2(10 char) not null,
	r_seat number(4) not null
);
drop table jun10_restaurant;
insert into jun10_restaurant values('서초점', '김기덕', 120);
insert into jun10_restaurant values('강남점', '허창식', 90);
insert into jun10_restaurant values('대치점', '박준영', 110);
select * from JUN10_restaurant;
------------------------------------------------------------------
-- 예약 테이블
-- 예약자 이름, 예약 시간, 예약자 전화번호, 예약 지점

-- 데이터 2-3개 정도 넣기
create table jun10_reservation (
	r_no number(4) primary key,
	r_name varchar2(20 char) not null,
	r_time date not null,
	r_phone char(13 char) not null,
	r_location varchar2(10 char) not null,
	constraint fk_r_location foreign key(r_location)
	references jun10_restaurant(r_location)
	on delete cascade
);
create sequence jun10_reservation_seq;
drop table jun10_reservation;
drop sequence jun10_reservation_seq;
insert into jun10_reservation values(jun10_reservation_seq.nextval, '박고객', to_date('2024-06-20 16:00', 'YYYY-MM-DD HH24:MI'), '010-0011-2233', '서초점');
insert into jun10_reservation values(jun10_reservation_seq.nextval, '김손님', to_date('2024-06-20 16:00', 'YYYY-MM-DD HH24:MI'), '010-1234-1234', '강남점');
insert into jun10_reservation values(jun10_reservation_seq.nextval, '이선생', to_date('2024-06-20 16:00', 'YYYY-MM-DD HH24:MI'), '010-0123-4567', '대치점');
select * from JUN10_reservation;
------------------------------------------------------------------
