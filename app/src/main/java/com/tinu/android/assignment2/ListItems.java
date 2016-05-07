package com.tinu.android.assignment2;

/**
 * Created by Tinu on 05-05-2016.
 */
public class ListItems {
    private int image;
    private String title;
    private String date_and_time;
    private String description;

   public ListItems(int image,String title,String date_and_time,String description){
       this.image = image;
       this.title = title;
       this.date_and_time = date_and_time;
       this.description = description;

    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_and_time() {
        return date_and_time;
    }

    public void setDate_and_time(String date_and_time) {
        this.date_and_time = date_and_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
