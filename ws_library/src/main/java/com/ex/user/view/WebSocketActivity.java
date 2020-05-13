package com.ex.user.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ex.user.manager.WebSocketServiceConnectManager;
import com.ex.user.service.IWebSocketPage;

/**
 * Author:  Jerry
 * Date:    2018/10/9
 * Version   v1.0
 * Desc:   已经绑定了 WebSocketService 服务的 Activity，
 */
@SuppressWarnings("all")
public abstract class WebSocketActivity extends AppCompatActivity implements IWebSocketPage {
    protected final String LOGTAG = this.getClass().getSimpleName();

    private WebSocketServiceConnectManager mConnectManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mConnectManager = new WebSocketServiceConnectManager(this, this);
        mConnectManager.onCreate();
        setContentView(setLayoutId());
        initUI();
        initData();
    }

    //设置资源文件
    protected abstract int setLayoutId();

    //初始化UI
    protected abstract void initUI();

    //初始化数据
    protected abstract void initData();

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
    protected void onDestroy() {
        mConnectManager.onDestroy();
        super.onDestroy();
    }
}
