package com.ds.design.algorithm.week1;

public class MaxContiSubArray {

	public static void main(String[] args) {
		MaxContiSubArray m = new MaxContiSubArray();
		int[] a = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(m.maxSum(a));
		int [] b = {1,2,5,6};
		int[] r = m.givenSum(b, 8);
		System.out.println(r[0]+"\t"+r[1]);
	}
	private int maxSum(int[] a){
		int r = 0;
		int t = 0;
		int l = a.length;
		for(int i=0;i<l;i++){
			t = t + a[i];
			if(t<0){
				t = 0;
			}
			if(r<t){
				r=t;
			}
		}
		return r;
	}
	private int[] givenSum(int []a, int k){
		int x1=0;
		int r[] = new int[2];
		int l = a.length;
		for(int i=0;i<l;i++){
			x1 = x1+a[i];
			if(x1==k){
				r[1]=i;
				return r;
			}
			else if(x1>k){
				x1 = 0;
			}
			else{
				r[0] =i;
			}
		}
		return r;
	}
}
