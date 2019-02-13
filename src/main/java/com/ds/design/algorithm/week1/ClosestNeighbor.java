package com.ds.design.algorithm.week1;

import java.util.ArrayList;
import java.util.List;

public class ClosestNeighbor {

	public static void main(String[] args) {
		ClosestNeighbor c = new ClosestNeighbor();
		int[] a = {2,3,5,6,9,10,11};
		System.out.println(c.findClosestNeighbor(a, 7));
	}
	private int findClosestNeighbor(int[] a,int target){
		List<Integer> resList = new ArrayList<Integer>();
		int low =0,high =a.length-1,mid;
		int result = -1;
		while(low<=high){
			mid = low + ((high-low)>>1);
			result = record(a, result, mid, target,resList);
			resList.add(result);
			if(a[mid]>target){
				high = mid-1;
			}
			else if(a[mid]<target){
				low = mid+1;
			}
			else{
				return mid;
			}
		}
		for(Integer i: resList){
			System.out.print(i+"\t");
		}
		System.out.println();
		return result;
	}
	private int record(int a[],int result,int mid, int key,List<Integer> resList){
		if(result == -1 || Math.abs(a[mid]-key)<Math.abs(a[result]-key)){
			return mid;
		}
		return result;
	}
}
