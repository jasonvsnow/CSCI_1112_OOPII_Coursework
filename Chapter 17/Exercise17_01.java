package ch17;

import java.io.*;

/*
 * Author: Jason Snow
 * Date: 02/01/21
 * 
 * This program creates a file named Exercise 17_01.txt unless it already exists.
 * The program then writes 100 random integers into the file using text I/O. It appends 
 * 100 integers if the file already exists. There is a space between each integer.
 */
public class Exercise17_01 {
	public static void main(String[] args) throws IOException {
		File source = new File("Exercise17_01.txt");
		if (source.exists()) {
			DataOutputStream output = new DataOutputStream(new FileOutputStream(source, true));
			for (int i = 0; i < 100; i++) {
				int hold = (int)(Math.random()*100);
				output.writeInt(hold);
				output.writeUTF(" ");
			}
		}
		else {
			source.createNewFile();
			DataOutputStream output = new DataOutputStream(new FileOutputStream(source));
			for (int i = 0; i < 100; i++) {
				int hold = (int)(Math.random()*100);
				output.writeInt(hold);
				output.writeUTF(" ");
			}
		}
	}
}
