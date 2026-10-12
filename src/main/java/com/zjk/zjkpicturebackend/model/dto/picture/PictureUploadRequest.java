package com.zjk.zjkpicturebackend.model.dto.picture;

import lombok.Data;
import java.io.Serializable;

@Data
public class PictureUploadRequest implements Serializable {

    /**
     * 图片 id（用于修改）
     */
    private Long id;

    /**
     * 图片名称（可选，用户自定义；URL 上传时无原始文件名）
     */
    private String picName;

    /**
     * 文件地址
     */
    private String FileUrl;

    private static final long serialVersionUID = 1L;
}
