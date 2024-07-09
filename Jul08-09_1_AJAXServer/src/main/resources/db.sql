create table jul08_fruit(
	f_name varchar2(10 char) primary key,
	f_price number(5) not null
);

insert into jul08_fruit values('귤', 2800);
insert into jul08_fruit values('망고', 5500);
insert into jul08_fruit values('레몬', 8000);
insert into jul08_fruit values('수박', 13000);
insert into jul08_fruit values('사과', 2000);
insert into jul08_fruit values('샤인머스캣', 10800);

select * from jul08_fruit;