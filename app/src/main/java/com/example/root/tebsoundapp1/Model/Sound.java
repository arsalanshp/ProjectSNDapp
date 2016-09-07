package com.example.root.tebsoundapp1.Model;

/**
 * Created by root on 9/6/16.
 */
public class Sound {

    private int id;
    private String name;
    private String category_name;
    private int size;
    private int download;
    private String sound_img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }

    public String getSound_img() {
        return sound_img;
    }

    public void setSound_img(String sound_img) {
        this.sound_img = sound_img;
    }
}
