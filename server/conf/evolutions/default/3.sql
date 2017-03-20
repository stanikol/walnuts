--- Users schema

# --- !Ups
create table images (
    name        varchar primary key,
    content     varchar not null,
    bytes       bytea not null,
    changed     timestamp default(now()::timestamp)
);

create or replace function import_img(filename text, alt text default '') returns void as $$
    declare
        filepath text := './articles/img/' || filename ;;
        img bytea := pg_read_binary_file(filepath);;
    begin
        if (alt <> '') IS NOT TRUE then
            alt := filename;;
        end if;;
        insert into images (name, content, bytes) values(filename, alt, img);;
    end;;
$$ language plpgsql;

select import_img('perspective.jpg');
select import_img('planting_1.jpg');
select import_img('planting_2.jpg');
select import_img('specifics.jpg');
select import_img('walnut_1.jpg');
select import_img('walnut_2.jpg');
select import_img('walnut_3.jpg');

create table categories (
    name        varchar primary key
);

insert into categories values ('Саженцы');
insert into categories values ('Орехи');
insert into categories values ('Макаруны');

create table goods (
    id          serial         primary key,
    category    varchar        references categories(name),
    title       varchar        not null,
    description varchar        not null,
    qnt         int            not null default(0),
    price       decimal(19, 2) not null default(0),
    show        int            not null default(0),
    image       varchar,
    changed     timestamp      default(now()::timestamp)
);

insert into goods(category, title, description , qnt, price, show, image)
    values('Саженцы', 'Саженец №1', 'Описание товвра', 100, 10.10, 1, '/img/cat');


create table orders (
    id        serial    primary key,
    phone     varchar   not null,
    created   timestamp,
    closed    timestamp,
    changed   timestamp default(now()::timestamp)
);


# --- !Downs
drop table images CASCADE;

drop table goods CASCADE;

drop table categories CASCADE;

drop table orders;
