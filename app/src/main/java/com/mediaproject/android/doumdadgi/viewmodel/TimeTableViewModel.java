package com.mediaproject.android.doumdadgi.viewmodel;

import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mediaproject.android.doumdadgi.R;
import com.mediaproject.android.doumdadgi.view.adapter.TimeTableListAdapter;
import com.mediaproject.android.doumdadgi.model.TimeTableModel;

public class TimeTableViewModel {
    private View view;
    private TimeTableModel timeTableModel;

    private ImageButton btn_add_lecture;
    private ImageButton btn_clear_table;
    private RecyclerView recyclerView;

    public TimeTableViewModel(View view) {
        this.view = view;
        this.timeTableModel = new TimeTableModel();
        initView(view);
    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.list_timetable);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        TimeTableListAdapter adapter = new TimeTableListAdapter(timeTableModel.getTimeTableList());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        btn_add_lecture = view.findViewById(R.id.btn_add_lecture);
        btn_add_lecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "수업 추가 버튼을 눌렀습니다", Toast.LENGTH_SHORT).show();
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
