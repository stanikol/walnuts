--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.1
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: articles; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE articles (
    id integer NOT NULL,
    sort_order character varying DEFAULT (now())::character varying NOT NULL,
    keywords character varying,
    title character varying,
    text text NOT NULL,
    description character varying NOT NULL
);


ALTER TABLE articles OWNER TO nuts;

--
-- Name: articles_id_seq; Type: SEQUENCE; Schema: public; Owner: nuts
--

CREATE SEQUENCE articles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE articles_id_seq OWNER TO nuts;

--
-- Name: articles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nuts
--

ALTER SEQUENCE articles_id_seq OWNED BY articles.id;


--
-- Name: auth_tokens; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE auth_tokens (
    id character varying NOT NULL,
    user_id character varying NOT NULL,
    expiry character varying
);


ALTER TABLE auth_tokens OWNER TO nuts;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE categories (
    name character varying NOT NULL
);


ALTER TABLE categories OWNER TO nuts;

--
-- Name: comments; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE comments (
    id integer NOT NULL,
    article bigint,
    user_id character varying,
    text character varying NOT NULL,
    added timestamp without time zone DEFAULT (now())::timestamp without time zone
);


ALTER TABLE comments OWNER TO nuts;

--
-- Name: comments_id_seq; Type: SEQUENCE; Schema: public; Owner: nuts
--

CREATE SEQUENCE comments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE comments_id_seq OWNER TO nuts;

--
-- Name: comments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nuts
--

ALTER SEQUENCE comments_id_seq OWNED BY comments.id;


--
-- Name: goods; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE goods (
    id integer NOT NULL,
    category character varying,
    title character varying NOT NULL,
    description character varying NOT NULL,
    qnt integer DEFAULT 0 NOT NULL,
    price numeric(19,2) DEFAULT 0 NOT NULL,
    show integer DEFAULT 0 NOT NULL,
    image character varying,
    changed timestamp without time zone DEFAULT (now())::timestamp without time zone
);


ALTER TABLE goods OWNER TO nuts;

--
-- Name: goods_id_seq; Type: SEQUENCE; Schema: public; Owner: nuts
--

CREATE SEQUENCE goods_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE goods_id_seq OWNER TO nuts;

--
-- Name: goods_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nuts
--

ALTER SEQUENCE goods_id_seq OWNED BY goods.id;


--
-- Name: images; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE images (
    name character varying NOT NULL,
    content character varying NOT NULL,
    bytes bytea NOT NULL,
    changed timestamp without time zone DEFAULT (now())::timestamp without time zone
);


ALTER TABLE images OWNER TO nuts;

--
-- Name: login_info; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE login_info (
    id integer NOT NULL,
    provider_id character varying NOT NULL,
    provider_key character varying NOT NULL
);


ALTER TABLE login_info OWNER TO nuts;

--
-- Name: login_info_id_seq; Type: SEQUENCE; Schema: public; Owner: nuts
--

CREATE SEQUENCE login_info_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE login_info_id_seq OWNER TO nuts;

--
-- Name: login_info_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nuts
--

ALTER SEQUENCE login_info_id_seq OWNED BY login_info.id;


--
-- Name: oauth1_info; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE oauth1_info (
    id integer NOT NULL,
    token character varying NOT NULL,
    secret character varying NOT NULL,
    login_info_id integer NOT NULL
);


ALTER TABLE oauth1_info OWNER TO nuts;

--
-- Name: oauth1_info_id_seq; Type: SEQUENCE; Schema: public; Owner: nuts
--

CREATE SEQUENCE oauth1_info_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE oauth1_info_id_seq OWNER TO nuts;

--
-- Name: oauth1_info_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nuts
--

ALTER SEQUENCE oauth1_info_id_seq OWNED BY oauth1_info.id;


--
-- Name: oauth2_info; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE oauth2_info (
    id integer NOT NULL,
    access_token character varying NOT NULL,
    token_type character varying,
    expires_in integer,
    refresh_token character varying,
    login_info_id integer NOT NULL
);


