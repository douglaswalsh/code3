package ticTacToe3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameHandler {
	// this my board
	public char[][] board = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
	private int[] square = new int[2];

	public int[] setAgentMove() {
		// search for winning move with x and then blocking move with o
		char[] marks = { 'x', 'o' };
		for (char mark : marks) {
			for (int row = 0; row < 3; row++) {
				for (int col = 0; col < 3; col++) {
					if (board[row][col] == '-') {
						square[0] = row;
						square[1] = col;
						makeMove(square, mark);
						if (gameWon(board, mark)) {
							makeMove(square, '-');
							if (mark == 'x') {
								System.out.println("agent getting winning move");
							} else {
								System.out.println("agent getting blocking move");
							}
							return square;
						} else if (!gameWon(board, mark)) {
							// System.out.println("undoing move");
							makeMove(square, '-');
						}
					}
				}
			}
		}
		// if no winning or blocking, get random move
		Random rand = new Random();
		int row = rand.nextInt(3);
		int col = rand.nextInt(3);
		square[0] = row;
		square[1] = col;
		System.out.println("agent making random move: " + row + col);
		return square;
	}

	public int[] setPlayerMove() {
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		int col = input.nextInt();
		this.square[0] = row;
		this.square[1] = col;
		// input.close();
		return square;
	}

	public int[] getMove() {
		return this.square;
	}

	public void makeMove(int[] square, char mark) {
		board[square[0]][square[1]] = mark;
	}

	public boolean validateMove(int[] square) {
		// move must be on the board and must be in a vacant space
		return !(square[0] > 2 || square[1] > 2 || square[0] < 0 || square[1] < 0
				|| board[square[0]][square[1]] != '-');
	}

	public void printBoard(char board[][]) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] + "\t");
			}
			System.out.println();
		}
	}

	public boolean gameWon(char[][] board, char mark) {
		char[] winRow = { mark, mark, mark };
		TestGrid tGrid = new TestGrid();
		for (int i = 0; i < 3; i++) {
			if (Arrays.equals(tGrid.getColumn(board, i), winRow) || Arrays.equals(tGrid.getRow(board, i), winRow)) {
				return true;
			}
		}
		if (Arrays.equals(tGrid.getDiagonal1(board), winRow)) {
			return true;
		}
		if (Arrays.equals(tGrid.getDiagonal2(board), winRow)) {
			return true;
		}
		return false;
	}

	public char whoWon(char[][] board) {
		char[] marks = { 'x', 'o' };
		for (char mark : marks) {
			if (gameWon(board, mark)) {
				return mark;
			}
		}
		return '-';
	}
}
