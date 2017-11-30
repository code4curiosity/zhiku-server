package com.ccbjb.controller.push;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import com.ccbjb.common.mybatis.Result;
import com.ccbjb.common.mybatis.ResultGenerator;
import com.ccbjb.common.utils.LoggerUtils;
import com.ccbjb.controller.common.BaseController;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息推送
 */
@RestController
@Scope(value="prototype")
@RequestMapping("push")
public class PushController extends BaseController{
	
	/**
	 * 消息推送index
	 * @return
	 */
	@RequestMapping(value="index")
	public String index(){
		return "push/index";
	}
	/**
	 * 消息推送
	 * @param pushTitle	          推送标题
	 * @param pushContent	 推送内容
	 * @param pushTag		 设备tag
	 * @param pushAlias		 设备alias
	 * @return
	 */
	@PostMapping(value="send")
	public Result send(String pushTitle, String pushContent, String pushTag, String pushAlias){
		
		JPushClient jpushClient = new JPushClient("8fea6193b3c2723254887345", "a482d6ef515165c46b805000", null, ClientConfig.getInstance());
		
		PushPayload payload = buildPushObject(pushContent,pushTitle,pushTag);
		Result result = null;
		try {
			PushResult pushresult = jpushClient.sendPush(payload);
			
			LoggerUtils.fmtDebug(getClass(), "推送成功 结果 - " + pushresult);
			result = ResultGenerator.genSuccessResult("推送成功");
		} catch (APIConnectionException e) {
			LoggerUtils.fmtDebug(getClass(), "连接极光推送服务器失败，请稍后重试");
			result = ResultGenerator.genFailResult();

		} catch (APIRequestException e) {
			// Should review the error, and fix the request
			LoggerUtils.fmtDebug(getClass(), "请求失败");
			LoggerUtils.fmtDebug(getClass(), "HTTP Status: " + e.getStatus());
			LoggerUtils.fmtDebug(getClass(), "Error Code: " + e.getErrorCode());
			LoggerUtils.fmtDebug(getClass(), "Error Message: " + e.getErrorMessage());
			result = ResultGenerator.genFailResult();
		}
		
		return result;
	}
	
	private PushPayload buildPushObject(String alert,String titles,String tag) {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.tag(tag))
                .setNotification(Notification.android(alert, titles, null))
                .build();
    }
}
