package com.example.project;

public class TemplateIntegers {
    private int weights;
    private int sets;
    private int reps;

    public TemplateIntegers(int weights, int sets, int reps) {
        this.weights = weights;
        this.sets = sets;
        this.reps = reps;
    }

    public int getWeights() {
        return weights;
    }

    public int getSets() {
        return sets;
    }

    public int getReps() {
        return reps;
    }
}
