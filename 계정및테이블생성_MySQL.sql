/*
설명 : 먼저 만들어둔 테이블을 삭제하고 새로 생성하려는 경우 실행해주세요.
*/
-- 이런 게 있으면 날리고.
drop table if exists member;
drop table if exists board;

create table member (
    id varchar(100) not null primary key,
    pass varchar(100) not null,
    name varchar(30) not null,
    regidate timestamp default current_timestamp not null
);

create table board (
    num int auto_increment,
    title varchar(200) not null,
    content varchar(2000) not null,
    id varchar(10) not null,
    postdate timestamp default current_timestamp not null,
    visitcount decimal(6) default 0,
    primary key (num)
);

insert into member (id, pass, name) values ('musthave', '1234', '머스트해브');
insert into member (id, pass, name) values ('musthave1', '1234', '머스트해브1');
insert into board  (num, title, content, id) values (1, '제목1입니다', '내용1입니다', 'musthave');
insert into board  (num, title, content, id) values (2, '제목2입니다', '내용2입니다', 'musthave');
insert into board  (num, title, content, id) values (3, '제목3입니다', '내용3입니다', 'musthave1');
insert into board  (num, title, content, id) values (4, '제목4입니다', '내용4입니다', 'musthave1');
