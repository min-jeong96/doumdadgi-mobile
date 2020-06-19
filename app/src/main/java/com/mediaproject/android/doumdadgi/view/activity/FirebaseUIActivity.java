package com.mediaproject.android.doumdadgi.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mediaproject.android.doumdadgi.R;
import com.mediaproject.android.doumdadgi.data.cache.LogInStatusData;
import com.mediaproject.android.doumdadgi.data.cache.UserProfileData;
import com.mediaproject.android.doumdadgi.data.remote.FirebaseAuthentication;
import com.mediaproject.android.doumdadgi.data.remote.FirebaseUserDetail;

public class FirebaseUIActivity extends AppCompatActivity {
    private FirebaseAuthentication auth;
    private FirebaseUserDetail user;

    // 이메일과 비밀번호
    private EditText editTextEmail;
    private EditText editTextPassword;

    private String email = "";
    private String password = "";

    // SharedPreferences data
    private LogInStatusData logInStatusData;
    private UserProfileData userProfileData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_ui);

        // SharedPreferences 객체 연결
        logInStatusData = new LogInStatusData(this);
        userProfileData = new UserProfileData(this);
        auth = new FirebaseAuthentication();
        user = new FirebaseUserDetail();

        editTextEmail = findViewById(R.id.text_eamil_id);
        editTextPassword = findViewById(R.id.text_password);

        Button btn_log_in = findViewById(R.id.btn_log_in);
        btn_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        TextView text_sign_up = findViewById(R.id.text_sign_up);
        text_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singUp();
            }
        });
    }

    public boolean singUp() {
        email = editTextEmail.getText().toString();
        password = editTextPassword.getText().toString();
        auth.setEmail(email);
        auth.setPassword(password);

        if (email.isEmpty()) {
            Toast.makeText(FirebaseUIActivity.this, R.string.toast_msg_empty_email_id,
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (auth.isValidEmail()) {
            Toast.makeText(FirebaseUIActivity.this, R.string.toast_msg_invalid_email_id,
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.isEmpty()) {
            Toast.makeText(FirebaseUIActivity.this, R.string.toast_msg_empty_password,
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (auth.isValidPasswd()) {
            Toast.makeText(FirebaseUIActivity.this, R.string.toast_msg_invalid_password,
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        auth.createUser(email, password);
        user.updateUserDetail();
        return true;
    }

    public boolean signIn() {
        email = editTextEmail.getText().toString() + "@ajou.ac.kr";
        password = editTextPassword.getText().toString();

        auth.setEmail(email);
        auth.setPassword(password);

        if (email.isEmpty()) {
            Toast.makeText(FirebaseUIActivity.this, R.string.toast_msg_empty_email_id,
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (auth.isValidEmail()) {
            Toast.makeText(FirebaseUIActivity.this, R.string.toast_msg_invalid_email_id,
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        if (password.isEmpty()) {
            Toast.makeText(FirebaseUIActivity.this, R.string.toast_msg_empty_password,
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (auth.isValidPasswd()) {
            Toast.makeText(FirebaseUIActivity.this, R.string.toast_msg_invalid_password,
                    Toast.LENGTH_SHORT).show();
            return false;
        }

        auth.loginUser(email, password);
        logInStatusData.setLogInnStatus(email, password);
        startMainActivity();
        return true;
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
