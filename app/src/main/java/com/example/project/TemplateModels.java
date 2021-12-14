

package com.example.project;
/**
 * Luokka asettaa nimet TemplateWorkOuts luokan listviewin elementeille
 * ja luo nimet yksittaisille treeniliikkeille.
 * @author Karoliina Multas
 * @version 0.1
 */

public class TemplateModels {
    private  String name;
    private  String exercise1;
    private  String exercise2;
    private  String exercise3;
    private  String exercise4;

    /**
     *
     * @param name treeniohjelman nimi
     * @param exercise1 ensimmaisen liikkeen nimi
     * @param exercise2 toisen liikkeen nimi
     * @param exercise3 kolmannen liikkeen nimi
     * @param exercise4 neljannen liikkeen nimi
     */
    public TemplateModels(String name, String exercise1, String exercise2, String exercise3, String exercise4) {
        this.name = name;
        this.exercise1 = exercise1;
        this.exercise2 = exercise2;
        this.exercise3 = exercise3;
        this.exercise4 = exercise4;
    }

    /**
     *
     * @return treeniohjelman nimi
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @return treeniohjelman nimi
     */
    @Override
    public String toString(){
        return name;
    }

    /**
     *
     * @return palauttaa ensimmaisen liikkeen
     */
    public String getExercise1() {
        return exercise1;
    }

    /**
     *
     * @return palauttaa toisen liikkeen
     */

    public String getExercise2() {
        return exercise2;
    }

    /**
     *
     * @return palauttaa kolmannen liikkeen
     */
    public String getExercise3() {
        return exercise3;
    }

    /**
     *
     * @return palauttaa neljannen liikkeen
     */
    public String getExercise4() {
        return exercise4;
    }

}
