package com.hqm.simplefortinklabscodetest.model.bean;

import com.google.gson.annotations.SerializedName;

/**
 * 数据模型
 */
public class ItemBean {
    private String id;
    private String type; //数据类型：1-富文本；2-单张图片
    private String title;
    private String description;

    @SerializedName("img_url")
    private String imgUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
