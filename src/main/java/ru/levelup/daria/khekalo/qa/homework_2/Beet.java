package ru.levelup.daria.khekalo.qa.homework_2;
import java.util.*;
public class Beet extends Vegetables {

    public Beet() {
        setCalorie(10);
        setWeight(200);
        setColour("violet");
    }

    public int compareTo(Vegetables other) {
        return super.compareTo(other);
    }
}
