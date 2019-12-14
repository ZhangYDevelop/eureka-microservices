package com.zy.uaa.exception.auth;


import com.zy.uaa.constant.CommonConstants;
import com.zy.uaa.exception.BaseException;

/**
 * Created by ace on 2017/9/8.
 */
public class UserTokenException extends BaseException {
    public UserTokenException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_CODE);
    }
}
