package com.mvp.common.bean;

import com.mvp.common.base.bean.BaseBean;

import lombok.Getter;
import lombok.Setter;

/**
 * Describe：水平选项卡Title
 */
@Getter
@Setter
public class HorizontalTabTitle<T> extends BaseBean {
    private String title;
    private T data;

    public HorizontalTabTitle(String title) {
        this.title = title;
    }

    public HorizontalTabTitle(String title, T data) {
        this.title = title;
        this.data = data;
    }

}
