package com.example.travel.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.travel.Adapter.TrendsAdapter;
import com.example.travel.Domain.TrendSDomain;
import com.example.travel.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterTrendsList;
    private RecyclerView recyclerViewTrends;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerView();
        BottomNavigation();
    }

    private void BottomNavigation() {
        LinearLayout profileBtn = findViewById(R.id.profileBtn);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
            }
        });
    }

    private void initRecyclerView() {
        ArrayList<TrendSDomain> items=new ArrayList<>();
        items.add(new TrendSDomain("Future in AI, what will\n"+
                "tomorrow be like?","The National","trends"));
        items.add(new TrendSDomain("Important points in\n" +
                "concluding a work contact","Reuters","trends2"));
        items.add(new TrendSDomain("Future in A, what will\n"+
                "tomorrow be like?","The National","trends"));

        recyclerViewTrends = findViewById(R.id.view1);
        recyclerViewTrends.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterTrendsList = new TrendsAdapter(items);
        recyclerViewTrends.setAdapter(adapterTrendsList);
    }
}