package com.hqj.noora12306.framework.starter.bases.constant;

/**
 * ClassName: UserConstant
 * Package: com.hqj.noora12306.framework.starter.bases.constant
 * Description:
 *
 * @Author:HQJ
 * @Create:2024/6/11 - 14:28
 * @Version v1.0
 */

/**
 * 用户常量
 * 这个常量不是只在用户组件库中使用的，在后续的网关中也会用到这个 因此放在顶级组件库中
 */
public final class UserConstant {
    /**
     * 用户 ID Key
     */
    public static final String USER_ID_KEY = "userId";

    /**
     * 用户名 Key
     */
    public static final String USER_NAME_KEY = "username";

    /**
     * 用户真实名称 Key
     */
    public static final String REAL_NAME_KEY = "realName";
}
