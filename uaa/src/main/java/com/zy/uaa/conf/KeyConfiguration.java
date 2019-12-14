package com.zy.uaa.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @author ace
 * @create 2017/12/17.
 */
@Configuration
public class KeyConfiguration {
    @Value("${jwt.rsa-secret}")
    private String userSecret;
    @Value("${client.rsa-secret}")
    private String serviceSecret;
    private byte[] userPubKey;
    private byte[] userPriKey;
    private byte[] servicePriKey;
    private byte[] servicePubKey;

    public String getUserSecret() {
        return userSecret;
    }

    public void setUserSecret(String userSecret) {
        this.userSecret = userSecret;
    }

    public String getServiceSecret() {
        return serviceSecret;
    }

    public void setServiceSecret(String serviceSecret) {
        this.serviceSecret = serviceSecret;
    }

    public byte[] getUserPubKey() {
        return userPubKey;
    }

    public void setUserPubKey(byte[] userPubKey) {
        this.userPubKey = userPubKey;
    }

    public byte[] getUserPriKey() {
        return userPriKey;
    }

    public void setUserPriKey(byte[] userPriKey) {
        this.userPriKey = userPriKey;
    }

    public byte[] getServicePriKey() {
        return servicePriKey;
    }

    public void setServicePriKey(byte[] servicePriKey) {
        this.servicePriKey = servicePriKey;
    }

    public byte[] getServicePubKey() {
        return servicePubKey;
    }

    public void setServicePubKey(byte[] servicePubKey) {
        this.servicePubKey = servicePubKey;
    }

    @Override
    public String toString() {
        return "KeyConfiguration{" +
                "userSecret='" + userSecret + '\'' +
                ", serviceSecret='" + serviceSecret + '\'' +
                ", userPubKey=" + Arrays.toString(userPubKey) +
                ", userPriKey=" + Arrays.toString(userPriKey) +
                ", servicePriKey=" + Arrays.toString(servicePriKey) +
                ", servicePubKey=" + Arrays.toString(servicePubKey) +
                '}';
    }
}
