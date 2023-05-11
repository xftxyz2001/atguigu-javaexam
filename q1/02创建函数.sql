-- 查看mysql是否允许创建函数：
SHOW VARIABLES LIKE 'log_bin_trust_function_creators';
-- 命令开启：允许创建函数设置：（global-所有session都生效）
SET GLOBAL log_bin_trust_function_creators = 1;

-- 随机产生字符串
DELIMITER $$
CREATE FUNCTION rand_string(n INT) RETURNS VARCHAR(255) BEGIN
DECLARE chars_str VARCHAR(100) DEFAULT 'abcdefghijklmnopqrstuvwxyzABCDEFJHIJKLMNOPQRSTUVWXYZ';
DECLARE return_str VARCHAR(255) DEFAULT '';
DECLARE i INT DEFAULT 0;
WHILE i < n DO
SET return_str = CONCAT(
        return_str,
        SUBSTRING(chars_str, FLOOR(1 + RAND() * 52), 1)
    );
SET i = i + 1;
END WHILE;
RETURN return_str;
END $$
-- 假如要删除
-- drop function rand_string;

-- 用于随机产生区间数字
DELIMITER $$
CREATE FUNCTION rand_num (from_num INT, to_num INT) RETURNS INT(11) BEGIN
DECLARE i INT DEFAULT 0;
SET i = FLOOR(from_num + RAND() *(to_num - from_num + 1));
RETURN i;
END $$
-- 假如要删除
-- drop function rand_num;