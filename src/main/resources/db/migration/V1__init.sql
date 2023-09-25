
create sequence <schema>.hibernate_sequence;

CREATE TABLE confirmation (
	id int8 NOT NULL,
	code varchar(255) NOT NULL,
	contact varchar(255) NOT NULL,
	CONSTRAINT confirmation_pkey PRIMARY KEY (id)
);

CREATE TABLE super_user (
	id int8 NOT NULL,
	first_name varchar(255) NOT NULL,
	last_name varchar(255) NOT NULL,
	middle_name varchar(255) NULL,
	uuid varchar(255) NOT NULL,
	CONSTRAINT super_user_pkey PRIMARY KEY (id)
);

CREATE TABLE doctor (
	"blocked" bool NOT NULL,
	login varchar(255) NOT NULL,
	"password" varchar(255) NOT NULL,
	id int8 NOT NULL,
	CONSTRAINT doctor_pkey PRIMARY KEY (id),
	CONSTRAINT uk_tm2sb4v32c08ib2gad5qxq0tc UNIQUE (login)
);
ALTER TABLE doctor ADD CONSTRAINT fkr2xrrlc2s3irp1daskiw3rgna FOREIGN KEY (id) REFERENCES super_user(id);

CREATE TABLE patient (
	birthday date NULL,
	discount float8 NULL,
	id int8 NOT NULL,
	CONSTRAINT patient_pkey PRIMARY KEY (id)
);
ALTER TABLE patient ADD CONSTRAINT fk2jqap4hb1w8cfbtsk9yr9i8er FOREIGN KEY (id) REFERENCES super_user(id);

CREATE TABLE contact (
	dtype varchar(31) NOT NULL,
	id int8 NOT NULL,
	active bool NOT NULL,
	contact varchar(255) NOT NULL,
	note varchar(255) NULL,
	patient_id int8 NOT NULL,
	CONSTRAINT contact_pkey PRIMARY KEY (id)
);
ALTER TABLE contact ADD CONSTRAINT fk2ygsb9t4baokpt9iqb5b9pdcc FOREIGN KEY (patient_id) REFERENCES patient(id);

CREATE TABLE post (
	id int8 NOT NULL,
	description varchar(255) NOT NULL,
	"name" varchar(255) NOT NULL,
	CONSTRAINT post_pkey PRIMARY KEY (id)
);

CREATE TABLE service (
	id int8 NOT NULL,
	description varchar(255) NOT NULL,
	duration numeric(21) NOT NULL,
	"name" varchar(255) NOT NULL,
	price int4 NOT NULL,
	CONSTRAINT service_pkey PRIMARY KEY (id)
);

CREATE TABLE "record" (
	id int8 NOT NULL,
	confirmed bool NOT NULL,
	"date" date NOT NULL,
	duration numeric(21) NOT NULL,
	"time" time(6) NOT NULL,
	doctor_id int8 NOT NULL,
	patient_id int8 NULL,
	CONSTRAINT record_pkey PRIMARY KEY (id),
    CONSTRAINT ukebpbubwg1yb9ilb1sy21hf7ne UNIQUE (doctor_id, "date","time")
);
ALTER TABLE record ADD CONSTRAINT fkfv7pwtoln90pqf2luckkbg8cb FOREIGN KEY (patient_id) REFERENCES patient(id);
ALTER TABLE record ADD CONSTRAINT fkmkdgn6xu9svuh75iqt1h2dip2 FOREIGN KEY (doctor_id) REFERENCES doctor(id);

CREATE TABLE post_service_list (
	post_id int8 NOT NULL,
	service_list_id int8 NOT NULL,
	CONSTRAINT uk_magmc18hedf0max3lnfllb3wm UNIQUE (service_list_id)
);
ALTER TABLE post_service_list ADD CONSTRAINT fkewf2nu28sh3pqiuvo9jghrhis FOREIGN KEY (service_list_id) REFERENCES service(id);
ALTER TABLE post_service_list ADD CONSTRAINT fki5ph2n9j2b2qpjbkx9brow0vb FOREIGN KEY (post_id) REFERENCES post(id);

CREATE TABLE doctor_post_list (
	doctor_id int8 NOT NULL,
	post_list_id int8 NOT NULL
);
ALTER TABLE doctor_post_list ADD CONSTRAINT fk23sqp2ye2f8ul4gq1bucq1jnm FOREIGN KEY (doctor_id) REFERENCES doctor(id);
ALTER TABLE doctor_post_list ADD CONSTRAINT fksouuiqllu3roqp5ypesaot97q FOREIGN KEY (post_list_id) REFERENCES post(id);

