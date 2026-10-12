package com.zjk.zjkpicturebackend.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求
 */
@Data
public class UserRegisterRequest implements Serializable {//继承序列化

    private static final long serialVersionUID = -7714527929221914704L;//无所谓，防止序列化字段被修改

    private String userAccount;

    private String userPassword;

    private String checkPassword;


}
