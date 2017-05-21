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
-- Name: albums; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE albums (
    id integer NOT NULL,
    name character varying NOT NULL,
    sort_order character varying
);


ALTER TABLE albums OWNER TO nuts;

--
-- Name: albums_id_seq; Type: SEQUENCE; Schema: public; Owner: nuts
--

CREATE SEQUENCE albums_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE albums_id_seq OWNER TO nuts;

--
-- Name: albums_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nuts
--

ALTER SEQUENCE albums_id_seq OWNED BY albums.id;


--
-- Name: articles; Type: TABLE; Schema: public; Owner: nuts
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
-- Name: binding_image_album; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE binding_image_album (
    image_name character varying,
    album_id integer
);


ALTER TABLE binding_image_album OWNER TO nuts;

--
-- Name: categories; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE categories (
    id integer NOT NULL,
    name character varying,
    sort_order character varying DEFAULT to_char(now(), 'YYYY-MM-DD HH:SS:MS'::text)
);


ALTER TABLE categories OWNER TO nuts;

--
-- Name: categories_id_seq; Type: SEQUENCE; Schema: public; Owner: nuts
--

CREATE SEQUENCE categories_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE categories_id_seq OWNER TO nuts;

--
-- Name: categories_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: nuts
--

ALTER SEQUENCE categories_id_seq OWNED BY categories.id;


--
-- Name: comments; Type: TABLE; Schema: public; Owner: nuts
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
-- Name: comments_info; Type: VIEW; Schema: public; Owner: nuts
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
-- Name: goods; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE goods (
    id integer NOT NULL,
    category integer,
    title character varying NOT NULL,
    description character varying NOT NULL,
    qnt integer DEFAULT 0 NOT NULL,
    price numeric(19,2) DEFAULT 0 NOT NULL,
    sort_order character varying DEFAULT to_char(now(), 'YYYY-MM-DD HH:SS:MS'::text),
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
-- Name: goods_view; Type: VIEW; Schema: public; Owner: nuts
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
-- Name: image_bytes; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE image_bytes (
    image_name character varying NOT NULL,
    bytes bytea NOT NULL,
    created timestamp without time zone DEFAULT (now())::timestamp without time zone
);


ALTER TABLE image_bytes OWNER TO nuts;

--
-- Name: images; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE images (
    name character varying NOT NULL,
    content character varying NOT NULL,
    albums character varying,
    created timestamp without time zone DEFAULT (now())::timestamp without time zone
);


ALTER TABLE images OWNER TO nuts;

--
-- Name: image_info; Type: VIEW; Schema: public; Owner: nuts
--

CREATE VIEW image_info AS
 SELECT i.name,
    i.content,
    string_agg(((((a.id)::character varying)::text || '	'::text) || (a.name)::text), '
'::text) AS categories
   FROM ((images i
     LEFT JOIN binding_image_album b ON (((b.image_name)::text = (i.name)::text)))
     LEFT JOIN albums a ON ((a.id = b.album_id)))
  GROUP BY i.name, i.content;


ALTER TABLE image_info OWNER TO nuts;

--
-- Name: image_thumbnail_bytes; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE image_thumbnail_bytes (
    image_name character varying NOT NULL,
    bytes bytea NOT NULL,
    created timestamp without time zone DEFAULT (now())::timestamp without time zone
);


ALTER TABLE image_thumbnail_bytes OWNER TO nuts;

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
-- Name: pages; Type: TABLE; Schema: public; Owner: nuts
--

CREATE TABLE pages (
    url character varying NOT NULL,
    title character varying NOT NULL,
    html text NOT NULL,
    keywords character varying NOT NULL,
    description character varying NOT NULL
);


ALTER TABLE pages OWNER TO nuts;

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
-- Name: albums id; Type: DEFAULT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY albums ALTER COLUMN id SET DEFAULT nextval('albums_id_seq'::regclass);


--
-- Name: articles id; Type: DEFAULT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY articles ALTER COLUMN id SET DEFAULT nextval('articles_id_seq'::regclass);


--
-- Name: categories id; Type: DEFAULT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY categories ALTER COLUMN id SET DEFAULT nextval('categories_id_seq'::regclass);


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
-- Name: albums albums_name_key; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY albums
    ADD CONSTRAINT albums_name_key UNIQUE (name);


--
-- Name: albums albums_pkey; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY albums
    ADD CONSTRAINT albums_pkey PRIMARY KEY (id);


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
-- Name: binding_image_album binding_image_album_unique; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY binding_image_album
    ADD CONSTRAINT binding_image_album_unique UNIQUE (image_name, album_id);


--
-- Name: categories categories_name_key; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY categories
    ADD CONSTRAINT categories_name_key UNIQUE (name);


--
-- Name: categories categories_pkey; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY categories
    ADD CONSTRAINT categories_pkey PRIMARY KEY (id);


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
-- Name: image_bytes image_bytes_pkey; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY image_bytes
    ADD CONSTRAINT image_bytes_pkey PRIMARY KEY (image_name);


--
-- Name: image_thumbnail_bytes image_thumbnail_bytes_pkey; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY image_thumbnail_bytes
    ADD CONSTRAINT image_thumbnail_bytes_pkey PRIMARY KEY (image_name);


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
-- Name: pages pages_pkey; Type: CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY pages
    ADD CONSTRAINT pages_pkey PRIMARY KEY (url);


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
-- Name: binding_image_album binding_image_album_album_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY binding_image_album
    ADD CONSTRAINT binding_image_album_album_id_fkey FOREIGN KEY (album_id) REFERENCES albums(id) ON DELETE CASCADE;


--
-- Name: binding_image_album binding_image_album_image_name_fkey; Type: FK CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY binding_image_album
    ADD CONSTRAINT binding_image_album_image_name_fkey FOREIGN KEY (image_name) REFERENCES images(name) ON DELETE CASCADE;


--
-- Name: comments comments_article_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comments_article_id_fkey FOREIGN KEY (article_id) REFERENCES articles(id);


--
-- Name: comments comments_user_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY comments
    ADD CONSTRAINT comments_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(user_id);


--
-- Name: goods goods_category_fkey; Type: FK CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY goods
    ADD CONSTRAINT goods_category_fkey FOREIGN KEY (category) REFERENCES categories(id);


--
-- Name: goods goods_image_fkey; Type: FK CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY goods
    ADD CONSTRAINT goods_image_fkey FOREIGN KEY (image) REFERENCES images(name);


--
-- Name: image_bytes image_bytes_image_name_fkey; Type: FK CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY image_bytes
    ADD CONSTRAINT image_bytes_image_name_fkey FOREIGN KEY (image_name) REFERENCES images(name) ON DELETE CASCADE;


--
-- Name: image_thumbnail_bytes image_thumbnail_bytes_image_name_fkey; Type: FK CONSTRAINT; Schema: public; Owner: nuts
--

ALTER TABLE ONLY image_thumbnail_bytes
    ADD CONSTRAINT image_thumbnail_bytes_image_name_fkey FOREIGN KEY (image_name) REFERENCES images(name) ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--