ALTER TABLE oauth2_info OWNER TO nuts;

--
-- Name: oauth2_info_id_seq; Type: SEQUENCE; Schema: public; Owner: nuts
--

CREATE SEQUENCE oauth2_info_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE oauth2_info_id_seq OWNER TO nuts;

--
-- Name: oauth2_info_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nuts
--

ALTER SEQUENCE oauth2_info_id_seq OWNED BY oauth2_info.id;


--
-- Name: orders; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE orders (
    id integer NOT NULL,
    phone character varying NOT NULL,
    created timestamp without time zone,
    closed timestamp without time zone,
    changed timestamp without time zone DEFAULT (now())::timestamp without time zone
);


ALTER TABLE orders OWNER TO nuts;

--
-- Name: orders_id_seq; Type: SEQUENCE; Schema: public; Owner: nuts
--

CREATE SEQUENCE orders_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE orders_id_seq OWNER TO nuts;

--
-- Name: orders_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nuts
--

ALTER SEQUENCE orders_id_seq OWNED BY orders.id;


--
-- Name: password_info; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE password_info (
    hasher character varying NOT NULL,
    password character varying NOT NULL,
    salt character varying,
    login_info_id integer NOT NULL
);


ALTER TABLE password_info OWNER TO nuts;

--
-- Name: play_evolutions; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE play_evolutions (
    id integer NOT NULL,
    hash character varying(255) NOT NULL,
    applied_at timestamp without time zone NOT NULL,
    apply_script text,
    revert_script text,
    state character varying(255),
    last_problem text
);


ALTER TABLE play_evolutions OWNER TO nuts;

--
-- Name: user_login_info; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE user_login_info (
    user_id character varying NOT NULL,
    login_info_id integer NOT NULL
);


ALTER TABLE user_login_info OWNER TO nuts;

--
-- Name: users; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE users (
    user_id character varying NOT NULL,
    first_name character varying,
    last_name character varying,
    full_name character varying,
    email character varying,
    avatar_url character varying,
    activated boolean DEFAULT false,
    role character varying
);


ALTER TABLE users OWNER TO nuts;

--
-- Name: articles id; Type: DEFAULT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY articles ALTER COLUMN id SET DEFAULT nextval('articles_id_seq'::regclass);


--
-- Name: comments id; Type: DEFAULT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY comments ALTER COLUMN id SET DEFAULT nextval('comments_id_seq'::regclass);


--
-- Name: goods id; Type: DEFAULT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY goods ALTER COLUMN id SET DEFAULT nextval('goods_id_seq'::regclass);


--
-- Name: login_info id; Type: DEFAULT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY login_info ALTER COLUMN id SET DEFAULT nextval('login_info_id_seq'::regclass);


--
-- Name: oauth1_info id; Type: DEFAULT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY oauth1_info ALTER COLUMN id SET DEFAULT nextval('oauth1_info_id_seq'::regclass);


--
-- Name: oauth2_info id; Type: DEFAULT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY oauth2_info ALTER COLUMN id SET DEFAULT nextval('oauth2_info_id_seq'::regclass);


--
-- Name: orders id; Type: DEFAULT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY orders ALTER COLUMN id SET DEFAULT nextval('orders_id_seq'::regclass);


--
-- Data for Name: articles; Type: TABLE DATA; Schema: public; Owner: nuts
--

COPY articles (id, sort_order, keywords, title, text, description) FROM stdin;
1	2017-02-26 03:08:16.731529+02	Title	keyword_1, keyword 2	Some blog text here	description
2	2017-02-26 03:08:16.732675+02	Title2	keyword_1, keyword 2	Another blog text here	Another description
\.


--
-- Name: articles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: nuts
--

SELECT pg_catalog.setval('articles_id_seq', 2, true);


--
-- Data for Name: auth_tokens; Type: TABLE DATA; Schema: public; Owner: nuts
--

