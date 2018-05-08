package com.alkowsar.bulksms.view;

import com.alkowsar.bulksms.shared.persistence._model.Staff;
import com.alkowsar.bulksms.shared.persistence._model.Student;

import java.util.List;

public interface SmsView{
    void onLoadStaff(List<Staff> staff);
    void onLoadStudent(List<Student>students);
}
