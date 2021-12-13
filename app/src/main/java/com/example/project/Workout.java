package com.example.project;
import java.util.ArrayList;

/**
 * Workout-luokka tekee ArrayListeja Move-elementeistä
 * @author Laura
 * @version 0.1
 */
public class Workout {
    ArrayList<Move> workout;

    /**
     * Konstruktori luokalle Workout
     */
    public Workout(){
        this.workout = new ArrayList<>();
    }

    /**
     *
     * @return ArrayList palauttaa listan yhdestä workoutista(harjoituksesta)
     */
    public ArrayList<Move> getWorkout() {

        return workout;
    }

    /**
     *
     * @param move Move-luokan yksi elementti
     * Lisataan uusi liike workout ArrayListiin
     */

    public void addMove(Move move) {
        workout.add(move);
    }
}
