package com.mediaproject.android.doumdadgi.model;

import com.mediaproject.android.doumdadgi.data.remote.FirestoreNotice;

import java.util.ArrayList;

public class NoticeModel {
    // dummy data for test MVVM...
    private ArrayList<Notice> notices;
    private FirestoreNotice firestoreNotice;

    public NoticeModel() {
        firestoreNotice = new FirestoreNotice();
        notices = firestoreNotice.getNotices();
    }

    public ArrayList<Notice> getNotices() {
        System.out.println("NoticeModel --> notices.size() == "+notices.size());
        return notices;
    }
}
