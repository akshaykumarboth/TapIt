package com.akshayboth.tapit.pojo;

import java.io.Serializable;

/**
 * Created by akshayboth on 18/03/18.
 */

public class ProfileFeatureItem implements Serializable {
    private String title;
    private String imgUrl;
    private int resId;

    public ProfileFeatureItem(String title, String imgUrl) {
        this.title = title;
        this.imgUrl = imgUrl;
    }

    public ProfileFeatureItem(String title, int resId) {
        this.title = title;
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
