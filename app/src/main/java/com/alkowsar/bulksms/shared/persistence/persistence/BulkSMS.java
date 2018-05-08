package com.alkowsar.bulksms.shared.persistence.persistence;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.alkowsar.bulksms.shared.persistence._model.Staff;
import com.alkowsar.bulksms.shared.persistence._model.StaffDao;
import com.alkowsar.bulksms.shared.persistence._model.Student;
import com.alkowsar.bulksms.shared.persistence._model.StudentDao;
import com.alkowsar.bulksms.shared.persistence._model.Word;
import com.alkowsar.bulksms.shared.persistence._model.WordDao;

/* Created By Adnan Ayoub*/

@Database(entities = {Word.class},version = 1)
public abstract class BulkSMS extends RoomDatabase {
    private static BulkSMS INSTANCE;

    public abstract  WordDao wordDao();

    public static BulkSMS getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BulkSMS.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BulkSMS.class, "BulkSmsDB")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback() {

                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final WordDao mDao;

        PopulateDbAsync(BulkSMS db) {
            mDao = db.wordDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            mDao.deleteAll();
            Word word = new Word("Hello");
            mDao.insert(word);
            word = new Word("World");
            mDao.insert(word);
            return null;
        }
    }
}
