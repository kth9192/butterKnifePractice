package com.example.butterknifeexam;


/**
 * Created by kth919 on 2017-03-07.
 */

public class PictureInfo  {

    private String title;
    private String desc;
    private String image;

    public PictureInfo(String title, String desc, String image) {
        this.title = title;
        this.desc = desc;
        this.image = image;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
