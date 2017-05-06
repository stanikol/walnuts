--- Users schema

# --- !Ups
create table images (
    name            varchar primary key,
    content         varchar not null,
    bytes           bytea,
    bytes150x150    bytea,
    albums          varchar,
    changed         timestamp default(now()::timestamp)
);


# --- !Downs
drop table images CASCADE;
