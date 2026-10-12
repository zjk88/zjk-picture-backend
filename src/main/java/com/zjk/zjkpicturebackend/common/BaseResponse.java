package com.zjk.zjkpicturebackend.common;

import com.zjk.zjkpicturebackend.exception.ErrorCode;
import lombok.Data;
import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {

    private int code;

    private T data;

    private String message;

    public BaseResponse(int code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

//    重载
    public BaseResponse(int code, T data) {
        this(code, data, "");//简化
    }

    //    重载
    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), null, errorCode.getMessage());
    }
}
