package com.alkowsar.bulksms.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.TextView;

import com.alkowsar.bulksms.R;
import com.alkowsar.bulksms.bulksms.MainActivity;
import com.alkowsar.bulksms.shared.base.BaseActivity;
import com.alkowsar.bulksms.student.StudentsActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class DashboardActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getLayout() {
        return (R.layout.activity_dashboard);
    }
    @OnClick(R.id.textView) void OnClick(){
        Intent intent = new Intent(this, StudentsActivity.class);
        startActivity(intent);
    }
}
