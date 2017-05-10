--- Users schema

# --- !Ups
create table images (
    name            varchar primary key,
    content         varchar not null,
    albums          varchar,
    created         timestamp default(now()::timestamp)
);

create table if not exists image_bytes(
    image_name varchar primary key references images(name) on delete cascade,
    bytes       bytea not null,
    created     timestamp default(now()::timestamp)
);

create table if not exists image_thumbnail_bytes(
    image_name varchar primary key references images(name) on delete cascade,
    bytes       bytea not null,
    created     timestamp default(now()::timestamp)
);

create table if not exists albums(
    id serial primary key,
    name varchar not null unique,
    sort_order varchar
);

insert into albums(name, sort_order) values('Gallery #1', '1');
insert into albums(name, sort_order) values('Gallery #2', '1');

create table if not exists binding_image_album (
    image_name varchar references images(name) on delete cascade,
    album_id int references albums(id) on delete cascade,
    CONSTRAINT binding_image_album_unique UNIQUE (image_name, album_id)
);


create or replace view image_info as
    select  i.name,
            i.content,
            string_agg(cast(a.id as varchar) || E'\t' || cast(a.name as varchar), E'\n') as "categories"
        from images i
            left join binding_image_album b on b.image_name = i.name
            left join albums a on a.id = b.album_id
        group by i.name, i.content
;



# --- !Downs
drop view image_info CASCADE;

drop table images CASCADE;

drop table image_bytes cascade;

drop table image_thumbnail_bytes cascade;

drop table albums cascade;

drop table binding_image_album cascade;
