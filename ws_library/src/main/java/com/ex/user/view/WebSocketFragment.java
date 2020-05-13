package com.ex.user.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ex.user.manager.WebSocketServiceConnectManager;
import com.ex.user.service.IWebSocketPage;

/**
 * Author:  Jerry
 * Date:    2018/10/9
 * Version   v1.0
 * Desc:    绑定了 WebSocketService 的抽象 Fragment
 */
@SuppressWarnings("all")
public abstract class WebSocketFragment extends Fragment implements IWebSocketPage {
    protected final String LOGTAG = this.getClass().getSimpleName();

    private WebSocketServiceConnectManager mConnectManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mConnectManager = new WebSocketServiceConnectManager(getActivity().getApplicationContext(), this);
        mConnectManager.onCreate();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void sendText(String text) {
        mConnectManager.sendText(text);
    }

    @Override
    public void reconnect() {
        mConnectManager.reconnect();
    }

    /**
     * 服务绑定成功时的回调，可以在此初始化数据
     */
    @Override
    public void onServiceBindSuccess() {

    }

    /**
     * WebSocket 连接成功事件
     */
    @Override
    public void onConnected() {

    }

    /**
     * WebSocket 连接出错事件
     *
     * @param cause 出错原因
     */
    @Override
    public void onConnectError(Throwable cause) {

    }

    /**
     * WebSocket 连接断开事件
     */
    @Override
    public void onDisconnected() {

    }

    @Override
    public void onDestroy() {
        mConnectManager.onDestroy();
        super.onDestroy();
    }
}
