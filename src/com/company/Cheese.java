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

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (arg0 instanceof Cheese){
                return true;
            }else{
                return false;
            }
        } else
            return false;
    }

}