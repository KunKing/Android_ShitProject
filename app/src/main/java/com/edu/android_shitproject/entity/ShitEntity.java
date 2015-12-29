package com.edu.android_shitproject.entity;

/**
 * Created by Ming on 2015/12/28.
 */
public class ShitEntity {

    private String id;
    private String title;
    private String type;

    public ShitEntity() {
    }

    public ShitEntity(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ShitEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
