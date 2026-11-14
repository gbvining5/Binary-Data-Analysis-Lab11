import java.io.Serializable;

/**
 * File: Lab11Prob01.java
 * Class: CSCI 1302
 * Author: Gavin Vining
 * Created on: Nov 13, 2026
 * Last Modified: Nov 13, 2026
 * Description: 
 */

public class Person implements Comparable<Person>, Serializable {
	private int age;
	private String nameFirstLast;
	private String address;
	private int zipCode;
	private double salary;
	
	public Person() {
	    this(0, "", "", 0, 0.0);
	}	
	
	
	public Person(int age, String nameFirstLast, String address, int zipCode, double salary) {
		super();
		this.age = age;
		this.nameFirstLast = nameFirstLast;
		this.address = address;
		this.zipCode = zipCode;
		this.salary = salary;
		
		
	}
	
	
	
	@Override
	public int compareTo(Person other) {
		return Double.compare(other.salary, this.salary);
	}
	@Override
	public String toString() {
	    // Same layout as Problem 1, with salary formatted as USD currency
	    return age + " " + nameFirstLast + " " + address + " " + zipCode + " "
	               + String.format(java.util.Locale.US, "$%,.2f", salary);
	}	

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNameFirstLast() {
		return nameFirstLast;
	}
	public void setNameFirstLast(String nameFirstLast) {
		this.nameFirstLast = nameFirstLast;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	
}