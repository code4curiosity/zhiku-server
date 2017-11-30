/**
 * 
 */
package com.ccbjb.logic.pay;

import java.security.MessageDigest;

/**
 * TODO 此处输入类或接口的概要说明
 * <p>
 * TODO  此处输入类或接口的详细说明（可省略） 此处输入参数或返回值的相应说明
 * @version 1.0
 * @since 1.0
 * @author CJB-国内开发组
 */
public class MD5Util {
	private static String byteArrayToHexString(byte b[]) {  
        StringBuffer resultSb = new StringBuffer();  
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();  
    }  
  
    private static String byteToHexString(byte b) {  
        int n = b;  
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;  
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }  
  
    public static String MD5Encode(String origin, String charsetname) {  
        String resultString = null;  
        try {  
            resultString = new String(origin);  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            if (charsetname == null || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            }
            else {
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
            }
        } catch (Exception exception) {  
        }  
        return resultString;  
    }  
  
    private static final String HEX_DIGITS[] = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

}
