package com.alkowsar.bulksms.student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alkowsar.bulksms.R;
import com.alkowsar.bulksms.shared.base.BaseActivity;
import com.alkowsar.bulksms.shared.database.BulkSmsDB;
import com.alkowsar.bulksms.student.model.Student;

import butterknife.BindView;
import butterknife.OnClick;

public class StudentsActivity extends BaseActivity {

    @BindView(R.id.etRollno)EditText etRollNo;
    @BindView(R.id.etName)EditText etName;
    @BindView(R.id.etFatherName)EditText etFatherName;
    Button button;
    Student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        button = findViewById(R.id.btnAdd);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rollNo = etRollNo.getText().toString();
                Toast.makeText(getApplicationContext(),"tesing  "+rollNo,Toast.LENGTH_SHORT).show();
                String name = etName.getText().toString();
                String fatherName = etFatherName.getText().toString();
                student = new Student(2,name,fatherName);
                BulkSmsDB.getDatabase(StudentsActivity.this).studentDao().add(student);
            }
        });
    }

    @Override
    public int getLayout() {
        return(R.layout.activity_students);
    }


}
