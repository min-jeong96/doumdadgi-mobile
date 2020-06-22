package com.mediaproject.android.doumdadgi.data.remote;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.mediaproject.android.doumdadgi.model.Notice;

import java.util.ArrayList;

public class FirestoreNotice {
    private FirebaseFirestore db;
    private ArrayList<Notice> notices;

    public FirestoreNotice() {
        db = FirebaseFirestore.getInstance();
        notices = new ArrayList<>();
        readNotices();
    }

    private void readNotices() {
        db.collection("notices").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Notice notice = new Notice();
                                notice.setDateAndTime(document.getId());
                                notice.setTitle(document.getData().get("title").toString());
                                notice.setDescription(document.getData().get("description").toString());
                                notice.setDepartment(document.getData().get("department").toString());
                                notices.add(0, notice);
                                System.out.println("TAG: notices.size(): " + notices.size());
                                System.out.println("TAG: notice.getTitle(): " + notice.getTitle());
                            }
                        }
                    }
                });
    }

    public ArrayList<Notice> getNotices() {
        return notices;
    }

}
