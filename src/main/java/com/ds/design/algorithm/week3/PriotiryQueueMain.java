package com.ds.design.algorithm.week3;

import java.util.PriorityQueue;
public class PriotiryQueueMain {

	public static void main(String[] args) {
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		heap.add(3);
		heap.add(2);
		heap.add(1);
		System.out.println(heap.poll());
	}

}
