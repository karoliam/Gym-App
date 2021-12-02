package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
/*Karoliinan osuus
Tämä on se listanäkymä, josta valitaan treeni
 */
public class TemplateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
    }
}