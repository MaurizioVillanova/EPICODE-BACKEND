--
-- PostgreSQL database dump
--

-- Dumped from database version 14.3 (Debian 14.3-1.pgdg110+1)
-- Dumped by pg_dump version 14.4

-- Started on 2022-08-03 06:24:52

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 3 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: -
--

CREATE SCHEMA public;


--
-- TOC entry 3381 (class 0 OID 0)
-- Dependencies: 3
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON SCHEMA public IS 'standard public schema';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 213 (class 1259 OID 57625)
-- Name: menu; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.menu (
    id bigint NOT NULL
);


--
-- TOC entry 218 (class 1259 OID 57642)
-- Name: menu_item; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.menu_item (
    dtype character varying(31) NOT NULL,
    id bigint NOT NULL,
    calories double precision,
    name character varying(255),
    price double precision,
    pizza_id bigint
);


--
-- TOC entry 214 (class 1259 OID 57630)
-- Name: menu_menu_drink; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.menu_menu_drink (
    menu_id bigint NOT NULL,
    menu_drink_id bigint NOT NULL
);


--
-- TOC entry 215 (class 1259 OID 57633)
-- Name: menu_menu_franchise; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.menu_menu_franchise (
    menu_id bigint NOT NULL,
    menu_franchise_id bigint NOT NULL
);


--
-- TOC entry 216 (class 1259 OID 57636)
-- Name: menu_menu_pizza; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.menu_menu_pizza (
    menu_id bigint NOT NULL,
    menu_pizza_id bigint NOT NULL
);


--
-- TOC entry 217 (class 1259 OID 57639)
-- Name: menu_menu_topping; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.menu_menu_topping (
    menu_id bigint NOT NULL,
    menu_topping_id bigint NOT NULL
);


--
-- TOC entry 209 (class 1259 OID 57621)
-- Name: menu_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.menu_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 210 (class 1259 OID 57622)
-- Name: menuitem_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.menuitem_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 219 (class 1259 OID 57647)
-- Name: menuitem_to_orders; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.menuitem_to_orders (
    ordine_id bigint NOT NULL,
    menuitem_quantity integer,
    menuitem_id bigint NOT NULL
);


--
-- TOC entry 220 (class 1259 OID 57652)
-- Name: ordine; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.ordine (
    id bigint NOT NULL,
    costo_coperto double precision,
    numero_coperti integer,
    numero_ordine integer,
    stato character varying(255),
    tavolo_id bigint
);


--
-- TOC entry 211 (class 1259 OID 57623)
-- Name: ordine_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.ordine_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 221 (class 1259 OID 57657)
-- Name: tavolo; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.tavolo (
    id bigint NOT NULL,
    numero integer,
    numero_massimo_coperti integer,
    occupato boolean
);


--
-- TOC entry 212 (class 1259 OID 57624)
-- Name: tavolo_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.tavolo_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 3367 (class 0 OID 57625)
-- Dependencies: 213
-- Data for Name: menu; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3372 (class 0 OID 57642)
-- Dependencies: 218
-- Data for Name: menu_item; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3368 (class 0 OID 57630)
-- Dependencies: 214
-- Data for Name: menu_menu_drink; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3369 (class 0 OID 57633)
-- Dependencies: 215
-- Data for Name: menu_menu_franchise; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3370 (class 0 OID 57636)
-- Dependencies: 216
-- Data for Name: menu_menu_pizza; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3371 (class 0 OID 57639)
-- Dependencies: 217
-- Data for Name: menu_menu_topping; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3373 (class 0 OID 57647)
-- Dependencies: 219
-- Data for Name: menuitem_to_orders; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3374 (class 0 OID 57652)
-- Dependencies: 220
-- Data for Name: ordine; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3375 (class 0 OID 57657)
-- Dependencies: 221
-- Data for Name: tavolo; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- TOC entry 3382 (class 0 OID 0)
-- Dependencies: 209
-- Name: menu_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.menu_seq', 1, false);


--
-- TOC entry 3383 (class 0 OID 0)
-- Dependencies: 210
-- Name: menuitem_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.menuitem_seq', 1, false);


--
-- TOC entry 3384 (class 0 OID 0)
-- Dependencies: 211
-- Name: ordine_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.ordine_seq', 1, false);


--
-- TOC entry 3385 (class 0 OID 0)
-- Dependencies: 212
-- Name: tavolo_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('public.tavolo_seq', 1, false);


--
-- TOC entry 3205 (class 2606 OID 57646)
-- Name: menu_item menu_item_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.menu_item
    ADD CONSTRAINT menu_item_pkey PRIMARY KEY (id);


--
-- TOC entry 3203 (class 2606 OID 57629)
-- Name: menu menu_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (id);


