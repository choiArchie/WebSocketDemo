package com.ex.demo;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.ex.user.bean.ErrorResponse;
import com.ex.user.bean.Response;
import com.ex.user.dispatcher.IResponseDispatcher;
import com.ex.user.listener.ResponseDelivery;

/**
 * Author:  Jerry
 * Date:    2018/10/9
 * Version   v1.0
 * Desc:    重写消息分发器
 */
@SuppressWarnings("all")
public class AppResponseDispatcher implements IResponseDispatcher {
    private static final String LOGTAG = "AppResponseDispatcher";

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
        try {
            CommonResponseEntity commonResponseEntity = JSON.parseObject(message.getResponseText(), new TypeReference<CommonResponseEntity>() {
            });
            CommonResponse commonResponse = new CommonResponse(message.getResponseText(), commonResponseEntity);
            if (commonResponse.getResponseEntity().getCode() == 1) {
                delivery.onMessageResponse(commonResponse);
            } else {
                ErrorResponse errorResponse = new ErrorResponse();
                errorResponse.setErrorCode(12);
                errorResponse.setDescription(commonResponse.getResponseEntity().getMsg());
                errorResponse.setResponseText(message.getResponseText());
                //将已经解析好的 CommonResponseEntity 独享保存起来以便后面使用
                errorResponse.setReserved(commonResponseEntity);
                onSendMessageError(errorResponse, delivery);
            }
        } catch (Exception e) {
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setResponseText(message.getResponseText());
            errorResponse.setErrorCode(11);
            errorResponse.setCause(e);
            onSendMessageError(errorResponse, delivery);
        }

    }

    @Override
    public void onSendMessageError(ErrorResponse error, ResponseDelivery delivery) {
        switch (error.getErrorCode()) {
            case 1002:
                error.setDescription("网络错误");
                break;
            case 1003:
                error.setDescription("网络错误");
                break;
            case 1004:
                error.setDescription("网络错误");
                break;
            case 11:
                error.setDescription("数据格式异常");
                Log.e(LOGTAG, "数据格式异常", error.getCause());
                break;
        }
        delivery.onSendMessageError(error);
    }
}
