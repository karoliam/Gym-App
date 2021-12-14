package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;

public class TemplateWorkOuts extends AppCompatActivity {
    public HashMap<String, Integer> templateHashmap;
    private TextView exerciseOneTV, exerciseTwoTV, exerciseThreeTV, exerciseFourTV, nameTV;
    private EditText weight1,weight2,weight3,weight4, set1, set2, set3, set4, rep1, rep2, rep3, rep4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_work_outs);
        loadData();
        //Etsitään Save-button
        Button saveButton = findViewById(R.id.saveButton);
        //Kun Save-buttonia painetaan toteutuu saveData metodi
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog();
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


        //Asetetaan tekstit Singletonin kautta harjoitusten TextVieweihin
        nameTV.setText(TemplateSingleton.getInstance().getTemplate(i).getName());
        exerciseOneTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise1());
        exerciseTwoTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise2());
        exerciseThreeTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise3());
        exerciseFourTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise4());

    }

    private void alertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title);
        AlertDialog dialog = builder.create();
        builder.setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
                Toast.makeText(getApplicationContext(),"Workout saved!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        dialog.setTitle("Saved!");
        dialog.show();

    }

    //Etsitään EditText kentät id:n avulla ja lisätään käyttäjän syöttämät arvot Hashmapiin
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


        templateHashmap.put("weight1", Integer.parseInt(weight1.getText().toString()));
        templateHashmap.put("weight2", Integer.parseInt(weight2.getText().toString()));
        templateHashmap.put("weight3", Integer.parseInt(weight3.getText().toString()));
        templateHashmap.put("weight4", Integer.parseInt(weight4.getText().toString()));
        templateHashmap.put("set1", Integer.parseInt(set1.getText().toString()));
        templateHashmap.put("set2", Integer.parseInt(set2.getText().toString()));
        templateHashmap.put("set3", Integer.parseInt(set3.getText().toString()));
        templateHashmap.put("set4", Integer.parseInt(set4.getText().toString()));
        templateHashmap.put("rep1", Integer.parseInt(rep1.getText().toString()));
        templateHashmap.put("rep2", Integer.parseInt(rep2.getText().toString()));
        templateHashmap.put("rep3", Integer.parseInt(rep3.getText().toString()));
        templateHashmap.put("rep4", Integer.parseInt(rep4.getText().toString()));

    }
    //Tallennetaan Hashmap Sharedpreferenceihin onPausessa
    @Override
    public void onPause () {
        super.onPause();
        SharedPreferences prefs = getSharedPreferences("workouts", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson Gson = new Gson();
        String json = Gson.toJson(templateHashmap);
        editor.putString("saving templates", json);
        editor.commit();

    }
    //Datan deserialisointi
    private void loadData() {
        //Weights
        SharedPreferences prefs = getSharedPreferences("workouts", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("saving templates", null);
        Type type = new TypeToken<HashMap<String, Integer>>() {}.getType();
        templateHashmap = gson.fromJson(json, type);
        //Jos lista on tyhjä, luodaan uusi tyhjä lista.
        if (templateHashmap == null){
            templateHashmap = new HashMap<>();
        }

    }
}
