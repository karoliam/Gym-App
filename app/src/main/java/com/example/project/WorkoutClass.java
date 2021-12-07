package com.example.project;

/**
 * Workout-luokka, jossa kasitellaan workoutteja
 * @author Laura, Karoliina, Elias
 * @version 0.1
 */
public class WorkoutClass {
    private String workoutName;
    private String gymWeight;
    private String reps;
    private String sets;

    /**
     *
     * @param workoutName String workoutin nimi
     * @param gymWeight int painojen paino
     * @param reps int toistojen määrä
     * @param sets int sarjojen määrä
     */
    public WorkoutClass(String workoutName, String gymWeight, String reps, String sets) {
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

    public String getGymWeight() {
        return gymWeight;
    }

    /**
     *
     * @return palauttaa toistojen määrän
     */

    public String getReps() {
        return reps;
    }

    /**
     *
     * @return palauttaa sarjojen määrän
     */

    public String getSets() {
        return sets;
    }
}
