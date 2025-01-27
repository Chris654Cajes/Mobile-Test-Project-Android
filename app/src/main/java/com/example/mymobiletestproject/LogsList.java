package com.example.mymobiletestproject;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import Adapters.LogAdapter;
import DbHelpers.DatabaseHelper;
import Models.LogItem;

public class LogsList extends AppCompatActivity {
    private ArrayList<LogItem> logs;
    private RecyclerView logsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_logs_list);

        displayLogs();
    }

    // This method is called to display all logs from the database
    public void displayLogs() {
        DatabaseHelper databaseHelper = new DatabaseHelper(LogsList.this);

        logs = new ArrayList<>();

        try {

            // Call the database helper to fetch all logs saved from the app database
            logs = databaseHelper.getLogs();
        } catch (Exception e) {
            e.printStackTrace();
        }


        logsList = findViewById(R.id.logs_list);
        LogAdapter logAdapter = new LogAdapter(LogsList.this, logs);
        logsList.setAdapter(logAdapter);
        logsList.setLayoutManager(new LinearLayoutManager(LogsList.this));
    }
}