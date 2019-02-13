package com.ds.design.algorithm.week3;

public class MergeSortedArrays {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int b[] = { 2, 4, 6, 8, 10 };
		int[] c = mergeSortedArray(a, b);
		for (Integer i : c) {
			System.out.print(i + "\t");
		}
	}

	public static int[] mergeSortedArray(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		int i = 0, j = 0;
		int k = 0;
		while (i < a.length && j < b.length) {
			if (a[i] <= b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}
		if (i != a.length) {
			for (int p = i; p < a.length; p++) {
				c[k++] = a[p];
			}
		}
		if (b.length != j) {
			for (int p = j; p < b.length; p++) {
				c[k++] = b[p];
			}
		}
		return c;
	}
	
	public static void mergeRecursively(int[][]a,int[] res,int  l){
		if(l==a.length){
			return;
		}
			
			mergeRecursively(a, res, l+1);
	}
}
