package ru.levelup.daria.khekalo.qa.homework_3_task1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO форматиование (CTRL + ALT + l)
    public class Discriminant {

        // TODO почему всё в статик методе?
        public static void main(String[] args) throws IOException {

            // TODO А как же закрыть поток ввода/вывода
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("a, b, c : ");
            String A = reader.readLine();
            Double a = Double.parseDouble(A);
            String B = reader.readLine();
            Double b = Double.parseDouble(B);
            String C = reader.readLine();
            Double c = Double.parseDouble(C);


            double x1, x2;

            double D = b * b - 4 * a * c;
            if (a != 0) {
                if (D > 0) {
                    x1 = (-b - Math.sqrt(D)) / (2 * a);
                    x2 = (-b + Math.sqrt(D)) / (2 * a);

                    System.out.printf( "Корни уравнения: x1 = %1$.2f, x2 = %2$.2f", x1, x2);
                } else if (D == 0) {
                    double x;
                    x = -b / (2 * a);
                    System.out.printf( "Уравнение имеет единственный корень: x = %1$.2f", x);
                } else {
                    System.out.println("Уравнение не имеет действительных корней");
                }
            } else {
                System.out.println("Это не квадратное ур-ие");
            }
            System.out.printf("%.2f",D);

        }
    }

