package com.mediaproject.android.doumdadgi.viewmodel;

import android.app.Dialog;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.mediaproject.android.doumdadgi.model.AttendanceStartTimer;
import com.mediaproject.android.doumdadgi.model.SecondsClock;
import com.mediaproject.android.doumdadgi.model.AttendanceAccessModel;
import com.mediaproject.android.doumdadgi.R;

public class AttendanceAccessViewModel {
    private View view;
    private FragmentManager fragmentManager;
    private Dialog dialog;

    private SecondsClock clock;
    private AttendanceStartTimer startTimer;
    private Handler handler;
    private AttendanceAccessModel attendanceAccessModel;

    private TextView text_current_time;
    private TextView text_access_start_time;
    private ImageButton btn_close_access_dialog;
    private FrameLayout btn_access_start;

    public AttendanceAccessViewModel(View view, FragmentManager fragmentManager,
                                     Dialog dialog) {
        this.view = view;
        this.fragmentManager = fragmentManager;
        this.dialog= dialog;

        this.handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                UpdateClock();
                UpdateStartTimer();
            }
        };
        this.clock = new SecondsClock(handler);
        this.startTimer = new AttendanceStartTimer(3, handler);

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

        btn_access_start = view.findViewById(R.id.btn_access_start);
        btn_access_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int accent_color = view.getContext().getResources().getColor(R.color.colorAccent, null);
                text_access_start_time.setTextColor(accent_color);
                Thread t = new Thread(startTimer);
                t.start();
            }
        });

        text_current_time = view.findViewById(R.id.text_current_time);
        text_access_start_time = view.findViewById(R.id.text_access_start_time);

        Thread t = new Thread(clock);
        t.start();
    }

    private void UpdateClock() {
        text_current_time.setText(clock.getStrTime());
    }

    private void UpdateStartTimer() {
        text_access_start_time.setText(startTimer.getStrTime());
    }
}
