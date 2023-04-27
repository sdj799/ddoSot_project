DROP TABLE men;

CREATE TABLE men (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR2(20) NOT NULL,
    age NUMBER NOT NULL,
    job VARCHAR(50) NOT NULL,
    phone_number VARCHAR2(20) NOT NULL,
    hobby VARCHAR2(30),
    salary NUMBER NOT NULL,
    grade VARCHAR2(20) NOT NULL,
    count NUMBER DEFAULT 3 NULL,
    partner_id VARCHAR2(20) DEFAULT null
);

CREATE SEQUENCE men_seq
    NOCACHE;

DROP TABLE women;

CREATE TABLE women (
    id VARCHAR(255) PRIMARY KEY,
    name VARCHAR2(20) NOT NULL,
    age NUMBER NOT NULL,
    job VARCHAR(50) NOT NULL,
    phone_number VARCHAR2(20) NOT NULL,
    hobby VARCHAR2(30),
    salary NUMBER NOT NULL,
    grade VARCHAR2(20) NOT NULL,
    count NUMBER DEFAULT 3 NULL,
    partner_id VARCHAR2(20) DEFAULT null
);

CREATE SEQUENCE women_seq
    NOCACHE;

DROP TABLE matching;

CREATE TABLE matching (
    match_num NUMBER PRIMARY KEY,
    men_id VARCHAR(255) UNIQUE NOT NULL,
    women_id VARCHAR(255) UNIQUE NOT NULL,
    manager_num NUMBER NOT NULL
);

CREATE SEQUENCE matching_seq
    NOCACHE;

DROP TABLE manager;

CREATE TABLE manager (
    manager_num NUMBER PRIMARY KEY,
    name VARCHAR2(20) NOT NULL,
    performance NUMBER NULL
);
DROP SEQUENCE manager_seq;
CREATE SEQUENCE manager_seq
    NOCACHE;

--ALTER TABLE men ADD FOREIGN KEY(partner_id) REFERENCES matching(women_id);
--
--ALTER TABLE women ADD FOREIGN KEY(partner_id) REFERENCES matching(men_id);
--
--ALTER TABLE matching ADD FOREIGN KEY(men_id) REFERENCES men(id);
--
--ALTER TABLE matching ADD FOREIGN KEY(women_id) REFERENCES women(id);
--
--ALTER TABLE matching ADD FOREIGN KEY(manager_num) REFERENCES manager(manager_num);

INSERT INTO men
(id, name, age, job, phone_number, hobby, salary, grade, count)
VALUES (
    'A-001',
    '±èÃ¶¼ö',
    28,
    '¼±»ý´Ô',
    '010-1234-5678',
    '³¬½Ã',
    60000000,
    '°ñµå',
    3);
    
INSERT INTO men
(id, name, age, job, phone_number, hobby, salary, grade, count)
VALUES (
    'A-002',
    'È«±æµ¿',
    30,
    '¹«Á÷',
    '010-1111-5678',
    '°ÔÀÓ',
    0,
    '°ñµå',
    3);
INSERT INTO men
(id, name, age, job, phone_number, hobby, salary, grade, count)
VALUES (
    'A-003',
    '±è´õ¹Ì',
    30,
    'ÇÐ»ý',
    '010-1111-1111',
    '¾øÀ½',
    0,
    '°ñµå',
    3);
INSERT INTO men
(id, name, age, job, phone_number, hobby, salary, grade, count)
VALUES (
    'A-004',
    '½ÅÂ÷Â÷',
    13,
    'Áý°æºñ°ß',
    '010-1111-0000',
    '»êÃ¥',
    0,
    'ºê·ÐÁî',
    3);
INSERT INTO men
(id, name, age, job, phone_number, hobby, salary, grade, count)
VALUES (
    'A-005',
    'ÀÌº¥Ã÷',
    30,
    'CEO',
    '010-2222-5678',
    '°ñÇÁ',
    1000000000,
    '´ÙÀÌ¾Æ',
    3);
INSERT INTO women
(id, name, age, job, phone_number, hobby, salary, grade, count)
VALUES (
    'B-001',
    '±è¿µÈñ',
    30,
    '»ç¹«Á÷',
    '010-1111-2222',
    'ÀáÀÚ±â',
    50000000,
    '°ñµå',
    3);
INSERT INTO women
(id, name, age, job, phone_number, hobby, salary, grade, count)
VALUES (
    'B-002',
    '±èÀÇ»ç',
    33,
    'ÀÇ»ç',
    '010-3333-2222',
    '°ÔÀÓ',
    80000000,
    '´ÙÀÌ¾Æ',
    3);
INSERT INTO women
(id, name, age, job, phone_number, hobby, salary, grade, count)
VALUES (
    'B-003',
    'ÇÑ¹«Á÷',
    28,
    '¹«Á÷',
    '010-5555-5555',
    'µß±¼±â',
    0,
    '°ñµå',
    3);
INSERT INTO women
(id, name, age, job, phone_number, hobby, salary, grade, count)
VALUES (
    'B-004',
    'ÀÌÇý¸®',
    25,
    '¹è¿ì',
    '010-3333-2222',
    '»êÃ¥',
    30000000,
    '°ñµå',
    3);
INSERT INTO women
(id, name, age, job, phone_number, hobby, salary, grade, count)
VALUES (
    'B-005',
    'ÀÌ³ª¿µ',
    28,
    '¼±»ý´Ô',
    '010-4321-7890',
    '¼îÇÎ',
    40000000,
    '°ñµå',
    3);

INSERT INTO manager
VALUES (1, '¿øºó', 3);
INSERT INTO manager
VALUES (2, '°­µ¿¿ø', 2);
INSERT INTO manager
VALUES (3, '¼ÛÇý±³', 3);