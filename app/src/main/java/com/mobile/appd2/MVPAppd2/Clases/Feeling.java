package com.mobile.appd2.MVPAppd2.Clases;

import com.mobile.appd2.MVPAppd2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by david on 4/2/16.
 */
public class Feeling {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    private String name;
    private int photoId;

    public Feeling(String name, int photoId) {
        this.name = name;
        this.photoId = photoId;
    }

}