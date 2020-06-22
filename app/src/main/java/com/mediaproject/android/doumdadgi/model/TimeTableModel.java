package com.mediaproject.android.doumdadgi.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import java.util.ArrayList;

public class TimeTableModel {
    // dummy data for test MVVM...
    private View view;
    private ArrayList<ClassInfo> list;
    private SQLiteDatabase my_db;

    public TimeTableModel(View view) {
        this.view = view;
        list = new ArrayList<>();
        my_db = view.getContext().openOrCreateDatabase("MyLocal.db",
                view.getContext().MODE_PRIVATE, null);
        my_db.execSQL("CREATE TABLE IF NOT EXISTS myLectures(faculty TEXT, major TEXT, lecture_name TEXT,"+
                "lecture_name_eng TEXT, lecture_id TEXT, lecture_type TEXT, credit INTEGER, time INTEGER,"+
                "professor TEXT, schedule TEXT, classroom TEXT);");
    }

    public ArrayList<ClassInfo> getTimeTableList() {
        Cursor cursor = my_db.rawQuery("SELECT lecture_name, professor, schedule, classroom FROM myLectures", null);

        if ((cursor != null) && (cursor.getCount() > 0)) {
            while (cursor.moveToNext()) {
                ClassInfo classInfo = new ClassInfo();
                classInfo.setLectureName(cursor.getString(cursor.getColumnIndex("lecture_name")));
                classInfo.setClassroom(cursor.getString(cursor.getColumnIndex("classroom")));
                classInfo.setSchedule(cursor.getString(cursor.getColumnIndex("schedule")));
                classInfo.setProfessor(cursor.getString(cursor.getColumnIndex("professor")));
                list.add(classInfo);
            }
        }

        cursor.close();
        return this.list;
    }
}
