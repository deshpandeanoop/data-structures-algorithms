package com.ds.design.algorithm.week1;

public class BinarySearchWithDuplicates {

	public static void main(String[] args) {
		BinarySearchWithDuplicates b  = new BinarySearchWithDuplicates();
		int a[] = {3,3,3,3,3,3,5,8,9};
		System.out.println(a[b.binarySearchWithDuplicates(a, 0)]);
	}
	private int binarySearchWithDuplicates(int[] a, int k){
		if(null == a){
			return -1;
		}
		int l  = a.length;
		int s=0;l--;int m;
		while(s<=l){
			m = s + ((l-s)>>1);
			if(a[m]==k){
				return find(a, m);
			}
			else if(a[m]>k){
				l = m-1;
			}
			else{
				s= m+1;
			}
		}
		return 0;
	}
	
	private int find(int[] a, int m){
		for(int i=m;i>0;i--){
			if(a[i] != a[i-1]){
				return i;
			}
		}
		return 0;
	}
}
