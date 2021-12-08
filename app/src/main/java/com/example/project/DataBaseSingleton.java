package com.example.project;

import java.util.ArrayList;

/**
 * Singleton-luokka workouteista
 * @author Laura, Karoliina, Elias
 * @version 0.1
 */

public class DataBaseSingleton {
    private ArrayList <Move> moveArrayList;
    private static final DataBaseSingleton ourInstance = new DataBaseSingleton();

    /**
     *
     * @return palauttaa singletonin instanssin
     */
    public static DataBaseSingleton getInstance(){
        return ourInstance;
    }

    private DataBaseSingleton(){
        moveArrayList = new ArrayList<Move>();
    }

    /**
     *
     * @param singlemove lisataan uusi singlemove listaan
     */

    public void addMove(Move singlemove){

        moveArrayList.add(singlemove);
    }

    /**
     *
     * @return palauttaa kaikki workoutit
     */

    public ArrayList<Move> getMoves(){
        return moveArrayList;
    }

    /**
     *
     * @param i int - yksittaisen workoutin indeksi
     * @return getteri palauttaa yhden workoutin
     */

    public Move getMove(int i){
        return moveArrayList.get(i);
    }
}
