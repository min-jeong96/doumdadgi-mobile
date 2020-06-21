package com.mediaproject.android.doumdadgi.data.remote;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mediaproject.android.doumdadgi.model.UserProfile;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class FirestoreUserDetail {
    private FirebaseFirestore db;
    private String email_id;
    private UserProfile userProfile;

    public FirestoreUserDetail() {
        db = FirebaseFirestore.getInstance();
        userProfile = new UserProfile();
    }

    public void setUserDetail(String email, UserProfile user) {
        this.email_id = email.substring(0, email.indexOf('@'));
        this.userProfile = user;
    }

    public void updateUserDetail() {
        db.collection("users").document(email_id)
                .set(userProfile)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "UserDetail successfully written.");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error writing UserDetail Document", e);
                    }
                });
    }

    public void getUserDetail() {
        db.collection("users").document(email_id)
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                userProfile = documentSnapshot.toObject(UserProfile.class);
            }
        });
    }
}
