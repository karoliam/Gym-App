package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


/**
 * Statistics-fragment, jonka avulla saadaan tilastosivu näkyviin
 */

public class StatisticsFragment extends Fragment {
    private Button templateButton;
    private Button ownButton;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Yläpalkin nimi
        getActivity().setTitle("Recent workout");
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
