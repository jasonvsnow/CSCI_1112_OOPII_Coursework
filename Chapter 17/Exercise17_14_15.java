package ch17;

import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Exercise17_14_15 {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		boolean choosing = true;
		while (choosing) {
			System.out.println("Would you like to ");
			System.out.println("1) Encrypt");
			System.out.println("2) Decrypt");
			System.out.println("3) Exit");
			System.out.print("> ");
			int choice = 0;
			try {
				choice = input.nextInt();
			}
			catch (InputMismatchException ex) {
				System.out.println("");
				input.nextLine();
				choice = 0;
			}
			if (choice == 1) {
				String sourceName = "";
				String targetName = "";
				boolean source = true;
				while (source) {
					System.out.println("Enter the name of the file you would like to encrypt.");
					System.out.print("> ");
					try {
						sourceName = input.next();
						source = false;
					}
					catch (InputMismatchException ex) {
						input.nextLine();
						sourceName = "";
						System.out.println("Invalid Input.");
					}
				}
				boolean target = true;
				while (target) {
					System.out.println("Enter the name of the file you would like to write the encryption in.");
					System.out.print("(Note: if you choose a file that does not already exist, it will be created)> ");
					try {
						targetName = input.next();
						target = false;
					}
					catch (InputMismatchException ex) {
						input.nextLine();
						targetName = "";
						System.out.println("Invalid Input.");
					}
				}
				System.out.println("");
				Encrypt.encryption(sourceName, targetName);
			
			}
			else if (choice == 2) {
				String sourceName = "";
				String targetName = "";
				boolean source = true;
				while (source) {
					System.out.println("Enter the name of the file you would like to decrypt.");
					System.out.print("> ");
					try {
						sourceName = input.next();
						source = false;
					}
					catch (InputMismatchException ex) {
						input.nextLine();
						sourceName = "";
						System.out.println("Invalid Input.");
					}
				}
				boolean target = true;
				while (target) {
					System.out.println("Enter the name of the file you would like to write the decryption in.");
					System.out.print("(Note: if you choose a file that does not already exist, it will be created)> ");
					try {
						targetName = input.next();
						target = false;
					}
					catch (InputMismatchException ex) {
						input.nextLine();
						targetName = "";
						System.out.println("Invalid Input.");
					}
				}
				System.out.println("");
				Decrypt.decryption(sourceName, targetName);
			}
			else if (choice == 3) {
				choosing = false;
				System.out.println("Program terminated.");
			}
			else  System.out.println("Invalid Input.");
		}	
	}
}

