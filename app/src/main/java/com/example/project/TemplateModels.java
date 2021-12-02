package com.example.project;

public class TemplateModels {

    private static String name;
    private static String exercise1;
    private static String exercise2;
    private static String exercise3;
    private static String exercise4;
    private static String exercise5;
    private static String exercise6;

    public TemplateModels(String name, String exercise1, String exercise2, String exercise3, String exercise4, String exercise5, String exercise6) {
        this.name = name;
        this.exercise1 = exercise1;
        this.exercise2 = exercise2;
        this.exercise3 = exercise3;
        this.exercise4 = exercise4;
        this.exercise5 = exercise5;
        this.exercise6 = exercise6;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }

    public static String getExercise1() {
        return exercise1;
    }

    public static String getExercise2() {
        return exercise2;
    }

    public static String getExercise3() {
        return exercise3;
    }

    public static String getExercise4() {
        return exercise4;
    }

    public static String getExercise5() {
        return exercise5;
    }

    public static String getExercise6() {
        return exercise6;
    }
}
