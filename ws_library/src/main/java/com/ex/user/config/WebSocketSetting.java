package com.ex.user.config;

import com.ex.user.dispatcher.DefaultResponseDispatcher;
import com.ex.user.dispatcher.IResponseDispatcher;

/**
 * Author:  Jerry
 * Date:    2018/10/9
 * Version   v1.0
 * Desc:   WebSocket 使用配置
 */
@SuppressWarnings("all")
public class WebSocketSetting {

    private static String connectUrl;
    private static IResponseDispatcher responseProcessDelivery;
    private static boolean reconnectWithNetworkChanged;

    /**
     * 获取 WebSocket 链接地址
     */
    public static String getConnectUrl() {
        return connectUrl;
    }

    /**
     * 设置 WebSocket 链接地址，第一次设置有效，
     * 必须在启动 WebSocket 线程之前设置
     */
    public static void setConnectUrl(String connectUrl) {
        WebSocketSetting.connectUrl = connectUrl;
    }

    /**
     * 获取当前已设置的消息分发器
     */
    public static IResponseDispatcher getResponseProcessDelivery() {
        if (responseProcessDelivery == null) {
            responseProcessDelivery = new DefaultResponseDispatcher();
        }
        return responseProcessDelivery;
    }

    /**
     * 设置消息分发器
     */
    public static void setResponseProcessDelivery(IResponseDispatcher responseProcessDelivery) {
        WebSocketSetting.responseProcessDelivery = responseProcessDelivery;
    }

    public static boolean isReconnectWithNetworkChanged() {
        return reconnectWithNetworkChanged;
    }

    /**
     * 设置网络连接变化后是否自动重连。
     * 如果设置 true 则需要注册广播：
     * 并添加 ACCESS_NETWORK_STATE 权限。
     */
    public static void setReconnectWithNetworkChanged(boolean reconnectWithNetworkChanged) {
        WebSocketSetting.reconnectWithNetworkChanged = reconnectWithNetworkChanged;
    }
}
