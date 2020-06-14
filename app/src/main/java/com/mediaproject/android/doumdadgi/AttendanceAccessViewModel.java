package com.mediaproject.android.doumdadgi;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class AttendanceAccessViewModel {
    private View view;
    private FragmentManager fragmentManager;
    private AttendanceAccessModel attendanceAccessModel;

    private ImageButton btn_close_access_dialog;

    public AttendanceAccessViewModel(View view, FragmentManager fragmentManager) {
        this.view = view;
        this.fragmentManager = fragmentManager;
        this.attendanceAccessModel = new AttendanceAccessModel();
        initView(view);
    }

    private void initView(View view) {
        btn_close_access_dialog = view.findViewById(R.id.btn_close_access_dialog);
        btn_close_access_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.popBackStack();
            }
        });
    }

}
