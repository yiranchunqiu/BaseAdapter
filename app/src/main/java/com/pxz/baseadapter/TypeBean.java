package com.pxz.baseadapter;

import java.io.Serializable;

/**
 * 类说明：实体类
 * 联系：530927342@qq.com
 *
 * @author peixianzhong
 * @date 2019/11/19 16:13
 */
public class TypeBean implements Serializable {
    private int type;
    private String string;

    public TypeBean(int type, String string) {
        this.type = type;
        this.string = string;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}