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

CREATE SEQUENCE manager_seq
    NOCACHE;

ALTER TABLE men ADD FOREIGN KEY(partner_id) REFERENCES matching(women_id);

ALTER TABLE women ADD FOREIGN KEY(partner_id) REFERENCES matching(men_id);

ALTER TABLE matching ADD FOREIGN KEY(men_id) REFERENCES men(id);

ALTER TABLE matching ADD FOREIGN KEY(women_id) REFERENCES women(id);

ALTER TABLE matching ADD FOREIGN KEY(manager_num) REFERENCES manager(manager_num);

