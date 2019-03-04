package com.shop.pyg.vo;

import java.io.Serializable;

/**
 * @Auther: 陈远明
 * @Date: 2019/1/23 16 : 32
 * @Description:
 */
public class ResultVO implements Serializable {


    private static final long serialVersionUID = 6068810864942549826L;

    private int flag;
    private String message;

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
