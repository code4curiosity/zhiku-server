/**
 * 
 */
package com.ccbjb.model.pay;

/**
 * TODO 此处输入类或接口的概要说明
 * <p>
 * TODO  此处输入类或接口的详细说明（可省略） 此处输入参数或返回值的相应说明
 * @version 1.0
 * @since 1.0
 * @author CJB-国内开发组
 */
public class AlipayTradePrecreateResponse{

	private String code;

    private String msg;

    private String out_trade_no;

    private String qr_code;

    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return this.msg;
    }
    public void setOut_trade_no(String out_trade_no){
        this.out_trade_no = out_trade_no;
    }
    public String getOut_trade_no(){
        return this.out_trade_no;
    }
    public void setQr_code(String qr_code){
        this.qr_code = qr_code;
    }
    public String getQr_code(){
        return this.qr_code;
    }
}
