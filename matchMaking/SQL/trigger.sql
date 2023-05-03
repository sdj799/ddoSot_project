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

CREATE OR REPLACE TRIGGER trg_men_count
    AFTER INSERT
        ON matching
        FOR EACH ROW
DECLARE
    v_id VARCHAR2(10);
BEGIN
    v_id := :NEW.men_id;
    
    UPDATE men SET count = count - 1
    WHERE id = v_id;
END;

CREATE OR REPLACE TRIGGER trg_women_count
    AFTER INSERT
        ON matching
        FOR EACH ROW
DECLARE
    v_id VARCHAR2(10);
BEGIN
    v_id := :NEW.women_id;
    
    UPDATE women SET count = count - 1
    WHERE id = v_id;
END;