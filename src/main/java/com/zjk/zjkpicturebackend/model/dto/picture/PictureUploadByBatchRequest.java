package com.zjk.zjkpicturebackend.model.dto.picture;

import lombok.Data;

/**
 * 批量导入图片请求
 */
@Data

public class PictureUploadByBatchRequest {

    /**
     * 搜索词
     */
    private String searchText;

    /**
     * 抓取数量,默认10条
     */
    private Integer count = 10;

    /**
     * 名称前缀
     */
    private String namePrefix;

    /**
     * 图片名称
     */
    private String picName;

}
