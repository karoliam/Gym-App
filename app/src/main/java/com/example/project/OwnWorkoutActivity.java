package com.example.project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;

import java.util.Objects;

/**
 * OwnWorkoutActitivy tallentaa oman workoutin shared preferenses-kansioon
 * @author Laura Immonen
 * @version 0.1
 */

public class OwnWorkoutActivity extends AppCompatActivity {
    private RecyclerView workoutRecyclerView;
    private MoveAdapter workoutAdapter;
    private RecyclerView.LayoutManager workoutLayoutManager;
    private final Workout workout = new  Workout();
    private DataBaseSingleton dataBase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_workout);
        //Yläpalkin nimi
        Objects.requireNonNull(getSupportActionBar()).setTitle("Add own workout");
        dataBase = DataBaseSingleton.getInstance();
        buildRecyclerView();
        setInsertButton();

        Button saveButton = findViewById(R.id.button_save);
        saveButton.setOnClickListener(v -> alertDialog());
    }

    /**
     * metodi tallentaa workoutin shared preferenses-kansioon onPause-tilassa
     */

    public void onPause() {
        super.onPause();
        dataBase.addWorkout(workout);
        SharedPreferences sharedPreferences = getSharedPreferences("workouts", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(DataBaseSingleton.getInstance().getWorkouts());
        editor.putString("workout list", json);
        editor.apply();
    }

    /**
     * metodi luo RecyclerViewn ja asettaa liikkeita nakyviin
     */

    private void buildRecyclerView() {
        workoutRecyclerView = findViewById(R.id.recyclerview);
        workoutRecyclerView.setHasFixedSize(true);
        workoutLayoutManager = new LinearLayoutManager(this);
        workoutAdapter = new MoveAdapter(workout.getWorkout());
        workoutRecyclerView.setLayoutManager(workoutLayoutManager);
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
            if (weight.getText().toString().trim().equals("") || Integer.parseInt(String.valueOf(weight.getText())) < 0) {

                weight.setError( "Not valid weight!" );
            }
            if (sets.getText().toString().trim().equals("")|| Integer.parseInt(String.valueOf(sets.getText())) < 0) {

                sets.setError( "Not valid set!" );

            }
            if (reps.getText().toString().trim().equals("")|| Integer.parseInt(String.valueOf(reps.getText())) < 0) {

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

        workout.addMove(new Move(name, weight, reps, sets));
    }

    /**
     * metodi tyhjentaa RecyclerView:n ja palaa edelliselle sivulle.
     */
    private void clearRecyclerView(){
        workoutAdapter.notifyDataSetChanged();
        startActivity(new Intent(OwnWorkoutActivity.this, StartNewWorkout.class));
    }

    /**
     * Ponnahdusikkuna, joka ilmoittaa workoutin tallennuksesta
     * ok-nappia painamalla toteutetaan clearRecyclerView-metodia
     */
    //lähde: https://developer.android.com/guide/topics/ui/dialogs
    private void alertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title);
        builder.setPositiveButton(R.string.ok_button, (dialog, id) -> {
            finish();
            Toast.makeText(getApplicationContext(),"Workout saved!",
                    Toast.LENGTH_SHORT).show();
            clearRecyclerView();
        });
        AlertDialog dialog = builder.create();
        dialog.setTitle("Saved!");
        dialog.show();

    }
}
