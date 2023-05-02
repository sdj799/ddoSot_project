DROP TABLE men;

CREATE TABLE men (
    id VARCHAR2(10) PRIMARY KEY,
    name VARCHAR2(20) NOT NULL,
    age NUMBER(3) NOT NULL,
    job VARCHAR2(50) NOT NULL,
    salary NUMBER(15) NOT NULL,
    grade VARCHAR2(20) NOT NULL,
    count NUMBER(1) DEFAULT 3 NULL,
    partner_id VARCHAR2(20) DEFAULT null,
    manager_num NUMBER(3)
);

DROP SEQUENCE men_seq;

CREATE SEQUENCE men_seq
    START WITH 106
    NOCACHE;

DROP TABLE women;

CREATE TABLE women (
    id VARCHAR2(10) PRIMARY KEY,
    name VARCHAR2(20) NOT NULL,
    age NUMBER(3) NOT NULL,
    job VARCHAR2(50) NOT NULL,
    salary NUMBER(15) NOT NULL,
    grade VARCHAR2(20) NOT NULL,
    count NUMBER(1) DEFAULT 3 NULL,
    partner_id VARCHAR2(20) DEFAULT null,
    manager_num NUMBER(3)
);

DROP SEQUENCE women_seq;

CREATE SEQUENCE women_seq
    START WITH 106
    NOCACHE;

DROP TABLE matching;

CREATE TABLE matching (
    match_num NUMBER PRIMARY KEY,
    men_id VARCHAR2(10) UNIQUE NOT NULL,
    women_id VARCHAR2(10) UNIQUE NOT NULL,
    manager_num NUMBER NOT NULL,
    married VARCHAR2(2) NULL
);

DROP SEQUENCE matching_seq;

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
    START WITH 4
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
(id, name, age, job, salary, grade, count, manager_num)
VALUES (
    'A101',
    '±èÃ¶¼ö',
    28,
    '¼±»ý´Ô',
    60000000,
    '°ñµå',
    3,
    1);
    
INSERT INTO men
(id, name, age, job, salary, grade, count, manager_num)
VALUES (
    'A102',
    'È«±æµ¿',
    30,
    '¹«Á÷',
    0,
    '°ñµå',
    3,
    2);
INSERT INTO men
(id, name, age, job, salary, grade, count, manager_num)
VALUES (
    'A103',
    '±è¼öÇö',
    30,
    'ÇÐ»ý',
    0,
    'ºê·ÐÁî',
    3,
    3);
INSERT INTO men
(id, name, age, job, salary, grade, count, manager_num)
VALUES (
    'A104',
    '¹Ú¼­ÁØ',
    27,
    'Ãà±¸¼±¼ö',
    30000000,
    '°ñµå',
    3,
    3);
INSERT INTO men
(id, name, age, job, salary, grade, count, manager_num)
VALUES (
    'A105',
    'ÀÌÇö¿ì',
    30,
    'CEO',
    1000000000,
    '´ÙÀÌ¾Æ',
    3,
    1);
INSERT INTO women
(id, name, age, job, salary, grade, count, manager_num)
VALUES (
    'B101',
    '±è¿µÈñ',
    30,
    '»ç¹«Á÷',
    50000000,
    '°ñµå',
    3,
    2);
INSERT INTO women
(id, name, age, job, salary, grade, count, manager_num)
VALUES (
    'B102',
    '±èÀÇ»ç',
    33,
    'ÀÇ»ç',
    80000000,
    '´ÙÀÌ¾Æ',
    3,
    3);
INSERT INTO women
(id, name, age, job, salary, grade, count, manager_num)
VALUES (
    'B103',
    '¾ÆÀÌÀ¯',
    28,
    '±âÀÚ',
    4000000,
    '°ñµå',
    3,
    1);
INSERT INTO women
(id, name, age, job, salary, grade, count, manager_num)
VALUES (
    'B104',
    'ÀÌÇý¸®',
    25,
    '¹è¿ì',
    30000000,
    '°ñµå',
    3,
    2);
INSERT INTO women
(id, name, age, job, salary, grade, count, manager_num)
VALUES (
    'B105',
    'ÀÌ³ª¿µ',
    28,
    '¼±»ý´Ô',
    40000000,
    '°ñµå',
    3,
    3);

INSERT INTO manager
VALUES (1, '¿øºó', 3);
INSERT INTO manager
VALUES (2, '°­µ¿¿ø', 2);
INSERT INTO manager
VALUES (3, '¼ÛÇý±³', 3);

DROP TRIGGER trg_performance;

CREATE OR REPLACE TRIGGER trg_performance
    AFTER INSERT
        ON matching
        FOR EACH ROW
DECLARE
    v_manager_num NUMBER;
BEGIN
    v_manager_num := :NEW.manager_num;

    UPDATE manager SET performance = performance + 3
    WHERE manager_num = v_manager_num;
END;

DROP TRIGGER trg_married;

CREATE OR REPLACE TRIGGER trg_married
    AFTER UPDATE
        ON matching
        FOR EACH ROW
DECLARE
    v_manager_num NUMBER;
BEGIN
    v_manager_num := :OLD.manager_num;

    UPDATE manager SET performance = performance + 30
    WHERE manager_num = v_manager_num;
END;

COMMIT;

