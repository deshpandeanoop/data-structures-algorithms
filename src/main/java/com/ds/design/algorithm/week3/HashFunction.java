package com.ds.design.algorithm.week3;

public class HashFunction {

	public static void main(String[] args) {
		Employee e1 = new Employee(1, "Anoop");
		Employee e2 = new Employee(2,"Aditya");
		System.out.println(e1==e2);
	}

	private static class Employee{
		int id;
		String name;
		public Employee(int id, String name){
			this.id = id;
			this.name = name;
		}
		public int hashCode(){
			System.out.println("I'm In Hash code");
			return -1;
		}
	}
}
