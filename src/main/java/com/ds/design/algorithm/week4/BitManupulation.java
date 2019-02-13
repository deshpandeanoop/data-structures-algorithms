package com.ds.design.algorithm.week4;

import java.util.Arrays;

public class BitManupulation {

	public static void main(String[] args) {
		long number = -2;
		System.out.println("Before Flipping : "+Long.toBinaryString(number)+"\t After Filipping : "+Long.toBinaryString(flipAllBits(number)));
		System.out.println(true ^ true);
		
	}
	public static long flipAllBits(long number){
		return (~0)^number;
	}
}
