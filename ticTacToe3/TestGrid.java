package ticTacToe3;

public class TestGrid {
	// int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
	int[] Col = new int[3];
	int counter = 0;
	public char[] getColumn(char[][] array, int index) {
		char[] column = new char[array[0].length];
		for (int i = 0; i < column.length; i++) {
			column[i] = array[i][index];
		}
		return column;
	}

	public char[] getRow(char[][] array, int x) {
		char[] row = new char[array.length];
		for (int i = 0; i < row.length; i++) {
			row[i] = array[x][i];
		}
		return row;
	}

	public char[] getDiagonal1(char[][] array) {
		char[] diagonal1 = new char[array.length];
		diagonal1[0] = array[0][0];
		diagonal1[1] = array[1][1];
		diagonal1[2] = array[2][2];
		return diagonal1;
	}

	public char[] getDiagonal2(char[][] array) {
		char[] diagonal2 = new char[array.length];
		diagonal2[0] = array[0][2];
		diagonal2[1] = array[1][1];
		diagonal2[2] = array[2][0];
		return diagonal2;
	}
}