COPY auth_tokens (id, user_id, expiry) FROM stdin;
752130ef-6e73-4996-ac4c-6000b7500d7d	d0bfd2b0-d34a-4ff0-9555-4e60b0bd9497	2017-02-26T01:13:43.455Z
76e5aaa7-61f2-4507-a893-6bca082e0982	685b5150-131f-4346-891d-95de2b782edb	2017-02-26T01:14:07.942Z
\.


--
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: nuts
--

COPY categories (name) FROM stdin;
Саженцы
Орехи
Макаруны
\.


--
-- Data for Name: comments; Type: TABLE DATA; Schema: public; Owner: nuts
--

COPY comments (id, article, user_id, text, added) FROM stdin;
\.


--
-- Name: comments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: nuts
--

SELECT pg_catalog.setval('comments_id_seq', 1, false);


--
-- Data for Name: goods; Type: TABLE DATA; Schema: public; Owner: nuts
--

COPY goods (id, category, title, description, qnt, price, show, image, changed) FROM stdin;
1	Саженцы	Саженец №1	Описание товвра	100	10.10	1	/img/cat	2017-02-26 03:08:16.722478
\.


--
-- Name: goods_id_seq; Type: SEQUENCE SET; Schema: public; Owner: nuts
--

SELECT pg_catalog.setval('goods_id_seq', 1, true);


--
-- Data for Name: images; Type: TABLE DATA; Schema: public; Owner: nuts
--

COPY images (name, content, bytes, changed) FROM stdin;
\.


--
-- Data for Name: login_info; Type: TABLE DATA; Schema: public; Owner: nuts
--

COPY login_info (id, provider_id, provider_key) FROM stdin;
1	credentials	a@a.a
2	credentials	u@u.u
\.


--
-- Name: login_info_id_seq; Type: SEQUENCE SET; Schema: public; Owner: nuts
--

SELECT pg_catalog.setval('login_info_id_seq', 2, true);


--
-- Data for Name: oauth1_info; Type: TABLE DATA; Schema: public; Owner: nuts
--

COPY oauth1_info (id, token, secret, login_info_id) FROM stdin;
\.


--
-- Name: oauth1_info_id_seq; Type: SEQUENCE SET; Schema: public; Owner: nuts
--

SELECT pg_catalog.setval('oauth1_info_id_seq', 1, false);


--
-- Data for Name: oauth2_info; Type: TABLE DATA; Schema: public; Owner: nuts
--

COPY oauth2_info (id, access_token, token_type, expires_in, refresh_token, login_info_id) FROM stdin;
\.


--
-- Name: oauth2_info_id_seq; Type: SEQUENCE SET; Schema: public; Owner: nuts
--

SELECT pg_catalog.setval('oauth2_info_id_seq', 1, false);


--
-- Data for Name: orders; Type: TABLE DATA; Schema: public; Owner: nuts
--

COPY orders (id, phone, created, closed, changed) FROM stdin;
\.


--
-- Name: orders_id_seq; Type: SEQUENCE SET; Schema: public; Owner: nuts
--

SELECT pg_catalog.setval('orders_id_seq', 1, false);


--
-- Data for Name: password_info; Type: TABLE DATA; Schema: public; Owner: nuts
--

COPY password_info (hasher, password, salt, login_info_id) FROM stdin;
bcrypt	$2a$10$FKa3NX7iYAAKPZFM0ymweuBARHPnN1wPJCchLCvIsXjPhf7JVKP/u	\N	1
bcrypt	$2a$10$Aokm0D0BB43YJHUvw1xqeOJdslf26gaJ0ESr/TBIfXs8O/W7JutbS	\N	2
\.


--
-- Data for Name: play_evolutions; Type: TABLE DATA; Schema: public; Owner: nuts
--

