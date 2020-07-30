package com.example.miniproject;

import com.google.firebase.database.Exclude;

public class Upload {
    private String mName;
    private Float mPrice;
    private String mImageUrl;
    private String mKey;
    public Upload() {
        //empty constructor needed
    }
    public Upload(String name,Float price ,String imageUrl) {
        if (name.trim().equals("")) {
            name = "No Name";
        }

        mName = name;
        mPrice= price;
        mImageUrl = imageUrl;
    }
    public String getName() {
        return mName;
    }
    public void setName(String name) {
        mName = name;
    }
    public Float getPrice() {
        return mPrice;
    }
    public void setPrice(Float price) {
        mPrice = price;
    }
    public String getImageUrl() {
        return mImageUrl;
    }
    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }
    @Exclude
    public String getKey() {
        return mKey;
    }
    @Exclude
    public void setKey(String key) {
        mKey = key;
    }
}