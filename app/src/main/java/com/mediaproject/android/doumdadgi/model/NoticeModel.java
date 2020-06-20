package com.mediaproject.android.doumdadgi.model;

import java.util.ArrayList;

public class NoticeModel {
    // dummy data for test MVVM...
    private ArrayList<Notice> notices;

    public NoticeModel() {
        notices = new ArrayList<>();
    }

    public ArrayList<Notice> getNotices() {
        for (int i = 0; i < 10; i++) {
            String tmp = String.format("TEXT %d", i);
            notices.add(new Notice(tmp, tmp, tmp, tmp));
        }
        return notices;
    }
}
