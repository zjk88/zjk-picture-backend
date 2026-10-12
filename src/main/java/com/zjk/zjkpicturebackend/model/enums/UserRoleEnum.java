package com.zjk.zjkpicturebackend.model.enums;

import cn.hutool.core.util.ObjUtil;
import lombok.Getter;

/**
 * 用户角色菜单
 */
@Getter
public enum UserRoleEnum {

    //枚举对象
    USER("用户", "user"),
    ADMIN("管理员", "admin");

    // getter 方法（项目一般会补上，原截图没展示）
    private final String text;

    private final String value;

    UserRoleEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value 枚举值的value
     * @return 枚举值
     */
    public static UserRoleEnum getEnumByValue(String value) {
        if (ObjUtil.isEmpty(value)) {
            return null;
        }
        //顺序查找可以优化为map查找
        for (UserRoleEnum anEnum : UserRoleEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

}
