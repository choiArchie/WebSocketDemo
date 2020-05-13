package com.ex.demo;

import android.view.View;

import com.alibaba.fastjson.JSONObject;
import com.blankj.utilcode.util.LogUtils;
import com.ex.user.bean.ErrorResponse;
import com.ex.user.bean.Response;
import com.ex.user.view.WebSocketActivity;


public class MainActivity extends WebSocketActivity {
    private static final String TAG = "MainActivity";


    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initUI() {
        findViewById(R.id.bt_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        JSONObject commed = new JSONObject();
        commed.put("tradePair", "ETH_BTC");
        commed.put("topic", "take_list_buy");
        commed.put("action", "refresh");
        sendText(commed.toJSONString());
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onMessageResponse(Response message) {
        LogUtils.dTag(TAG, "onMessageResponse" + message.toString());
    }

    @Override
    public void onSendMessageError(ErrorResponse error) {
        LogUtils.dTag(TAG, "onMessageResponse" + error.toString());
    }

}
