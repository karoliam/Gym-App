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

        /**
         *
         * @param moveView asettaa nakymat
         */

        public MoveViewHolder(View moveView) {
            super(moveView);
            mExerciseTextview = moveView.findViewById(R.id.exerciseTextview);
            mWeightTextview = moveView.findViewById(R.id.weightTextview);
            mRepsTextview = moveView.findViewById(R.id.repsTextview);
            mSetsTextview = moveView.findViewById(R.id.setsTextview);
        }
    }

    /**
     *
     * @param moveArrayList Move-luokan lista
     */

    public MoveAdapter(ArrayList<Move> moveArrayList) {
        this.moveArrayList = moveArrayList;
    }

    /**
     *
     * @param parent ViewGroup-olio
     * @param viewType int
     * @return palauttaa nakyman maaritetyn layoutin nakoisena
     */

    @NonNull
    @Override
    public MoveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_list, parent, false);
        return new MoveViewHolder(v);
    }

    /**
     *
     * @param moveHolder MoveViewHolder-olio jarjestaa syotetyt tiedot oikeisiin paikkoihin
     * @param i int hakee oikean liikkeen
     * Syotetty teksti asetetaan nakymaan
     */

    @Override
    public void onBindViewHolder(MoveViewHolder moveHolder, int i) {
        Move currentMove = moveArrayList.get(i);
        moveHolder.mExerciseTextview.setText(currentMove.getMoveName());
        moveHolder.mWeightTextview.setText(currentMove.getGymWeight());
        moveHolder.mRepsTextview.setText(currentMove.getReps());
        moveHolder.mSetsTextview.setText(currentMove.getSets());
    }

    /**
     *
     * @return metodi palauttaa liikelistan pituuden
     */

    @Override
    public int getItemCount() {
        return moveArrayList.size();
    }

    /**
     * metodi tyhjentaa Move listan
     */

    public void clear() {
        int size = moveArrayList.size();
        moveArrayList.clear();
        notifyItemRangeRemoved(0, size);
    }
}
