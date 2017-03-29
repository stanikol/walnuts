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
select import_img('08-01.jpg');
select import_img('10-01.jpg');
select import_img('15-01.jpg');
select import_img('16-01.jpg');
select import_img('16-02.jpg');


# --- !Downs
drop table images CASCADE;
