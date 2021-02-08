package ch18;

import java.util.*;

/*
 * Author: Jason Snow
 * Date: 02/08/21
 * 
 * This program uses recursion to display the reverse of a string entered by the user.
 */
public class Programming18_09 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a string to reverse: ");
		String value = input.next();
		System.out.print("Reversed string: ");
		reverseDisplay(value);
	}
	
	
	public static void reverseDisplay(String value) {
		int le = value.length();
		System.out.print(value.charAt(le-1));
		if ((le-1) > 0) {
			char[] ch = new char[le-1];
			for (int i = 0; i < le-1; i++) {
				ch[i] = value.charAt(i);
			}
			reverseDisplay(String.valueOf(ch));
		}
	}
}
