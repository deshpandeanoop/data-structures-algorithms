package com.ds.design.algorithm.week1;

public class DutchNationalFlag {

	public static void main(String[] args) {
		DutchNationalFlag d = new DutchNationalFlag();
		d.start();
	}
	private void start(){
		int [] a = {3,5,2,6,8,4,4,6,4,4,3};
		a = reArrange(a, 5);
		for(Integer i : a){
			System.out.print(i+"\t");
		}
	}
	private int[] reArrange(int a[],int p){
		int l=-1,m=-1,h=a.length;
		while(m+1 < h){
			if(a[m+1]==p){
				m++;
			}
			else if (a[m+1]>p){
				swapElements(a, m+1, h-1);
				h--;
			}
			else{
				swapElements(a, m+1, l+1);
				l++;
				m++;
			}
		}
		return a;
	}
	private int[] swapElements(int[] a,int i, int j){
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
		return a;
	}
}
