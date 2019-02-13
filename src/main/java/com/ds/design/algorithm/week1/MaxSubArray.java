package com.ds.design.algorithm.week1;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArray {

	public static void main(String[] args) {
		MaxSubArray max = new MaxSubArray();
		int[] a = {2,4,-2,1,-3,5,-3 };
		Pair p = max.new Pair(0, -1);
//		while(p.start !=-1 ){
//			p = max.getMaxSubArrayWithOnlyPositiveValues(0, a, p.last+1);
//			System.out.println(p);
//		}
		
		Pair p1 = max.new Pair(0, -1);
//		while(p1.start !=-1 ){
			p1 = max.getMaxSubArrayWithNegAndPositive(a,p.last+1,0);
			System.out.println(p1);
	//	}
		//getMaxSubArrayWithNegAndPositive
	}

	private Pair getMaxSubArrayWithOnlyPositiveValues(int target, int[] a, int start) {
		Pair p = new Pair(-1, -1);
		if(start>=a.length){
			return p;
		}
		int s =start,l=start;
		int sum = a[start];
		while (s < a.length && l < a.length) {
			if (sum < target) {
				l++;
				if (l < a.length) {
					sum = sum + a[l];
				}
			} else if (sum > target) {
				sum = sum - a[s++];
			} 
			else if (s>l){
				l =s ;
				sum= a[s];
			}else {
				p.start = s;
				p.last = l;
				return p;
			}
		}
		return p;
	}
	private Pair getMaxSubArrayWithNegAndPositive(int[] a, int start, int target){
		Pair p = new Pair(-1, -1);
		if(start>=a.length){
			return p;
		}
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		int sum = 0;
		for(int i = start; i<a.length;i++){
			sum = sum + a[i];
			if(sum == target){
				p.start = 0;
				p.last = i;
				return p;
			}
			if(map.containsKey(sum)){
				p.start = map.get(sum)+1;
				p.last = i;
				return p;
			}
			map.put(sum, i);
		}
		return p;
	}
	private class Pair {
		int start;
		int last;

		public Pair(int start, int last) {
			super();
			this.start = start;
			this.last = last;

		}

		public String toString() {
			return "[ " + start + ", " + last + " ]";
		}
	}
}
