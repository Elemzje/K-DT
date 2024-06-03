-- 웹사이트에서 게시판에 대한 테이블과 이를 [참조하는] 댓글 테이블을 만드려고 함
-- 게시판 테이블에는 [작성자 / 게시판 글 내용 / 작성 시간]에 대한 부분이 있었으면
-- 댓글 테이블에는 [작성자 / 댓글 내용 / 작성 시간]에 대한 부분이 있었으면

-- 1. 테이블의 구조를 파악해서 게시판 테이블 만들기

create table post(
	p_no number(2) primary key,
	p_author varchar2(10 char) not null,
	p_script varchar2(100 char) not null,
	p_date date not null
);

create sequence post_seq;

-- 2. 테이블의 구조를 파악해서 댓글 테이블 만들기
--	[조건 : 참조 되는 테이블의 내용이 삭제되면 관련있는 댓글 내용도 삭제]

create table reply(
	p_no number(2) not null, -- 소속된 글 번호 / 이걸로 post 테이블을 참조
	r_no number(3) primary key,
	r_author varchar2(10 char) not null,
	r_script varchar2(50 char) not null,
	r_date date not null,
	constraint fk_reply foreign key(p_no)
		references post(p_no)
		on delete cascade
);

create sequence reply_seq;

-- 3. 게시판 테이블에 값 2개 넣고 / 각 게시글마다 댓글 2개씩 넣기
--	[조건 : 날짜 관련한 값은 현재 날짜/시간으로 통일]

insert into post values(post_seq.nextval, '글싸개작성자', '오늘 점심 뭐 먹지', sysdate);
insert into post values(post_seq.nextval, '작성자글찌끄리개', '왜 고양이는 전선을 씹을까', sysdate);

insert into reply values(1, reply_seq.nextval, '허리요정', '모두 허리 한 번씩 피고 가요', sysdate);
insert into reply values(1, reply_seq.nextval, '돼지', '삼겹살', sysdate);

insert into reply values(2, reply_seq.nextval, '킹댕이', '킹댕이였으면 벌써 전선 피복 벗겨서 연결하고 다시 이어줬다', sysdate);
insert into reply values(2, reply_seq.nextval, '야옹', '사진좀', sysdate);

select * from post;
select * from reply;

-- 4. 게시글 1번을 지웠을 때 관련 댓글들도 지워지는지 확인
delete from post where p_no = 1; 

select * from post;
select * from reply;

drop table post cascade constraint purge;
drop sequence post_seq;
drop table reply cascade constraint purge;
drop sequence reply_seq;