COPY play_evolutions (id, hash, applied_at, apply_script, revert_script, state, last_problem) FROM stdin;
1	f7b791b413e1b466fd0625fb6de0e5ae23ded71d	2017-02-26 00:00:00	CREATE TABLE users (\nuser_id CHARACTER VARYING NOT NULL PRIMARY KEY,\nfirst_name CHARACTER VARYING,\nlast_name CHARACTER VARYING,\nfull_name CHARACTER VARYING,\nemail CHARACTER VARYING,\navatar_url CHARACTER VARYING,\nactivated BOOLEAN DEFAULT FALSE,\nrole CHARACTER VARYING --DEFAULT NULL\n);\n\nCREATE TABLE auth_tokens (\nid CHARACTER VARYING PRIMARY KEY,\nuser_id CHARACTER VARYING NOT NULL,\nexpiry CHARACTER VARYING\n);\n\nCREATE TABLE login_info (\nid SERIAL PRIMARY KEY,\nprovider_id CHARACTER VARYING NOT NULL,\nprovider_key CHARACTER VARYING NOT NULL\n);\n\nCREATE TABLE user_login_info (\nuser_id CHARACTER VARYING NOT NULL,\nlogin_info_id INTEGER NOT NULL\n);\n\nCREATE TABLE password_info (\nuser_id CHARACTER VARYING NOT NULL,\npassword CHARACTER VARYING NOT NULL,\nsalt CHARACTER VARYING,\nlogin_info_id INTEGER NOT NULL\n);\n\nCREATE TABLE oauth1_info (\nid SERIAL PRIMARY KEY,\ntoken CHARACTER VARYING NOT NULL,\nsecret CHARACTER VARYING NOT NULL,\nlogin_info_id INTEGER NOT NULL\n);\n\nCREATE TABLE oauth2_info (\nid SERIAL PRIMARY KEY,\naccess_token CHARACTER VARYING NOT NULL,\ntoken_type CHARACTER VARYING,\nexpires_in INTEGER,\nrefresh_token CHARACTER VARYING,\nlogin_info_id INTEGER NOT NULL\n);\n\n--COPY password_info FROM '/Users/snc/scala/walnuts/password_info.csv';\n--COPY user_login_info FROM '/Users/snc/scala/walnuts/user_login_info.csv';\n--COPY users FROM '/Users/snc/scala/walnuts/users.csv';\n--COPY auth_tokens FROM '/Users/snc/scala/walnuts/auth_tokens.csv';	DROP TABLE oauth2_info;\nDROP TABLE oauth1_info;\nDROP TABLE password_info;\nDROP TABLE user_login_info;\nDROP TABLE login_info;\nDROP TABLE users;	applied	
2	c1146801e230fc46974ac43de487b4d2c93c7984	2017-02-26 00:00:00	ALTER TABLE password_info RENAME COLUMN user_id TO hasher;		applied	
3	b9fa9ca98103c988a4147ddcda653e8b14aa042e	2017-02-26 00:00:00	create table images (\nname        varchar primary key,\ncontent     varchar not null,\nbytes       bytea not null,\nchanged     timestamp default(now()::timestamp)\n);\n\ncreate table categories (\nname        varchar primary key\n);\n\ninsert into categories values ('Саженцы');\ninsert into categories values ('Орехи');\ninsert into categories values ('Макаруны');\n\n--create table goods (\n--    id          serial         primary key,\n--    category    varchar        references categories(name),\n--    title       varchar        not null,\n--    description varchar        not null,\n--    qnt         int            not null default(0),\n--    price       decimal(19, 2) not null default(0),\n--    show        int            not null default(0),\n--    image       varchar ,\n----    image       varchar array  not null default(array[]::varchar[]),\n--    changed     timestamp default(now()::timestamp)\n--);\n\ncreate table goods (\nid          serial         primary key,\ncategory    varchar        references categories(name),\ntitle       varchar        not null,\ndescription varchar        not null,\nqnt         int            not null default(0),\nprice       decimal(19, 2) not null default(0),\nshow        int            not null default(0),\nimage       varchar,\nchanged     timestamp      default(now()::timestamp)\n);\n\ninsert into goods(category, title, description , qnt, price, show, image)\nvalues('Саженцы', 'Саженец №1', 'Описание товвра', 100, 10.10, 1, '/img/cat');\n\n\ncreate table orders (\nid        serial    primary key,\nphone     varchar   not null,\ncreated   timestamp,\nclosed    timestamp,\nchanged   timestamp default(now()::timestamp)\n);	drop table goods CASCADE;\n\ndrop table categories CASCADE;\n\ndrop table images CASCADE;\n\ndrop table orders;	applied	
4	b73e46d428199bdda8cf8e98f78f07f06ad78fbc	2017-02-26 00:00:00	create table articles (\nid          serial      primary key,\nsort_order  varchar     default(now()::varchar) not null,\nkeywords    varchar,\n--    keywords    varchar array   not null,\ntitle       varchar,\ntext        text        not null,\ndescription varchar     not null\n);\n\ninsert into articles(keywords, title, text, description) values('Title', 'keyword_1, keyword 2', 'Some blog text here', 'description');\ninsert into articles(keywords, title, text, description) values('Title2', 'keyword_1, keyword 2', 'Another blog text here', 'Another description');\n\ncreate table comments (\nid          serial      primary key,\narticle     bigint      references articles(id),\nuser_id   varchar       references users(user_id),\ntext        varchar     not null,\nadded       timestamp   default(now()::timestamp)\n\n);\n\n--insert into comments(article, user_id, text) values (1, (select user_id from users where email = 'a@a.a'), 'This is a test comment!');\n--insert into comments(article, user_id, text) values (2, (select user_id from users where email = 'u@u.u'), 'This is a test comment 2!');	delete from comments;\n\ndelete from articles;	applied	
\.


