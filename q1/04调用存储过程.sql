-- 执行存储过程，往dept表添加1万条数据
CALL insert_dept(10000);
-- 执行存储过程，往emp表添加50万条数据，编号从100000开始
CALL insert_emp(100000, 500000);