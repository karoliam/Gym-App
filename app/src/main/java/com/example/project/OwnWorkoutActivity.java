package com.example.project;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
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
    ArrayList<Move> mWorkoutList;
    private RecyclerView mRecyclerView;
    private WorkoutAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_workout);


        Button buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        Button newworkoutbutton = findViewById(R.id.button_new);
        newworkoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearRecyclerView();

            }
        });
        loadData();
        if(!newworkoutbutton.isPressed()){
            loadData();
        }
        buildRecyclerView();
        setInsertButton();

    }

    private void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences("workouts", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(mWorkoutList);
        editor.putString("workout list", json);
        editor.apply();
    }

    private void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("workouts", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("workout list", null);
        Type type = new TypeToken<ArrayList<Move>>() {}.getType();
        mWorkoutList = gson.fromJson(json, type);

        if (mWorkoutList == null) {
            mWorkoutList = new ArrayList<>();
        }
    }

    private void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new WorkoutAdapter(mWorkoutList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setInsertButton() {
        Button buttonInsert = findViewById(R.id.button_insert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
            }
        });
    }

    private void insertItem(String line1, String line2, String line3, String line4) {
        mWorkoutList.add(new Move(line1, line2, line3, line4));
        mAdapter.notifyItemInserted(mWorkoutList.size());
    }
    private void clearRecyclerView(){
        mWorkoutList.clear();
        mAdapter.notifyDataSetChanged();
    }
}