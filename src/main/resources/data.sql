drop table if exists posts;

create table posts(
    id bigint primary key auto_increment,
    title varchar(500),
    content varchar(500) not null,
    author varchar(255),
    created_date varchar(255),
    modified_date varchar(255)
);

insert into posts (title, author, content, created_date, modified_date) values ('테스트1', 'test1@gmail.com', '테스트1의 본문', now(), now());
insert into posts (title, author, content, created_date, modified_date) values ('테스트2', 'test2@gmail.com', '테스트2의 본문', now(), now());