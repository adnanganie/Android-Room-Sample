package com.alkowsar.bulksms.student.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Student")
public class Student {

    @PrimaryKey
    @ColumnInfo(name = "roll_no")
    int rollNo;
    @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "father_name")
    String fatherName;

    public Student(int rollNo, String name, String fatherName) {
        this.rollNo = rollNo;
        this.name = name;
        this.fatherName = fatherName;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
}
