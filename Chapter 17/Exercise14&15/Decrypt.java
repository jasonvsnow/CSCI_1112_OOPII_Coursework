package ch17;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Decrypt {
	public static void decryption(String sourceFileName, String targetFileName) throws IOException {
		Scanner input = new Scanner(System.in);
		File file = new File(sourceFileName);
		File test = new File(targetFileName);
		if (file.exists()) {
			if (test.exists()) {
				boolean checking = true;
				while (checking) {
					System.out.println("Target file already exists. Do you want to overwrite the data in this file?");
					System.out.print("(Y for yes N for no)> ");
					String hold = "";
					try { 
						hold = input.next();
						}
					catch (InputMismatchException ex) {
						input.nextLine();
						hold = "";
					}
					if (hold.equalsIgnoreCase("y")) {
						checking = false;
						try (RandomAccessFile source = new RandomAccessFile(sourceFileName, "r")) {
							RandomAccessFile target = new RandomAccessFile(targetFileName, "rw");
							target.setLength(0);
							while (true) {
								target.write((byte)(source.readByte() - 5));
							}
						}
						catch (EOFException ex) {
							System.out.println("File decrypted.");
						}
					}
					else if (hold.equalsIgnoreCase("n")) {
						checking = false;
						System.out.println("Terminating decryption.");
					}
					else {
						System.out.println("Invalid input.");
					}
				}
				
			}
			else {
				try (RandomAccessFile source = new RandomAccessFile(sourceFileName, "r")) {
					RandomAccessFile target = new RandomAccessFile(targetFileName, "rw");
					target.setLength(0);
					while (true) {
						target.write((byte)(source.readByte() - 5));
					}
				}
				catch (EOFException ex) {
					System.out.println("File decrypted.");
				}
			}
		}
		else System.out.println("Source file does not exist. Only existing files can be decrpyted.");
	}

}
