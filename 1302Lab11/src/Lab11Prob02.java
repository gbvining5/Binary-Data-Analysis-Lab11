/**
 * File: Lab11Prob02.java
 * Class: CSCI 1302
 * Author: Gavin Vining
 * Created on: Nov 13, 2026
 * Last Modified: Nov 13, 2026
 * Description: Reads Person records from a binary file, prints them to the
 *              console, and writes an exact binary copy to people-copy.dat
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11Prob02 {
	public static void main(String[] args)  {
		
		
		ArrayList<Person> peopleArray = new ArrayList<>();
		try (
				DataInputStream din = new DataInputStream(
						new BufferedInputStream(new FileInputStream("src/people.dat")));)	
				{
			while (true) {	
			int age = din.readInt();
			String nameFirstLast = din.readUTF();
			String address = din.readUTF();
			int zipCode = din.readInt();
			double salary = din.readDouble();			
			peopleArray.add(new Person(age, nameFirstLast, address, zipCode, salary));	
			
			System.out.println(age);
			System.out.println(nameFirstLast);
			System.out.println(address);
			System.out.println(zipCode);
			System.out.println(salary);
			System.out.println();
			}
		}catch(EOFException e) {
			 System.out.println("Finished reading " + peopleArray.size() + " records.");
		} catch(Exception e) {			
			e.printStackTrace();
		}
		
		
		Collections.sort(peopleArray);
		
		try (DataOutputStream dout = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("src/people-salary-sorted.dat")))){

		for(Person p: peopleArray ) {
			dout.writeUTF(p.toString());
		}
//		dout.writeInt(age);
//		dout.writeUTF(nameFirstLast);
//		dout.writeUTF(address);
//		dout.writeInt(zipCode);
//		dout.writeDouble(salary);
//		
		} catch (IOException e)	{
			e.printStackTrace();
		}
		
	// test
		
		
		}
	}
	
	


