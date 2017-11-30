package com.ccbjb.common.mybatis;

/**
 * 服务（业务）异常如“ 账号或密码错误 ”，该异常只做INFO级别的日志记录 @see WebMvcConfigurer
 */
public class TKMException extends RuntimeException {
    private Integer code;
    public TKMException() {
    }

    public TKMException(String message) {
        super(message);
    }

    public TKMException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public TKMException(String message, Throwable cause) {
        super(message, cause);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
