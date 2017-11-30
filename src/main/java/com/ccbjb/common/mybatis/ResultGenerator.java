package com.ccbjb.common.mybatis;

/**
 * 响应结果生成工具
 */
public class ResultGenerator {

    public static Result genSuccessResult() {
        return new Result().setCode(ResultCode.SUCCESS.getCode()).setMessage(ResultCode.SUCCESS.getMessage());
    }

    public static Result genSuccessResult(Object data) {
        return new Result().setCode(ResultCode.SUCCESS.getCode()).setMessage(ResultCode.SUCCESS.getMessage()).setData(data);
    }

    public static Result genFailResult() {
        return new Result().setCode(ResultCode.FAIL).setMessage(ResultCode.FAIL.getMessage());
    }

    public static Result genFailResult(ResultCode errCode) {
        return new Result().setCode(errCode.getCode()).setMessage(errCode.getMessage());
    }
}
