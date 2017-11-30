package com.ccbjb.controller.user;

import com.ccbjb.common.domain.SysUser;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultCode;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.shiro.TokenManager;
import com.ccbjb.common.shiro.VerifyCodeUtils;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.controller.common.BaseController;
import com.ccbjb.service.user.IUserService;
import org.apache.shiro.authc.DisabledAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 登陆和退出
 * @version 1.0
 * @since 1.0
 * @author CJB-国内开发组
 */
@RestController
@Scope(value="prototype")
@RequestMapping("user")
public class LoginController extends BaseController{

	@Autowired
    IUserService userService;
	/**
	 * 登录跳转
	 * @return
	 */
	@RequestMapping(value="login")
	public Result login(HttpServletRequest request){
		return ResultGenerator.genFailResult(ResultCode.RE_LOGIN);
	}

	/**
	 * 无权限
	 * @return
	 */
	@RequestMapping(value="refuse")
	public Result refuse(HttpServletRequest request){
		return ResultGenerator.genFailResult(ResultCode.RE_LOGIN);
	}

	//登陆提交地址，和applicationContext-shiro.xml中配置的loginurl一致
	@PostMapping(value="submitLogin")
	public Result submitLogin(SysUser sysUser, Boolean rememberMe, HttpServletRequest request)throws Exception{
		Result result = null;
		try {
			sysUser = TokenManager.login(sysUser.getEmail(),sysUser.getPswd(),rememberMe);

			//跳转地址
			result = ResultGenerator.genSuccessResult("登录成功");
			/**
			 * 这里其实可以直接catch Exception，然后抛出 message即可，但是最好还是各种明细catch 好点。。
			 */
		} catch (DisabledAccountException e) {
			result = ResultGenerator.genFailResult(ResultCode.ERR_108);
		} catch (Exception e) {
			result = ResultGenerator.genFailResult(ResultCode.ERR_105);
		}

		return result;
	}

	/**
	 * 注册 && 登录
	 * @param vcode		验证码
	 * @param entity	SysUser实体
	 * @return
	 */
	@PostMapping(value="subRegister")
	public Result subRegister(String vcode, SysUser entity){
		Result result = null;
		if(!VerifyCodeUtils.verifyCode(vcode)){
			result = ResultGenerator.genFailResult(ResultCode.ERR_109);
			return result;
		}
		String email =  entity.getEmail();
		String password = entity.getPswd();

		SysUser user = userService.findUserByEmail(email);
		if(null != user){
			result = ResultGenerator.genFailResult(ResultCode.ERR_110);
			return result;
		}

		userService.insert(entity);
		LoggerUtils.fmtDebug(getClass(), "注册插入完毕！");
		TokenManager.login(email,password, Boolean.TRUE);
		LoggerUtils.fmtDebug(getClass(), "注册后，登录完毕！");
		result = ResultGenerator.genSuccessResult("注册成功！");
		return result;
	}
}
