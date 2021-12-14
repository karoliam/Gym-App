package com.example.project;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Profile-luokka, jonka avulla saadaan profiilisivu näkyviin
 * @author Elias
 */
public class ProfileFragment extends Fragment {
    private EditText pituus;
    private EditText paino;
    private EditText nimi;
    private Button saveButton;


    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String PITUUS = "pituus";
    public static final String PAINO = "paino";
    public static final String NIMI = "nimi";

    private String pituus2;
    private String paino2;
    private String nimi2;




    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.profile,container,false);
        pituus = (EditText) rootView.findViewById(R.id.pituus_view);
        paino = (EditText) rootView.findViewById(R.id.paino_view);
        nimi = (EditText) rootView.findViewById(R.id.nimi_view);
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

    /**
     * Metodi, joka tallentaa nimen, painon ja pituuden shared preferences kansioon.
     */
    public void saveData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PITUUS, pituus.getText().toString());
        editor.putString(PAINO, paino.getText().toString());
        editor.putString(NIMI,nimi.getText().toString());

        editor.apply();
    }

    /**
     * Metodi, joka hakee tallennetun painon, pituuden ja nimen shared preferences kansiosta.
     */
    public void loadData(){
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        pituus2 = sharedPreferences.getString(PITUUS,"");
        paino2 =  sharedPreferences.getString(PAINO,"");
        nimi2 = sharedPreferences.getString(NIMI,"");
    }

    /**
     * Metodi, joka asettaa annetun painon, pituuden ja ian oikeisiin nakymiin.
     */
    public void updateViews(){
        pituus.setText(pituus2);
        paino.setText(paino2);
        nimi.setText(nimi2);

    }

}
