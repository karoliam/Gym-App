package com.example.project;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Profile-luokka, jonka avulla saadaan profiilisivu näkyviin
 */
public class ProfileFragment extends Fragment {
    private EditText pituus;
    private EditText paino;
    private Button saveButton;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String PITUUS = "pituus";
    public static final String PAINO = "paino";

    private int pituus2;
    private int paino2;



    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.profile,container,false);
        pituus = (EditText) rootView.findViewById(R.id.pituus_view);
        paino = (EditText) rootView.findViewById(R.id.paino_view);
        saveButton = (Button) rootView.findViewById(R.id.save_button);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        loadData();
        updateViews();
        return rootView;
    }

    public void saveData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(PITUUS, Integer.parseInt(pituus.getText().toString()));
        editor.putInt(PAINO, Integer.parseInt(paino.getText().toString()));

        editor.apply();
    }

    public void loadData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        pituus2 = sharedPreferences.getInt(PITUUS,0);
        paino2 =  sharedPreferences.getInt(PAINO,0);
    }

    public void updateViews(){
        pituus.setText(Integer.toString(pituus2));
        paino.setText(Integer.toString(paino2));
    }

}
