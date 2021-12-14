package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Objects;

/**
 * Luokka, joka hakee viimeisimman tallennetun template-workoutin.
 * @author Elias Leipola
 * @version 0.1
 */
public class TemplateStatistics extends AppCompatActivity {

    public HashMap templateHashmap;

    private TextView weight1;
    private TextView reps1;
    private TextView sets1;
    private TextView weight2;
    private TextView reps2;
    private TextView sets2;
    private TextView weight3;
    private TextView reps3;
    private TextView sets3;
    private TextView weight4;
    private TextView reps4;
    private TextView sets4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_statistics);
        //Yläpalkin nimi
        Objects.requireNonNull(getSupportActionBar()).setTitle("Recent template");
        weight1 = (TextView) findViewById(R.id.weight1View);
        weight2 = (TextView) findViewById(R.id.weight2View);
        weight3 = (TextView) findViewById(R.id.weight3View);
        weight4 = (TextView) findViewById(R.id.weight4View);
        reps1 = (TextView) findViewById(R.id.reps1View);
        reps2 = (TextView) findViewById(R.id.reps2View);
        reps3 = (TextView) findViewById(R.id.reps3View);
        reps4 = (TextView) findViewById(R.id.reps4View);
        sets1 = (TextView) findViewById(R.id.sets1View);
        sets2 = (TextView) findViewById(R.id.sets2View);
        sets3 = (TextView) findViewById(R.id.sets3View);
        sets4 = (TextView) findViewById(R.id.sets4View);

        loadData();
    }
    /**
     * Metodi, joka hakee template workoutissa kaytetyt painot, settien ja toistojen maarat.
     * Haetut arvot asetetaan oikeisiin nakymiin.
     */
    public void loadData(){
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
        weight1.setText("Weight: "+ String.valueOf(templateHashmap.get("weight1")) + " kg");
        weight2.setText("Weight: "+ String.valueOf(templateHashmap.get("weight2")) + " kg");
        weight3.setText("Weight: "+ String.valueOf(templateHashmap.get("weight3")) + " kg");
        weight4.setText("Weight: "+ String.valueOf(templateHashmap.get("weight4")) + " kg");
        reps1.setText("Reps: "+ String.valueOf(templateHashmap.get("rep1")));
        reps2.setText("Reps: "+ String.valueOf(templateHashmap.get("rep2")));
        reps3.setText("Reps: "+ String.valueOf(templateHashmap.get("rep3")));
        reps4.setText("Reps: "+ String.valueOf(templateHashmap.get("rep4")));
        sets1.setText("Sets: "+ String.valueOf(templateHashmap.get("set1")));
        sets2.setText("Sets: "+ String.valueOf(templateHashmap.get("set2")));
        sets3.setText("Sets: "+ String.valueOf(templateHashmap.get("set3")));
        sets4.setText("Sets: "+ String.valueOf(templateHashmap.get("set4")));

    }
}