--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
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
-- Name: albums; Type: TABLE; Schema: public; Owner: blog
--

CREATE TABLE albums (
    id integer NOT NULL,
    name character varying NOT NULL,
    sort_order character varying
);


ALTER TABLE albums OWNER TO nuts;

--
-- Name: albums_id_seq; Type: SEQUENCE; Schema: public; Owner: blog
--

CREATE SEQUENCE albums_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE albums_id_seq OWNER TO nuts;

--
-- Name: albums_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: blog
--

ALTER SEQUENCE albums_id_seq OWNED BY albums.id;


--
-- Name: articles; Type: TABLE; Schema: public; Owner: blog
--

CREATE TABLE articles (
    id integer NOT NULL,
    sort_order character varying DEFAULT (now())::character varying NOT NULL,
    keywords character varying,
    title character varying,
    article text NOT NULL,
    description character varying NOT NULL,
    short_text character varying NOT NULL
);


ALTER TABLE articles OWNER TO nuts;

--
-- Name: articles_id_seq; Type: SEQUENCE; Schema: public; Owner: blog
--

CREATE SEQUENCE articles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE articles_id_seq OWNER TO nuts;

--
-- Name: articles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: blog
--

ALTER SEQUENCE articles_id_seq OWNED BY articles.id;


--
-- Name: auth_tokens; Type: TABLE; Schema: public; Owner: blog
--

CREATE TABLE auth_tokens (
    id character varying NOT NULL,
    user_id character varying NOT NULL,
    expiry character varying
);


ALTER TABLE auth_tokens OWNER TO nuts;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: blog
--

CREATE TABLE categories (
    id integer NOT NULL,
    name character varying,
    sort_order character varying DEFAULT to_char(now(), 'YYYY-MM-DD HH:SS:MS'::text)
);


ALTER TABLE categories OWNER TO nuts;

--
-- Name: categories_id_seq; Type: SEQUENCE; Schema: public; Owner: blog
--

CREATE SEQUENCE categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE categories_id_seq OWNER TO nuts;

--
-- Name: categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: blog
--

ALTER SEQUENCE categories_id_seq OWNED BY categories.id;


--
-- Name: comments; Type: TABLE; Schema: public; Owner: blog
--

CREATE TABLE comments (
    id integer NOT NULL,
    article_id bigint,
    user_id character varying,
    text character varying NOT NULL,
    added timestamp without time zone DEFAULT (now())::timestamp without time zone
);


ALTER TABLE comments OWNER TO nuts;

--
-- Name: comments_id_seq; Type: SEQUENCE; Schema: public; Owner: blog
--

CREATE SEQUENCE comments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE comments_id_seq OWNER TO nuts;

--
-- Name: comments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: blog
--

ALTER SEQUENCE comments_id_seq OWNED BY comments.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: blog
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
-- Name: comments_info; Type: VIEW; Schema: public; Owner: blog
--

CREATE VIEW comments_info AS
 SELECT c.id,
    c.article_id,
    c.user_id,
    c.text,
    c.added,
    u.full_name,
    u.email,
    a.title
   FROM ((comments c
     LEFT JOIN users u ON (((c.user_id)::text = (u.user_id)::text)))
     LEFT JOIN articles a ON ((c.article_id = a.id)));


ALTER TABLE comments_info OWNER TO nuts;

--
-- Name: goods; Type: TABLE; Schema: public; Owner: blog
--

CREATE TABLE goods (
    id integer NOT NULL,
    category integer,
    title character varying NOT NULL,
    description character varying NOT NULL,
    qnt integer DEFAULT 0 NOT NULL,
    price numeric(19,2) DEFAULT 0 NOT NULL,
    sort_order integer DEFAULT 1 NOT NULL,
    image character varying,
    changed timestamp without time zone DEFAULT (now())::timestamp without time zone
);


ALTER TABLE goods OWNER TO nuts;

--
-- Name: goods_id_seq; Type: SEQUENCE; Schema: public; Owner: blog
--

CREATE SEQUENCE goods_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE goods_id_seq OWNER TO nuts;

--
-- Name: goods_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: blog
--

