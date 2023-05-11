-- 插入员工数据
DELIMITER $$
CREATE PROCEDURE insert_emp(START INT, max_num INT) BEGIN
DECLARE i INT DEFAULT 0;
SET autocommit = 0; -- 关闭自动提交
REPEAT
SET i = i + 1;
INSERT INTO emp (empno, NAME, age, deptid)
VALUES (
        (START + i),
        rand_string(6),
        rand_num(30, 50),
        rand_num(1, 10000)
    );
UNTIL i = max_num
END REPEAT;
COMMIT;
END $$
-- 删除
-- DELIMITER ;
-- drop PROCEDURE insert_emp;

-- 插入部门数据
DELIMITER $$
CREATE PROCEDURE insert_dept(max_num INT) BEGIN
DECLARE i INT DEFAULT 0;
SET autocommit = 0;
REPEAT
SET i = i + 1;
INSERT INTO dept (deptname, address, ceo)
VALUES (
        rand_string(8),
        rand_string(10),
        rand_num(1, 500000)
    );
UNTIL i = max_num
END REPEAT;
COMMIT;
END $$
-- 删除
-- DELIMITER ;
-- drop PROCEDURE insert_dept;