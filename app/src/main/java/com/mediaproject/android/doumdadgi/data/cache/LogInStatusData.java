package com.mediaproject.android.doumdadgi.data.cache;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Arrays;
import java.util.List;

public class LogInStatusData {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    private static final String PREFERENCES_NAME = "LOGIN_STATUS_PREFERENCES";
    private static final String IS_STAYING_LOGGED_IN = "STAY_LOGGED_IN";
    private static final String IS_EMAIL_ADDRESS_SAVED = "SAVED_EMAIL_ADDRESS";
    private static final String IS_PASSWORD_SAVED = "SAVED_PASSWORD";
    private Boolean stay_logged_in;
    private String saved_email_address;
    private String saved_password;

    public LogInStatusData(Context context) {
        this.context = context;
        getSharedPreferences();
    }

    private void getSharedPreferences() {
        this.sharedPreferences = context.getSharedPreferences(PREFERENCES_NAME, context.MODE_PRIVATE);
        stay_logged_in = sharedPreferences.getBoolean(IS_STAYING_LOGGED_IN, false);
        saved_email_address = sharedPreferences.getString(IS_EMAIL_ADDRESS_SAVED, "");
        saved_password = sharedPreferences.getString(IS_PASSWORD_SAVED, "");
    }

    public boolean isStayingLoggedIn() {
        return stay_logged_in;
    }

    public List<String> getEmailAddressAndPassword() {
        return Arrays.asList(saved_email_address, saved_password);
    }

    public void setLogInnStatus(String address, String password) {
        this.editor = this.sharedPreferences.edit();
        editor.putBoolean(IS_STAYING_LOGGED_IN, true);
        editor.putString(IS_EMAIL_ADDRESS_SAVED, address);
        editor.putString(IS_PASSWORD_SAVED, password);
        editor.commit();
    }
}
