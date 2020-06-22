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

    public String getTitle() { return this.title; }
    public String getDescription () { return this.description; }
    public String getDepartment () { return this.department; }
    public String getDateAndTime() { return this.date_and_time; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setDepartment(String department) { this.department = department; }
    public void setDateAndTime(String date_and_time) { this.date_and_time = date_and_time; }
}
