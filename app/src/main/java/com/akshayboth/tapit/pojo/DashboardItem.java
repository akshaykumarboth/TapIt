package com.akshayboth.tapit.pojo;

import java.io.Serializable;

/**
 * Created by akshayboth on 18/03/18.
 */

public class DashboardItem implements Serializable{

    private String title;
    private String imageURL;
    private int resId;


    public DashboardItem(String title, String imageURL) {
        this.title = title;
        this.imageURL = imageURL;
    }

    public DashboardItem(String title, int resId) {
        this.title = title;
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
