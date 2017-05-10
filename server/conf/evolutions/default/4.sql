--- Users schema

# --- !Ups
create table categories (
    id          serial primary key,
    name        varchar unique,
    sort_order  varchar default(to_char(now(), 'YYYY-MM-DD HH:SS:MS'))
);

create table goods (
    id          serial         primary key,
    category    int            references categories(id),
    title       varchar        not null,
    description varchar        not null,
    qnt         int            not null default(0),
    price       decimal(19, 2) not null default(0),
    sort_order  varchar        default(to_char(now(), 'YYYY-MM-DD HH:SS:MS')),
    image       varchar        references images(name),
    changed     timestamp      default(now()::timestamp)
);

create view goods_view as
    select g.id, c.name as category, c.id as category_id, g.title, g.description, g.qnt, g.price,
            c.sort_order as category_sort_order, g.sort_order, g.image, g.changed
        from goods g left join categories c on c.id = g.category
        order by c.sort_order, g.sort_order;


# --- !Downs
drop view goods_view;

drop table goods CASCADE;

drop table categories CASCADE;