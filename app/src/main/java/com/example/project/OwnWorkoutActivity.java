package com.example.project;

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

public class OwnWorkoutActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MoveAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Workout workout = new  Workout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_workout);
//ONGELMA: LISTA TYHJENEE KUN POISTUU
        loadData();
        buildRecyclerView();

        setInsertButton();

        Button button = findViewById(R.id.button_clear);
        if(button.isPressed()){
            clearRecyclerView();
        }

    }

    public void onPause() {
        //Tallennetaan workout shared preferensseihin pause tilassa
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("moves", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(DataBaseSingleton.getInstance().getWorkouts());
        editor.putString("workout list", json);
        editor.apply();
    }

    private void loadData() {
        //ladataan tiedot ja asetetaan workoutit workoutArrayListiin
        SharedPreferences sharedPreferences = getSharedPreferences("moves", MODE_PRIVATE);
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

    private void buildRecyclerView() {
        //Luodaan RecyclerView
        Log.d("tagi","buildi väli 1");
        mRecyclerView = findViewById(R.id.recyclerview);
        Log.d("tagi","buildi väli 2");
        mRecyclerView.setHasFixedSize(true);
        Log.d("tagi","buildi väli 3");
        mLayoutManager = new LinearLayoutManager(this);
        Log.d("tagi","buildi väli 4");
        mAdapter = new MoveAdapter(workout.getWorkout());
        Log.d("tagi","buildi väli 5");
        mRecyclerView.setLayoutManager(mLayoutManager);
        Log.d("tagi","buildi väli 6");
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setInsertButton() {
        //Insert-nappia painamalla tiedot otetaan vastaan
        Button buttonInsert = findViewById(R.id.button_insert);
        buttonInsert.setOnClickListener(v -> {
            EditText exercise = findViewById(R.id.setTextExercise);
            EditText weight = findViewById(R.id.setTextWeight);
            EditText reps = findViewById(R.id.setTextReps);
            EditText sets = findViewById(R.id.setTextSets);
            insertItem(exercise.getText().toString(),weight.getText().toString(),
                    reps.getText().toString(), sets.getText().toString());
            exercise.setText("");
            weight.setText("");
            reps.setText("");
            sets.setText("");

        });
    }

    private void insertItem(String name, String weight, String reps, String sets) {
        /*Syötetty liike lisätään Move-luokkaan ja näytetään RecyclerViewssa.
        Liike haetaan DataBaseSingletonista */

        DataBaseSingleton dataBase = DataBaseSingleton.getInstance();
        Log.d("tagi","vali1");
        workout.addMove(new Move(name, weight, reps, sets));
        Log.d("tagi","vali2");
        dataBase.addWorkout(workout);
        Log.d("tagi","vali3");

        Log.d("tagi","vali4");
        mAdapter.notifyItemInserted(DataBaseSingleton.getInstance().getWorkouts().size());
    }
    private void clearRecyclerView(){
        mAdapter.clear();
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