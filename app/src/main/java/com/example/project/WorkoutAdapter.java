package com.example.project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder> {
    private ArrayList<WorkoutClass> mWorkoutList;

    public static class WorkoutViewHolder extends RecyclerView.ViewHolder {
        public TextView mExerciseTextview;
        public TextView mWeightTextview;
        public TextView mSetsTextview;
        public TextView mRepsTextview;

        public WorkoutViewHolder(View workoutView) {
            super(workoutView);
            mExerciseTextview = workoutView.findViewById(R.id.exerciseTextview);
            mWeightTextview = workoutView.findViewById(R.id.weightTextview);
            mRepsTextview = workoutView.findViewById(R.id.repsTextview);
            mSetsTextview = workoutView.findViewById(R.id.setsTextview);
        }
    }

    public WorkoutAdapter(ArrayList<WorkoutClass> workoutList) {
        mWorkoutList = workoutList;
    }

    @Override
    public WorkoutViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.workout_list, parent, false);;
        return new WorkoutViewHolder(v);
    }

    @Override
    public void onBindViewHolder(WorkoutViewHolder holder, int position) {
        WorkoutClass currentItem = mWorkoutList.get(position);

        holder.mExerciseTextview.setText(currentItem.getWorkoutName());
        holder.mWeightTextview.setText(currentItem.getGymWeight());
        holder.mRepsTextview.setText(currentItem.getReps());
        holder.mSetsTextview.setText(currentItem.getSets());
    }

    @Override
    public int getItemCount() {
        return mWorkoutList.size();
    }
}
