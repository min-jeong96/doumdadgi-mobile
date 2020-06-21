package com.mediaproject.android.doumdadgi.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mediaproject.android.doumdadgi.R;
import com.mediaproject.android.doumdadgi.model.Request;

import java.util.ArrayList;

public class RequestListAdapter extends RecyclerView.Adapter<RequestListAdapter.ViewHolder> {
    public ArrayList<Request> requests;

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text_request_title;
        private TextView text_request_professor;
        private TextView text_request_location;
        private TextView text_request_schedule;
        private Button btn_apply_request;

        public ViewHolder(View itemView) {
            super(itemView);
            text_request_title = itemView.findViewById(R.id.text_request_name);
            text_request_professor = itemView.findViewById(R.id.text_request_professor);
            text_request_location = itemView.findViewById(R.id.text_request_location);
            text_request_schedule = itemView.findViewById(R.id.text_reqeust_schedule);
            btn_apply_request = itemView.findViewById(R.id.btn_apply_request);
        }
    }

    public RequestListAdapter(ArrayList<Request> list) { this.requests = list; }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.item_request, parent, false);

        final ViewHolder vh = new RequestListAdapter.ViewHolder(view);
        vh.btn_apply_request.setVisibility(View.GONE);
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vh.btn_apply_request.getVisibility() == View.VISIBLE) {
                    vh.btn_apply_request.setVisibility(View.GONE);
                }
                else {
                    vh.btn_apply_request.setVisibility(View.VISIBLE);
                }
            }
        });

        final int after_applying_color = view.getContext().getResources().getColor(R.color.colorPrimaryText, null);
        vh.btn_apply_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vh.btn_apply_request.setClickable(false);
                vh.btn_apply_request.setBackgroundResource(R.drawable.btn_after_applying);
                vh.btn_apply_request.setTextColor(after_applying_color);
                vh.btn_apply_request.setText("지원하였습니다.");
            }
        });

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.text_request_title.setText(requests.get(position).getRequestTitle());
        holder.text_request_professor.setText(requests.get(position).getRequestProfessor());
        holder.text_request_location.setText(requests.get(position).getRequestLocation());
        holder.text_request_schedule.setText(requests.get(position).getRequesSchedule());
    }

    @Override
    public int getItemCount() {
        if (requests == null)
            return 0;
        else
            return requests.size();
    }
}
