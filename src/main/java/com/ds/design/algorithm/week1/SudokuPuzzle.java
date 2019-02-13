package com.ds.design.algorithm.week1;

import java.util.Scanner;

public class SudokuPuzzle {
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
		scanner.close();
	}

	private static boolean sudoku(int[][] a, int i, int j) {
		
		return true;
	}

	// Helper Functions
	private static boolean isSafe(int[][] a, int i, int j) {
		return !isInRow(a, i, j) && !isInColumn(a, i, j) && !isInMatrix(a, i, j);
	}

	private static boolean isInRow(int[][] a, int row, int number) {
		for (int k = 0; k < a.length; k++) {
			// Grid, board will be an 2X2 square matrix
			if (a[row][k] == number) {
				return true;
			}
		}
		return false;
	}

	private static boolean isInColumn(int[][] a, int column, int number) {
		for (int k = 0; k < a.length; k++) {
			if (a[k][column] == number) {
				return true;
			}
		}
		return false;
	}

	private static boolean isInMatrix(int[][] a, int row, int column) {
		row = row - row%3;
		column = column - column%3;
		return false;
	}
}
