# --- !Ups
create table if not exists pages (
    url         varchar  primary key,
    title       varchar  not null,
    html        text     not null,
    keywords    varchar  not null,
    description varchar  not null
);

insert into pages values('contacts', 'TEST TITELE', 'TEST HTML', 'TEST KW', 'TEST DESCR');
# --- !Downs
drop table pages;