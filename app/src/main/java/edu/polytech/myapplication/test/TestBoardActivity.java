package edu.polytech.myapplication.test;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.polytech.myapplication.R;
import edu.polytech.myapplication.domain.MainTarae;

public class TestBoardActivity extends AppCompatActivity {

    private ArrayList<MainTarae> maintaraeList;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_board);


        recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        maintaraeList = new ArrayList<MainTarae>();


//        for (int i = 0; i < 10; i++) {
//            MainTarae mt = new MainTarae();
//
//            mt.setTitle(String.valueOf(i));
//            mt.setContent(String.valueOf(i));
//            mt.setDate(String.valueOf(i));
//            mt.setLikeCOunt(i);
//            mt.setViewCount(i);
//            maintaraeList.add(mt);
//        }

        mAdapter = new MainTaraeAdapter(maintaraeList);
        recyclerView.setAdapter(mAdapter);
    }
}
