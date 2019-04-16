package ru.levelup.daria.khekalo.qa.homework_2;

// TODO Не используемый импорт
import java.util.*;
public abstract class Vegetables implements Comparable<Vegetables>{

	// TODO Модификатор доступа какой должен быть?
	int weight;
	int calorie;
    String colour;



    public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getCalorie() {
		return calorie;
	}
	protected void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	

    public int compareTo(Vegetables other)
	{
		if (weight < other.weight)
			return -1;
		else if (weight > other.weight)
			return 1;
		else
			return 0;
	}
    
    
    
}
