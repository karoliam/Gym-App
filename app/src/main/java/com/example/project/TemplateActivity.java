/**
 * TemplateActivityssä on listview, johon haetaan treeniohjelmien nimet TemplateSingletonista.
 * Treeniohjelmien nimiä painamalla pääsee treeniohjelmaan, johon voi täyttää tyhjiin
 * tekstikenttiin käytetyt kilot, toistojen määrät ja sarjojen määrät.
 *
 * @author Karoliina Multas
 * @version 0.1
 */
package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Objects;

public class TemplateActivity extends AppCompatActivity {
public final static String EXTRA = "com.example.templateworkout";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        //Yläpalkin nimi
        Objects.requireNonNull(getSupportActionBar()).setTitle("Templates");

        ListView templates = findViewById(R.id.workOutTemplates);

        templates.setAdapter(new ArrayAdapter<TemplateModels>(
                this,
                android.R.layout.simple_list_item_1,
                TemplateSingleton.getInstance().getTemplates())
        );

        templates.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent nextActivity = new Intent(TemplateActivity.this, TemplateWorkOuts.class);
            nextActivity.putExtra(EXTRA, i);
            startActivity(nextActivity);
        });
    }
}