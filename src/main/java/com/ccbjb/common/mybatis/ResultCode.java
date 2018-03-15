package com.ccbjb.common.mybatis;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESS(200, "成功"),
    RE_LOGIN(101, "重新登录"),
    FIRST(102, "首页"),
    LOGIN_REFUSE(103, "无权限"),
    LOGIN_SUCCESS(104, "登录成功"),
    ERR_105(105, "帐号或密码错误"),
    ERR_106(106, "管理员不准修改密码。"),
    ERR_107(107, "密码不正确！"),
    ERR_108(108, "帐号已经禁用。"),
    ERR_109(109, "验证码不正确！"),
    ERR_110(110, "帐号|Email已经存在！"),
    ERR_111(111, "存在多个当前tips"),
    ERR_112(112, "不存在的tips"),
    ERR_113(113, "存在子节点的Tip不能删除！"),
    FAIL(400, "失败"),
    UNAUTHORIZED(401, "未认证（签名错误）"),
    NOT_FOUND(404, "接口不存在"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
