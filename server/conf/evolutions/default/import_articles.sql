create or replace  function import_article(file_name text) returns void as $$
    #variable_conflict use_variable
    declare
        filename text := './articles/' || file_name;
        txt text := pg_read_file(filename);
        lines text[] := regexp_split_to_array(txt, '\n');
        article_txt text:= array_to_string(lines[2:array_upper(lines, 1)], '<br/>');
        article_short text:= substring(array_to_string(lines[2:4], ' ') from 1 for 111);
        article_id int := cast( split_part(file_name, '_',1) as int);
    begin
        insert into articles(id, title, keywords, article, description, short_text)
            values( article_id,
                    lines[1],
                    'keyword-1, keyword-2 ' || filename,
                    article_txt,
                    'description ' || filename,
                    article_short
            );
    end;
$$ language plpgsql;

delete from articles;
select import_article('01_Борьба с сорняком.txt');
select import_article('02_Влияние внешних условий.txt');
select import_article('03_перспективы.txt');
select import_article('04_specifics.txt');
select import_article('05_planting.txt');
select import_article('06_walnut.txt');
select import_article('07_Группы орехов.txt');
select import_article('08_Формирование кроны и обрезка.txt');
select import_article('09_Вредители и болезни.txt');
select import_article('10_Выбор места под питомник.txt');
select import_article('11_Структура почвы.txt');
select import_article('12_Питательные вещества.txt');
select import_article('13_Корневая система грецкого ореха.txt');
select import_article('14_Из каких частей состоит дерево ореха.txt');
select import_article('15_Уход за ореховым садом.txt');
select import_article('16_Повышение плодородия почвы.txt');