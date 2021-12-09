package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/**
 * MoveAdapter pitaa huolta workouttejen listauksesta
 * @author Laura
 * @version 0.1
 */

public class MoveAdapter extends RecyclerView.Adapter<MoveAdapter.MoveViewHolder> {

    private ArrayList<Move> moveArrayList;

    public static class MoveViewHolder extends RecyclerView.ViewHolder {

        public TextView mExerciseTextview;
        public TextView mWeightTextview;
        public TextView mSetsTextview;
        public TextView mRepsTextview;

        public MoveViewHolder(View moveView) {
            //Asetetaan näkymät
            super(moveView);
            mExerciseTextview = moveView.findViewById(R.id.exerciseTextview);
            mWeightTextview = moveView.findViewById(R.id.weightTextview);
            mRepsTextview = moveView.findViewById(R.id.repsTextview);
            mSetsTextview = moveView.findViewById(R.id.setsTextview);
        }
    }

    public MoveAdapter(ArrayList<Move> moveArrayList) {
        this.moveArrayList = moveArrayList;
    }

    @Override
    public MoveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Liikkeet näytetään määritetyn layotin näköisenä
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_list, parent, false);;
        return new MoveViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MoveViewHolder holder, int position) {
        //Haetaan Move-luokasta tiedot ja asetetaan ne näkyviin listauksessa
        Move currentItem = moveArrayList.get(position);

        holder.mExerciseTextview.setText(currentItem.getMoveName());
        holder.mWeightTextview.setText(currentItem.getGymWeight());
        holder.mRepsTextview.setText(currentItem.getReps());
        holder.mSetsTextview.setText(currentItem.getSets());
    }

    @Override
    public int getItemCount() {

        //Liikelistan pituus
        return moveArrayList.size();
    }
}
