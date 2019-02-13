package com.ds.design.algorithm.week3;

import java.util.ArrayList;
import java.util.List;

public class Recursion {

	public static void main(String[] args) {
			Recursion r = new Recursion();
//			System.out.println(r.getSumIteratively(3));
//			System.out.println(r.getSumRecursively(3));
			List<Integer> list = new ArrayList<>();
			list.add(1);
			list.add(2);
			list.add(3);
			r.printList(list, 0);
			System.out.println(r.calculatePower(3, 3));
	}
	public  void printList(List<Integer> list,int i){
		if(list.size()==i){
			return;
		}
		System.out.println(list.get(i));
		printList(list, i+1);
	}
	public int getSumIteratively(int n){
		int sum = 0;
		for(int i=1;i<=n;i++){
			sum = sum+i;
		}
		return sum;
	}
	public int getSumRecursively(int n){
		if(n<=1){
			return n;
		}
		else {
			return n + getSumIteratively(n-1);
		}
	}
	public int calculatePower(int x,int n){
		if(n==0){
			 return 1;
		}
		else {
			return x*calculatePower(x, n-1);
		}
	}
}
