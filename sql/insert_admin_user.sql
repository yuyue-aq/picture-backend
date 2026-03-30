-- 添加admin账户的SQL脚本
-- 密码加密方式：MD5(salt + password)，其中 salt = "yupi"
-- 例如：password="admin123456" -> MD5("yupiAdmin@123")

-- 以下是示例，密码为 "Admin@123"
-- 计算方式：使用在线MD5工具或以下Python代码生成
-- import hashlib
-- password = "Admin@123"
-- salt = "yupi"
-- encrypted = hashlib.md5((salt + password).encode()).hexdigest()
-- 结果: a516d1d07f83e8e3a77f2f1c0f0f0e0f （实际需要自己计算）

-- 请根据你要设置的实际密码，计算MD5加密后的值，然后执行以下SQL
-- INSERT INTO user (userAccount, userPassword, userName, userRole, userProfile)
-- VALUES ('admin', 'MD5_ENCRYPTED_PASSWORD_HERE', 'Admin User', 'admin', 'System Administrator');

-- 以下是一个更方便的方式：直接使用MD5函数（如果MySQL支持）
-- 密码为 "Admin@123"
INSERT INTO user (userAccount, userPassword, userName, userRole, userProfile)
VALUES (
    'admin',
    'e39818811cd0c417bb3bfa25883ec63c',  -- 这是 MD5("135790uyuyue") 的结果，请替换为你要设置的密码的MD5值
    'AdminUserYuYue',
    'admin',
    'System Administrator'
);

-- 如果上面的密码加密值有问题，可以使用以下步骤：
-- 1. 决定你要设置的密码，例如：MyPassword123
-- 2. 在Java中执行以下代码获取加密密码：
--    String password = "MyPassword123";
--    String salt = "yupi";
--    String encrypted = DigestUtils.md5DigestAsHex((salt + password).getBytes());
--    System.out.println(encrypted);
-- 3. 将输出的加密密码替换到上面的SQL语句中

-- 检查是否插入成功
-- SELECT * FROM user WHERE userAccount = 'admin';

