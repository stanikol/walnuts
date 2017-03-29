--- Users schema

# --- !Ups
create table categories (
    name        varchar primary key
);

insert into categories values ('Саженцы');

create table goods (
    id          serial         primary key,
    category    varchar        references categories(name),
    title       varchar        not null,
    description varchar        not null,
    qnt         int            not null default(0),
    price       decimal(19, 2) not null default(0),
    show_order  int            not null default(1),
    image       varchar,
    changed     timestamp      default(now()::timestamp)
);

insert into goods(category, title, description , qnt, price, show_order, image)
    values('Саженцы', 'Саженец №1', 'Описание товвра', 100, 10.10, 1, '/img/cat');


# --- !Downs
drop table goods CASCADE;

drop table categories CASCADE;

--drop table orders;
