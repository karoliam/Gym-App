package com.example.project;

import java.util.ArrayList;

/**
 * Singleton-luokka workouteista
 * @author Laura, Karoliina, Elias
 * @version 0.1
 */

public class DataBaseSingleton {
    private ArrayList <WorkoutClass> workoutClassArrayList;
    private static final DataBaseSingleton ourInstance = new DataBaseSingleton();

    /**
     *
     * @return palauttaa singletonin instanssin
     */
    public static DataBaseSingleton getInstance(){
        return ourInstance;
    }

    private DataBaseSingleton(){
        workoutClassArrayList = new ArrayList<WorkoutClass>();
    }

    /**
     *
     * @param workout lisataan uusi workout listaan
     */

    public void addWorkout(WorkoutClass workout){
        workoutClassArrayList.add(workout);
    }

    /**
     *
     * @return palauttaa kaikki workoutit
     */

    public ArrayList<WorkoutClass> getWorkouts(){
        return workoutClassArrayList;
    }

    /**
     *
     * @param i int - yksittaisen workoutin indeksi
     * @return getteri palauttaa yhden workoutin
     */

    public WorkoutClass getWorkout(int i){
        return workoutClassArrayList.get(i);
    }
}
