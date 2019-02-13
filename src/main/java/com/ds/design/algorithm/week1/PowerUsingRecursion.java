package com.ds.design.algorithm.week1;

public class PowerUsingRecursion {
	public static void main(String args[]){
		PowerUsingRecursion p = new PowerUsingRecursion();
		System.out.println(p.powerOfNumber(2, 10));
		double a = Double.MAX_VALUE;
		double b = Double.MAX_VALUE;
		double c = a*b;
		System.out.println(c>Double.MAX_VALUE);
	}
	private int powerOfNumber(int x,int e){
		if(e==0)
			return 1;
		return x*powerOfNumber(x, --e);
	}
}
