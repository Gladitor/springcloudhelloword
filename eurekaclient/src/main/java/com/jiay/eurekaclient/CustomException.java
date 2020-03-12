package com.jiay.eurekaclient;

/**
 * @author jiay
 * @date 2020-03-12
 */
public class CustomException extends Exception {

    public CustomException(int code,String errmsg){
        this.code = code;
        this.errmsg = errmsg;
    }

    /**代码*/
    private int code;
    /**错误信息*/
    private String errmsg;

    public int getCode(){
        return this.code;
    }

    public String getErrmsg(){
        return this.errmsg;
    }
}
