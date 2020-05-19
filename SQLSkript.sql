-- clear schema before running the script
DROP SCHEMA IF EXISTS versandwarenhausdb;
CREATE SCHEMA versandwarenhausdb;
-- use versandwarenhausdb as default schema to perform subsequent statements on that schema
USE versandwarenhausdb;


DROP TABLE IF exists kat_kategorien;

-- produktkategorien base data
CREATE TABLE kat_kategorien(
-- attributes to see what this table is about
kat_name Varchar(50) NOT null, -- check(kat_name >= 2),
-- technical attributes
kat_id INTEGER UNIQUE NOT null AUTO_INCREMENT, -- Produktspezifischer Key der Produktkategorien
-- relations and primary key
primary key (kat_id)
) AUTO_INCREMENT = 1000000;

DROP TABLE IF exists pro_produkte;

-- Produkte die das Warenhaus führt
-- mapping von n-to-? 
CREATE TABLE pro_produkte (
-- business attributes to see what this table is about
pro_name Varchar(128) not null unique,
pro_preis decimal(12,2),
-- technical attributes
pro_id INTEGER UNIQUE NOT NULL AUTO_INCREMENT,
pro_kat_id integer NOT NULL,
-- relations and primary key
primary key (pro_id),
foreign key (pro_kat_id) references kat_kategorien (kat_id)
) AUTO_INCREMENT = 1000000;

DROP TABLE IF exists kun_kundenstamm;

-- erklären warum Tabellen notwendig
create table kun_kundenstamm (
-- business attributes to see what this table is about
kun_name varchar(50),
kun_email varchar(100) UNIQUE NOT null,
-- technical attributes
kun_id integer UNIQUE NOT null AUTO_INCREMENT,
-- relations and primary key
primary key (kun_email)
) AUTO_INCREMENT = 1000000;

DROP TABLE IF exists his_historie;

-- beschrieben warum tabelle
create table his_historie(
-- business attributes to see what this table is about
his_status varchar(10) not null,
-- technical attributes
his_id integer UNIQUE NOT null auto_increment,
his_zeitstempel TIMESTAMP not null,
his_pro_id integer,
his_kun_id integer,
-- relations and primary key
primary key (his_id),
foreign key (his_pro_id) references pro_produkte (pro_id),
foreign key (his_kun_id) references kun_kundenstamm (kun_id) 
) AUTO_INCREMENT = 100000000;



