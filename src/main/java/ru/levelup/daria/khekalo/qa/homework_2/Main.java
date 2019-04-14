package ru.levelup.daria.khekalo.qa.homework_2;

// TODO Не используемые импорты
import java.util.Collection;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

/* TODO
        стартовым для решения вашей задачи. Пример:
        public class ApplicationName {
            public static void main(String[] args) {
                ApplicationName app = new ApplicationName();
                app.startApplication();
            }
            public void startApplication() {
                //далее выполняется приложение
            }
        }
 */
/* TODO
    1. Классы сделанны однообразно
    2. Все поля объектов должны заполняться из основной программы, а не из самих классов
    3. Классы должны содержать уникальные поля, а не не только поля родительского класса
*/
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
        // TODO Для чего сортировка???
        Collections.sort(soup);

        find(soup);
        System.out.println("");
        System.out.println("Ingrediens are sorted by calories: ");

        int sumCalories = 0;
        for(int i = 0; i < soup.size(); i++) {
            System.out.println(soup.get(i));
            // TODO Можно упростить запись
            sumCalories = sumCalories + soup.get(i).getCalorie();
        }

        System.out.println();
        System.out.println("All calories = " + sumCalories);
    }

    // TODO не понятно что ищем и по какому критерию
    public static void find(List<Vegetables> soup) {
        for (Vegetables item : soup) {
            if (item.getColour().equals("white")){
                System.out.println(item);
            }
        }
    }


}
