package com.ds.design.algorithm.week1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MazeProblem {

	public static void main(String[] args) {
		
		  Scanner scanner = new Scanner(System.in); 
		  int row = scanner.nextInt(); 
		  int col = scanner.nextInt(); 
		  int a[][] = new int[row][col]; 
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				a[i][j] = scanner.nextInt();
			}
		}	  
		  System.out.println(mazeWithDownRightMovement(a, 0, 0));
		  Set<Pair<Integer>> set = new HashSet<>();
		  System.out.println(mazeWithFourDirections(a, 0, 0, set));
		  scanner.close();
	}

	private static boolean mazeWithDownRightMovement(int[][] a, int i, int j) {
		// Base Case/termination case: When to pop function call from stack
		// (stack used by current Thread)
		if (isOutOfBound(a, i, j) || a[i][j] == 1) {
			return false;
		}
		if (i == a.length - 1 && j == a[0].length - 1) {
			return true;
		}
		// Recursive step/ either do something or pop the function call from
		// stack (stack used by current Thread)
		if (mazeWithDownRightMovement(a, i + 1, j)) {
			return true;
		}
		if (mazeWithDownRightMovement(a, i, j + 1)) {
			return true;
		}
		return false;
	}

	private static boolean mazeWithFourDirections(int[][] a, int i, int j, Set<Pair<Integer>> set) {
		Pair<Integer> ij = new Pair<Integer>(i, j);
		// Base case/termination case: When to pop function call from stack
		// (call stack used by current Thread)
		if (isOutOfBound(a, i, j) || a[i][j] == 1 || set.contains(ij)) {
			return false;
		}
		if (i == a.length - 1 && a[0].length - 1 == j) {
			return false;
		}
		set.add(ij);
		// Recursive step/ either do something or pop the function call from the
		// stack
		// (call stack used by current Thread)
		if (mazeWithFourDirections(a, i + 1, j, set) || mazeWithFourDirections(a, i - 1, j, set)
				|| mazeWithFourDirections(a, i, j - 1, set) || mazeWithDownRightMovement(a, i, j + 1)) {
			return true;
		}
		set.remove(ij);
		return false;
	}

	private static boolean isOutOfBound(int[][] a, int i, int j) {
		int row = a.length;
		int column = a[0].length;
		if (i == row || j == column || i==-1 || j == -1) {
			return true;
		}
		return false;
	}

	public static class Pair<T> {
		T i;
		T j;

		public Pair(T i, T j) {
			this.i = i;
			this.j = j;
		}

		@SuppressWarnings("unchecked")
		public boolean equals(Object pair) {
			Pair<T> pair1 = (Pair<T>) pair;
			if (this.i == pair1.i && this.j == pair1.j) {
				return true;
			}
			return false;
		}

		public int hashCode() {
			return this.i.hashCode() ^ this.j.hashCode();
		}
	}
}
