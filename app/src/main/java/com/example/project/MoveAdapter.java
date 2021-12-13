package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/**
 * MoveAdapter pitaa huolta workouttejen listauksesta
 * @author Laura
 * @version 0.1
 */

public class MoveAdapter extends RecyclerView.Adapter<MoveAdapter.MoveViewHolder> {

    private final ArrayList<Move> moveArrayList;

    public static class MoveViewHolder extends RecyclerView.ViewHolder {

        public TextView mExerciseTextview, mWeightTextview, mSetsTextview, mRepsTextview;

        //Asetetaan näkymät
        public MoveViewHolder(View moveView) {
            super(moveView);
            mExerciseTextview = moveView.findViewById(R.id.exerciseTextview);
            mWeightTextview = moveView.findViewById(R.id.weightTextview);
            mRepsTextview = moveView.findViewById(R.id.repsTextview);
            mSetsTextview = moveView.findViewById(R.id.setsTextview);
        }
    }

    //Move-luokan lista
    public MoveAdapter(ArrayList<Move> moveArrayList) {
        this.moveArrayList = moveArrayList;
    }

    //Liikkeet näytetään määritetyn layotin näköisenä
    @NonNull
    @Override
    public MoveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_list, parent, false);
        return new MoveViewHolder(v);
    }

    //Syötetty teksti asetetaan näkymään
    @Override
    public void onBindViewHolder(MoveViewHolder moveHolder, int i) {
        Move currentMove = moveArrayList.get(i);
        moveHolder.mExerciseTextview.setText(currentMove.getMoveName());
        moveHolder.mWeightTextview.setText(currentMove.getGymWeight());
        moveHolder.mRepsTextview.setText(currentMove.getReps());
        moveHolder.mSetsTextview.setText(currentMove.getSets());
    }
    //Liikelistan pituus
    @Override
    public int getItemCount() {
        return moveArrayList.size();
    }

    public void clear() {
        int size = moveArrayList.size();
        moveArrayList.clear();
        notifyItemRangeRemoved(0, size);
    }
}
