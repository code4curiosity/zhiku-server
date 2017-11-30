package com.ccbjb.controller.user;

import com.ccbjb.common.domain.SysUser;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultCode;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.shiro.TokenManager;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.logic.user.UserManager;
import com.ccbjb.service.user.IUserService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆和退出
 * @version 1.0
 * @since 1.0
 * @author CJB-国内开发组
 */
@RestController
@Scope(value="prototype")
@RequestMapping("welcome")
public class WelcomeController {

	@Autowired
    IUserService userService;

	//登陆提交地址，和applicationContext-shiro.xml中配置的loginurl一致
	@GetMapping("first")
	public Result first(HttpServletRequest request, ModelMap modal)throws Exception{
		return ResultGenerator.genFailResult(ResultCode.FIRST);
	}
	
	@GetMapping("userinfo")
	public Result userinfo(HttpServletRequest request, ModelMap modal)throws Exception{
		
		SysUser token = TokenManager.getToken();
		return ResultGenerator.genSuccessResult(token);
	}

	/**
	 * 密码修改
	 * @return
	 */
	@PostMapping(value="updatePswd")
	public Result updatePswd(String pswd, String newPswd){
		SysUser user = TokenManager.getToken();
		String email = user.getEmail();
		user.setPswd(pswd);
		user = userService.login(user);

		Result result = null;
		if("admin".equals(email)){
			return ResultGenerator.genFailResult(ResultCode.ERR_106);
		}

		if(null == user){
			result = ResultGenerator.genFailResult(ResultCode.ERR_107);
		}else{
			String newPassword = newPswd;
			user.setPswd(newPassword);
			//重新生成盐值
			String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
			user.setSalt(salt);
	        user = UserManager.md5Pswd(user);
			//修改密码
			userService.updateByPrimaryKeySelective(user);
			result = ResultGenerator.genSuccessResult("修改成功!");
			//重新登录一次
			TokenManager.login(user.getEmail(),newPassword, Boolean.TRUE);
		}
		return result;
	}
	/**
	 * 个人资料修改
	 * @return
	 */
	@RequestMapping(value="updateSelf",method= RequestMethod.POST)
	public Result updateSelf(SysUser entity){
		Result result = null;
		try {
			userService.updateByPrimaryKeySelective(entity);
			result = ResultGenerator.genSuccessResult("修改成功!");
		} catch (Exception e) {
			result = ResultGenerator.genFailResult();
			LoggerUtils.fmtError(getClass(), e, "修改个人资料出错。[%s]");
		}
		return result;
	}
}
