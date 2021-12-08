package com.example.project;

import java.util.ArrayList;

/**
 * Singleton-luokka workouteista
 * @author Laura, Karoliina, Elias
 * @version 0.1
 */

public class DataBaseSingleton {
    private ArrayList <Move> workoutClassArrayList;
    private static final DataBaseSingleton ourInstance = new DataBaseSingleton();

    /**
     *
     * @return palauttaa singletonin instanssin
     */
    public static DataBaseSingleton getInstance(){
        return ourInstance;
    }

    private DataBaseSingleton(){
        workoutClassArrayList = new ArrayList<Move>();

    }

    /**
     *
     * @param workout lisataan uusi workout listaan
     */

    public void addWorkout(Move workout){

        workoutClassArrayList.add(workout);
    }

    /**
     *
     * @return palauttaa kaikki workoutit
     */

    public ArrayList<Move> getWorkouts(){
        return workoutClassArrayList;
    }

    /**
     *
     * @param i int - yksittaisen workoutin indeksi
     * @return getteri palauttaa yhden workoutin
     */

    public Move getWorkout(int i){
        return workoutClassArrayList.get(i);
    }
}
