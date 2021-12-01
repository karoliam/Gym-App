package com.example.project;

/**
 * Workout-luokka, jossa kasitellaan workoutteja
 * @author Laura, Karoliina, Elias
 * @version 0.1
 */
public class WorkoutClass {
    private String workoutName;
    private int gymWeight;
    private int reps;
    private int sets;

    /**
     *
     * @param workoutName String workoutin nimi
     * @param gymWeight int painojen paino
     * @param reps int toistojen määrä
     * @param sets int sarjojen määrä
     */
    public WorkoutClass(String workoutName, int gymWeight, int reps, int sets) {
        this.workoutName = workoutName;
        this.gymWeight = gymWeight;
        this.reps = reps;
        this.sets = sets;
    }

    /**
     *
     * @return palauttaa workoutin nimen
     */

    public String getWorkoutName() {
        return workoutName;
    }

    /**
     *
     * @return palauttaa painojen painon
     */

    public int getGymWeight() {
        return gymWeight;
    }

    /**
     *
     * @return palauttaa toistojen määrän
     */

    public int getReps() {
        return reps;
    }

    /**
     *
     * @return palauttaa sarjojen määrän
     */

    public int getSets() {
        return sets;
    }
}
