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
public class AlipayQrCodeBean {

	private AlipayTradePrecreateResponse alipay_trade_precreate_response;

    private String sign;

    public void setAlipay_trade_precreate_response(AlipayTradePrecreateResponse alipay_trade_precreate_response){
        this.alipay_trade_precreate_response = alipay_trade_precreate_response;
    }
    public AlipayTradePrecreateResponse getAlipay_trade_precreate_response(){
        return this.alipay_trade_precreate_response;
    }
    public void setSign(String sign){
        this.sign = sign;
    }
    public String getSign(){
        return this.sign;
    }
}
