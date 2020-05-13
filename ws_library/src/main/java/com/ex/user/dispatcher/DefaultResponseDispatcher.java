package com.ex.user.dispatcher;

import com.ex.user.bean.ErrorResponse;
import com.ex.user.bean.Response;
import com.ex.user.listener.ResponseDelivery;

/**
 * Author:  Jerry
 * Date:    2018/10/9
 * Version   v1.0
 * Desc:   通用消息调度器，不做任何数据处理
 */
@SuppressWarnings("all")
public class DefaultResponseDispatcher implements IResponseDispatcher {
    @Override
    public void onConnected(ResponseDelivery delivery) {
        delivery.onConnected();
    }

    @Override
    public void onConnectError(Throwable cause, ResponseDelivery delivery) {
        delivery.onConnectError(cause);
    }

    @Override
    public void onDisconnected(ResponseDelivery delivery) {
        delivery.onDisconnected();
    }

    @Override
    public void onMessageResponse(Response message, ResponseDelivery delivery) {
        delivery.onMessageResponse(message);
    }

    @Override
    public void onSendMessageError(ErrorResponse error, ResponseDelivery delivery) {
        delivery.onSendMessageError(error);
    }
}
