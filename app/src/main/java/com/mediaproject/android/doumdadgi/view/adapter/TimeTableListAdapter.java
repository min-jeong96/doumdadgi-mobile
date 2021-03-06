package com.mediaproject.android.doumdadgi.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mediaproject.android.doumdadgi.R;
import com.mediaproject.android.doumdadgi.model.ClassInfo;

import java.util.ArrayList;

public class TimeTableListAdapter extends RecyclerView.Adapter<TimeTableListAdapter.ViewHolder> {
    private ArrayList<ClassInfo> mData;

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView lecture_name;
        TextView schedule;
        TextView professor;

        public ViewHolder(View itemView) {
            super(itemView);
            lecture_name = itemView.findViewById(R.id.text_lecture_name);
            schedule = itemView.findViewById(R.id.text_schedule);
            professor = itemView.findViewById(R.id.text_professor);
        }
    }

    public TimeTableListAdapter(ArrayList<ClassInfo> list) {
        this.mData = list;
    }

    @Override
    public TimeTableListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_timetable, parent, false);

        final ViewHolder vh = new TimeTableListAdapter.ViewHolder(view);
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), vh.getAdapterPosition() + "번째 수업을 클릭했습니다", Toast.LENGTH_SHORT).show();
            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.lecture_name.setText(mData.get(position).getLectureName());
        holder.schedule.setText(mData.get(position).getSchedule());
        holder.professor.setText(mData.get(position).getProfessor());
    }

    @Override
    public int getItemCount() {
        if (mData == null)
            return 0;
        else
            return mData.size();
    }
}
