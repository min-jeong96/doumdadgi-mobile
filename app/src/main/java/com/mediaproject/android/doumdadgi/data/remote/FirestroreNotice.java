package com.mediaproject.android.doumdadgi.data.remote;

import com.google.firebase.firestore.FirebaseFirestore;
import com.mediaproject.android.doumdadgi.model.Notice;

import java.util.ArrayList;

public class FirestroreNotice {
    private FirebaseFirestore database;
    private ArrayList<Notice> notices;

    public FirestroreNotice() {
        database = FirebaseFirestore.getInstance();
        notices = new ArrayList<>();
    }

}
