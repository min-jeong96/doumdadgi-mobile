package com.mediaproject.android.doumdadgi.model;

public class UserProfile {
    private String user_name;
    private String sex;
    private boolean isInDormitory;
    private String school_id;
    private String major;
    private String phone_number;
    private String email;

    public UserProfile() {
        this.user_name = "";
        this.sex = "FEMALE";
        this.isInDormitory = false;
        this.school_id = "";
        this.major = "";
        this.phone_number = "";
        this.email = "";
    }

    public UserProfile(String name, String sex, boolean dorm, String id, String major, String phone_number, String email) {
        this.user_name = name;
        this.sex = sex;
        this.isInDormitory = dorm;
        this.school_id = id;
        this.major = major;
        this.phone_number = phone_number;
        this.email = email;
    }

    public String getUserName() { return user_name; }
    public String getSex() { return sex; }
    public boolean getIsInDormitory() { return isInDormitory; }
    public String getSchoolID() { return school_id; }
    public String getMajor() { return major; }
    public String getPhoneNumber() { return phone_number; }
    public String getEmail() { return email; }

    public void setUserName(String name) {
        this.user_name = name;
    }
    public void setSex(String sex) { this.sex = sex; }
    public void setIsInDormitory(boolean dorm) { this.isInDormitory = dorm; }
    public void setSchoolId(String id) {
        this.school_id = id;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }
    public void setEmail(String email) { this.email = email; }
}
