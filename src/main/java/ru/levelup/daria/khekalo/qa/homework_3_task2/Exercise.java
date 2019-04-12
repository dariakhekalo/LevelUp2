package ru.levelup.daria.khekalo.qa.homework_3_task2;

import java.util.ArrayList;
import java.util.List;

public class Exercise {
    public static void main(String[] args){

        List<Sku> list = new ArrayList<>();
        list.add(new Sku ("good 1", 76.98));
        list.add(new Sku ("good 2", 11.02));
        list.add(new Sku ("good 3", 36.18));
        list.add(new Sku ("good 4", 9.02));
        list.add(new Sku ("good 5", 99.99));
        list.add(new Sku ("good 6", 15.15));
        list.add(new Sku ("good 7", 67.17));
        list.add(new Sku ("good 8", 2.99));

        System.out.println(getSkuInRange(list,10, 40));
     //   System.out.println calculateAverage;
    }

    static List<Sku> getSkuInRange (List<Sku> inputData, double lowPrice, double highPrice) {
        List<Sku> results = new ArrayList<>();
        for (Sku item : inputData) {
            if (item.getPrice() < highPrice && item.getPrice() > lowPrice) {
                results.add(item);
            }
        }

        return results;
    }

    private double calculateAverage(List <Sku> goods) {
        double sum = 0;
        for (double i=0; i< goods.size(); i++) {
            sum += i;
        }
        return sum / goods.size();

    }


     /*   static List<Sku> getSkuAveragePrice(List<Sku> inputData, double averagePrice){
        List<Sku> result = new ArrayList<>();
            for (Sku item : inputData) {
                if (item.getPrice() > (averagePrice + 20)) {
                    result.add(item);
                }
            }
            return result;


        }
*/
    }