ALTER SEQUENCE goods_id_seq OWNED BY goods.id;


--
-- Name: goods_view; Type: VIEW; Schema: public; Owner: blog
--

CREATE VIEW goods_view AS
 SELECT g.id,
    c.name AS category,
    c.id AS category_id,
    g.title,
    g.description,
    g.qnt,
    g.price,
    c.sort_order AS category_sort_order,
    g.sort_order,
    g.image,
    g.changed
   FROM (goods g
     LEFT JOIN categories c ON ((c.id = g.category)))
  ORDER BY c.sort_order, g.sort_order;


ALTER TABLE goods_view OWNER TO nuts;

--
-- Name: images; Type: TABLE; Schema: public; Owner: blog
--

CREATE TABLE images (
    name character varying NOT NULL,
    content character varying NOT NULL,
    bytes bytea,
    bytes150x150 bytea,
    albums character varying,
    changed timestamp without time zone DEFAULT (now())::timestamp without time zone
);


ALTER TABLE images OWNER TO nuts;

--
-- Name: login_info; Type: TABLE; Schema: public; Owner: blog
--

CREATE TABLE login_info (
    id integer NOT NULL,
    provider_id character varying NOT NULL,
    provider_key character varying NOT NULL
);


ALTER TABLE login_info OWNER TO nuts;

--
-- Name: login_info_id_seq; Type: SEQUENCE; Schema: public; Owner: blog
--

CREATE SEQUENCE login_info_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE login_info_id_seq OWNER TO nuts;

--
-- Name: login_info_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: blog
--

ALTER SEQUENCE login_info_id_seq OWNED BY login_info.id;


--
-- Name: oauth1_info; Type: TABLE; Schema: public; Owner: blog
--

CREATE TABLE oauth1_info (
    id integer NOT NULL,
    token character varying NOT NULL,
    secret character varying NOT NULL,
    login_info_id integer NOT NULL
);


ALTER TABLE oauth1_info OWNER TO nuts;

--
-- Name: oauth1_info_id_seq; Type: SEQUENCE; Schema: public; Owner: blog
--

CREATE SEQUENCE oauth1_info_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE oauth1_info_id_seq OWNER TO nuts;

--
-- Name: oauth1_info_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: blog
--

ALTER SEQUENCE oauth1_info_id_seq OWNED BY oauth1_info.id;


--
-- Name: oauth2_info; Type: TABLE; Schema: public; Owner: blog
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
-- Name: oauth2_info_id_seq; Type: SEQUENCE; Schema: public; Owner: blog
--

CREATE SEQUENCE oauth2_info_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE oauth2_info_id_seq OWNER TO nuts;

--
-- Name: oauth2_info_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: blog
--

ALTER SEQUENCE oauth2_info_id_seq OWNED BY oauth2_info.id;


--
-- Name: password_info; Type: TABLE; Schema: public; Owner: blog
--

CREATE TABLE password_info (
    hasher character varying NOT NULL,
    password character varying NOT NULL,
    salt character varying,
    login_info_id integer NOT NULL
);


ALTER TABLE password_info OWNER TO nuts;

--
-- Name: play_evolutions; Type: TABLE; Schema: public; Owner: blog
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
-- Name: user_login_info; Type: TABLE; Schema: public; Owner: blog
--

CREATE TABLE user_login_info (
    user_id character varying NOT NULL,
    login_info_id integer NOT NULL
);


ALTER TABLE user_login_info OWNER TO nuts;

--
-- Name: albums id; Type: DEFAULT; Schema: public; Owner: blog
--

ALTER TABLE ONLY albums ALTER COLUMN id SET DEFAULT nextval('albums_id_seq'::regclass);


--
-- Name: articles id; Type: DEFAULT; Schema: public; Owner: blog
--

ALTER TABLE ONLY articles ALTER COLUMN id SET DEFAULT nextval('articles_id_seq'::regclass);


--
-- Name: categories id; Type: DEFAULT; Schema: public; Owner: blog
--

ALTER TABLE ONLY categories ALTER COLUMN id SET DEFAULT nextval('categories_id_seq'::regclass);


--
-- Name: comments id; Type: DEFAULT; Schema: public; Owner: blog
--

