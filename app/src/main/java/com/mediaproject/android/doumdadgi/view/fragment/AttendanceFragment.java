package com.mediaproject.android.doumdadgi.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.mediaproject.android.doumdadgi.viewmodel.AttendanceViewModel;
import com.mediaproject.android.doumdadgi.R;

public class AttendanceFragment extends Fragment {
    private AttendanceViewModel attendanceViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_attendance, container, false);

        FragmentManager fragmentManager = getFragmentManager();
        attendanceViewModel = new AttendanceViewModel(view, fragmentManager);

        return view;
    }
}
