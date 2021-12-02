package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TemplateWorkOuts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template_work_outs);

        Bundle b = getIntent().getExtras();
        int i = b.getInt(TemplateActivity.EXTRA, 0);
        TextView nameTV = findViewById(R.id.nameTextView);
        TextView exerciseOneTV = findViewById(R.id.exercise1);
        TextView exerciseTwoTV = findViewById(R.id.exercise2);
        TextView exerciseThreeTV = findViewById(R.id.exercise3);
        TextView exerciseFourTV = findViewById(R.id.exercise4);
        TextView exerciseFiveTV = findViewById(R.id.exercise5);
        TextView exerciseSixTV = findViewById(R.id.exercise6);

        nameTV.setText(TemplateSingleton.getInstance().getTemplate(i).getName());
        exerciseOneTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise1());
        exerciseTwoTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise2());
        exerciseThreeTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise3());
        exerciseFourTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise4());
        exerciseFiveTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise5());
        exerciseSixTV.setText(TemplateSingleton.getInstance().getTemplate(i).getExercise6());

    }
}