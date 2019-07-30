package ticTacToe3;

import java.util.Arrays;

public class GameHandler {
	// this my board
	public char[][] board = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };

	// puts the mark in the coordinates
	public void makeMove(int row, int col, char mark) {
		if (validateMove(row, col, mark)) {
			board[row][col] = mark;
		} else {
			System.out.println("illegal move");
		}
	}

	public boolean validateMove(int row, int col, char mark) {
		// move must be on the board and must be in a vacant space
		return !(row > 2 || col > 2 || row < 0 || col < 0 || board[row][col] != '-');
	}

	// method to print the board broh
	public void printBoard(char board[][]) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] + "\t");
			}
			System.out.println();
		}
	}

	public boolean gameWon(char[][] board) {

		char[] winRowX = { 'x', 'x', 'x' };
		char[] winRowO = { 'o', 'o', 'o' };
		// GameHandler game = new GameHandler();
		TestGrid tGrid = new TestGrid();
		for (int i = 0; i < 3; i++) {
			if (Arrays.equals(tGrid.getColumn(board, i), winRowX) || Arrays.equals(tGrid.getColumn(board, i), winRowO)
					|| Arrays.equals(tGrid.getRow(board, i), winRowX)
					|| Arrays.equals(tGrid.getRow(board, i), winRowO)) {
				return true;
			}
		}
		if (Arrays.equals(tGrid.getDiagonal1(board), winRowX) || Arrays.equals(tGrid.getDiagonal1(board), winRowO)) {
			return true;
		}
		if (Arrays.equals(tGrid.getDiagonal2(board), winRowX) || Arrays.equals(tGrid.getDiagonal2(board), winRowO)) {
			return true;
		}
		return false;
	}
}
