package com.example.project;

import java.util.ArrayList;

/**
 * Singleton-luokka liikkeista
 * @author Laura Immonen
 * @version 0.1
 */

public class DataBaseSingleton {
    private ArrayList <Workout> workoutArrayList;
    private static final DataBaseSingleton ourInstance = new DataBaseSingleton();

    /**
     *
     * @return palauttaa singletonin instanssimuuttujan
     */
    public static DataBaseSingleton getInstance(){
        return ourInstance;
    }

    private DataBaseSingleton(){
        workoutArrayList = new ArrayList<Workout>();
    }

    /**
     *
     * @param workout lisataan uusi liike listaan
     */

    public void addWorkout(Workout workout){

        workoutArrayList.add(workout);
    }

    /**
     *
     * @return palauttaa kaikki liikkeet
     */

    public ArrayList<Workout> getWorkouts(){
        return workoutArrayList;
    }

    /**
     *
     * @param i int - yksittaisen liikeen indeksi
     * @return getteri palauttaa yhden liikkeen
     */

    public Workout getWorkout(int i){
        return workoutArrayList.get(i);
    }

    /**
     *
     * @param workouts setteri asettaa workoutit ArrayListiin
     */

    public void setWorkouts(ArrayList <Workout> workouts){
       this.workoutArrayList = workouts;
    }

}
