package com.mediaproject.android.doumdadgi.view.fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.mediaproject.android.doumdadgi.R;
import com.mediaproject.android.doumdadgi.viewmodel.TimeTableViewModel;

public class TimeTableFragment extends Fragment {
    private TimeTableViewModel timeTableViewModel;
    private SQLiteDatabase database;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_timetable, container, false);

        FragmentManager fragmentManager = getFragmentManager();
        timeTableViewModel = new TimeTableViewModel(view, fragmentManager);

        return view;
    }
}
