# --- !Ups
create table if not exists pages (
    url         varchar  not null,
    lang        varchar,
    title       varchar  not null,
    html        text     not null,
    keywords    varchar  not null,
    description varchar  not null,
    primary key(url, lang)
);

--﻿insert into pages values('contacts', 'en', 'TEST TITELE', 'TEST HTML', 'TEST KW', 'TEST DESCR');
--﻿insert into pages values('contacts', 'ru', 'ТЕСТ ЗАГОЛОВКА', 'ТЕСТ ТЕЛО СТРАНИЦЫ', 'ТЕСТ КЛЮЧ СЛОВА', 'ТЕСТ ОПИСАНИЕ');
# --- !Downs
drop table pages;