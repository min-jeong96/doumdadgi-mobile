package com.mediaproject.android.doumdadgi.data.remote;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;
import java.util.regex.Pattern;

public class FirebaseAuthentication implements Executor {
    // 비밀번호 정규식
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9!@.#$%^&*?_~]{8,16}$");

    // 파이어베이스 인증 객체 생성
    private FirebaseAuth firebaseAuth;

    private String email = "";
    private String password = "";

    public FirebaseAuthentication() {
        // 파이어베이스 인증 객체 선언
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void setEmail (String string) {
        this.email = string;
    }

    public void setPassword(String string) {
        this.password = string;
    }

    // 이메일 유효성 검사
    public boolean isValidEmail() {
        // 이메일 형식 불일치
        return PASSWORD_PATTERN.matcher(email).matches();
    }

    // 비밀번호 유효성 검사
    public boolean isValidPasswd() {
        // 비밀번호 형식 불일치
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    // 회원가입
    public void createUser(String email, String password) {
        String full_email = email + "@ajou.ac.kr";
        firebaseAuth.createUserWithEmailAndPassword(full_email, password)
                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 회원가입 성공
                        } else {
                            // 회원가입 실패
                        }
                    }
                });
    }

    // 로그인
    public void loginUser(String email, String password)
    {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 로그인 성공
                        } else {
                            // 로그인 실패
                            System.out.println("TAG, Login Failure");
                        }
                    }
                });
    }

    @Override
    public void execute(Runnable command) {

    }
}
