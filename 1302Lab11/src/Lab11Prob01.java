

/**
 * File: Lab11Prob01.java
 * Class: CSCI 1302
 * Author: Gavin Vining
 * Created on: Nov 13, 2026
 * Last Modified: Nov 13, 2026
 * Description: Reads Person records from a binary file, prints them to the
 *              console, and writes an exact binary copy to people-copy.dat
 */


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
public class Lab11Prob01 {
public static void main(String[] args) {
	try (
			DataInputStream din = new DataInputStream(new BufferedInputStream(new FileInputStream("src/people.dat")));
			DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("src/people-copy.dat"))
			);
				)
			{
		while (true) {
		
		int age = din.readInt();
		String nameFirstLast = din.readUTF();
		String address = din.readUTF();
		int zipCode = din.readInt();
		double salary = din.readDouble();
		
		System.out.printf("%d %s %s %d %.2f%n", age, nameFirstLast, address, zipCode, salary);
		
		dout.writeInt(age);
		dout.writeUTF(nameFirstLast);
		dout.writeUTF(address);
		dout.writeInt(zipCode);
		dout.writeDouble(salary);
		
		
		
		}
	}catch(EOFException e) {
	//	System.out.println("Finished copying file.");
		
	} catch(Exception e) {
		e.printStackTrace();
	}
		


}


}