ALTER TABLE ONLY comments ALTER COLUMN id SET DEFAULT nextval('comments_id_seq'::regclass);


--
-- Name: goods id; Type: DEFAULT; Schema: public; Owner: blog
--

ALTER TABLE ONLY goods ALTER COLUMN id SET DEFAULT nextval('goods_id_seq'::regclass);


--
-- Name: login_info id; Type: DEFAULT; Schema: public; Owner: blog
--

ALTER TABLE ONLY login_info ALTER COLUMN id SET DEFAULT nextval('login_info_id_seq'::regclass);


--
-- Name: oauth1_info id; Type: DEFAULT; Schema: public; Owner: blog
--

ALTER TABLE ONLY oauth1_info ALTER COLUMN id SET DEFAULT nextval('oauth1_info_id_seq'::regclass);


--
-- Name: oauth2_info id; Type: DEFAULT; Schema: public; Owner: blog
--

ALTER TABLE ONLY oauth2_info ALTER COLUMN id SET DEFAULT nextval('oauth2_info_id_seq'::regclass);


--
-- Data for Name: albums; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY albums (id, name, sort_order) FROM stdin;
1	Gallery #1	1
2	Gallery #2	1
\.


--
-- Name: albums_id_seq; Type: SEQUENCE SET; Schema: public; Owner: blog
--

SELECT pg_catalog.setval('albums_id_seq', 2, true);


--
-- Data for Name: articles; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY articles (id, sort_order, keywords, title, article, description, short_text) FROM stdin;
\.


--
-- Name: articles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: blog
--

SELECT pg_catalog.setval('articles_id_seq', 1, false);


--
-- Data for Name: auth_tokens; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY auth_tokens (id, user_id, expiry) FROM stdin;
b75029ce-b7e7-4fc1-9b01-7d6f115b2acc	604ff63c-c0c2-4bda-9e76-1fe85e237154	2017-05-04T16:31:44.832Z
\.


--
-- Data for Name: categories; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY categories (id, name, sort_order) FROM stdin;
\.


--
-- Name: categories_id_seq; Type: SEQUENCE SET; Schema: public; Owner: blog
--

SELECT pg_catalog.setval('categories_id_seq', 1, false);


--
-- Data for Name: comments; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY comments (id, article_id, user_id, text, added) FROM stdin;
\.


--
-- Name: comments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: blog
--

SELECT pg_catalog.setval('comments_id_seq', 1, false);


--
-- Data for Name: goods; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY goods (id, category, title, description, qnt, price, sort_order, image, changed) FROM stdin;
\.


--
-- Name: goods_id_seq; Type: SEQUENCE SET; Schema: public; Owner: blog
--

SELECT pg_catalog.setval('goods_id_seq', 1, false);


--
-- Data for Name: images; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY images (name, content, bytes, bytes150x150, albums, changed) FROM stdin;
\.


--
-- Data for Name: login_info; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY login_info (id, provider_id, provider_key) FROM stdin;
1	credentials	a@a.a
\.


--
-- Name: login_info_id_seq; Type: SEQUENCE SET; Schema: public; Owner: blog
--

SELECT pg_catalog.setval('login_info_id_seq', 1, true);


--
-- Data for Name: oauth1_info; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY oauth1_info (id, token, secret, login_info_id) FROM stdin;
\.


--
-- Name: oauth1_info_id_seq; Type: SEQUENCE SET; Schema: public; Owner: blog
--

SELECT pg_catalog.setval('oauth1_info_id_seq', 1, false);


--
-- Data for Name: oauth2_info; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY oauth2_info (id, access_token, token_type, expires_in, refresh_token, login_info_id) FROM stdin;
\.


--
-- Name: oauth2_info_id_seq; Type: SEQUENCE SET; Schema: public; Owner: blog
--

SELECT pg_catalog.setval('oauth2_info_id_seq', 1, false);


--
-- Data for Name: password_info; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY password_info (hasher, password, salt, login_info_id) FROM stdin;
bcrypt	$2a$10$1jlaCRQcTVN7iTvTXAqB9uwwGCpBRCrz7itfxI4PJbzXHp.emaQom	\N	1
\.


