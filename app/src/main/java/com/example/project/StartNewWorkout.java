package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartNewWorkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_new);

        Button ownWorkoutButton = (Button)findViewById(R.id.ownWorkoutButton);

        ownWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartNewWorkout.this, OwnWorkoutActivity.class));
            }
        });
        Button templateWorkoutButton = (Button)findViewById(R.id.templateButton);

        templateWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartNewWorkout.this, TemplateActivity.class));
            }
        });

    }
}