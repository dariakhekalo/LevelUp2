package ru.levelup.daria.khekalo.qa.homework_2;

import java.util.Collection;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class Main {

    public static void main (String[] args) {

        List< Vegetables > soup = new ArrayList<Vegetables>();
        Potato potato = new Potato();
        Meat meat = new Meat();
        Beet beet = new Beet();
        Onion onion = new Onion();
        Water water = new Water();
        Carrot carrot  = new Carrot();

        soup.add(potato);
        soup.add(beet);
        soup.add(meat);
        soup.add(onion);
        soup.add(carrot);
        soup.add(water);

        System.out.println("White colour have: ");
        Collections.sort(soup);

        find(soup);
        System.out.println("");
        System.out.println("Ingrediens are sorted by calories: ");

        int sumCalories = 0;
        for(int i = 0; i < soup.size(); i++) {
            System.out.println(soup.get(i));
            sumCalories = sumCalories + soup.get(i).getCalorie();
        }

        System.out.println();
        System.out.println("All calories = " + sumCalories);
    }

    public static void find(List<Vegetables> soup) {
        for (Vegetables item : soup) {
            if (item.getColour().equals("white")){
                System.out.println(item);
            }
        }
    }


}
