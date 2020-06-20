package com.mediaproject.android.doumdadgi.model;

import java.util.ArrayList;

public class TimeTableModel {
    // dummy data for test MVVM...
    ArrayList<ClassInfo> list = new ArrayList<>();

    public ArrayList<ClassInfo> getTimeTableList() {
        for (int i = 0; i < 10; i++) {
            String tmp = String.format("TEXT %d", i);
            list.add(new ClassInfo(tmp, tmp, tmp, tmp));
        }

        return list;
    }
}
