package com.ex.user.service;

import com.ex.user.listener.SocketListener;

/**
 * Author:  Jerry
 * Date:    2018/10/9
 * Version   v1.0
 * Desc:    需要使用 WebSocketService 的页面应该事先的接口
 */
@SuppressWarnings("all")
public interface IWebSocketPage extends SocketListener {
    /**
     * WebSocketService 绑定成功回调
     */
    void onServiceBindSuccess();

    /**
     * 通过 WebSocketService 发送数据
     *
     * @param text 需要发送的文本数据
     */
    void sendText(String text);

    /**
     * 重新连接，内部已经做了自动重连机制，一般不需要使用此方法
     */
    void reconnect();
}
