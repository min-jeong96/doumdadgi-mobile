package com.mediaproject.android.doumdadgi.viewmodel;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mediaproject.android.doumdadgi.R;
import com.mediaproject.android.doumdadgi.view.adapter.TimeTableListAdapter;
import com.mediaproject.android.doumdadgi.model.TimeTableModel;
import com.mediaproject.android.doumdadgi.view.fragment.AddLectureDialogFragment;

public class TimeTableViewModel {
    private View view;
    private FragmentManager fragmentManager;
    private TimeTableModel timeTableModel;

    private ImageButton btn_add_lecture;
    private ImageButton btn_clear_table;
    private RecyclerView recyclerView;

    private SQLiteDatabase my_db;

    public TimeTableViewModel(View view, FragmentManager fragmentManager) {
        this.view = view;
        this.fragmentManager = fragmentManager;
        this.timeTableModel = new TimeTableModel(view);

        my_db = view.getContext().openOrCreateDatabase("MyLocal.db",
                view.getContext().MODE_PRIVATE, null);

        initView();
    }

    private void initView() {
        recyclerView = view.findViewById(R.id.list_timetable);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        final TimeTableListAdapter adapter = new TimeTableListAdapter(timeTableModel.getTimeTableList());
        recyclerView.setAdapter(adapter);

        btn_add_lecture = view.findViewById(R.id.btn_add_lecture);
        btn_add_lecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(v.getContext(), "수업 추가 버튼을 눌렀습니다", Toast.LENGTH_SHORT).show();
                AddLectureDialogFragment dialogFragment = new AddLectureDialogFragment(adapter);
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                dialogFragment.show(transaction, "ADD LECTURE DIALOG");
                /*
                AttendanceAccessDialogFragment dialogFragment = new AttendanceAccessDialogFragment();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                dialogFragment.show(transaction, "ATTENDANCE ACCESS DIALOG");
                 */
            }
        });

        btn_clear_table = view.findViewById(R.id.btn_clear_table);
        btn_clear_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "전체 삭제 버튼을 눌렀습니다", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
