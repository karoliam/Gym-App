/**
 * Activity, jossa näkyy treeniohjelma ja avoimet tekstikentät, joihin käyttäjä
 * voi syöttää painojen, toistojen ja sarjojen määrät. Täyttämisen jälkeen käyttäjä
 * voi tallentaa suorituksen Profile-activityyn.
 * @author Karoliina Multas
 * @version 0.1
 */

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
        //Kun Save-buttonia painetaan toteutuu saveData ja alertDialog metodit
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog();
                saveData();
            }
        });


        //Etsitään treeniohjelman nimen ja yksittäisten liikkeiden TextViewit
        Bundle b = getIntent().getExtras();
        int i = b.getInt(TemplateActivity.EXTRA, 0);
        nameTV = findViewById(R.id.nameTextView);
        exerciseOneTV = findViewById(R.id.exercise1);
        exerciseTwoTV = findViewById(R.id.exercise2);
        exerciseThreeTV = findViewById(R.id.exercise3);
        exerciseFourTV = findViewById(R.id.exercise4);


        //Asetetaan tekstit Singletonin kautta treeniohjelman nimen ja liikkeiden TextVieweihin
        nameTV.setText(TemplateSingleton.getInstance().getTemplate(i).getName());
        exerciseOneTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise1());
        exerciseTwoTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise2());
        exerciseThreeTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise3());
        exerciseFourTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise4());

    }
    /*Metodi, joka luo alert dialog ikkunan, kun painetaan save-nappia. Ikkuna ilmoittaa
      tietojen tallentuneen.*/

    /**
     * Luo alert dialog ikkunan, joka ilmoittaa tietojen tallentuneen.
     */
    private void alertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title);
        builder.setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
                Toast.makeText(getApplicationContext(),"Workout saved!",
                        Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setTitle("Saved!");
        dialog.show();

    }

    /*Etsitään EditText kentät id:n avulla ja lisätään käyttäjän syöttämät kilot, sarjat,
      ja toistot Hashmapiin*/

    /**
     * tallentaa käyttäjän syöttämät kilot, sarjat ja toistot hashmapiin
     */
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

    //Tallennetaan Hashmap Sharedpreferenceihin onPausessa kääntämällä se Jsoniksi

    /**
     * onPausessa tallennetaan hashmap shared preferenceihin
     */
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

    /**
     * loadData metodi hakee datan shared preferenceistä
     */
    //Datan deserialisointi, eli muutetaan json takaisin gsoniksi
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
