package com.mediaproject.android.doumdadgi.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mediaproject.android.doumdadgi.R;
import com.mediaproject.android.doumdadgi.viewmodel.TimeTableViewModel;

public class TimeTableFragment extends Fragment {
    private TimeTableViewModel timeTableViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_timetable, container, false);

        timeTableViewModel = new TimeTableViewModel(view);

        return view;
    }
}
