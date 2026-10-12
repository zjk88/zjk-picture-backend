package com.zjk.zjkpicturebackend.controller;

import com.zjk.zjkpicturebackend.common.BaseResponse;
import com.zjk.zjkpicturebackend.common.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    /**
     * 健康检查
     * @return
     */
    @GetMapping("/health")
    public BaseResponse<String> health() {
        return ResultUtils.success("ok");
    }
}