--
-- TOC entry 3207 (class 2606 OID 57651)
-- Name: menuitem_to_orders menuitem_to_orders_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.menuitem_to_orders
    ADD CONSTRAINT menuitem_to_orders_pkey PRIMARY KEY (ordine_id, menuitem_id);


--
-- TOC entry 3209 (class 2606 OID 57656)
-- Name: ordine ordine_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.ordine
    ADD CONSTRAINT ordine_pkey PRIMARY KEY (id);


--
-- TOC entry 3211 (class 2606 OID 57661)
-- Name: tavolo tavolo_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.tavolo
    ADD CONSTRAINT tavolo_pkey PRIMARY KEY (id);


--
-- TOC entry 3214 (class 2606 OID 57672)
-- Name: menu_menu_franchise fk4yqq84k0phspopywnluk2bta3; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.menu_menu_franchise
    ADD CONSTRAINT fk4yqq84k0phspopywnluk2bta3 FOREIGN KEY (menu_franchise_id) REFERENCES public.menu_item(id);


--
-- TOC entry 3222 (class 2606 OID 57712)
-- Name: menuitem_to_orders fk63ea1ssw3pi94ecek9m8mcyo9; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.menuitem_to_orders
    ADD CONSTRAINT fk63ea1ssw3pi94ecek9m8mcyo9 FOREIGN KEY (ordine_id) REFERENCES public.ordine(id);


--
-- TOC entry 3212 (class 2606 OID 57662)
-- Name: menu_menu_drink fk7n57t0b5srvvqhpgs2i2b9s81; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.menu_menu_drink
    ADD CONSTRAINT fk7n57t0b5srvvqhpgs2i2b9s81 FOREIGN KEY (menu_drink_id) REFERENCES public.menu_item(id);


--
-- TOC entry 3213 (class 2606 OID 57667)
-- Name: menu_menu_drink fkdmbuqhdd5jxuefyg39pd6mjjx; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.menu_menu_drink
    ADD CONSTRAINT fkdmbuqhdd5jxuefyg39pd6mjjx FOREIGN KEY (menu_id) REFERENCES public.menu(id);


--
-- TOC entry 3221 (class 2606 OID 57707)
-- Name: menuitem_to_orders fke6jly26f3w03cqerbbck6i24f; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.menuitem_to_orders
    ADD CONSTRAINT fke6jly26f3w03cqerbbck6i24f FOREIGN KEY (menuitem_id) REFERENCES public.menu_item(id);


--
-- TOC entry 3217 (class 2606 OID 57687)
-- Name: menu_menu_pizza fkicu2vfm5v49oam52gwfnxujn3; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.menu_menu_pizza
    ADD CONSTRAINT fkicu2vfm5v49oam52gwfnxujn3 FOREIGN KEY (menu_id) REFERENCES public.menu(id);


--
-- TOC entry 3223 (class 2606 OID 57717)
-- Name: ordine fkktlj2iadyrm5parj605ifgr06; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.ordine
    ADD CONSTRAINT fkktlj2iadyrm5parj605ifgr06 FOREIGN KEY (tavolo_id) REFERENCES public.tavolo(id);


--
-- TOC entry 3216 (class 2606 OID 57682)
-- Name: menu_menu_pizza fkl3fomjlcbx2wiui26nwq4herw; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.menu_menu_pizza
    ADD CONSTRAINT fkl3fomjlcbx2wiui26nwq4herw FOREIGN KEY (menu_pizza_id) REFERENCES public.menu_item(id);


--
-- TOC entry 3215 (class 2606 OID 57677)
-- Name: menu_menu_franchise fkmn1flc3a4r467i8t42e7k06c7; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.menu_menu_franchise
    ADD CONSTRAINT fkmn1flc3a4r467i8t42e7k06c7 FOREIGN KEY (menu_id) REFERENCES public.menu(id);


--
-- TOC entry 3220 (class 2606 OID 57702)
-- Name: menu_item fko9m9rd7snpbat15iqi3036hbd; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.menu_item
    ADD CONSTRAINT fko9m9rd7snpbat15iqi3036hbd FOREIGN KEY (pizza_id) REFERENCES public.menu_item(id);


--
-- TOC entry 3219 (class 2606 OID 57697)
-- Name: menu_menu_topping fkodqyt8ta3ibb3ecfa5rj0gk29; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.menu_menu_topping
    ADD CONSTRAINT fkodqyt8ta3ibb3ecfa5rj0gk29 FOREIGN KEY (menu_id) REFERENCES public.menu(id);


--
-- TOC entry 3218 (class 2606 OID 57692)
-- Name: menu_menu_topping fkpk2xxuykaqslexx1w01rh08bn; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.menu_menu_topping
    ADD CONSTRAINT fkpk2xxuykaqslexx1w01rh08bn FOREIGN KEY (menu_topping_id) REFERENCES public.menu_item(id);


-- Completed on 2022-08-03 06:24:53

--
-- PostgreSQL database dump complete
--

