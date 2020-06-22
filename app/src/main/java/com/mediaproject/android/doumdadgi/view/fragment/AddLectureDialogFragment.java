package com.mediaproject.android.doumdadgi.view.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.mediaproject.android.doumdadgi.R;
import com.mediaproject.android.doumdadgi.view.adapter.TimeTableListAdapter;
import com.mediaproject.android.doumdadgi.viewmodel.AddLectureViewModel;

public class AddLectureDialogFragment extends DialogFragment {
    private AddLectureViewModel viewModel;
    private TimeTableListAdapter adapter;
    private Dialog dialog;

    public AddLectureDialogFragment() {}
    public AddLectureDialogFragment(TimeTableListAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.ThemeOverlay_Material_Dark_ActionBar);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.dialog_add_lecture, container, false);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.ThemeOverlay_Material_Dark_ActionBar);

        FragmentManager fragmentManager = getFragmentManager();
        viewModel = new AddLectureViewModel(view, fragmentManager, dialog, adapter);

        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        dialog =  super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }

    @Override
    public void onStart() {
        getDialog().getWindow().setWindowAnimations(R.style.Animation_WindowSlideUpDown);
        super.onStart();
    }
}
