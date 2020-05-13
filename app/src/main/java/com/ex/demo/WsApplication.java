package com.ex.demo;

import android.app.Application;
import android.content.Intent;

import com.blankj.utilcode.util.Utils;
import com.ex.user.config.WebSocketSetting;
import com.ex.user.service.WebSocketService;

/**
 * Author:  Jerry
 * Date:    2018/10/9
 * Version   v1.0
 * Desc:   应用程序的入口
 */
@SuppressWarnings("all")
public class WsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        //配置webSocket必须在服务启动前配置
        WebSocketSetting.setConnectUrl(Constant.WEBSOCKET_URL);
        WebSocketSetting.setResponseProcessDelivery(new AppResponseDispatcher());
        WebSocketSetting.setReconnectWithNetworkChanged(true);
        //启动服务
        startService(new Intent(this, WebSocketService.class));
    }
}
