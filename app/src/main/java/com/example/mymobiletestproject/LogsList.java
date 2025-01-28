package com.example.mymobiletestproject;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import Adapters.LogAdapter;
import DbHelpers.DatabaseHelper;
import Models.LogItem;

/*
    This activity displays a page that views list of logs
*/

public class LogsList extends AppCompatActivity {
    private ArrayList<LogItem> logs;
    private RecyclerView logsList;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_logs_list);

        displayLogs();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.btn_back:
                        finish();
                        break;
                }

                return false;
            }
        });
    }

    // This method is called to display all logs from the database
    public void displayLogs() {
        DatabaseHelper databaseHelper = new DatabaseHelper(LogsList.this);

        logs = new ArrayList<>();

        logs = databaseHelper.getLogs();

        logsList = findViewById(R.id.logs_list);
        LogAdapter logAdapter = new LogAdapter(LogsList.this, logs);
        logsList.setAdapter(logAdapter);
        logsList.setLayoutManager(new LinearLayoutManager(LogsList.this));
    }
}