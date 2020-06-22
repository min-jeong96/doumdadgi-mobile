package com.mediaproject.android.doumdadgi.model;

import android.os.Handler;

import java.sql.Time;

public class AttendanceStartTimer implements Runnable {
    private int time;
    private String str_time;
    private Handler handler;

    public AttendanceStartTimer(int seconds, Handler handler) {
        this.time = seconds * 60;
        this.handler = handler;
        this.str_time = "활동 시작";
    }

    @Override
    public void run() {
        while(time > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            time -= 1;
            str_time = String.format("%2d:%2d", time/60, time%60);
            handler.sendEmptyMessage(0);
        }
    }

    public String getStrTime() {
        return str_time;
    }
}
