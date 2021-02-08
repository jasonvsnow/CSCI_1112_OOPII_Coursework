package ch18;

import java.util.*;

/*
 * Author: Jason Snow
 * Date: 02/08/21
 * 
 * This program asks for two integers and, using recursion, finds the greatest common divisor of the two. 
 */
public class Programming18_03 {
	public static void main(String[] args) {
		int m = 0;
		int n = 0;
		int checker = 0;
		Scanner input = new Scanner(System.in);
		boolean correct = true;
		while (correct) {
			System.out.println("This program finds the greatest common divisor of two numebrs.");
			System.out.print("Enter an integer: ");
			try {
				m = input.nextInt();
				checker += 1;
			}
			catch (InputMismatchException ex) {
				input.nextLine();
			}
			System.out.print("Enter a second integer: ");
			try {
				n = input.nextInt();
				checker += 1;
			}
			catch (InputMismatchException ex) {
				input.nextLine();
			}
			if (checker == 2) correct = false;
			else {
				checker = 0;
				System.out.println("One of your inputs was invalid. Please enter new inputs.");
			}
			
		}
		int i = 0;
		if (m > n) {
			if (n == 0) {
				i = m;
			}
			else i = test(m, n);
		}
		else if (n > m) {
			if (m == 0) {
				i = n;
			}
			else i = test(n, m);
		}
		else if (m == n) {
			i = m;
		}
		System.out.print("The greatest common divsior of " + m + " and " + n + " is " + i);
			
		
		
		
	}
	
	
	public static int test(int m, int n) {
		if ((m%n) == 0) {
			return n;
		}
		else {
			return test(n, (m%n));
		}
	}
}
