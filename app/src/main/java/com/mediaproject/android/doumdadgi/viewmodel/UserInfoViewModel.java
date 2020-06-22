package com.mediaproject.android.doumdadgi.viewmodel;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.mediaproject.android.doumdadgi.R;
import com.mediaproject.android.doumdadgi.data.cache.LogInStatusData;
import com.mediaproject.android.doumdadgi.data.cache.UserProfileData;
import com.mediaproject.android.doumdadgi.model.UserProfile;

public class UserInfoViewModel {
    private View view;
    private LogInStatusData logInStatusData;
    private UserProfileData userProfileData;
    private UserProfile userProfile;

    private TextView text_user_name;
    private TextView text_user_school_id;
    private TextView text_user_email;
    private Spinner spinner_major;
    private RadioButton radio_btn_sex_male;
    private RadioButton radio_btn_sex_female;
    private RadioButton radio_btn_in_dorm;
    private RadioButton radio_btn_not_in_dorm;
    private EditText editText_user_phone_number;
    private Switch switch_auto_login;
    private LinearLayout btns_edit;
    private Button btn_user_edit;
    private Button btn_user_edit_cancel;
    private Button btn_user_edit_complete;
    private Button btn_log_out;

    public UserInfoViewModel(View view) {
        this.view = view;
        this.logInStatusData = new LogInStatusData(view.getContext());
        this.userProfileData = new UserProfileData(view.getContext());
        this.userProfile = userProfileData.getUserProfile();

        initView();
    }

    private void initView() {
        text_user_name = view.findViewById(R.id.text_user_name);
        text_user_school_id = view.findViewById(R.id.text_user_school_id);
        text_user_email = view.findViewById(R.id.text_user_email);

        spinner_major = view.findViewById(R.id.spinner_major);
        ArrayAdapter majorAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.majors,
                android.R.layout.simple_spinner_dropdown_item);
        spinner_major.setAdapter(majorAdapter);
        spinner_major.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                userProfile.setMajor(spinner_major.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        radio_btn_sex_male = view.findViewById(R.id.radio_btn_sex_male);
        radio_btn_sex_female = view.findViewById(R.id.radio_btn_sex_female);

        radio_btn_sex_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userProfile.setSex("MALE");
            }
        });
        radio_btn_sex_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userProfile.setSex("FEMALE");
            }
        });

        radio_btn_in_dorm = view.findViewById(R.id.radio_btn_in_dorm);
        radio_btn_not_in_dorm = view.findViewById(R.id.radio_btn_not_in_dorm);

        radio_btn_in_dorm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userProfile.setIsInDormitory(true);
            }
        });
        radio_btn_not_in_dorm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userProfile.setIsInDormitory(false);
            }
        });

        editText_user_phone_number = view.findViewById(R.id.editText_user_phone_number);
        editText_user_phone_number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                userProfile.setPhoneNumber(editText_user_phone_number.getText().toString());
            }
        });

        switch_auto_login = view.findViewById(R.id.switch_auto_login);
        switch_auto_login.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                logInStatusData.setLogInStatus(switch_auto_login.isChecked());
            }
        });

        btns_edit = view.findViewById(R.id.btns_edit);
        btn_user_edit = view.findViewById(R.id.btn_user_edit);

        btn_user_edit_cancel = view.findViewById(R.id.btn_user_edit_cancel);
        btn_user_edit_complete = view.findViewById(R.id.btn_user_edit_complete);
        btn_log_out = view.findViewById(R.id.btn_log_out);

        setUpUI();
        notEditableUserInfo();

        btn_user_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editableUserInfo();
            }
        });

        btn_user_edit_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notEditableUserInfo();

                userProfile = userProfileData.getUserProfile();
                setUpUI();
            }
        });

        btn_user_edit_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText_user_phone_number.getText().toString().equals(""))
                    Toast.makeText(v.getContext(), R.string.toast_msg_empty_phone_number, Toast.LENGTH_SHORT).show();
                else {
                    notEditableUserInfo();
                    userProfileData.setSharedPreferences(userProfile);
                    Toast.makeText(v.getContext(), "수정되었습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // log-in fragment 실행
            }
        });
    }

    private void setUpUI() {
        text_user_name.setText(userProfile.getUserName());
        text_user_school_id.setText(userProfile.getSchoolID());
        text_user_email.setText(userProfile.getEmail());

        if (userProfile.getSex().equals("MALE")) {
            radio_btn_sex_male.setChecked(true);
        } else { // userProfile.getSex().equals("FEMALE")
            radio_btn_sex_female.setChecked(true);
        }

        if (userProfile.getIsInDormitory()) {
            radio_btn_in_dorm.setChecked(true);
        } else {
            radio_btn_not_in_dorm.setChecked(true);
        }

        editText_user_phone_number.setText(userProfile.getPhoneNumber());
        switch_auto_login.setChecked(logInStatusData.isStayingLoggedIn());
    }

    private void notEditableUserInfo() {
        spinner_major.setEnabled(false);

        radio_btn_sex_male.setClickable(false);
        radio_btn_sex_female.setClickable(false);
        radio_btn_in_dorm.setClickable(false);
        radio_btn_not_in_dorm.setClickable(false);

        editText_user_phone_number.setFocusableInTouchMode(false);
        switch_auto_login.setClickable(false);
        btns_edit.setVisibility(View.GONE);
        btn_user_edit.setVisibility(View.VISIBLE);
    }

    private void editableUserInfo() {
        spinner_major.setEnabled(true);

        radio_btn_sex_male.setClickable(true);
        radio_btn_sex_female.setClickable(true);
        radio_btn_in_dorm.setClickable(true);
        radio_btn_not_in_dorm.setClickable(true);

        editText_user_phone_number.setFocusableInTouchMode(true);
        switch_auto_login.setClickable(true);
        btns_edit.setVisibility(View.VISIBLE);
        btn_user_edit.setVisibility(View.GONE);
    }
}
