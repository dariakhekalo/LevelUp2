package ru.levelup.daria.khekalo.qa.homework_1;

import java.util.Scanner;

public class Calculate {

	public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number 1 : ");
		int num1 = scanner.nextInt();
	    double number1 =scanner.nextDouble();
	    
		System.out.println("Input number 2 : ");
        int num2 = scanner.nextInt();
        double number2 =scanner.nextDouble();
     //   int result = scanner.nextInt();
        System.out.println("Input operation: ");
        String operation = scanner.next();
        
        calc(num1,num2, number1, number2, operation);
        int res = calc(num1,num2, number1, number2, operation);
        System.out.println("Your result is: " + res);
        
	}
   //    double result = num1 - num2;


        public static int calc(int num1, int num2,double number1, double number2, String operation){

            int result=-1;
            double result1 =-1;
			switch (operation){
                case "+":
                    result = num1+num2;
                    result1 = number1 + number2;
                    break;
                case "-":
                    result = num1-num2;
                    break;
                case "*":
                    result = num1*num2;
                    break;
                default:
                    System.out.println("wrong");
            }
            return result;
        }
}

