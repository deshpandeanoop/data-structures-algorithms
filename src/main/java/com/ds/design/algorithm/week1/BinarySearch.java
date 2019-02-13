package com.ds.design.algorithm.week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinarySearch {

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		BinarySearch b = new BinarySearch();
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		System.out.println(b.binarySearch(a, 7));
	}
	private int binarySearch(int a[],int k){
		if(null == a){
			return -1;
		}
		int l = a.length;
		int s=0;l--;int mid;
		while(s<=l){
			// using bitwise operation for better performance,
			// Also, to calculate mid value, (s+l)/2 formula is not preferred since 
			// mid value may over flow if in case 's' & 'l' value are big/large
			mid = s+ ((l-s)>>1);
			if(a[mid]==k){
				return mid;
			}
			else if(a[mid]<k){
				s = mid+1;
			}
			else{
				l = mid-1;
			}
		}
		return -1;
	}
}
