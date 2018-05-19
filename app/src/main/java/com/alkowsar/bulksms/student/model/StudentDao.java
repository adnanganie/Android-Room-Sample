package com.alkowsar.bulksms.student.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void add(Student student);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addAll(List<Student> students);
}
