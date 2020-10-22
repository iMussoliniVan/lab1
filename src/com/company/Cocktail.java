package com.company;

public class Cocktail extends Food{
    private String drink;
    private String fruit;
    private int caloriesFruit;
    private int caloriesDrink;

    public Cocktail(String drink, String fruit) {
        super("Cocktail");
        this.drink = drink;
        this.fruit = fruit;
    }

    public String getDrink() {
        return drink;
    }

    public String getFruit(){
        return fruit;
    }

    public void setDrink(String drink){
        this.drink = drink;
    }

    public void setFruit(String fruit){
        this.fruit = fruit;
    }

    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Cocktail)) {
                return false;
            } else{
                if (drink.equals(((Cocktail) arg0).drink) && fruit.equals(((Cocktail) arg0).fruit)) {
                    return true;
                }else {
                    return false;
                }
            }
        } else
            return false;
    }

    public String toString() {
        return super.toString() + " из напитка '" + drink.toUpperCase() + "' и фрукта '" + fruit.toUpperCase() + "'";
    }

    public void consume(){
        System.out.println(this + " выпит");
    }

    public int calculateCalories(){
        caloriesDrink = 78;
        caloriesFruit = 65;
        return caloriesDrink + caloriesFruit;
    }
}
