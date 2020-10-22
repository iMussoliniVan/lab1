package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.*;

public class Main{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Food[] breakfast = new Food[20];
        String[] temp = new String[6];
        for(int i = 0; i < temp.length; i++){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            temp[i] = reader.readLine();
        }
        int itemsSoFar = 0;
        boolean checkCalories = false;
        boolean checkSort = false;
        for (String arg: temp) {
            String[] parts = arg.split("/");
            try {
                Class myClass = Class.forName("com.company." + parts[0]);
                if (parts.length == 1) {
                    Constructor constructor = myClass.getConstructor();
                    breakfast[itemsSoFar] = (Food)constructor.newInstance();
                    itemsSoFar++;
                } else if (parts.length == 2) {
                    Constructor constructor = myClass.getConstructor(String.class);
                    breakfast[itemsSoFar] = (Food)constructor.newInstance(parts[1]);
                    itemsSoFar++;
                }else if(parts.length == 3){
                    Constructor constructor = myClass.getConstructor(String.class, String.class);
                    breakfast[itemsSoFar] = (Food)constructor.newInstance(parts[1], parts[2]);
                    itemsSoFar++;
                }
            } catch (ClassNotFoundException | NoSuchMethodException e){
                if(parts[0].equals("-calories")){
                    checkCalories = true;
                    continue;
                }else if(parts[0].equals("-sort")){
                    checkSort = true;
                    continue;
                }
                System.out.println("Продукт " + parts[0] + " не может быть включен в завтрак");
            }
        }
        if(checkCalories){
            int calories = 0;
            int i = 0;
            while (breakfast[i] != null){
                calories += breakfast[i].calculateCalories();
                i++;
            }
            System.out.println("Количество калорий в завтраке равно: " + calories);
        }
        if(checkSort){
            Arrays.sort(breakfast, new Comparator() {
                public int compare(Object f1, Object f2) {
                    if (f1==null || ((Food)f1).calculateCalories() < (((Food)f2).calculateCalories())) {
                        return 1;
                    }else if(f2==null || ((Food)f2).calculateCalories() < (((Food)f1).calculateCalories())){
                        return -1;
                    }else{
                        return 0;
                    }
                }
            });
        }
        for (Food item: breakfast)
            if (item!=null)
                item.consume();
            else
                break;
        System.out.println("Всего хорошего!");
    }
}
