package com.company;

public class Cheese extends Food {
    private int calories;
    public Cheese() {
        super("Cheese");
    }
    public void consume() {
        System.out.println(this + " съеден");
    }

    public int calculateCalories(){
        calories = 300;
        return calories;
    }

}