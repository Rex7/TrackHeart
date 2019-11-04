package com.example.regischarles.fitheart.fragment;

public class AppModel {
    private int imageView;
    private String name,size;

    public AppModel(int imageView, String name, String size) {
        this.imageView = imageView;
        this.name = name;
        this.size = size;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
