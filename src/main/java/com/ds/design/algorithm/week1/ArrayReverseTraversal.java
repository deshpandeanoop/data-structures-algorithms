package com.ds.design.algorithm.week1;

public class ArrayReverseTraversal {
	public static void main(String ar[]){
		ArrayReverseTraversal t = new ArrayReverseTraversal();
		int a[] = {2,-1};
		t.shiftEvenElements(a);
	}
	public void shiftEvenElements(int a[]){
		int l = a.length;
		int e = lastElement(a, l);
		for(int i=e;i>=0;i--){
			if(a[i]%2==0){
				a[--l] = a[i];
				a[--l] = a[i];
			}
			else{
				a[--l] = a[i];
			}
		}
		print(a,l);
	}
	private int lastElement(int a[],int length){
		for(int i=length-1;i>=0;i--){
			if(a[i] != -1){
				return i;
			}
		}
		return 0;
	}
	private void print(int[] a, int b){
		for(int i =b;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
	}
}
