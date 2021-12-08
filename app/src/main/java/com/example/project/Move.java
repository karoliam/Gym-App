package com.example.project;

/**
 * Workout-luokka, jossa kasitellaan workoutteja
 * @author Laura, Karoliina, Elias
 * @version 0.1
 */
public class Move {
    private String moveName;
    private String gymWeight;
    private String reps;
    private String sets;

    /**
     *
     * @param workoutName String workoutin nimi
     * @param gymWeight String painojen paino
     * @param reps String toistojen määrä
     * @param sets String sarjojen määrä
     */
    public Move(String workoutName, String gymWeight, String reps, String sets) {
        this.moveName = workoutName;
        this.gymWeight = gymWeight;
        this.reps = reps;
        this.sets = sets;
    }

    /**
     *
     * @return palauttaa liikkeen nimen
     */

    public String getMoveName() {
        return moveName;
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
