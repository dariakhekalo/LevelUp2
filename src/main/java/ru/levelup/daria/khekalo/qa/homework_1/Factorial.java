package ru.levelup.daria.khekalo.qa.homework_1;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args){
	 Scanner scanner = new Scanner(System.in);
	 System.out.println("Input number 1 : ");
		int n = scanner.nextInt();
		
		factorial(n);
		int res = factorial(n);
		System.out.println(res);
		
	}
		static int factorial(int n){
			int result = 1;
			for (int i = 1; i <=n; i ++){
				result = result*i;
			}
			return result; 
		}
	}
	