--
-- Data for Name: play_evolutions; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY play_evolutions (id, hash, applied_at, apply_script, revert_script, state, last_problem) FROM stdin;
1	9fa0258bc6a898d2eda3d415cd8a839be617950b	2017-05-04 00:00:00	CREATE TABLE users (\nuser_id CHARACTER VARYING NOT NULL PRIMARY KEY,\nfirst_name CHARACTER VARYING,\nlast_name CHARACTER VARYING,\nfull_name CHARACTER VARYING,\nemail CHARACTER VARYING,\navatar_url CHARACTER VARYING,\nactivated BOOLEAN DEFAULT FALSE,\nrole CHARACTER VARYING --DEFAULT NULL\n);\n\nCREATE TABLE auth_tokens (\nid CHARACTER VARYING PRIMARY KEY,\nuser_id CHARACTER VARYING NOT NULL,\nexpiry CHARACTER VARYING\n);\n\nCREATE TABLE login_info (\nid SERIAL PRIMARY KEY,\nprovider_id CHARACTER VARYING NOT NULL,\nprovider_key CHARACTER VARYING NOT NULL\n);\n\nCREATE TABLE user_login_info (\nuser_id CHARACTER VARYING NOT NULL,\nlogin_info_id INTEGER NOT NULL\n);\n\nCREATE TABLE password_info (\nhasher CHARACTER VARYING NOT NULL,\npassword CHARACTER VARYING NOT NULL,\nsalt CHARACTER VARYING,\nlogin_info_id INTEGER NOT NULL\n);\n\nCREATE TABLE oauth1_info (\nid SERIAL PRIMARY KEY,\ntoken CHARACTER VARYING NOT NULL,\nsecret CHARACTER VARYING NOT NULL,\nlogin_info_id INTEGER NOT NULL\n);\n\nCREATE TABLE oauth2_info (\nid SERIAL PRIMARY KEY,\naccess_token CHARACTER VARYING NOT NULL,\ntoken_type CHARACTER VARYING,\nexpires_in INTEGER,\nrefresh_token CHARACTER VARYING,\nlogin_info_id INTEGER NOT NULL\n);\n\n--COPY password_info FROM '/Users/snc/scala/walnuts/password_info.csv';\n--COPY user_login_info FROM '/Users/snc/scala/walnuts/user_login_info.csv';\n--COPY users FROM '/Users/snc/scala/walnuts/users.csv';\n--COPY auth_tokens FROM '/Users/snc/scala/walnuts/auth_tokens.csv';\n\n--ALTER TABLE password_info RENAME COLUMN user_id TO hasher;	DROP TABLE oauth2_info;\nDROP TABLE oauth1_info;\nDROP TABLE password_info;\nDROP TABLE user_login_info;\nDROP TABLE login_info;\nDROP TABLE users;	applied	
2	b85377f7be9985715dbb0eefdab852abffdd9c29	2017-05-04 00:00:00	create table images (\nname            varchar primary key,\ncontent         varchar not null,\nbytes           bytea,\nbytes150x150    bytea,\nalbums          varchar,\nchanged         timestamp default(now()::timestamp)\n);	drop table images CASCADE;	applied	
3	4ed6c9e85baeb3d769d1885b786c78a981cec0ce	2017-05-04 00:00:00	create table articles (\nid          serial      primary key,\nsort_order  varchar     default(now()::varchar) not null,\nkeywords    varchar,\ntitle       varchar,\narticle     text        not null,\ndescription varchar     not null,\nshort_text  varchar     not null\n);	drop table articles CASCADE;	applied	
4	f7ea678f22593e171331ce982238c4a432b6344c	2017-05-04 00:00:00	create table comments (\nid          serial      primary key,\narticle_id  bigint      references articles(id),\nuser_id     varchar     references users(user_id),\ntext        varchar     not null,\nadded       timestamp   default(now()::timestamp)\n);\n\ncreate view comments_info as\nselect c.*, u.full_name, u.email, a.title\nfrom comments c\nleft join users u on c.user_id = u.user_id\nleft join articles a on c.article_id = a.id;	drop view comments_info;\n\ndrop table comments;	applied	
5	173b7af3999a8c588ec060e7ab5fea9265f6a205	2017-05-04 00:00:00	create table categories (\nid          serial primary key,\nname        varchar unique,\nsort_order  varchar default(to_char(now(), 'YYYY-MM-DD HH:SS:MS'))\n);\n\n--insert into categories(name) values ('Саженцы');\n\ncreate table goods (\nid          serial         primary key,\ncategory    int            references categories(id),\ntitle       varchar        not null,\ndescription varchar        not null,\nqnt         int            not null default(0),\nprice       decimal(19, 2) not null default(0),\nsort_order  int            not null default(1),\nimage       varchar,\nchanged     timestamp      default(now()::timestamp)\n);\n\ncreate view goods_view as\nselect g.id, c.name as category, c.id as category_id, g.title, g.description, g.qnt, g.price, c.sort_order as category_sort_order, g.sort_order, g.image, g.changed\nfrom goods g left join categories c on c.id = g.category\norder by c.sort_order, g.sort_order;	drop table goods CASCADE;\n\ndrop table categories CASCADE;	applied	
6	6e51f203744821bf1581c6b585f04050370d5676	2017-05-04 00:00:00	create table if not exists  albums(id serial, name varchar not null unique, sort_order varchar);\n\ninsert into albums(name, sort_order) values('Gallery #1', '1');\ninsert into albums(name, sort_order) values('Gallery #2', '1');	drop table albums;	applied	
\.


