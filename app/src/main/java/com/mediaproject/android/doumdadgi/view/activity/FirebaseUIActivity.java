package com.mediaproject.android.doumdadgi.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mediaproject.android.doumdadgi.R;

import java.util.regex.Pattern;

public class FirebaseUIActivity extends AppCompatActivity {
    // 비밀번호 정규식
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9!@.#$%^&*?_~]{8,16}$");

    // 파이어베이스 인증 객체 생성
    private FirebaseAuth firebaseAuth;

    // 이메일과 비밀번호
    private EditText editTextEmail;
    private EditText editTextPassword;

    private Button btn_log_in;
    private TextView text_sign_up;

    private String email = "";
    private String password = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_ui);

        // 파이어베이스 인증 객체 선언
        firebaseAuth = FirebaseAuth.getInstance();

        editTextEmail = findViewById(R.id.text_eamil_id);
        editTextPassword = findViewById(R.id.text_password);

        btn_log_in = findViewById(R.id.btn_log_in);
        btn_log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        text_sign_up = findViewById(R.id.text_sign_up);
        text_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                singUp();
            }
        });
    }

    public void singUp() {
        email = editTextEmail.getText().toString();
        password = editTextPassword.getText().toString();

        if(isValidEmail() && isValidPasswd()) {
            createUser(email, password);
        }
    }

    public void signIn() {
        email = editTextEmail.getText().toString() + "@ajou.ac.kr";
        password = editTextPassword.getText().toString();

        if(isValidEmail() && isValidPasswd()) {
            loginUser(email, password);
        }
    }

    // 이메일 유효성 검사
    private boolean isValidEmail() {
        if (email.isEmpty()) {
            // 이메일 공백
            Toast.makeText(FirebaseUIActivity.this, R.string.toast_msg_empty_email_id,
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            // 이메일 형식 불일치
            return false;
        } else {
            return true;
        }
    }

    // 비밀번호 유효성 검사
    private boolean isValidPasswd() {
        if (password.isEmpty()) {
            // 비밀번호 공백
            Toast.makeText(FirebaseUIActivity.this, R.string.toast_msg_empty_password,
                    Toast.LENGTH_SHORT).show();
            return false;
        } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
            // 비밀번호 형식 불일치
            return false;
        } else {
            return true;
        }
    }

    // 회원가입
    private void createUser(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 회원가입 성공
                            Toast.makeText(FirebaseUIActivity.this, R.string.success_signup, Toast.LENGTH_SHORT).show();
                        } else {
                            // 회원가입 실패
                            Toast.makeText(FirebaseUIActivity.this, R.string.failed_signup, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    // 로그인
    private void loginUser(String email, String password)
    {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 로그인 성공
                            startMainActivity();
                        } else {
                            // 로그인 실패
                            Toast.makeText(FirebaseUIActivity.this, R.string.failed_login, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
