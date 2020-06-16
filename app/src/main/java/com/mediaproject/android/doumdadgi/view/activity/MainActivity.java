package com.mediaproject.android.doumdadgi.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mediaproject.android.doumdadgi.R;
import com.mediaproject.android.doumdadgi.view.fragment.AttendanceFragment;
import com.mediaproject.android.doumdadgi.view.fragment.NoticeFragment;
import com.mediaproject.android.doumdadgi.view.fragment.TimeTableFragment;
import com.mediaproject.android.doumdadgi.view.fragment.UserInfoFragment;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private TimeTableFragment timeTableFragment   = new TimeTableFragment();
    private AttendanceFragment attendanceFragment  = new AttendanceFragment();
    private NoticeFragment noticeFragment      = new NoticeFragment();
    private UserInfoFragment userInfoFragment    = new UserInfoFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.frame_layout, timeTableFragment).commitAllowingStateLoss();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.timetable:
                        transaction.replace(R.id.frame_layout, timeTableFragment).commitAllowingStateLoss();
                        break;
                    case R.id.attendance:
                        transaction.replace(R.id.frame_layout, attendanceFragment).commitAllowingStateLoss();
                        break;
                    case R.id.notice:
                        transaction.replace(R.id.frame_layout, noticeFragment).commitAllowingStateLoss();
                        break;
                    case R.id.user_info:
                        transaction.replace(R.id.frame_layout, userInfoFragment).commitAllowingStateLoss();
                        break;
                }
                return true;
            }
        });

    }
}
