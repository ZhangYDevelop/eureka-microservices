package com.zy.uaa.exception.auth;


import com.zy.uaa.constant.CommonConstants;
import com.zy.uaa.exception.BaseException;

/**
 * Created by ace on 2017/9/10.
 */
public class ClientTokenException extends BaseException {
    public ClientTokenException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}
