package ru.levelup.daria.khekalo.qa.homework_1;

import java.util.Scanner;

public class Power {
	private static Scanner scanner;
	public static void main(String[] args){
		   scanner = new Scanner(System.in);
	        System.out.println("Input number 1 : ");
			int num1 = scanner.nextInt();
			System.out.println("Input number 2 : ");
	        int num2 = scanner.nextInt();
	        
	        
		power(num1, num2);
		int res = power(num1, num2);
		System.out.println(res);
		
	}
		static int power(int num1, int num2){
			int result = 1;
			for (int i = 1; i <=num2; i ++){
				result = result*num1;
			}
			return result; 
		}
	}
	