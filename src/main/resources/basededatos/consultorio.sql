--
-- PostgreSQL database cluster dump
--

SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Roles
--

CREATE ROLE consultorio;
ALTER ROLE consultorio WITH SUPERUSER INHERIT CREATEROLE CREATEDB LOGIN REPLICATION BYPASSRLS PASSWORD 'SCRAM-SHA-256$4096:Aa046a6s6O3wLHof8wY7/w==$ga4Kueo6R7oYcNnuUhRnFmGiYiTlAgSFXFDbDltNGfY=:FP0e3k28hNAZorBXVlqNZ01Mlq6fZA7miWSOdiMUbQQ=';

--
-- User Configurations
--








--
-- Databases
--

--
-- Database "template1" dump
--

\connect template1

--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3 (Debian 15.3-1.pgdg110+1)
-- Dumped by pg_dump version 15.3 (Debian 15.3-1.pgdg110+1)

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
-- PostgreSQL database dump complete
--

--
-- Database "consultorio" dump
--

--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3 (Debian 15.3-1.pgdg110+1)
-- Dumped by pg_dump version 15.3 (Debian 15.3-1.pgdg110+1)

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
-- Name: consultorio; Type: DATABASE; Schema: -; Owner: consultorio
--

CREATE DATABASE consultorio WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.utf8';


ALTER DATABASE consultorio OWNER TO consultorio;

\connect consultorio

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
-- Name: uuid-ossp; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS "uuid-ossp" WITH SCHEMA public;


--
-- Name: EXTENSION "uuid-ossp"; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION "uuid-ossp" IS 'generate universally unique identifiers (UUIDs)';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: agenda; Type: TABLE; Schema: public; Owner: consultorio
--

CREATE TABLE public.agenda (
    uuid uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    uuidpaciente uuid NOT NULL,
    uuidmedico uuid NOT NULL,
    fechaconsulta date NOT NULL,
    horaconsulta character varying(10)
);


ALTER TABLE public.agenda OWNER TO consultorio;

--
-- Name: calendariomedico; Type: TABLE; Schema: public; Owner: consultorio
--

CREATE TABLE public.calendariomedico (
    uuid uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    uuidmedico uuid NOT NULL,
    lunes boolean,
    martes boolean,
    miercoles boolean,
    jueves boolean,
    viernes boolean,
    sabado boolean,
    domingo boolean,
    horaingresoam character varying(10) NOT NULL,
    horasalidaam character varying(10) NOT NULL,
    horaingresopm character varying(10) NOT NULL,
    horasalidapm character varying(10) NOT NULL
);


ALTER TABLE public.calendariomedico OWNER TO consultorio;

--
-- Name: consulta; Type: TABLE; Schema: public; Owner: consultorio
--

CREATE TABLE public.consulta (
    uuid uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    uuidpaciente uuid NOT NULL,
    uuidmedico uuid NOT NULL,
    diagnostico character varying(500) NOT NULL
);


ALTER TABLE public.consulta OWNER TO consultorio;

--
-- Name: consultamedicamento; Type: TABLE; Schema: public; Owner: consultorio
--

CREATE TABLE public.consultamedicamento (
    uuid uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    uuidmedicamento uuid NOT NULL,
    uuidconsulta uuid NOT NULL
);


ALTER TABLE public.consultamedicamento OWNER TO consultorio;

--
-- Name: medicamento; Type: TABLE; Schema: public; Owner: consultorio
--

CREATE TABLE public.medicamento (
    uuid uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    codigo character varying(20) NOT NULL,
    nombregenerico character varying(50),
    nombrecomercial character varying(50) NOT NULL,
    laboratorio character varying(50),
    marca character varying(50) NOT NULL
);


ALTER TABLE public.medicamento OWNER TO consultorio;

--
-- Name: medico; Type: TABLE; Schema: public; Owner: consultorio
--

CREATE TABLE public.medico (
    uuid uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    primernombre character varying(50) NOT NULL,
    segundonombre character varying(50),
    primerapellido character varying(50) NOT NULL,
    segundoapellido character varying(50),
    tipodocumento character(2) NOT NULL,
    numerodocumento integer NOT NULL,
    genero character(2) NOT NULL,
    fechanacimiento date NOT NULL,
    tarjetaprofecional character varying(40) NOT NULL,
    especialidad character varying(40) NOT NULL
);


ALTER TABLE public.medico OWNER TO consultorio;

--
-- Name: paciente; Type: TABLE; Schema: public; Owner: consultorio
--

CREATE TABLE public.paciente (
    uuid uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    primernombre character varying(50) NOT NULL,
    segundonombre character varying(50),
    primerapellido character varying(50) NOT NULL,
    segundoapellido character varying(50),
    tipodocumento character(10) NOT NULL,
    numerodocumento integer NOT NULL,
    genero character(2) NOT NULL,
    fechanacimiento date NOT NULL
);


ALTER TABLE public.paciente OWNER TO consultorio;

--
-- Name: usuario; Type: TABLE; Schema: public; Owner: consultorio
--

CREATE TABLE public.usuario (
    uuid uuid DEFAULT public.uuid_generate_v4() NOT NULL,
    usuario character varying(50) NOT NULL,
    contrasena character varying(50)
);


ALTER TABLE public.usuario OWNER TO consultorio;

--
-- Data for Name: agenda; Type: TABLE DATA; Schema: public; Owner: consultorio
--

COPY public.agenda (uuid, uuidpaciente, uuidmedico, fechaconsulta, horaconsulta) FROM stdin;
\.


