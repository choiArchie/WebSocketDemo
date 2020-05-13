package com.ex.user.listener;

import com.ex.user.bean.ErrorResponse;
import com.ex.user.bean.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  Jerry
 * Date:    2018/10/9
 * Version   v1.0
 * Desc:   消息发射器
 * 内部维护一个 {@link SocketListener} 的 List，调用每一个方法都会通知 List 中所有的 Listener
 * 简化代码
 */
@SuppressWarnings("all")
public class ResponseDelivery implements SocketListener {
    private final List<SocketListener> mSocketListenerList = new ArrayList<>();

    public ResponseDelivery() {
    }

    public void addListener(SocketListener listener) {
        synchronized (mSocketListenerList) {
            mSocketListenerList.add(listener);
        }
    }

    public void removeListener(SocketListener listener) {
        synchronized (mSocketListenerList) {
            mSocketListenerList.remove(listener);
        }
    }

    @Override
    public void onConnected() {
        synchronized (mSocketListenerList) {
            for (SocketListener listener : mSocketListenerList) {
                listener.onConnected();
            }
        }
    }

    @Override
    public void onConnectError(Throwable cause) {
        synchronized (mSocketListenerList) {
            for (SocketListener listener : mSocketListenerList) {
                listener.onConnectError(cause);
            }
        }
    }

    @Override
    public void onDisconnected() {
        synchronized (mSocketListenerList) {
            for (SocketListener listener : mSocketListenerList) {
                listener.onDisconnected();
            }
        }
    }

    @Override
    public void onMessageResponse(Response message) {
        synchronized (mSocketListenerList) {
            for (SocketListener listener : mSocketListenerList) {
                listener.onMessageResponse(message);
            }
        }
    }

    @Override
    public void onSendMessageError(ErrorResponse message) {
        synchronized (mSocketListenerList) {
            for (SocketListener listener : mSocketListenerList) {
                listener.onSendMessageError(message);
            }
        }
    }
}
