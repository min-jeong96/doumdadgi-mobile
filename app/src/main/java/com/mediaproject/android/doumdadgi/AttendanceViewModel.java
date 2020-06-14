package com.mediaproject.android.doumdadgi;

import android.view.View;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class AttendanceViewModel {
    private View view;
    private FragmentManager fragmentManager;
    private AttendanceModel attendanceModel;

    private FrameLayout btn_access_attendance;
    private FrameLayout btn_attendance_list;

    AttendanceViewModel(View view, FragmentManager fragmentManager) {
        this.view = view;
        this.fragmentManager = fragmentManager;
        this.attendanceModel = new AttendanceModel();
        initView(view);
    }

    private void initView(View view) {
        btn_access_attendance = view.findViewById(R.id.btn_access_attendance);
        btn_access_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AttendanceAccessDialogFragment dialogFragment = new AttendanceAccessDialogFragment();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                transaction.add(android.R.id.content, dialogFragment).addToBackStack(null).commit();
            }
        });

        btn_attendance_list = view.findViewById(R.id.btn_attendance_list);
    }
}
