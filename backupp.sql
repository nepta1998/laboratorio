PGDMP             	        
    w            laboratorio    12.1    12.1 -    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16444    laboratorio    DATABASE     }   CREATE DATABASE laboratorio WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8';
    DROP DATABASE laboratorio;
                postgres    false            �            1259    40921    empleado    TABLE     
  CREATE TABLE public.empleado (
    cedula character varying(255) NOT NULL,
    "contraseña" character varying(255),
    edad integer,
    nombre character varying(255),
    sexo character(1),
    telefono character varying(255),
    fundacion_id bigint NOT NULL
);
    DROP TABLE public.empleado;
       public         heap    postgres    false            �            1259    40929 	   fundacion    TABLE     �   CREATE TABLE public.fundacion (
    id bigint NOT NULL,
    nombre character varying(255),
    porcentaje double precision,
    gobernacion_id character varying(255) NOT NULL
);
    DROP TABLE public.fundacion;
       public         heap    postgres    false            �            1259    40937    gobernacion    TABLE     t   CREATE TABLE public.gobernacion (
    estado character varying(255) NOT NULL,
    partida_anual double precision
);
    DROP TABLE public.gobernacion;
       public         heap    postgres    false            �            1259    40919    native    SEQUENCE     o   CREATE SEQUENCE public.native
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.native;
       public          postgres    false            �            1259    40942    persona    TABLE     �   CREATE TABLE public.persona (
    cedula character varying(255) NOT NULL,
    edad integer,
    nombre character varying(255),
    sexo character(1),
    telefono character varying(255)
);
    DROP TABLE public.persona;
       public         heap    postgres    false            �            1259    40950    role    TABLE     ~   CREATE TABLE public.role (
    id bigint NOT NULL,
    description character varying(255),
    name character varying(255)
);
    DROP TABLE public.role;
       public         heap    postgres    false            �            1259    40958    servicio    TABLE     �   CREATE TABLE public.servicio (
    id bigint NOT NULL,
    costo double precision NOT NULL,
    fechaf date NOT NULL,
    fechai date NOT NULL,
    nombre character varying(255),
    tipo character(1) NOT NULL
);
    DROP TABLE public.servicio;
       public         heap    postgres    false            �            1259    40963    servicio_solicitud    TABLE     n   CREATE TABLE public.servicio_solicitud (
    solicitud_id bigint NOT NULL,
    servicio_id bigint NOT NULL
);
 &   DROP TABLE public.servicio_solicitud;
       public         heap    postgres    false            �            1259    40966 	   solicitud    TABLE     -  CREATE TABLE public.solicitud (
    id bigint NOT NULL,
    fecha date,
    presupuesto double precision,
    prioridad smallint,
    status character(1),
    empleado_cedula character varying(255) NOT NULL,
    fundacion_id bigint NOT NULL,
    beneficiario_cedula character varying(255) NOT NULL
);
    DROP TABLE public.solicitud;
       public         heap    postgres    false            �            1259    40974 
   user_roles    TABLE     ]   CREATE TABLE public.user_roles (
    user_id bigint NOT NULL,
    role_id bigint NOT NULL
);
    DROP TABLE public.user_roles;
       public         heap    postgres    false            �            1259    40979    usuario    TABLE     �   CREATE TABLE public.usuario (
    id bigint NOT NULL,
    password character varying(255),
    username character varying(255)
);
    DROP TABLE public.usuario;
       public         heap    postgres    false            �          0    40921    empleado 
   TABLE DATA           e   COPY public.empleado (cedula, "contraseña", edad, nombre, sexo, telefono, fundacion_id) FROM stdin;
    public          postgres    false    203   �5       �          0    40929 	   fundacion 
   TABLE DATA           K   COPY public.fundacion (id, nombre, porcentaje, gobernacion_id) FROM stdin;
    public          postgres    false    204   6       �          0    40937    gobernacion 
   TABLE DATA           <   COPY public.gobernacion (estado, partida_anual) FROM stdin;
    public          postgres    false    205   �6       �          0    40942    persona 
   TABLE DATA           G   COPY public.persona (cedula, edad, nombre, sexo, telefono) FROM stdin;
    public          postgres    false    206   �6       �          0    40950    role 
   TABLE DATA           5   COPY public.role (id, description, name) FROM stdin;
    public          postgres    false    207   o8       �          0    40958    servicio 
   TABLE DATA           K   COPY public.servicio (id, costo, fechaf, fechai, nombre, tipo) FROM stdin;
    public          postgres    false    208   9       �          0    40963    servicio_solicitud 
   TABLE DATA           G   COPY public.servicio_solicitud (solicitud_id, servicio_id) FROM stdin;
    public          postgres    false    209   �9       �          0    40966 	   solicitud 
   TABLE DATA           �   COPY public.solicitud (id, fecha, presupuesto, prioridad, status, empleado_cedula, fundacion_id, beneficiario_cedula) FROM stdin;
    public          postgres    false    210   �9       �          0    40974 
   user_roles 
   TABLE DATA           6   COPY public.user_roles (user_id, role_id) FROM stdin;
    public          postgres    false    211   �9       �          0    40979    usuario 
   TABLE DATA           9   COPY public.usuario (id, password, username) FROM stdin;
    public          postgres    false    212    :       �           0    0    native    SEQUENCE SET     4   SELECT pg_catalog.setval('public.native', 8, true);
          public          postgres    false    202                       2606    16445    empleado empleado_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT empleado_pkey PRIMARY KEY (cedula);
 @   ALTER TABLE ONLY public.empleado DROP CONSTRAINT empleado_pkey;
       public            postgres    false    203                       2606    16446    fundacion fundacion_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.fundacion
    ADD CONSTRAINT fundacion_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.fundacion DROP CONSTRAINT fundacion_pkey;
       public            postgres    false    204                       2606    16447    gobernacion gobernacion_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.gobernacion
    ADD CONSTRAINT gobernacion_pkey PRIMARY KEY (estado);
 F   ALTER TABLE ONLY public.gobernacion DROP CONSTRAINT gobernacion_pkey;
       public            postgres    false    205                       2606    16448    persona persona_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.persona
    ADD CONSTRAINT persona_pkey PRIMARY KEY (cedula);
 >   ALTER TABLE ONLY public.persona DROP CONSTRAINT persona_pkey;
       public            postgres    false    206                        2606    16449    role role_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.role DROP CONSTRAINT role_pkey;
       public            postgres    false    207            "           2606    16450    servicio servicio_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.servicio
    ADD CONSTRAINT servicio_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.servicio DROP CONSTRAINT servicio_pkey;
       public            postgres    false    208            $           2606    16451 *   servicio_solicitud servicio_solicitud_pkey 
   CONSTRAINT        ALTER TABLE ONLY public.servicio_solicitud
    ADD CONSTRAINT servicio_solicitud_pkey PRIMARY KEY (solicitud_id, servicio_id);
 T   ALTER TABLE ONLY public.servicio_solicitud DROP CONSTRAINT servicio_solicitud_pkey;
       public            postgres    false    209    209            &           2606    16452    solicitud solicitud_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.solicitud
    ADD CONSTRAINT solicitud_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.solicitud DROP CONSTRAINT solicitud_pkey;
       public            postgres    false    210            (           2606    16453    user_roles user_roles_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (user_id, role_id);
 D   ALTER TABLE ONLY public.user_roles DROP CONSTRAINT user_roles_pkey;
       public            postgres    false    211    211            *           2606    16454    usuario usuario_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.usuario DROP CONSTRAINT usuario_pkey;
       public            postgres    false    212            -           2606    16455 .   servicio_solicitud fk3qjbqbt7du00di9vlkxk44vma    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicio_solicitud
    ADD CONSTRAINT fk3qjbqbt7du00di9vlkxk44vma FOREIGN KEY (servicio_id) REFERENCES public.servicio(id);
 X   ALTER TABLE ONLY public.servicio_solicitud DROP CONSTRAINT fk3qjbqbt7du00di9vlkxk44vma;
       public          postgres    false    209    2850    208            2           2606    16460 &   user_roles fk6hdcxig28sjux082ekdae5wnj    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fk6hdcxig28sjux082ekdae5wnj FOREIGN KEY (user_id) REFERENCES public.usuario(id);
 P   ALTER TABLE ONLY public.user_roles DROP CONSTRAINT fk6hdcxig28sjux082ekdae5wnj;
       public          postgres    false    211    212    2858            /           2606    16465 %   solicitud fk90f5tocl5wvnw1aobyk1ub7bx    FK CONSTRAINT     �   ALTER TABLE ONLY public.solicitud
    ADD CONSTRAINT fk90f5tocl5wvnw1aobyk1ub7bx FOREIGN KEY (empleado_cedula) REFERENCES public.empleado(cedula);
 O   ALTER TABLE ONLY public.solicitud DROP CONSTRAINT fk90f5tocl5wvnw1aobyk1ub7bx;
       public          postgres    false    210    2840    203            +           2606    16470 $   empleado fkc6e0n2fyed2hpue8b4pofmkxl    FK CONSTRAINT     �   ALTER TABLE ONLY public.empleado
    ADD CONSTRAINT fkc6e0n2fyed2hpue8b4pofmkxl FOREIGN KEY (fundacion_id) REFERENCES public.fundacion(id);
 N   ALTER TABLE ONLY public.empleado DROP CONSTRAINT fkc6e0n2fyed2hpue8b4pofmkxl;
       public          postgres    false    204    2842    203            ,           2606    16475 %   fundacion fkgqht2rmwyp8wxao3p80r0tpmc    FK CONSTRAINT     �   ALTER TABLE ONLY public.fundacion
    ADD CONSTRAINT fkgqht2rmwyp8wxao3p80r0tpmc FOREIGN KEY (gobernacion_id) REFERENCES public.gobernacion(estado);
 O   ALTER TABLE ONLY public.fundacion DROP CONSTRAINT fkgqht2rmwyp8wxao3p80r0tpmc;
       public          postgres    false    204    2844    205            0           2606    16480 %   solicitud fkl2a4vy73hnnjw3eow8911sv0u    FK CONSTRAINT     �   ALTER TABLE ONLY public.solicitud
    ADD CONSTRAINT fkl2a4vy73hnnjw3eow8911sv0u FOREIGN KEY (fundacion_id) REFERENCES public.fundacion(id);
 O   ALTER TABLE ONLY public.solicitud DROP CONSTRAINT fkl2a4vy73hnnjw3eow8911sv0u;
       public          postgres    false    204    2842    210            1           2606    16485 %   solicitud fkma453mknaquc3bvm1p5sukr2j    FK CONSTRAINT     �   ALTER TABLE ONLY public.solicitud
    ADD CONSTRAINT fkma453mknaquc3bvm1p5sukr2j FOREIGN KEY (beneficiario_cedula) REFERENCES public.persona(cedula);
 O   ALTER TABLE ONLY public.solicitud DROP CONSTRAINT fkma453mknaquc3bvm1p5sukr2j;
       public          postgres    false    2846    206    210            .           2606    16490 .   servicio_solicitud fkmtgcckkiqr82wwq623b9q5o3b    FK CONSTRAINT     �   ALTER TABLE ONLY public.servicio_solicitud
    ADD CONSTRAINT fkmtgcckkiqr82wwq623b9q5o3b FOREIGN KEY (solicitud_id) REFERENCES public.solicitud(id);
 X   ALTER TABLE ONLY public.servicio_solicitud DROP CONSTRAINT fkmtgcckkiqr82wwq623b9q5o3b;
       public          postgres    false    2854    210    209            3           2606    16495 &   user_roles fkrhfovtciq1l558cw6udg0h0d3    FK CONSTRAINT     �   ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fkrhfovtciq1l558cw6udg0h0d3 FOREIGN KEY (role_id) REFERENCES public.role(id);
 P   ALTER TABLE ONLY public.user_roles DROP CONSTRAINT fkrhfovtciq1l558cw6udg0h0d3;
       public          postgres    false    2848    207    211            �   :   x�ȹ  ���$���O��V;
Q���9�[�!��"4�O֔�$�F"      �   �   x�3�t+�KIL�<�9/&/%U���4%Q!Q�/����b0�X�P������Z���W�Z�ij�����e��]��$5�Ỉ�s�,NN, ʖ$��sC�s* i
JM���K���IT�-�J-�4�*����� �7�      �      x��qr�44��=... +�      �   �  x�ER9r�0���d"�_�< mJET����'� �pdƱ���)���rHXZ���n�X���9�qo	O�{�Qz��r�;5X��`�d�7�U(I��4�p+>ST&?��i4X,��4������uAA+6�������z,(��oo�2�kz�(I:�rk8����؍:���\YW�ᢈ�q��Y�y�q_.MȎ٘ٲ���k��o�B��*ǁW�S" �������l����(eh�4j��(@jA�ǵS�fz˛��f�Q�s��Ý��� jϞjDhc������ ������Ҩ�QY�ϟǓ*J �''�&���Q��̥-�D�+QV�b�Eh(n���qՒVE��&u�P_X�pr!L��qn7�������������S      �   �   x�M�A
�@ϙW�DH��MBn�������{ȳ�'�c�BNM�]�uu��h����:�nʎ��"�;��d8a�gY[�[�(�VC���XC~У�H��&ra�h�ԕ��|y�����V[8T�{���X6��`��mD�      �   j   x�m�K
�0���.JӴ���R�����f0����1w���{�RSM�E%�t)��F�����y1�ܙ�T�1�o)kr�v3cODH�&Q      �      x�3�4�2�=... ��      �   1   x�3�420��54�5��4N�NC#cNCN##.C|���\1z\\\ �N&      �   "   x�3�4�2�4�2�@ڄӄ˘Ә+F��� 5]�      �   �   x�3�4426�LI̫�2��|.0��ĘˈS�(Q��D%/,�ӭ���- ��$�'�<'�;B/���5�#�,�4��-*�(�ܢ��4*�1�ܩ8�,&�3/��$1'�b2gV~q*�	gbJnf������ J#�     