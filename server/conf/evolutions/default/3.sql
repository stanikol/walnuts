# --- !Ups
create table articles (
    id          serial      primary key,
    sort_order  varchar     default(now()::varchar) not null,
    keywords    varchar,
    title       varchar,
    article     text        not null,
    description varchar     not null,
    short_text  varchar     not null
);

create table comments (
    id          serial      primary key,
    article_id  bigint      references articles(id),
    user_id     varchar     references users(user_id),
    text        varchar     not null,
    added       timestamp   default(now()::timestamp)
);

create view comments_info as
    select c.*, u.full_name, u.email, a.title
        from comments c
            left join users u on c.user_id = u.user_id
            left join articles a on c.article_id = a.id;

# --- !Downs

drop view comments_info;

drop table comments;

drop table articles CASCADE;


