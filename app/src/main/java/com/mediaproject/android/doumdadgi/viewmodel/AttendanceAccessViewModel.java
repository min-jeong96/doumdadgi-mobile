package com.mediaproject.android.doumdadgi.viewmodel;

import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.mediaproject.android.doumdadgi.model.SecondsClock;
import com.mediaproject.android.doumdadgi.model.AttendanceAccessModel;
import com.mediaproject.android.doumdadgi.R;

public class AttendanceAccessViewModel {
    private View view;
    private FragmentManager fragmentManager;
    private Dialog dialog;

    private SecondsClock clock;
    private Handler handler;
    private AttendanceAccessModel attendanceAccessModel;

    private TextView text_current_time;
    private ImageButton btn_close_access_dialog;

    public AttendanceAccessViewModel(View view, FragmentManager fragmentManager,
                                     Dialog dialog) {
        this.view = view;
        this.fragmentManager = fragmentManager;
        this.dialog= dialog;

        this.handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                UpdateClock();
            }
        };
        this.clock = new SecondsClock(handler);

        this.attendanceAccessModel = new AttendanceAccessModel();
        initView();
    }

    private void initView() {
        btn_close_access_dialog = view.findViewById(R.id.btn_close_access_dialog);
        btn_close_access_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // fragmentManager.popBackStack();
                dialog.dismiss();
            }
        });

        text_current_time = view.findViewById(R.id.text_current_time);

        Thread t = new Thread(clock);
        t.start();
    }

    private void UpdateClock() {
        text_current_time.setText(clock.getStrTime());
    }
}
