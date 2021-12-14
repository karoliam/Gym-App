package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class OwnStatistics extends AppCompatActivity {

    private RecyclerView statsRecyclerview;
    private MoveAdapter moveAdapter;
    private RecyclerView.LayoutManager workoutLayoutManager;
    private Workout lastWorkout;
    private ArrayList<Workout> workoutArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_statistics);

        loadWorkouts();
        setLastWorkout();

    }

    /**
     * metodi lataa shared preferenses-kansiosta workoutit
     */
    private void loadWorkouts() {
        SharedPreferences sharedPreferences = getSharedPreferences("workouts", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("workout list", null);
        if(json!=null) {
            TypeToken<List<Workout>> token = new TypeToken<List<Workout>>() {
            };
            List<Workout> workoutList = gson.fromJson(json, token.getType());
            workoutArrayList = new ArrayList<>(workoutList.size());
            workoutArrayList.addAll(workoutList);
            DataBaseSingleton.getInstance().setWorkouts(workoutArrayList);


        }
    }

    /**
     * Haetaan viimeisin workout -listalta
     * Asetetaan viimeisin workout nakyviin RecyclerView:n avulla.
     * MoveAdapter
     */

    private void setLastWorkout(){
        lastWorkout = workoutArrayList.get(workoutArrayList.size()-1);

        statsRecyclerview = findViewById(R.id.statistics_recyclerview);
        statsRecyclerview.setHasFixedSize(true);
        workoutLayoutManager = new LinearLayoutManager(this);
        moveAdapter = new MoveAdapter(lastWorkout.getWorkout());
        statsRecyclerview.setLayoutManager(workoutLayoutManager);
        statsRecyclerview.setAdapter(moveAdapter);

    }






}