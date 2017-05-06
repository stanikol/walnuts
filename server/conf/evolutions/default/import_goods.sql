create or replace  function import_goods_item(file_name text, image_name text) returns void as $$
    #variable_conflict use_variable
    declare
        filename text := './blog-photos/' || file_name;
        txt text := pg_read_file(filename);
        lines text[] := regexp_split_to_array(txt, '\n');
        item_text text:= array_to_string(lines[5:array_upper(lines, 1)], '<br/>');
--        article_short text:= substring(array_to_string(lines[5:4], ' ') from 1 for 111);
    begin
        insert into goods(title, category, description, sort_order, image)
            values( lines[1],
                    'Селекция Приднестровской опытной станции, г. Черновцы',
                    item_text,
                    1,
                    image_name
            );
    end;
$$ language plpgsql;

insert into categories values('Селекция Приднестровской опытной станции, г. Черновцы');

select import_goods_item('Буковинская бомба.txt', 'Буковинская бомба.png');
select import_goods_item('Буковинский 1.txt', 'Буковинский 1.png');
select import_goods_item('Буковинский 2.txt', 'Буковинский 2.png');
select import_goods_item('Клишкивский.txt', 'Клишкивский.png');
select import_goods_item('Приднестровский.txt', 'Приднестровский.jpg');
select import_goods_item('Прикарпатский.txt', 'Прикарпатский.jpg');
select import_goods_item('Рудковский.txt', 'Рудковский.png');
select import_goods_item('Топоровский.txt', 'Топоровский.png');
select import_goods_item('Черновицкий 1.txt', 'Черновицкий 1.png');
select import_goods_item('Черновицкий 2.txt', 'Черновицкий 2.jpg');
select import_goods_item('Яблунивский.txt', 'Яблунивский.png');
select import_goods_item('Яровской.txt', 'Яровской.png');