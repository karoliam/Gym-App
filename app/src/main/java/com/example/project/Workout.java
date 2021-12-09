package com.example.project;

import java.util.ArrayList;

public class Workout {
    ArrayList<Move> workout;

    public ArrayList<Move> getWorkout() {

        return workout;
    }

    public void addMove(Move move) {
        workout.add(move);
    }
}
