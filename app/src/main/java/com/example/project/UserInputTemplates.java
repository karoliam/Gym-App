package com.example.project;

import android.widget.EditText;

import java.util.ArrayList;

public class UserInputTemplates extends TemplateWorkOuts {
    private EditText weight1,weight2,weight3,weight4, set1, set2, set3, set4, rep1, rep2, rep3, rep4;

    public void saving(){
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


        templateIntegersArrayList.add(Integer.parseInt(weight1.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(weight2.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(weight3.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(weight4.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(set1.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(set2.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(set3.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(set4.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(rep1.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(rep2.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(rep3.getText().toString()));
        templateIntegersArrayList.add(Integer.parseInt(rep4.getText().toString()));

    }


}