--
-- Data for Name: calendariomedico; Type: TABLE DATA; Schema: public; Owner: consultorio
--

COPY public.calendariomedico (uuid, uuidmedico, lunes, martes, miercoles, jueves, viernes, sabado, domingo, horaingresoam, horasalidaam, horaingresopm, horasalidapm) FROM stdin;
9c35a590-d900-4ecf-985d-2939c0608d56	b9a8f09b-7ff3-4da2-91f9-4a040b882d4d	f	t	t	t	t	f	f	8:00	12:00	2:00	6:00
\.


--
-- Data for Name: consulta; Type: TABLE DATA; Schema: public; Owner: consultorio
--

COPY public.consulta (uuid, uuidpaciente, uuidmedico, diagnostico) FROM stdin;
\.


--
-- Data for Name: consultamedicamento; Type: TABLE DATA; Schema: public; Owner: consultorio
--

COPY public.consultamedicamento (uuid, uuidmedicamento, uuidconsulta) FROM stdin;
\.


--
-- Data for Name: medicamento; Type: TABLE DATA; Schema: public; Owner: consultorio
--

COPY public.medicamento (uuid, codigo, nombregenerico, nombrecomercial, laboratorio, marca) FROM stdin;
f150b26d-2470-4792-b1ec-d547bb3998a6	001	dolex	dolex	mk	la sante
\.


--
-- Data for Name: medico; Type: TABLE DATA; Schema: public; Owner: consultorio
--

COPY public.medico (uuid, primernombre, segundonombre, primerapellido, segundoapellido, tipodocumento, numerodocumento, genero, fechanacimiento, tarjetaprofecional, especialidad) FROM stdin;
b9a8f09b-7ff3-4da2-91f9-4a040b882d4d	julian	andres	buitron	rendon	CC	10303388	M 	1984-04-13	123456	general
\.


--
-- Data for Name: paciente; Type: TABLE DATA; Schema: public; Owner: consultorio
--

COPY public.paciente (uuid, primernombre, segundonombre, primerapellido, segundoapellido, tipodocumento, numerodocumento, genero, fechanacimiento) FROM stdin;
17537227-c298-4fdb-987b-97d2a56045f7	Julian	Andres	Buitron	Rendon	CC        	10303388	M 	1984-04-13
07f64cb6-70a7-4f7d-b67f-174e655ee5f9	Andres	Camilo	Fuentes	Mora	C         	1023	M 	2023-06-27
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: consultorio
--

COPY public.usuario (uuid, usuario, contrasena) FROM stdin;
5a959e8d-df09-473d-9286-10b43f2e204f	julian	julian
\.


--
-- Name: agenda agenda_pkey; Type: CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY public.agenda
    ADD CONSTRAINT agenda_pkey PRIMARY KEY (uuid);


--
-- Name: calendariomedico calendariomedico_pkey; Type: CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY public.calendariomedico
    ADD CONSTRAINT calendariomedico_pkey PRIMARY KEY (uuid);


--
-- Name: consulta consulta_pkey; Type: CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT consulta_pkey PRIMARY KEY (uuid);


--
-- Name: consultamedicamento consultamedicamento_pkey; Type: CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY public.consultamedicamento
    ADD CONSTRAINT consultamedicamento_pkey PRIMARY KEY (uuid);


--
-- Name: medicamento medicamento_pkey; Type: CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY public.medicamento
    ADD CONSTRAINT medicamento_pkey PRIMARY KEY (uuid);


--
-- Name: medico medico_pkey; Type: CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY public.medico
    ADD CONSTRAINT medico_pkey PRIMARY KEY (uuid);


--
-- Name: paciente paciente_pkey; Type: CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY public.paciente
    ADD CONSTRAINT paciente_pkey PRIMARY KEY (uuid);


--
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (uuid);


--
-- Name: calendariomedico calendariomedico_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY public.calendariomedico
    ADD CONSTRAINT calendariomedico_fk FOREIGN KEY (uuidmedico) REFERENCES public.medico(uuid);


--
-- Name: consultamedicamento consultamedicamento_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY public.consultamedicamento
    ADD CONSTRAINT consultamedicamento_fk FOREIGN KEY (uuidconsulta) REFERENCES public.consulta(uuid);


--
-- Name: consulta consultamedico_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT consultamedico_fk FOREIGN KEY (uuidmedico) REFERENCES public.medico(uuid);


--
-- Name: consulta consultapaciente_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY public.consulta
    ADD CONSTRAINT consultapaciente_fk FOREIGN KEY (uuidpaciente) REFERENCES public.paciente(uuid);


--
-- Name: consultamedicamento medicamentoconsulta_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY public.consultamedicamento
    ADD CONSTRAINT medicamentoconsulta_fk FOREIGN KEY (uuidmedicamento) REFERENCES public.medicamento(uuid);


--
-- Name: agenda medicoagenda_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY public.agenda
    ADD CONSTRAINT medicoagenda_fk FOREIGN KEY (uuidmedico) REFERENCES public.medico(uuid);


--
-- Name: agenda pacienteAgenda_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY public.agenda
    ADD CONSTRAINT "pacienteAgenda_fk" FOREIGN KEY (uuidpaciente) REFERENCES public.paciente(uuid);


--
-- PostgreSQL database dump complete
--

--
-- Database "postgres" dump
--

\connect postgres

--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3 (Debian 15.3-1.pgdg110+1)
-- Dumped by pg_dump version 15.3 (Debian 15.3-1.pgdg110+1)

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
-- PostgreSQL database dump complete
--

--
-- PostgreSQL database cluster dump complete
--

