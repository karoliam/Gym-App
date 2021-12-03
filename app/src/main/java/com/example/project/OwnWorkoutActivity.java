package com.example.project;

import android.app.Activity;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
public class OwnWorkoutActivity extends Activity {
    private Button buttonView;
    private LinearLayout parentLayout;
    private int hint=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_workout);
        buttonView=(Button)findViewById(R.id.buttonView);
        parentLayout = (LinearLayout)findViewById(R.id.parentLayout);
        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createEditTextView();
            }
        });
    }
    protected void createEditTextView() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams (
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        params.setMargins(0,10,0,10);
        EditText exercise = new EditText(this);
        EditText weight = new EditText(this);
        EditText sets = new EditText(this);
        EditText reps = new EditText(this);
        int maxLength = 5;
        hint++;
        exercise.setHint("Your exercise");
        exercise.setInputType(InputType.TYPE_CLASS_TEXT);
        exercise.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        exercise.setId(hint);
        InputFilter[] fArray = new InputFilter[1];
        fArray[0] = new InputFilter.LengthFilter(maxLength);
        exercise.setFilters(fArray);
        parentLayout.addView(exercise);

        weight.setHint("weight");
        weight.setLayoutParams(params);
        weight.setInputType(InputType.TYPE_CLASS_NUMBER);
        weight.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        weight.setId(hint);
        weight.setFilters(fArray);
        parentLayout.addView(weight);

        sets.setHint("sets");
        sets.setLayoutParams(params);
        sets.setInputType(InputType.TYPE_CLASS_NUMBER);
        sets.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        sets.setId(hint);
        sets.setFilters(fArray);
        parentLayout.addView(sets);

        reps.setHint("reps");
        reps.setLayoutParams(params);
        reps.setInputType(InputType.TYPE_CLASS_NUMBER);
        reps.setTextSize(TypedValue.COMPLEX_UNIT_SP,18);
        reps.setId(hint);
        reps.setFilters(fArray);
        parentLayout.addView(reps);
    }
}