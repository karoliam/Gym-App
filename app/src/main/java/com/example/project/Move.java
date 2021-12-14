package com.example.project;

/**
 * Move-luokka, jossa kasitellaan liikkeita
 * @author Laura, Karoliina, Elias
 * @version 0.1
 */

public class Move {
    private final String moveName;
    private final String gymWeight;
    private final String reps;
    private final String sets;

    /**
     *
     * @param moveName String liikkeen nimi
     * @param gymWeight String painojen paino
     * @param reps String toistojen maara
     * @param sets String sarjojen maara
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
     * @return palauttaa toistojen maaran
     */

    public String getReps() {
        return reps;
    }

    /**
     *
     * @return palauttaa sarjojen maaran
     */

    public String getSets() {
        return sets;
    }

}
