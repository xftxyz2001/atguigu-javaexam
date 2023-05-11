-- 批量删除某个表上的所有索引
DELIMITER $$ CREATE PROCEDURE `proc_drop_index`(dbname VARCHAR(200), tablename VARCHAR(200)) BEGIN
DECLARE done INT DEFAULT 0;
DECLARE ct INT DEFAULT 0;
DECLARE _index VARCHAR(200) DEFAULT '';
DECLARE _cur CURSOR FOR
SELECT index_name
FROM information_schema.STATISTICS
WHERE table_schema = dbname
    AND table_name = tablename
    AND seq_in_index = 1
    AND index_name <> 'PRIMARY';
DECLARE CONTINUE HANDLER FOR NOT FOUND
set done = 2;
OPEN _cur;
FETCH _cur INTO _index;
WHILE _index <> '' DO
SET @str = CONCAT("drop index ", _index, " on ", tablename);
PREPARE sql_str
FROM @str;
EXECUTE sql_str;
DEALLOCATE PREPARE sql_str;
SET _index = '';
FETCH _cur INTO _index;
END WHILE;
CLOSE _cur;
END $$ -- 执行批量删除：dbname 库名称, tablename 表名称
CALL proc_drop_index("dbname", "tablename");