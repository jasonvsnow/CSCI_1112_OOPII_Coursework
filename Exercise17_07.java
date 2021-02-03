
package ch17;

/*
 * 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmazorow
 */
import java.io.*;


/*
 * Author: Jason Snow
 * Date: 02/02/21
 * 
 * This program is modified to read the data from serialized loan objects and find the total loan amount from an undetermined number of loans
 * in a file
 */
public class Exercise17_07 {
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		Loan loan1 = new Loan();
		Loan loan2 = new Loan(1.8, 10, 10000);
		
		try ( ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat")); ) {
			output.writeObject(loan1);
			output.writeObject(loan2);
		} 
		catch (IOException ex) {
			System.out.println("File could not be opened");
		}
		
		outputData("Exercise17_07.dat");
	}
	
	public static void outputData(String string) throws ClassNotFoundException, IOException {
		Double totalLoan = 0.0;
		int numLoans = 0;
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(string));) {
			while (true) {
				Loan test = (Loan)(input.readObject());
				numLoans += 1;
				totalLoan += test.getLoanAmount();
			}
		}
		catch (EOFException ex) {
			System.out.print("All data read. Loans in File: " + numLoans + " Total Loan Amount: " + totalLoan);
		}
		
	}
}
