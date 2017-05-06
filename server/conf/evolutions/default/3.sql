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

# --- !Downs
drop table articles CASCADE;


