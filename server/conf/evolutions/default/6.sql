--- Users schema

# --- !Ups

create table if not exists  albums(id serial primary key, name varchar not null unique, sort_order varchar);

insert into albums(name, sort_order) values('Gallery #1', '1');
insert into albums(name, sort_order) values('Gallery #2', '1');

create table if not exists binding_image_album (
    image_name varchar references images(name) on delete cascade,
    album_id int references albums(id) on delete cascade,
    CONSTRAINT unique_vals UNIQUE (image_name, album_id)
);

# --- !Downs
drop table albums cascade;


