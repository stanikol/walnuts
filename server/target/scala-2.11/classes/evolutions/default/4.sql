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

create or replace  function import_article(file_name text) returns void as $$
    #variable_conflict use_variable
    declare
        filename text := './articles/' || file_name;;
        txt text := pg_read_file(filename);;
        lines text[] := regexp_split_to_array(txt, '\n');;
        article_txt text:= array_to_string(lines[2:array_upper(lines, 1)], '<br/>');;
        article_short text:= substring(array_to_string(lines[2:4], ' ') from 1 for 111);;
    begin
        insert into articles(title, keywords, article, description, short_text)
            values( lines[1],
                    'keyword-1, keyword-2 ' || filename,
                    article_txt,
                    'description ' || filename,
                    article_short
            );;
    end;;
$$ language plpgsql;

delete from articles;
select import_article('01_перспективы.txt');
select import_article('02_specifics.txt');
select import_article('03_planting.txt');
select import_article('04_walnut.txt');
select import_article('04_walnut.txt');

create table comments (
    id          serial      primary key,
    article_id  bigint      references articles(id),
    user_id     varchar       references users(user_id),
    text        varchar     not null,
    added       timestamp   default(now()::timestamp)
);

create view comments_info as
    select c.*, u.full_name, u.email, a.title
        from comments c
            left join users u on c.user_id = u.user_id
            left join articles a on c.article_id = a.id;

# --- !Downs
drop table articles CASCADE;

drop view comments_info;

drop table comments CASCADE;

