package com.mediaproject.android.doumdadgi.viewmodel;

import android.view.View;
import android.widget.ImageButton;

import androidx.fragment.app.FragmentManager;

import com.mediaproject.android.doumdadgi.model.AttendanceAccessModel;
import com.mediaproject.android.doumdadgi.R;

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
