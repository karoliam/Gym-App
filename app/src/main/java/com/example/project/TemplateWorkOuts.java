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
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class TemplateWorkOuts extends AppCompatActivity {
    public ArrayList<Integer> templateIntegersArrayList;
    private TextView exerciseOneTV, exerciseTwoTV, exerciseThreeTV, exerciseFourTV, nameTV;
    private EditText weight1,weight2,weight3,weight4, set1, set2, set3, set4, rep1, rep2, rep3, rep4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_work_outs);
        loadData();
        //Etsitään Save-button
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        //Etsitään harjoitusten TextViewit
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


    //Etsitään EditText kentät id:n avulla ja lisätään käyttäjän syöttämät arvot ArrayListiin
    private void saveData() {
        weight1 = findViewById(R.id.weightEditText);
        weight2 = findViewById(R.id.weightEditText2);
        weight3 = findViewById(R.id.weightEditText3);
        weight4 = findViewById(R.id.weightEditText4);
        set1 = findViewById(R.id.setsEditText);
        set2 = findViewById(R.id.setsEditText2);
        set3 = findViewById(R.id.setsEditText3);
        set4 = findViewById(R.id.setsEditText4);
        rep1 = findViewById(R.id.repsEditText);
        rep2 = findViewById(R.id.repsEditText2);
        rep3 = findViewById(R.id.repsEditText3);
        rep4 = findViewById(R.id.repsEditText4);


        templateIntegersArrayList.add(Integer.parseInt(weight1.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(weight2.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(weight3.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(weight4.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(set1.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(set2.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(set3.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(set4.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(rep1.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(rep2.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(rep3.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(rep4.getText().toString()));

    }
    //Tallennetaan Arraylist Sharedpreferenceihin onPausessa
    @Override
    public void onPause () {
        super.onPause();
        SharedPreferences prefs = getSharedPreferences("saving templates", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(templateIntegersArrayList);
        editor.putString("templates", json);
        editor.commit();

    }
    //Datan deserialisointi
    private void loadData() {
        SharedPreferences prefs = getSharedPreferences("saving templates", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("templates", null);
        Type type = new TypeToken<ArrayList<Integer>>() {}.getType();
        templateIntegersArrayList = gson.fromJson(json, type);
        //Jos lista on tyhjä, luodaan uusi tyhjä lista.
        if (templateIntegersArrayList == null){
            templateIntegersArrayList = new ArrayList<>();
        }
    }
}
