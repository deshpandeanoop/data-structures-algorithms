package com.ds.design.algorithm.week1;

public class SortColor {
	public static void main(String args[]) {
		SortColor s = new SortColor();
		// Red : 0, White: 1, Blue : 2
		int a[] = { 0, 1, 2, 0, 1, 2, 2, 1, 2, 2, 1, 2 };
		s.sortColors(a, 0);
		s.sortColors(a, 1);
		s.sortColors(a, 2);
		for (Integer i : a) {
			System.out.print(i + "\t");
		}
	}

	private void sortColors(int[] a, int p) {
		int l = -1, h = a.length, m = -1;
		while (m + 1 < h) {
			if (a[m + 1] == p) {
				m++;
			} else if (a[m + 1] > p) {
				swapElements(a, m + 1, h - 1);
				h--;
			} else {
				swapElements(a, m + 1, l + 1);
				l++;
				m++;
			}
		}
	}

	private void swapElements(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
