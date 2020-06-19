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
    private static final String SCHOOL_ID   = "SCHOOL_ID";
    private static final String MAJOR       = "MAJOR";
    private static final String PHONE       = "PHONE_NUMBER";
    private UserProfile userProfile;

    public UserProfileData (Context context) {
        this.context = context;
        getSharedPreferences();
    }

    private void getSharedPreferences() {
        this.sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        this.userProfile.setUserName(sharedPreferences.getString(USER_NAME, ""));
        this.userProfile.setSchoolId(sharedPreferences.getString(SCHOOL_ID, ""));
        this.userProfile.setMajor(sharedPreferences.getString(MAJOR, ""));
        this.userProfile.setPhoneNumber(sharedPreferences.getString(PHONE, ""));
    }

    public void setSharedPreferences(UserProfile user) {
        this.userProfile = user;
        this.editor = this.sharedPreferences.edit();
        this.editor.putString(USER_NAME, userProfile.getUserName());
        this.editor.putString(SCHOOL_ID, userProfile.getSchoolID());
        this.editor.putString(MAJOR, userProfile.getMajor());
        this.editor.putString(PHONE, userProfile.getPhoneNumber());
        this.editor.apply();
    }
}
