package com.mediaproject.android.doumdadgi.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mediaproject.android.doumdadgi.R;
import com.mediaproject.android.doumdadgi.viewmodel.NoticeViewModel;

public class NoticeFragment extends Fragment {
    private NoticeViewModel noticeViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_notice, container, false);

        noticeViewModel = new NoticeViewModel(view);

        return view;
    }
}
