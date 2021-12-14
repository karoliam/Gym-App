package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/**
 * OwnWorkoutActitivy tallentaa oman workoutin shared preferenses-kansioon
 * @author Laura
 * @version 0.1
 */

public class OwnWorkoutActivity extends AppCompatActivity {
    private RecyclerView workoutRecyclerView;
    private MoveAdapter workoutAdapter;
    private RecyclerView.LayoutManager workoutLayoutManager;
    private Workout workout = new  Workout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_workout);

        buildRecyclerView();
        setInsertButton();

        Button saveButton = findViewById(R.id.button_save);
        saveButton.setOnClickListener(v -> clearRecyclerView());

    }

    /**
     * metodi tallentaa workoutin shared preferenses-kansioon onPause-tilassa
     */

    public void onPause() {
        //Tallennetaan workout shared preferensseihin pause tilassa
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("workouts", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(DataBaseSingleton.getInstance().getWorkouts());
        editor.putString("workout list", json);
        editor.apply();
    }

    //Tässä ei tarvita, tarvitaan statseissa
    private void loadData() {
        //ladataan tiedot ja asetetaan workoutit workoutArrayListiin
        SharedPreferences sharedPreferences = getSharedPreferences("workouts", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("workout list", null);
        if(json!=null) {
            TypeToken<List<Workout>> token = new TypeToken<List<Workout>>() {
            };
            List<Workout> workoutList = gson.fromJson(json, token.getType());
            ArrayList<Workout> workoutArrayList = new ArrayList<>(workoutList.size());
            workoutArrayList.addAll(workoutList);
            DataBaseSingleton.getInstance().setWorkouts(workoutArrayList);
        }
    }

    /**
     * metodi luo RecyclerViewn ja asettaa liikkeita nakyviin
     */

    private void buildRecyclerView() {
        //Luodaan RecyclerView
        Log.d("tagi","buildi väli 1");
        workoutRecyclerView = findViewById(R.id.recyclerview);
        Log.d("tagi","buildi väli 2");
        workoutRecyclerView.setHasFixedSize(true);
        Log.d("tagi","buildi väli 3");
        workoutLayoutManager = new LinearLayoutManager(this);
        Log.d("tagi","buildi väli 4");
        workoutAdapter = new MoveAdapter(workout.getWorkout());
        Log.d("tagi","buildi väli 5");
        workoutRecyclerView.setLayoutManager(workoutLayoutManager);
        Log.d("tagi","buildi väli 6");
        workoutRecyclerView.setAdapter(workoutAdapter);
    }

    /**
     * metodilla otetaan kayttajalta tiedot vastaan
     * Katsotaan ettei kentat ole tyhjia
     * Sijoitetaan tiedot insertItem-metodiin
     */

    private void setInsertButton() {
        //Insert-nappia painamalla tiedot otetaan vastaan
        Button buttonInsert = findViewById(R.id.button_insert);
        buttonInsert.setOnClickListener(v -> {
            EditText exercise = findViewById(R.id.setTextExercise);
            EditText weight = findViewById(R.id.setTextWeight);
            EditText reps = findViewById(R.id.setTextReps);
            EditText sets = findViewById(R.id.setTextSets);

            //Virheilmoitus, jos kenttä on tyhjä tai numerot on negatiivisia
            if( exercise.getText().toString().trim().equals(""))
            {
                exercise.setError( "Not valid exercise!" );

            }
            else if (weight.getText().toString().trim().equals("") || Integer.parseInt(String.valueOf(weight.getText())) < 0) {

                weight.setError( "Not valid weight!" );
            }
            else if (sets.getText().toString().trim().equals("")|| Integer.parseInt(String.valueOf(sets.getText())) < 0) {

                sets.setError( "Not valid set!" );

            }
            else if (reps.getText().toString().trim().equals("")|| Integer.parseInt(String.valueOf(reps.getText())) < 0) {

                reps.setError( "Not valid rep!" );

            }
            else {
                insertItem(exercise.getText().toString(),weight.getText().toString(),
                        reps.getText().toString(), sets.getText().toString());
                exercise.setText("");
                weight.setText("");
                reps.setText("");
                sets.setText("");
            }
        });
    }

    /**
     *
     * @param name String liikkeen nimi
     * @param weight String liikkeen paino
     * @param reps String liikkeen toistot
     * @param sets String liikkeen sarjat
     * Kayttajan syotetty liike lisataan Move-luokkaan ja naytetaan RecyclerView:ssa
     * Liike haetaan DataBaseSingletonista
     */

    private void insertItem(String name, String weight, String reps, String sets) {
        /*Syötetty liike lisätään Move-luokkaan ja näytetään RecyclerViewssa.
        Liike haetaan DataBaseSingletonista */

        DataBaseSingleton dataBase = DataBaseSingleton.getInstance();
        Log.d("tagi","vali1");
        workout.addMove(new Move(name, weight, reps, sets));
        Log.d("tagi","vali2");
        dataBase.addWorkout(workout);
        Log.d("tagi","vali3");
    }

    /**
     * metodi tyhjentaa RecyclerView:n ja palaa edelliselle sivulle.
     */
    private void clearRecyclerView(){
        Log.d("tagi","1");
        workoutAdapter.notifyDataSetChanged();
        Log.d("tagi","2");
        startActivity(new Intent(OwnWorkoutActivity.this, StartNewWorkout.class));
    }
}


/*
package com.example.project;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class OwnWorkoutActivity extends AppCompatActivity {
    private ArrayList<Move> workoutList;
    private MoveAdapter workoutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_workout);

        //Kun clear-nappia painetaan, lista tyhjenee
        Button clearButton = findViewById(R.id.button_clear);
        clearButton.setOnClickListener(v -> clearWorkout());

        //Jos ei ole painettu clear-nappia, ladataan data
        if(!clearButton.isPressed()){
            loadData();
        }

        //Syötetty teksti asetetaan paikoille
        buildRecyclerView();
        setInsertButton();

    }

    //onPause()-tilassa tallennetaan data shared preferences
    public void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("workouts", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(workoutList);
        editor.putString("Own workout", json);
        editor.apply();
    }

    //Ladataan lista liikkeistä
    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("workouts", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Own workout", null);
        Type type = new TypeToken<ArrayList<Move>>() {}.getType();
        workoutList = gson.fromJson(json, type);

        if (workoutList == null) {
            workoutList = new ArrayList<>();
        }
    }

    //Rakennetaan Recycler View:n sisälle lista liikkeistä
    private void buildRecyclerView() {
        RecyclerView workoutRecyclerView = findViewById(R.id.recyclerview);
        workoutRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager workoutLayoutManager = new LinearLayoutManager(this);
        workoutAdapter = new MoveAdapter(workoutList);
        workoutRecyclerView.setLayoutManager(workoutLayoutManager);
        workoutRecyclerView.setAdapter(workoutAdapter);
    }

    //Kun insert-nappia painetaan, kerätään syötetty teksti ja tyhjennetään näkymät
    private void setInsertButton() {
        Button buttonInsert = findViewById(R.id.button_insert);
        buttonInsert.setOnClickListener(v -> {
            EditText exercise = findViewById(R.id.setTextExercise);
            EditText weight = findViewById(R.id.setTextWeight);
            EditText reps = findViewById(R.id.setTextReps);
            EditText sets = findViewById(R.id.setTextSets);
            insertExercise(exercise.getText().toString(),weight.getText().toString(),
                    reps.getText().toString(), sets.getText().toString());
            exercise.setText("");
            weight.setText("");
            reps.setText("");
            sets.setText("");
        });
    }

    //Syötetty teksti lisätään listalle Move-luokan avulla
    private void insertExercise(String name, String weight, String reps, String sets) {
        workoutList.add(new Move(name, weight, reps, sets));
        workoutAdapter.notifyItemInserted(workoutList.size());
    }

    //Tyhjennetään lista
    private void clearWorkout(){
        workoutList.clear();
        workoutAdapter.notifyDataSetChanged();
    }
}

 */