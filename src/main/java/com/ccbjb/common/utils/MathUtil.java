package com.ccbjb.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.Random;

public class MathUtil {
	/**
	 * 获取随机的数值。
	 * @param length	长度
	 * @return
	 */
	public static String getRandom620(Integer length){
	   String result = "";
	   Random rand = new Random();
	   int n = 20;
	   if(null != length && length > 0){
		   n = length;
	   }
       boolean[]  bool = new boolean[n];
       int randInt = 0;
       for(int i = 0; i < length ; i++) {
            do {
                randInt  = rand.nextInt(n);

            }while(bool[randInt]);

           bool[randInt] = true;
           result += randInt;
       }
       return result;
	}
	/**
	 * MD5 加密
	 * @param str
	 * @return
	 * @throws Exception
	 */
	 public static String  getMD5(String str,String salt) {
		 	String md5 =  new SimpleHash("md5",str, ByteSource.Util.bytes(salt),2).toHex();
		 	return md5;
	    }  
}