--
-- Data for Name: user_login_info; Type: TABLE DATA; Schema: public; Owner: nuts
--

COPY user_login_info (user_id, login_info_id) FROM stdin;
d0bfd2b0-d34a-4ff0-9555-4e60b0bd9497	1
d0bfd2b0-d34a-4ff0-9555-4e60b0bd9497	1
685b5150-131f-4346-891d-95de2b782edb	2
685b5150-131f-4346-891d-95de2b782edb	2
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: nuts
--

COPY users (user_id, first_name, last_name, full_name, email, avatar_url, activated, role) FROM stdin;
d0bfd2b0-d34a-4ff0-9555-4e60b0bd9497	a	a	a a	a@a.a	\N	t	admin
685b5150-131f-4346-891d-95de2b782edb	u	u	u u	u@u.u	\N	t	\N
\.


--
-- Name: articles articles_pkey; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY articles
    ADD CONSTRAINT articles_pkey PRIMARY KEY (id);


--
-- Name: auth_tokens auth_tokens_pkey; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY auth_tokens
    ADD CONSTRAINT auth_tokens_pkey PRIMARY KEY (id);


--
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (name);


--
-- Name: comments comments_pkey; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comments_pkey PRIMARY KEY (id);


--
-- Name: goods goods_pkey; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY goods
    ADD CONSTRAINT goods_pkey PRIMARY KEY (id);


--
-- Name: images images_pkey; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY images
    ADD CONSTRAINT images_pkey PRIMARY KEY (name);


--
-- Name: login_info login_info_pkey; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY login_info
    ADD CONSTRAINT login_info_pkey PRIMARY KEY (id);


--
-- Name: oauth1_info oauth1_info_pkey; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY oauth1_info
    ADD CONSTRAINT oauth1_info_pkey PRIMARY KEY (id);


--
-- Name: oauth2_info oauth2_info_pkey; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY oauth2_info
    ADD CONSTRAINT oauth2_info_pkey PRIMARY KEY (id);


--
-- Name: orders orders_pkey; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY orders
    ADD CONSTRAINT orders_pkey PRIMARY KEY (id);


--
-- Name: play_evolutions play_evolutions_pkey; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY play_evolutions
    ADD CONSTRAINT play_evolutions_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- Name: comments comments_article_fkey; Type: FK CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comments_article_fkey FOREIGN KEY (article) REFERENCES articles(id);


--
-- Name: comments comments_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comments_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(user_id);


--
-- Name: goods goods_category_fkey; Type: FK CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY goods
    ADD CONSTRAINT goods_category_fkey FOREIGN KEY (category) REFERENCES categories(name);


--
-- PostgreSQL database dump complete
--

