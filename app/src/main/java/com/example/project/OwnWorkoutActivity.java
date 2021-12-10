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

        //New workout-nappia painamalla RecyclerView tyhjenee
        Button newworkoutbutton = findViewById(R.id.button_new);
        newworkoutbutton.setOnClickListener(v -> clearRecyclerView());

        //Jos new workout - nappia ei paineta - ladataan data
        if(!newworkoutbutton.isPressed()){
            loadData();
        }

        setInsertButton();

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
        TypeToken<List<Workout>> token = new TypeToken<List<Workout>>() {};
        List<Workout> workoutList = gson.fromJson(json, token.getType());
        ArrayList<Workout> workoutArrayList = new ArrayList<>(workoutList.size());
        workoutArrayList.addAll(workoutList);
        DataBaseSingleton.getInstance().setWorkouts(workoutArrayList);

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
        //Tässä jokin vialla tai luokassa Move/workout/Databasesingleton

        DataBaseSingleton dataBase = DataBaseSingleton.getInstance();
        Log.d("tagi","vali1");
        workout.addMove(new Move(name, weight, reps, sets));
        Log.d("tagi","vali2");
        dataBase.addWorkout(workout);
        Log.d("tagi","vali3");
        buildRecyclerView();
        Log.d("tagi","vali4");
        //mAdapter.notifyItemInserted(DataBaseSingleton.getInstance().getWorkouts().size());
    }
    private void clearRecyclerView(){
        //RecyclerViewn tyhjennys
        //Tässä jokin vialla
        Log.d("tagi","vali1 tyhjennys");
        DataBaseSingleton.getInstance().getWorkouts().clear();
        Log.d("tagi","vali2 tyhjennys");
        mAdapter.notifyDataSetChanged();
        Log.d("tagi","vali3 tyhjennys");
    }
}