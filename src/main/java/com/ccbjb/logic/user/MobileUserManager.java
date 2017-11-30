package com.ccbjb.logic.user;


import com.ccbjb.common.domain.ShopOwner;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;

public class MobileUserManager {
	
	/**
	 * 加工密码，和登录一致。
	 * @param user
	 * @return
	 */
	public static ShopOwner md5Pswd(ShopOwner user){
		user.setPswd(UserManager.md5Pswd(user.getPswd(),user.getMobile()+user.getSalt()));
		return user;
	}
	
	public static String createTokenId(){
		return new SecureRandomNumberGenerator().nextBytes().toHex();
	}
	
}
