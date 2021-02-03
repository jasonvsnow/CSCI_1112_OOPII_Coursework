package ch17;

import java.io.*;

public class Exercise17_03 {
	public static void main(String[] args) throws IOException {
		Ex1703.Write();
		Ex1703.Sum();
	}
}


class Ex1703 {
	private static File source = new File("Exercise17_03.dat");
	
	public static void Write() throws IOException {
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
	
	public static void Sum() throws IOException {
		int count = 0;
		int sum = 0;
		if (source.exists()) {
			DataInputStream input = new DataInputStream(new FileInputStream(source)); 
			try {
				while (true) {
					int hold = input.readInt();
					input.readUTF();
					sum += hold;
					count += 1;
				}
			}
			catch (EOFException ex) {
				System.out.println("");
				System.out.print("All data read. Integers in File: " + count + " Sum of integers: " + sum);
			}
		}
		else System.out.print("No file found.");
	}
	
}
