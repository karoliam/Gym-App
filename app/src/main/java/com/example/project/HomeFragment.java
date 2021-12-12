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
 * Home-luokka, jonka avulla saadaan kotisivu näkyviin
 * https://github.com/gurkanucar/BottomNavigationViewExample/
 */
public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.home,container,false);

        Intent intent = new Intent(getActivity(), StartNewWorkout.class);
        final Button button = rootView.findViewById(R.id.startNewActivity);

        button.setOnClickListener(v -> startActivity(intent));

        return rootView;
    }


}
