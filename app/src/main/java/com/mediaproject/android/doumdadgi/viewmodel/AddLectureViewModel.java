package com.mediaproject.android.doumdadgi.viewmodel;

import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mediaproject.android.doumdadgi.R;
import com.mediaproject.android.doumdadgi.model.ClassInfo;
import com.mediaproject.android.doumdadgi.view.adapter.LectureListAdapter;
import com.mediaproject.android.doumdadgi.view.adapter.TimeTableListAdapter;

import java.util.ArrayList;

public class AddLectureViewModel {
    private View view;
    private FragmentManager fragmentManager;
    private Dialog dialog;

    private SQLiteDatabase ajou_db;
    private ArrayList<ClassInfo> list;
    private LectureListAdapter adapter;
    private TimeTableListAdapter timeTableListAdapter;

    private ImageButton btn_add_lecture_close;
    private ImageButton btn_lecture_search;
    private EditText editText_lecture_name;
    private Spinner spinner_condition_type;
    private Spinner spinner_condition_major;
    private RecyclerView recyclerView;

    private String searched_string;
    private String lecture_type;
    private String major;

    public AddLectureViewModel(View view, FragmentManager fragmentManager, Dialog dialog,
                               TimeTableListAdapter timeTableListAdapter) {
        this.view = view;
        this.fragmentManager = fragmentManager;
        this.dialog = dialog;
        this.timeTableListAdapter = timeTableListAdapter;

        ajou_db = view.getContext().openOrCreateDatabase("AjouTimetable.db",
                view.getContext().MODE_PRIVATE, null);
        ajou_db.execSQL("CREATE TABLE IF NOT EXISTS AjouTimetable(faculty TEXT, major TEXT, lecture_name TEXT,"+
                "lecture_name_eng TEXT, lecture_id TEXT, lecture_type TEXT, credit INTEGER, time INTEGER,"+
                "professor TEXT, schedule TEXT, classroom TEXT);");
        initView();
    }

    private void initView() {
        btn_add_lecture_close = view.findViewById(R.id.btn_add_lecture_close);
        btn_add_lecture_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        editText_lecture_name = view.findViewById(R.id.editText_lecture_name);

        btn_lecture_search = view.findViewById(R.id.btn_lecture_search);
        btn_lecture_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list = new ArrayList<>();
                searched_string = editText_lecture_name.getText().toString();
                lecture_type = spinner_condition_type.getSelectedItem().toString();
                major = spinner_condition_major.getSelectedItem().toString();

                if (lecture_type.equals("전체")) {
                    ajou_db.execSQL("CREATE VIEW IF NOT EXISTS FILTERING_TYPE AS SELECT * FROM AjouTimetable");
                } else {
                    ajou_db.execSQL("CREATE VIEW IF NOT EXISTS FILTERING_TYPE AS SELECT * FROM AjouTimetable " +
                            "WHERE lecture_type = '"+lecture_type+"'");
                }

                if (major.equals("전체")) {
                    ajou_db.execSQL("CREATE VIEW IF NOT EXISTS FILTERING_MAJOR AS SELECT * FROM FILTERING_TYPE");
                } else {
                    ajou_db.execSQL("CREATE VIEW IF NOT EXISTS FILTERING_MAJOR AS SELECT * FROM FILTERING_TYPE " +
                            "WHERE major = '"+major+"'");
                }

                if (searched_string.length() <= 0) {
                    ajou_db.execSQL("CREATE VIEW IF NOT EXISTS SEARCH_KEYWORD AS SELECT * FROM FILTERING_MAJOR");
                } else {
                    ajou_db.execSQL("CREATE VIEW IF NOT EXISTS SEARCH_KEYWORD AS SELECT * FROM FILTERING_MAJOR " +
                            "WHERE lecture_name LIKE '%"+searched_string+"%'");
                }

                System.out.println("TAG: searched_string: " + searched_string +", major: "+major);

                Cursor cursor = ajou_db.rawQuery("SELECT * FROM SEARCH_KEYWORD", null);
                if ((cursor != null) && (cursor.getCount() > 0)) {
                    while (cursor.moveToNext()) {
                        ClassInfo classInfo = new ClassInfo();
                        classInfo.setLectureName(cursor.getString(cursor.getColumnIndex("lecture_name")));
                        classInfo.setProfessor(cursor.getString(cursor.getColumnIndex("professor")));
                        classInfo.setSchedule(cursor.getString(cursor.getColumnIndex("schedule")));
                        list.add(classInfo);
                        System.out.println("lecture name:"+classInfo.getLectureName());
                    }
                }

                System.out.println("list.size() == "+list.size());

                cursor.close();
                ajou_db.execSQL("DROP VIEW SEARCH_KEYWORD");
                ajou_db.execSQL("DROP VIEW FILTERING_MAJOR");
                ajou_db.execSQL("DROP VIEW FILTERING_TYPE");

                updateRecyclerView();
            }
        });

        spinner_condition_type = view.findViewById(R.id.spinner_condition_type);
        ArrayAdapter typeAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.lecture_types,
                android.R.layout.simple_spinner_dropdown_item);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_condition_type.setAdapter(typeAdapter);

        spinner_condition_major = view.findViewById(R.id.spinner_condition_major);
        ArrayAdapter majorAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.majors,
                android.R.layout.simple_spinner_dropdown_item);
        majorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_condition_major.setAdapter(majorAdapter);

        recyclerView = view.findViewById(R.id.list_lectures);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

    private void updateRecyclerView() {
        adapter = new LectureListAdapter(list, timeTableListAdapter);
        recyclerView.setAdapter(adapter);
    }
}
