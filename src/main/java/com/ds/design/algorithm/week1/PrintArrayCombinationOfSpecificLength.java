package com.ds.design.algorithm.week1;

public class PrintArrayCombinationOfSpecificLength {
	public static void main(String s[]){
		PrintArrayCombinationOfSpecificLength p = new PrintArrayCombinationOfSpecificLength();
		int [] a = {1,2,3};
		for(int i=0;i<a.length;i++)
		{
		int[] b = new int[i];
		p.printCombo(a, b, 0, 0, a.length,b.length);
		}
	}
	private void printCombo(int[] a, int[] b,int sI,int bI,int aL,int bL){
		// termination case
		if(bI == bL){
			print(b);
			return;
		}
		// termination case
		if(sI == aL){
			return;
		}
		// Recursive case/Recursive step
		for(int i=sI;i<aL;i++){
			b[bI] = a[i];
			printCombo(a, b, i+1, bI+1, aL, bL);
		}
	}
	private void print(int[] b){
		StringBuffer sb = new StringBuffer("[");
		for(Integer i: b){
			sb.append(i);
			sb.append(",");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		System.out.println(sb.toString());
	}
}
