package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class StartNewWorkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_new);

        Button ownWorkoutButton = findViewById(R.id.ownWorkoutButton);


        ownWorkoutButton.setOnClickListener(v -> startActivity(new Intent(StartNewWorkout.this, OwnWorkoutActivity.class)));
        Button templateWorkoutButton = findViewById(R.id.templateButton);

        templateWorkoutButton.setOnClickListener(v -> startActivity(new Intent(StartNewWorkout.this, TemplateActivity.class)));

    }
}