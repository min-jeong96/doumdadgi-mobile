package com.mediaproject.android.doumdadgi.model;

import android.os.Handler;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SecondsClock implements Runnable {
    private Calendar calendar;
    private Handler handler;
    private SimpleDateFormat sdf;
    private String str_time;

    public SecondsClock(Handler handler) {
        this.calendar = Calendar.getInstance();
        this.handler = handler;
        this.sdf = new SimpleDateFormat("HH:mm:ss");
    }

    @Override
    public void run() {
        while (true) {
            calendar = Calendar.getInstance();
            str_time = sdf.format(calendar.getTime());
            handler.sendEmptyMessage(0);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getStrTime() {
        return str_time;
    }
}
