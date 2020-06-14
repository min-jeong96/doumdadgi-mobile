package com.mediaproject.android.doumdadgi;

import java.util.ArrayList;

public class TimeTableModel {
    // dummy data for test MVVM...
    ArrayList<TimeTableListItemViewModel> list = new ArrayList<>();

    public ArrayList<TimeTableListItemViewModel> getTimeTableList() {
        for (int i = 0; i < 10; i++) {
            String tmp = String.format("TEXT %d", i);
            list.add(new TimeTableListItemViewModel(tmp, tmp, tmp, tmp));
        }

        return list;
    }
}
