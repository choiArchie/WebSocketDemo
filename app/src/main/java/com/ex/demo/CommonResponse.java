package com.ex.demo;

import com.ex.user.bean.Response;

/**
 * Author:  Jerry
 * Date:    2018/10/9
 * Version   v1.0
 * Desc:
 */
@SuppressWarnings("all")
public class CommonResponse implements Response<CommonResponseEntity> {
    private String responseText;
    private CommonResponseEntity responseEntity;

    public CommonResponse(String responseText, CommonResponseEntity responseEntity) {
        this.responseText = responseText;
        this.responseEntity = responseEntity;
    }

    @Override
    public String getResponseText() {
        return responseText;
    }

    @Override
    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    @Override
    public CommonResponseEntity getResponseEntity() {
        return this.responseEntity;
    }

    @Override
    public void setResponseEntity(CommonResponseEntity responseEntity) {
        this.responseEntity = responseEntity;
    }
}
