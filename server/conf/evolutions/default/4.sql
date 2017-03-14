# --- !Ups
create table articles (
    id          serial      primary key,
    sort_order  varchar     default(now()::varchar) not null,
    keywords    varchar,
    title       varchar,
    text        text        not null,
    description varchar     not null,
    short_text  varchar     not null
);

insert into articles(title, keywords, text, description, short_text) values('Title', 'keyword-1, keyword-2', 'Some blog text here', 'description', 'short text');
insert into articles(title, keywords, text, description, short_text) values('Title2', 'keyword_1, keyword 2', 'Another blog text here', 'Another description', 'short text');

create table comments (
    id          serial      primary key,
    article_id  bigint      references articles(id),
    user_id     varchar       references users(user_id),
    text        varchar     not null,
    added       timestamp   default(now()::timestamp)

);

--insert into comments(article_id, user_id, text) values (1, (select user_id from users where email = 'a@a.a'), 'This is a test comment!');
--insert into comments(article_id, user_id, text) values (2, (select user_id from users where email = 'u@u.u'), 'This is a test comment 2!');


# --- !Downs
drop table comments CASCADE;

drop table articles CASCADE;