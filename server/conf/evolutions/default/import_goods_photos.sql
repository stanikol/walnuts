create or replace function import_img2(filename text, alt text default '') returns void as $$
    declare
        filepath text := './nuts-photos/' || filename ;
        img bytea := pg_read_binary_file(filepath);
    begin
        if (alt <> '') IS NOT TRUE then
            alt := filename;
        end if;
        insert into images (name, content, bytes) values(filename, alt, img);
    end;
$$ language plpgsql;

select import_img2('Буковинская бомба.png', 'Буковинская бомба')
select import_img2('Буковинский 2.png',     'Буковинский 2');
select import_img2('Буковинский 1.png',     'Буковинский 1');
select import_img2('Клишкивский.png',       'Клишкивский');
select import_img2('Приднестровский.jpg',   'Приднестровский');
select import_img2('Прикарпатский.jpg',     'Прикарпатский');
select import_img2('Рудковский.png',        'Рудковский');
select import_img2('Топоровский.png',       'Топоровский');
select import_img2('Черновицкий 1.png',     'Черновицкий 1');
select import_img2('Черновицкий 2.jpg',     'Черновицкий 2');
select import_img2('Яблунивский.png',       'Яблунивский');
select import_img2('Яровской.png',          'Яровской');