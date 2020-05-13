package com.ex.user.bean;

/**
 * Author:  Jerry
 * Date:    2018/10/9
 * Version   v1.0
 * Desc:   默认的消息响应事件包装类,只包含文本，不包含数据实体
 */
@SuppressWarnings("all")
public class TextResponse implements Response<String> {
    private String responseText;

    public TextResponse(String responseText) {
        this.responseText = responseText;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getResponseEntity() {
        return null;
    }

    public void setResponseEntity(String responseEntity) {
    }
}
