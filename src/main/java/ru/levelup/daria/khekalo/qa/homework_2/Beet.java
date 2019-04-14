package ru.levelup.daria.khekalo.qa.homework_2;
// TODO неиспользуемый импорт
import java.util.*;
// TODO Почему все значения устанавливаются в конструкторе??
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
