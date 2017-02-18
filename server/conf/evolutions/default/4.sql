# --- !Ups
insert into articles(keywords, title, text, description) values('Title', 'keyword_1, keyword 2', 'Some blog text here', 'description');
insert into articles(keywords, title, text, description) values('Title2', 'keyword_1, keyword 2', 'Another blog text here', 'Another description');

insert into categories values ('Саженцы');
insert into categories values ('Орехи');
insert into categories values ('Макаруны');

# --- !Downs
delete from categories;

delete from articles;