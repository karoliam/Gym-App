package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.os.Bundle;
=======
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

>>>>>>> d9fd59a76a59a2f72c158c37bee5a7f21ca57a43
/*Karoliinan osuus
Tämä on se listanäkymä, josta valitaan treeni
 */
public class TemplateActivity extends AppCompatActivity {
<<<<<<< HEAD

=======
    public final static String EXTRA = "com.example.templateworkout";
>>>>>>> d9fd59a76a59a2f72c158c37bee5a7f21ca57a43
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
<<<<<<< HEAD
=======

        ListView templates = (ListView)findViewById(R.id.workOutTemplates);

        templates.setAdapter(new ArrayAdapter<TemplateModels>(
                this,
                android.R.layout.simple_list_item_1,
                TemplateSingleton.getInstance().getTemplates())
        );

        templates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent nextActivity = new Intent(TemplateActivity.this, TemplateWorkOuts.class);
                nextActivity.putExtra(EXTRA, i);
                startActivity(nextActivity);
            }
        });


>>>>>>> d9fd59a76a59a2f72c158c37bee5a7f21ca57a43
    }
}