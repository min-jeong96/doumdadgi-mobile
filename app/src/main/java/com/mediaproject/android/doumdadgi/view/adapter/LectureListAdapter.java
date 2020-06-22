package com.mediaproject.android.doumdadgi.view.adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mediaproject.android.doumdadgi.R;
import com.mediaproject.android.doumdadgi.model.ClassInfo;

import java.util.ArrayList;

public class LectureListAdapter extends RecyclerView.Adapter<LectureListAdapter.ViewHolder> {
    private ArrayList<ClassInfo> lectures;
    private TimeTableListAdapter adapter;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text_item_lecture_title;
        private TextView text_item_professor;
        private TextView text_item_schedule;
        private Button btn_add_selected_lecture;

        public ViewHolder(final View itemView) {
            super(itemView);
            text_item_lecture_title = itemView.findViewById(R.id.text_item_lecture_title);
            text_item_professor = itemView.findViewById(R.id.text_item_professor);
            text_item_schedule = itemView.findViewById(R.id.text_item_schedule);
            btn_add_selected_lecture = itemView.findViewById(R.id.btn_add_selected_lecture);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (btn_add_selected_lecture.getVisibility() == View.GONE) {
                        btn_add_selected_lecture.setVisibility(View.VISIBLE);
                    } else {
                        btn_add_selected_lecture.setVisibility(View.GONE);
                    }
                }
            });

            btn_add_selected_lecture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SQLiteDatabase my_db = v.getContext().openOrCreateDatabase("MyLocal.db",
                            v.getContext().MODE_PRIVATE, null);
                    my_db.execSQL("INSERT INTO myLectures (lecture_name, professor, schedule) "+
                                    "VALUES ('"+text_item_lecture_title.getText().toString()+"'," +
                            "'"+text_item_professor.getText().toString()+"','"+text_item_schedule.getText().toString()+"')");

                    Toast.makeText(v.getContext(),"시간표에 추가했습니다", Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                }
            });
        }
    }

    public LectureListAdapter(ArrayList<ClassInfo> list, TimeTableListAdapter adapter) {
        this.lectures = list;
        this.adapter = adapter;
    }

    @NonNull
    @Override
    public LectureListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_lecture, parent, false);

        ViewHolder vh = new LectureListAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text_item_lecture_title.setText(lectures.get(position).getLectureName());
        holder.text_item_professor.setText(lectures.get(position).getProfessor());
        holder.text_item_schedule.setText(lectures.get(position).getSchedule());
    }

    @Override
    public int getItemCount() {
        if (lectures == null)
            return 0;
        else
            return lectures.size();
    }
}
