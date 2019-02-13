package com.ds.design.algorithm.week1;

public class ShiftZeroesToRight {

	public static void main(String[] args) {
		int[] a = { 0, 1, 2, 3, 0 };
		ShiftZeroesToRight s = new ShiftZeroesToRight();
		a = s.shiftZerosToRight(a);
		for (Integer i : a) {
			System.out.print(i + "\t");
		}
		System.out.println();
		int[] b = { 0, 1, 0, 2, 0, 3, 0 };
		b = s.shiftZeroesToLeft(b);
		for (Integer i : b) {
			System.out.print(i + "\t");
		}
	}

	private int[] shiftZerosToRight(int[] a) {
		int c = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				a[c++] = a[i];
			}
		}
		for (int i = c; i < a.length; i++) {
			a[i] = 0;
		}
		return a;
	}

	private int[] shiftZeroesToLeft(int[] a) {
		int c = a.length - 1;
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] != 0) {
				a[c--] = a[i];
			}
		}
		for (int i = c; i >= 0; i--) {
			a[i] = 0;
		}
		return a;
	}
}