--
-- Data for Name: user_login_info; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY user_login_info (user_id, login_info_id) FROM stdin;
604ff63c-c0c2-4bda-9e76-1fe85e237154	1
604ff63c-c0c2-4bda-9e76-1fe85e237154	1
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: blog
--

COPY users (user_id, first_name, last_name, full_name, email, avatar_url, activated, role) FROM stdin;
604ff63c-c0c2-4bda-9e76-1fe85e237154	a	a	a a	a@a.a	\N	t	admin
\.


--
-- Name: albums albums_name_key; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY albums
    ADD CONSTRAINT albums_name_key UNIQUE (name);


--
-- Name: articles articles_pkey; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY articles
    ADD CONSTRAINT articles_pkey PRIMARY KEY (id);


--
-- Name: auth_tokens auth_tokens_pkey; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY auth_tokens
    ADD CONSTRAINT auth_tokens_pkey PRIMARY KEY (id);


--
-- Name: categories categories_name_key; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY categories
    ADD CONSTRAINT categories_name_key UNIQUE (name);


--
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);


--
-- Name: comments comments_pkey; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comments_pkey PRIMARY KEY (id);


--
-- Name: goods goods_pkey; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY goods
    ADD CONSTRAINT goods_pkey PRIMARY KEY (id);


--
-- Name: images images_pkey; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY images
    ADD CONSTRAINT images_pkey PRIMARY KEY (name);


--
-- Name: login_info login_info_pkey; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY login_info
    ADD CONSTRAINT login_info_pkey PRIMARY KEY (id);


--
-- Name: oauth1_info oauth1_info_pkey; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY oauth1_info
    ADD CONSTRAINT oauth1_info_pkey PRIMARY KEY (id);


--
-- Name: oauth2_info oauth2_info_pkey; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY oauth2_info
    ADD CONSTRAINT oauth2_info_pkey PRIMARY KEY (id);


--
-- Name: play_evolutions play_evolutions_pkey; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY play_evolutions
    ADD CONSTRAINT play_evolutions_pkey PRIMARY KEY (id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (user_id);


--
-- Name: comments comments_article_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comments_article_id_fkey FOREIGN KEY (article_id) REFERENCES articles(id);


--
-- Name: comments comments_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comments_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(user_id);


--
-- Name: goods goods_category_fkey; Type: FK CONSTRAINT; Schema: public; Owner: blog
--

ALTER TABLE ONLY goods
    ADD CONSTRAINT goods_category_fkey FOREIGN KEY (category) REFERENCES categories(id);


--
-- PostgreSQL database dump complete
--

