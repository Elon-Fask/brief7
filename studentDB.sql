PGDMP                          z        
   studentsDB    14.3    14.2     ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    32778 
   studentsDB    DATABASE     p   CREATE DATABASE "studentsDB" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1252';
    DROP DATABASE "studentsDB";
                postgres    false            ?            1259    32779    students    TABLE     ?   CREATE TABLE public.students (
    idstudent integer NOT NULL,
    fname character varying(10),
    lname character varying(10),
    email character varying(20),
    adresse character varying(20),
    contact character varying(15)
);
    DROP TABLE public.students;
       public         heap    postgres    false            ?          0    32779    students 
   TABLE DATA           T   COPY public.students (idstudent, fname, lname, email, adresse, contact) FROM stdin;
    public          postgres    false    209   ?       \           2606    32783    students students_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.students
    ADD CONSTRAINT students_pkey PRIMARY KEY (idstudent);
 @   ALTER TABLE ONLY public.students DROP CONSTRAINT students_pkey;
       public            postgres    false    209            ?   =  x?m??n?0???Sp??????m 6???]w1???$֚"O???P$?V????)$,?'Xӡ6?;܏?=?k?[??????????! ?Je?????"?????;_!܃????e1?|?vt?wgr`uK-?T??]gt?G?{?	X??ڲ??m??*??????4??y?G?"^?7V?]8?????S3Zpq? ?!1?$v?;X?ʐݢKw)?0`?e*V?(?H???"ߍ>??&?[l??5>???$NTv&0ׅV?k(B?-j?D)?$?=&??ó?k؇?i?????PJƉ?>?Q}잢O     