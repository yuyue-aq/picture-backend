-- 清空数据库脚本
-- 该脚本将清空 yu_picture 数据库中的所有数据，但保留表结构

-- 禁用外键检查
SET FOREIGN_KEY_CHECKS = 0;

-- 清空 user 表
DELETE FROM user;
-- 重置自增id为1
ALTER TABLE user AUTO_INCREMENT = 1;

-- 启用外键检查
SET FOREIGN_KEY_CHECKS = 1;

-- 验证清空是否成功
-- SELECT COUNT(*) FROM user;
-- SELECT COUNT(*) FROM picture;

