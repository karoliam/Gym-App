
package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Objects;
/**
 * TemplateActivityssa on listview, johon haetaan treeniohjelmien nimet TemplateSingletonista.
 * Treeniohjelmien nimia painamalla paasee treeniohjelmaan, johon voi tayttaa tyhjiin
 * tekstikenttiin kaytetyt kilot, toistojen maarat ja sarjojen maarat.
 *
 * @author Karoliina Multas
 * @version 0.1
 */
public class TemplateActivity extends AppCompatActivity {
public final static String EXTRA = "com.example.templateworkout";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        //Yläpalkin nimi
        Objects.requireNonNull(getSupportActionBar()).setTitle("Templates");

        ListView templates = findViewById(R.id.workOutTemplates);
        //Listview
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