package com.mediaproject.android.doumdadgi;

import android.media.Image;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TimeTableViewModel {
    private View view;
    private TimeTableModel timeTableModel;
    private TextView textView;

    private ImageButton btn_add_lecture;
    private ImageButton btn_clear_table;
    private RecyclerView recyclerView;

    public TimeTableViewModel(View view) {
        this.view = view;
        this.timeTableModel = new TimeTableModel();
        initView(view);
    }

    private void initView(View view) {
        textView = view.findViewById(R.id.btn_text);
        textView.setText("Non-Clicked");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(timeTableModel.getClickedText());
            }
        });

        ArrayList<TimeTableListItemViewModel> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String tmp = String.format("TEXT %d", i);
            list.add(new TimeTableListItemViewModel(tmp, tmp, tmp, tmp));
        }

        recyclerView = view.findViewById(R.id.list_timetable);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        TimeTableListAdapter adapter = new TimeTableListAdapter(list);
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
