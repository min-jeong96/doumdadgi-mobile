package com.mediaproject.android.doumdadgi.data.cache;

import android.content.Context;
import android.content.SharedPreferences;

import com.mediaproject.android.doumdadgi.model.UserProfile;

public class UserProfileData {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    private static final String PREFERENCES_NAME = "USER_PROFILE_DATA";
    private static final String USER_NAME   = "USER_NAME";
    private static final String SEX         = "SEX";
    private static final String DORMITORY   = "IS_IN_DORMITORY";
    private static final String SCHOOL_ID   = "SCHOOL_ID";
    private static final String MAJOR       = "MAJOR";
    private static final String PHONE       = "PHONE_NUMBER";
    private static final String EMAIL       = "EMAIL";
    private UserProfile userProfile;

    public UserProfileData (Context context) {
        this.context = context;
        this.userProfile = new UserProfile();
        getSharedPreferences();
    }

    private void getSharedPreferences() {
        this.sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, context.MODE_PRIVATE);
        this.userProfile.setUserName(sharedPreferences.getString(USER_NAME, ""));
        this.userProfile.setSex(sharedPreferences.getString(SEX, "FEMALE"));
        this.userProfile.setIsInDormitory(sharedPreferences.getBoolean(DORMITORY, false));
        this.userProfile.setSchoolId(sharedPreferences.getString(SCHOOL_ID, ""));
        this.userProfile.setMajor(sharedPreferences.getString(MAJOR, ""));
        this.userProfile.setPhoneNumber(sharedPreferences.getString(PHONE, ""));
        this.userProfile.setEmail(sharedPreferences.getString(EMAIL, ""));
    }

    public UserProfile getUserProfile() {
        return this.userProfile;
    }

    public void setSharedPreferences(UserProfile user) {
        this.userProfile = user;
        this.editor = this.sharedPreferences.edit();
        this.editor.putString(USER_NAME, userProfile.getUserName());
        this.editor.putString(SEX, userProfile.getSex());
        this.editor.putBoolean(DORMITORY, userProfile.getIsInDormitory());
        this.editor.putString(SCHOOL_ID, userProfile.getSchoolID());
        this.editor.putString(MAJOR, userProfile.getMajor());
        this.editor.putString(PHONE, userProfile.getPhoneNumber());
        this.editor.putString(EMAIL, userProfile.getEmail());
        this.editor.apply();

        getSharedPreferences();
    }
}
