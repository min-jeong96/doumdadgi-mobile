package com.mediaproject.android.doumdadgi.viewmodel;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mediaproject.android.doumdadgi.R;
import com.mediaproject.android.doumdadgi.model.NoticeModel;
import com.mediaproject.android.doumdadgi.view.adapter.NoticeListAdapter;

public class NoticeViewModel {
    private View view;
    private NoticeModel noticeModel;

    private TextView text_menu_notice;
    private TextView text_menu_partner_matching;
    private RecyclerView recyclerView;

    public NoticeViewModel(View view) {
        this.view = view;
        this.noticeModel = new NoticeModel();
        initView(view);
    }

    private void initView(View view) {
        // default: notice fragment
        recyclerView = view.findViewById(R.id.list_notice);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

        NoticeListAdapter adapter = new NoticeListAdapter((noticeModel.getNotices()));
        recyclerView.setAdapter(adapter);

        final int clicked_color = view.getContext().getResources().getColor(R.color.colorPrimary, null);
        final int not_clicked_color = view.getContext().getResources().getColor(R.color.colorSecondaryText, null);
        text_menu_notice = view.findViewById(R.id.text_menu_notice);
        text_menu_notice.setTypeface(null, Typeface.BOLD);
        text_menu_notice.setTextColor(clicked_color);

        text_menu_partner_matching = view.findViewById(R.id.text_menu_partner_matching);
        text_menu_partner_matching.setTypeface(null, Typeface.NORMAL);
        text_menu_partner_matching.setTextColor(not_clicked_color);

        text_menu_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NoticeListAdapter adapter = new NoticeListAdapter(noticeModel.getNotices());
                recyclerView.setAdapter(adapter);

                text_menu_notice.setTypeface(null, Typeface.BOLD);
                text_menu_notice.setTextColor(clicked_color);
                text_menu_partner_matching.setTypeface(null, Typeface.NORMAL);
                text_menu_partner_matching.setTextColor(not_clicked_color);
            }
        });

        text_menu_partner_matching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                PartnerMatchingListAdapter adapter = new PartnerMatchingListAdapter(partnerModel.getPartners());
                recyclerView.setAdapter(adapter);
                */

                text_menu_partner_matching.setTypeface(null, Typeface.BOLD);
                text_menu_partner_matching.setTextColor(clicked_color);
                text_menu_notice.setTypeface(null, Typeface.NORMAL);
                text_menu_notice.setTextColor(not_clicked_color);
            }
        });
    }
}
