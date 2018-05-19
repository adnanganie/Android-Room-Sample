package com.alkowsar.bulksms.shared.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.alkowsar.bulksms.student.model.Student;
import com.alkowsar.bulksms.student.model.StudentDao;

/* Created By Adnan Ayoub*/

@Database(entities = {Student.class},version = 1)
public abstract class BulkSmsDB extends RoomDatabase {
    private static BulkSmsDB INSTANCE;

    public abstract StudentDao studentDao();

    public static BulkSmsDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BulkSmsDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BulkSmsDB.class, "BulkSmsDB")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
