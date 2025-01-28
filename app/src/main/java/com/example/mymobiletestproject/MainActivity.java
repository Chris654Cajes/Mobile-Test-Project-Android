package com.example.mymobiletestproject;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import DbHelpers.DatabaseHelper;

/*
    This activity displays a page that displays 4 buttons to add new logs
*/

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2, btn3, btn4;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        // Add new log for button 1
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLog(1);
            }
        });

        // Add new log for button 2
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLog(2);
            }
        });

        // Add new log for button 3
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLog(3);
            }
        });

        // Add new log for button 4
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLog(4);
            }
        });

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.btn_view_logs:
                        Intent homeIntent = new Intent(MainActivity.this, LogsList.class);
                        startActivity(homeIntent);
                        break;
                }

                return false;
            }
        });
    }

    // This method adds the new log in the database
    private void addLog(int buttonNumber) {
        DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this);

        Toast.makeText(MainActivity.this, dbHelper.addLog(buttonNumber), Toast.LENGTH_SHORT).show();
    }
}