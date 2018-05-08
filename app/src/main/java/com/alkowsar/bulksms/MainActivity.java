package com.alkowsar.bulksms;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.alkowsar.bulksms.adapter.WordListAdapter;
import com.alkowsar.bulksms.shared.persistence._model.Word;
import com.alkowsar.bulksms.shared.persistence._model.WordViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity { //implements OnStudentDetailsClickListiner{

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private WordViewModel mWordViewModel;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        init();
    }

    void init() {


        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        fab = findViewById(R.id.fabBttn);
        final WordListAdapter adapter = new WordListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewWordActivity.class);
                startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);
            }
        });
        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable final List<Word> words) {
                // Update the cached copy of the words in the adapter.
                adapter.setWords(words);
            }
        });
        // BulkSmsDB.getInstance(this);
       /* smsAdapter = new SmsAdapter(this,getStudentsDetails());
        recyclerView.setAdapter(smsAdapter);
        smsAdapter.notifyDataSetChanged();*/
    }/*
    private ArrayList<Student> getStudentsDetails(){
        ArrayList<Student> list = new ArrayList<>();

        for (int index = 0; index < 10; index++){
            Student student = new Student(index ,"Student" +index ,"lastName","10th - "+index);
            list.add(index,student);
        }
        return list;
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getApplicationContext(),"You clicked at position  "+position,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }*/

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Word word = new Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY));
            mWordViewModel.insert(word);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }
}
