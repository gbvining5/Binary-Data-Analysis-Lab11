/**
 * File: Lab11Prob03.java
 * Class: CSCI 1302
 * Author: Gavin Vining
 * Created on: Nov 13, 2026
 * Last Modified: Nov 13, 2026
 * Description: Reads Person records from a binary file, sorts them by salary
 *              (highest first), writes each Person's toString() to
 *              people-salary-sorted.dat, and writes each Person object to
 *              people-salary-sorted-objects.dat
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11Prob03 {
    public static void main(String[] args) {
        ArrayList<Person> peopleArray = new ArrayList<>();

   
        try (DataInputStream din = new DataInputStream(
                new BufferedInputStream(new FileInputStream("src/people.dat")))) {
            while (true) {
                int age = din.readInt();
                String nameFirstLast = din.readUTF();
                String address = din.readUTF();
                int zipCode = din.readInt();
                double salary = din.readDouble();
                peopleArray.add(new Person(age, nameFirstLast, address, zipCode, salary));
            }
        } catch (EOFException e) {
            System.out.println("Finished reading " + peopleArray.size() + " records.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(peopleArray);
     
        try (DataOutputStream dout = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("src/people-salary-sorted.dat")))) {
            for (Person p : peopleArray) {
                dout.writeUTF(p.toString());
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

       
        try (ObjectOutputStream oout = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream("src/people-salary-sorted-objects.dat")))) {
            for (Person p : peopleArray) {
                oout.writeObject(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}