package com.devcoder.mvvmexample2.models;

import android.graphics.drawable.Drawable;

public class DataModel {

    private String androidVersion, androidName, imageUrl;
    private Drawable imageUrlInt;

    public DataModel(String androidName, String androidVersion, String imageUrl, Drawable imageUrlInt) {

        this.androidName = androidName;
        this.androidVersion = androidVersion;
        this.imageUrl = imageUrl;
        this.imageUrlInt = imageUrlInt;
    }

    public String getAndroidVersion() {
        return androidVersion;
    }

    public void setAndroidVersion(String androidVersion) {
        this.androidVersion = androidVersion;
    }

    public String getAndroidName() {
        return androidName;
    }

    public void setAndroidName(String androidName) {
        this.androidName = androidName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

//    @BindingAdapter({"bind:imageUrl"})
//    public static void loadImage(ImageView view, String url) {
//        Picasso.get().load(url).into(view);
//    }

//    @BindingAdapter({"bind:imageUrl"})
//    public static void loadImage(ImageView view, int url) {
//        view.setImageResource(url);
//    }

    public Drawable getImageUrlInt() {
        return imageUrlInt;
    }

    public void setImageUrlInt(Drawable imageUrlInt) {
        this.imageUrlInt = imageUrlInt;
    }
}