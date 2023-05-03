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
    START WITH 111
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
    START WITH 111
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
    START WITH 3
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



INSERT INTO men (id, name, age, job, salary, grade, count, manager_num, partner_id) VALUES ('A101', '김철수', 28, '선생님',60000000, '골드', 2,  1, 'B101');
INSERT INTO men (id, name, age, job, salary, grade, count, manager_num) VALUES ('A102', '홍길동', 30, '무직',1000000, '골드', 3, 2);
INSERT INTO men (id, name, age, job, salary, grade, count, manager_num) VALUES ('A103', '김수현', 30, '학생',2000000, '브론즈', 3, 3);
INSERT INTO men (id, name, age, job, salary, grade, count, manager_num) VALUES ('A104', '이현우', 30, 'CEO',1000000000, '다이아', 3, 3);
INSERT INTO men (id, name, age, job, salary, grade, count, manager_num) VALUES ('A105', '김형준', 48, '대기업부장',100000000, '다이아', 3, 2);
INSERT INTO men (id, name, age, job, salary, grade, count, manager_num, partner_id) VALUES ('A106', '박수민', 37, '자영업자',200000000, '골드', 2, 2, 'B105');
INSERT INTO men (id, name, age, job, salary, grade, count, manager_num) VALUES ('A107', '민용기', 44, '카페사장',50000000, '브론즈', 3, 2);
INSERT INTO men (id, name, age, job, salary, grade, count, manager_num) VALUES ('A108', '최민수', 34, '중소기업팀장',60000000, '브론즈', 2, 3);
INSERT INTO men (id, name, age, job, salary, grade, count, manager_num) VALUES ('A109', '임현창', 40, 'IT소프트웨어부장',80000000, '브론즈', 2, 1);
INSERT INTO men (id, name, age, job, salary, grade, count, manager_num) VALUES ('A110', '고규민', 32, '대기업사원',60000000, '골드', 3, 2);


INSERT INTO women (id, name, age, job, salary, grade, count, manager_num, partner_id) VALUES ('B101', '김영희', 30, '사무직',50000000, '골드', 2, 1, 'A101');
INSERT INTO women (id, name, age, job, salary, grade, count, manager_num) VALUES ('B102', '김의사', 33, '의사',80000000, '다이아', 3, 3);
INSERT INTO women (id, name, age, job, salary, grade, count, manager_num) VALUES ('B103', '아이유', 28, '기자',4000000, '골드', 3, 1);
INSERT INTO women (id, name, age, job, salary, grade, count, manager_num) VALUES ('B104', '이혜리', 25, '배우',30000000, '골드', 3, 1);
INSERT INTO women (id, name, age, job, salary, grade, count, manager_num, partner_id) VALUES ('B105', '이나영', 28, '선생님',40000000, '골드', 2, 2, 'A106');
INSERT INTO women (id, name, age, job, salary, grade, count, manager_num) VALUES ('B106', '김현지', 40, '경리',30000000, '브론즈', 2, 2);
INSERT INTO women (id, name, age, job, salary, grade, count, manager_num) VALUES ('B107', '심원경', 44, '중소기업팀장',100000000, '다이아', 2, 3);
INSERT INTO women (id, name, age, job, salary, grade, count, manager_num) VALUES ('B108', '신나정', 30, '승무원',50000000, '골드', 1, 3);
INSERT INTO women (id, name, age, job, salary, grade, count, manager_num) VALUES ('B109', '박연수', 28, '어린이집교사',40000000, '브론즈', 3, 1);
INSERT INTO women (id, name, age, job, salary, grade, count, manager_num) VALUES ('B110', '김은혜', 32, '무직',1000000, '브론즈', 3, 1);

INSERT INTO matching (match_num, men_id, women_id, manager_num)
VALUES (1, 'A101', 'B101', 1);
INSERT INTO matching (match_num, men_id, women_id, manager_num)
VALUES (2, 'A106', 'B105', 2);


INSERT INTO manager
VALUES (1, '원빈', 3);
INSERT INTO manager
VALUES (2, '강동원', 2);
INSERT INTO manager
VALUES (3, '송혜교', 3);




COMMIT;