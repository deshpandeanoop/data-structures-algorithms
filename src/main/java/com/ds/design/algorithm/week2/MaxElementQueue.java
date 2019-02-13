package com.ds.design.algorithm.week2;

public class MaxElementQueue {
private final int size;
private int[] mainQ;
private int f1=-1,f=-1,r1=-1,r2=-1;
// Double ended queue
private int[] maxQ;
public MaxElementQueue(int size) {
	this.size = size;
	mainQ = new int[size];
	maxQ = new int[size];
}
public void enQueue(int data){
	mainQ[++r1] = data;
	if(f1==-1){
		f1++;
	}
}
public void deQueue(){
	
}
public int getMax(){
	return -1;
}
}
