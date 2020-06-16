package com.mediaproject.android.doumdadgi.view;

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
import com.mediaproject.android.doumdadgi.viewmodel.AttendanceAccessViewModel;

public class AttendanceAccessDialogFragment extends DialogFragment {
    private AttendanceAccessViewModel attendanceAccessViewModel;
    private Dialog dialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.dialog_attendance_access, container, false);

        FragmentManager fragmentManager = getFragmentManager();
        attendanceAccessViewModel = new AttendanceAccessViewModel(view, fragmentManager);
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog =  super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }
}
