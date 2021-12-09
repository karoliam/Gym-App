package com.example.project;

/**
 * Move-luokka, jossa kasitellaan liikkeitä
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
     * @param moveName String liikkeen nimi
     * @param gymWeight String painojen paino
     * @param reps String toistojen määrä
     * @param sets String sarjojen määrä
     */
    public Move(String moveName, String gymWeight, String reps, String sets) {
        this.moveName = moveName;
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
