package com.example.project;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Statistics-luokka, jonka avulla saadaan tilastosivu näkyviin
 */

public class StatisticsFragment extends Fragment {



    private Button templateButton;
    private Button ownButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.statistics,container,false);
        templateButton = (Button) rootView.findViewById(R.id.button);
        ownButton = (Button) rootView.findViewById(R.id.button2);

        Intent intent = new Intent(getActivity(), TemplateStatistics.class);
        templateButton = rootView.findViewById(R.id.button);
        templateButton.setOnClickListener(v -> startActivity(intent));


        Intent intent2 = new Intent(getActivity(), OwnStatistics.class);
        ownButton = rootView.findViewById(R.id.button2);
        ownButton.setOnClickListener(v -> startActivity(intent2));

        return rootView;
    }



}
