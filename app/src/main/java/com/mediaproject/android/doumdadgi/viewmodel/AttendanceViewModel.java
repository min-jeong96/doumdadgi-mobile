package com.mediaproject.android.doumdadgi.viewmodel;

import android.view.View;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.mediaproject.android.doumdadgi.view.fragment.AttendanceAccessDialogFragment;
import com.mediaproject.android.doumdadgi.model.AttendanceModel;
import com.mediaproject.android.doumdadgi.R;

public class AttendanceViewModel {
    private View view;
    private FragmentManager fragmentManager;
    private AttendanceModel attendanceModel;

    private FrameLayout btn_access_attendance;
    private FrameLayout btn_attendance_list;

    public AttendanceViewModel(View view, FragmentManager fragmentManager) {
        this.view = view;
        this.fragmentManager = fragmentManager;
        this.attendanceModel = new AttendanceModel();
        initView();
    }

    private void initView() {
        btn_access_attendance = view.findViewById(R.id.btn_access_attendance);
        btn_access_attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AttendanceAccessDialogFragment dialogFragment = new AttendanceAccessDialogFragment();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                dialogFragment.show(transaction, "ATTENDANCE ACCESS DIALOG");
                /*
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_down,
                        R.anim.slide_in_up, R.anim.slide_out_down);
                transaction.add(android.R.id.content, dialogFragment).addToBackStack(null).commit();
                */
            }
        });

        btn_attendance_list = view.findViewById(R.id.btn_attendance_list);
    }
}
