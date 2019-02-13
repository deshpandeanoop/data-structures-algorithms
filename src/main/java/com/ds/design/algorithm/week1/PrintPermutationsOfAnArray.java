package com.ds.design.algorithm.week1;

public class PrintPermutationsOfAnArray {

	public static void main(String[] args) {
		PrintPermutationsOfAnArray p = new PrintPermutationsOfAnArray();
		int a[] = { 1, 2, 3 };
		int b[] = new int[a.length];
		boolean[] isExistsInBuffer = new boolean[a.length];
		p.printPermutations(a, b, 0, isExistsInBuffer);
	}

	private void printPermutations(int a[], int b[], int bufferIndex, boolean[] isExitsInBuffer) {
		// Termination case
		if (bufferIndex == b.length) {
			print(b);
			return;
		}
		// Recursive step/Recursive case
		for (int i = 0; i < a.length; i++) {
			if (!isExitsInBuffer[i]) {
				b[bufferIndex] = a[i];
				isExitsInBuffer[i] = true;
				printPermutations(a, b, bufferIndex + 1, isExitsInBuffer);
				isExitsInBuffer[i] = false;
			}
		}
	}

	private void print(int[] b) {
		StringBuffer sb = new StringBuffer("[");
		for (Integer i : b) {
			sb.append(i);
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		System.out.println(sb.toString());
	}
}
