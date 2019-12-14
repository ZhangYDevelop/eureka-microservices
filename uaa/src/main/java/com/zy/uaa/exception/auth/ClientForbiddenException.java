package com.zy.uaa.exception.auth;


import com.zy.uaa.constant.CommonConstants;
import com.zy.uaa.exception.BaseException;

/**
 * Created by ace on 2017/9/12.
 */
public class ClientForbiddenException extends BaseException {
    public ClientForbiddenException(String message) {
        super(message, CommonConstants.EX_CLIENT_FORBIDDEN_CODE);
    }

}
