--- Users schema

--# --- !Ups

create table if not exists contact(
    phones  varchar,
    email   varchar,
    city    varchar,
    address varchar,
    www     varchar
);
insert into contact values(E'phone1\\nphone2', 'email', 'city', 'address',  'www' );

create table if not exists rich_contact(
    html varchar
);
insert into rich_contact values('<b>rich</b> contact <i>info</i>' );

--# --- !Downs

drop table contact;
drop table rich_contact;

