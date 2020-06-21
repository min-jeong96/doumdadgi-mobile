package com.mediaproject.android.doumdadgi.viewmodel;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mediaproject.android.doumdadgi.R;
import com.mediaproject.android.doumdadgi.model.NoticeModel;
import com.mediaproject.android.doumdadgi.model.RequestModel;
import com.mediaproject.android.doumdadgi.view.adapter.NoticeListAdapter;
import com.mediaproject.android.doumdadgi.view.adapter.RequestListAdapter;

public class NoticeViewModel {
    private View view;
    private NoticeModel noticeModel;
    private RequestModel requestModel;

    private View divider_menu_notice;
    private View divider_partner_matching;
    private TextView text_menu_notice;
    private TextView text_menu_partner_matching;
    private RecyclerView recyclerView;

    public NoticeViewModel(View view) {
        this.view = view;
        this.noticeModel = new NoticeModel();
        this.requestModel = new RequestModel();
        initView();
    }

    private void initView() {
        // default: notice fragment
        recyclerView = view.findViewById(R.id.list_notice);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        NoticeListAdapter adapter = new NoticeListAdapter((noticeModel.getNotices()));
        recyclerView.setAdapter(adapter);

        final int clicked_color = view.getContext().getResources().getColor(R.color.colorPrimary, null);
        final int not_clicked_color = view.getContext().getResources().getColor(R.color.colorSecondaryText, null);
        text_menu_notice = view.findViewById(R.id.text_menu_notice);
        text_menu_partner_matching = view.findViewById(R.id.text_menu_partner_matching);
        divider_menu_notice = view.findViewById(R.id.divider_menu_notice);
        divider_partner_matching = view.findViewById(R.id.divider_menu_partner_matching);

        text_menu_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoticeListAdapter adapter = new NoticeListAdapter(noticeModel.getNotices());
                recyclerView.setAdapter(adapter);

                text_menu_notice.setTypeface(null, Typeface.BOLD);
                text_menu_notice.setTextColor(clicked_color);
                text_menu_partner_matching.setTypeface(null, Typeface.NORMAL);
                text_menu_partner_matching.setTextColor(not_clicked_color);
                divider_menu_notice.setVisibility(View.VISIBLE);
                divider_partner_matching.setVisibility(View.INVISIBLE);
            }
        });

        text_menu_partner_matching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestListAdapter adapter = new RequestListAdapter(requestModel.getRequests());
                recyclerView.setAdapter(adapter);

                text_menu_partner_matching.setTypeface(null, Typeface.BOLD);
                text_menu_partner_matching.setTextColor(clicked_color);
                text_menu_notice.setTypeface(null, Typeface.NORMAL);
                text_menu_notice.setTextColor(not_clicked_color);
                divider_partner_matching.setVisibility(View.VISIBLE);
                divider_menu_notice.setVisibility(View.INVISIBLE);
            }
        });
    }
}
