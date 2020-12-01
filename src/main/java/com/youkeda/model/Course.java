package com.youkeda.model;

public class Course {

    private String id;

    private String name;

    private int sections;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSections(int sections) {
        this.sections = sections;
    }

    public int getSections() {
        return this.sections;
    }

}