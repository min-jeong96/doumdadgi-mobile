package com.mediaproject.android.doumdadgi.model;

public class Notice {
    private String title;
    private String description;
    private String department;
    private String date_and_time;

    public Notice() {}
    public Notice(String title, String description, String department, String date_and_time) {
        this.title = title;
        this.description = description;
        this.department = department;
        this.date_and_time = date_and_time;
    }

    public Notice getNotice() { return this; }
    public String getTitle() { return this.title; }
    public String getDescription () { return this.description; }
    public String getDepartment () { return this.department; }
    public String getDateAndTime() { return this.date_and_time; }
}
