package com.alkowsar.bulksms.bulksms;

import android.os.Bundle;
import com.alkowsar.bulksms.R;
import com.alkowsar.bulksms.shared.base.BaseActivity;
import com.alkowsar.bulksms.shared.database.BulkSmsDB;

public class MainActivity extends BaseActivity {

    //public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();
    }

    @Override
    public int getLayout() {
        return (R.layout.activity_main);
    }

    void init(){
        BulkSmsDB.getDatabase(this).studentDao();
    }

    /*public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            //Word word = new Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY));
            //mWordViewModel.insert(word);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }*/
}
