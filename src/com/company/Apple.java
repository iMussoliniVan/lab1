package com.company;

public class Apple extends Food {
    private String size;
    private int calories;
    public Apple(String size) {
        super("Apple");
        this.size = size;
    }
    public void consume() {
        System.out.println(this + " съедено");
    }

    public int calculateCalories(){
        if (size.equals("small")){
            calories = 40;
        } else if(size.equals("average")){
            calories = 50;
        }else if (size.equals("big")){
            calories = 60;
        }
        return calories;
    }

    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            if (!(arg0 instanceof Apple)) return false;
            return size.equals(((Apple)arg0).size);
        } else
            return false;
    }
    public String toString() {
        return super.toString() + " размера '" + size.toUpperCase() + "'";
    }

}