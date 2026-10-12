package com.zjk.zjkpicturebackend.manager.upload;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.zjk.zjkpicturebackend.exception.ErrorCode;
import com.zjk.zjkpicturebackend.exception.ThrowUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class UrlPictureUpload extends PictureUploadTemplate {

    @Override
    protected void validPicture(Object inputSource) {
        String fileUrl = (String) inputSource;
        //1.校验非空
        ThrowUtils.throwIf(StrUtil.isBlank(fileUrl), ErrorCode.PARAMS_ERROR, "文件地址不能为空");
        // 2. 校验 URL 格式
        try {
            new URL(fileUrl);
        } catch (MalformedURLException e) {
            ThrowUtils.throwIf(true, ErrorCode.PARAMS_ERROR, "URL格式错误");
        }

        // 3. 校验 URL 的协议
        ThrowUtils.throwIf(!fileUrl.startsWith("http://") && !fileUrl.startsWith("https://"),
                ErrorCode.PARAMS_ERROR, "仅支持 HTTP 或 HTTPS 协议的文件地址");

        // 4. 发送 HEAD 请求验证文件是否存在
        HttpResponse httpResponse = null;
        try {
            httpResponse = HttpUtil.createRequest(cn.hutool.http.Method.HEAD, fileUrl)
                    .timeout(5000)
                    .execute();
            ThrowUtils.throwIf(!httpResponse.isOk(), ErrorCode.PARAMS_ERROR, "远程文件不存在");
        } finally {
            // 记得释放资源
            if (httpResponse != null) {
                httpResponse.close();
            }
        }
    }

    @Override
    protected String getOriginFilename(Object inputSource) {
        String fileUrl = (String) inputSource;
        // 从 URL 中提取文件名
        return FileUtil.mainName(fileUrl);
    }

    @Override
    protected void processFile(Object inputSource, File file) throws Exception {
        String fileUrl = (String) inputSource;
        // 下载文件到临时目录
        HttpUtil.downloadFile(fileUrl, file);
    }
}
