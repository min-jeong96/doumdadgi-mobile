package com.mediaproject.android.doumdadgi.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mediaproject.android.doumdadgi.R;
import com.mediaproject.android.doumdadgi.model.Notice;

import java.util.ArrayList;

public class NoticeListAdapter extends RecyclerView.Adapter<NoticeListAdapter.ViewHolder> {
    public ArrayList<Notice> notices;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text_notice_title;
        private TextView text_notice_description;
        private TextView text_notice_department;
        private TextView text_notice_date_and_time;

        public ViewHolder(View itemView) {
            super(itemView);
            text_notice_title = itemView.findViewById(R.id.text_notice_title);
            text_notice_description = itemView.findViewById(R.id.text_notice_description);
            text_notice_department = itemView.findViewById(R.id.text_notice_department);
            text_notice_date_and_time = itemView.findViewById(R.id.text_notice_date_and_time);
        }
    }

    public NoticeListAdapter(ArrayList<Notice> list) { this.notices = list; }

    @NonNull
    @Override
    public NoticeListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_notice, parent, false);

        final ViewHolder vh = new NoticeListAdapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text_notice_title.setText(notices.get(position).getTitle());
        holder.text_notice_description.setText(notices.get(position).getDescription());
        holder.text_notice_department.setText(notices.get(position).getDepartment());
        holder.text_notice_date_and_time.setText(notices.get(position).getDateAndTime());
    }

    @Override
    public int getItemCount() {
        if (notices == null)
            return 0;
        else
            return notices.size();
    }
}
