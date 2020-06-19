package com.mediaproject.android.doumdadgi.model;

public class UserProfile {
    private String user_name;
    private String school_id;
    private String major;
    private String phone_number;

    public UserProfile() {
        this.user_name = "";
        this.school_id = "";
        this.major = "";
        this.phone_number = "";
    }

    public UserProfile(String name, String id, String major, String phone_number) {
        this.user_name = name;
        this.school_id = id;
        this.major = major;
        this.phone_number = phone_number;
    }

    public String getUserName() { return user_name; }
    public String getSchoolID() { return school_id; }
    public String getMajor() { return major; }
    public String getPhoneNumber() { return phone_number; }

    public void setUserName(String name) {
        this.user_name = name;
    }

    public void setSchoolId(String id) {
        this.school_id = id;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }
}
