package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class TemplateWorkOuts extends AppCompatActivity {
    ArrayList<TemplateIntegers> templateIntegersArrayList;
    private TextView exerciseOneTV, exerciseTwoTV, exerciseThreeTV, exerciseFourTV, nameTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_work_outs);

/*        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });*/

        Bundle b = getIntent().getExtras();
        int i = b.getInt(TemplateActivity.EXTRA, 0);
        nameTV = findViewById(R.id.nameTextView);
        exerciseOneTV = findViewById(R.id.exercise1);
        exerciseTwoTV = findViewById(R.id.exercise2);
        exerciseThreeTV = findViewById(R.id.exercise3);
        exerciseFourTV = findViewById(R.id.exercise4);
        //Asetetaan tekstit Singletonin kautta paikoilleen
        nameTV.setText(TemplateSingleton.getInstance().getTemplate(i).getName());
        exerciseOneTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise1());
        exerciseTwoTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise2());
        exerciseThreeTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise3());
        exerciseFourTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise4());
    }
/*
    private void saveData() {
        SharedPreferences prefs = getSharedPreferences("saving templates", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(templateIntegersArrayList);
        editor.putString ("templates", json);
        editor.apply();
    }

    private void loadData() {

    }*/

}