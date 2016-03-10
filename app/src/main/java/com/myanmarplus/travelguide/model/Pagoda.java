package com.myanmarplus.travelguide.model;

import java.io.Serializable;

/**
 * Created by winthanhtike on 12/29/15.
 */
public class Pagoda implements Serializable{

    private int imageId;

    private String pagodaDesc;

    private String pagodaName;

    private int detailPhoto;

    public int getDetailPhoto() {
        return detailPhoto;
    }

    public void setDetailPhoto(int detailPhoto) {
        this.detailPhoto = detailPhoto;
    }

    public String getPagodaName() {
        return pagodaName;
    }

    public void setPagodaName(String pagodaName) {
        this.pagodaName = pagodaName;
    }

    public String getPagodaDesc() {
        return pagodaDesc;
    }

    public void setPagodaDesc(String pagodaDesc) {
        this.pagodaDesc = pagodaDesc;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

}
