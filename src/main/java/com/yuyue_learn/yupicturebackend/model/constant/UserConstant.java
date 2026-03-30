package com.yuyue_learn.yupicturebackend.model.constant;

/**
 * 用户相关常量
 */
public final class UserConstant {

    /**
     * 用户登录态键
     */
    public static final String USER_LOGIN_STATE = "user_login";

    /**
     * 默认角色
     */
    public static final String DEFAULT_ROLE = "user";

    /**
     * 管理员角色
     */
    public static final String ADMIN_ROLE = "admin";

    /**
     * 私有构造方法，防止实例化
     */
    private UserConstant() {
        throw new AssertionError("不能实例化常量类");
    }
}
