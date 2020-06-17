package com.mediaproject.android.doumdadgi.view.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mediaproject.android.doumdadgi.R;
import com.mediaproject.android.doumdadgi.data.cache.LogInStatusData;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LogInStatusData status = new LogInStatusData(this);

        if (status.isStayingLoggedIn()) {
            /* IS STAYING LOGGED IN */
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            /* NEED TO LOG IN */
            Intent intent = new Intent(this, FirebaseUIActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_up, R.anim.not_move);
            finish();
        }
    }
}
