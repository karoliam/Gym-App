package com.example.project;


public class TemplateModels {
    private  String name;
    private  String exercise1;
    private  String exercise2;
    private  String exercise3;
    private  String exercise4;


    public TemplateModels(String name, String exercise1, String exercise2, String exercise3, String exercise4) {
        this.name = name;
        this.exercise1 = exercise1;
        this.exercise2 = exercise2;
        this.exercise3 = exercise3;
        this.exercise4 = exercise4;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }


    public String getExercise1() {
        return exercise1;
    }

    public String getExercise2() {
        return exercise2;
    }

    public String getExercise3() {
        return exercise3;
    }

    public String getExercise4() {
        return exercise4;
    }

}
