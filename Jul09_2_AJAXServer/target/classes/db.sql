create table jul09_error(
	e_what varchar2(30 char) primary key,
	e_where varchar2(30 char) not null
);

insert into JUL09_ERROR values('@빼먹음', 'DAO');
insert into JUL09_ERROR values('mapper입력 빼먹음', 'servlet-context.xml');
insert into JUL09_ERROR values('세미콜론(;) 넣음', 'mapper.xml');
insert into JUL09_ERROR values('패키지 클래스 X', 'mapper.xml');
insert into JUL09_ERROR values('패키지 파일 위치', '프로젝트');

select * from JUL09_ERROR;