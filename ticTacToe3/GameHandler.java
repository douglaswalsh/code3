package ticTacToe3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameHandler {
	// this my board
	public char[][] board = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
	private int[] moveArray = new int[2];

	public int[] setAgentMove() {
		Random rand = new Random();
		int row = rand.nextInt(3);
		int col = rand.nextInt(3);
		this.moveArray[0] = row;
		this.moveArray[1] = col;
		return moveArray;
	}

	public int[] findAgentMove() {

		/*
		 * returns a moveArray for the agent first loops thru board and makes a
		 * move checks if this is winning move if iswinning return this
		 * moveArray this will be the move undo move else get moveArray for a
		 * edit: need to make it so it only tries free spaces
		 * 
		 * now need to make it so that if it can't find a winning move
		 * it tries to find a blocking move if no blocking move then random
		 */

		for (int row = 0; row < board[row].length - 1; row++) {
			for (int col = 0; col < board.length; col++) {
				if (board[row][col] == '-') {
					moveArray[0] = row;
					moveArray[1] = col;
					makeMove(moveArray, 'x');
					//System.out.println("looping");
					if (gameWon(board, 'x')) {
						makeMove(moveArray, '-');
						System.out.println("agent getting winning move");
						return moveArray;
					} else if (!gameWon(board, 'x')) {
						//System.out.println("undoing move");
						makeMove(moveArray, '-');
					}
				}
			}
		}
		Random rand = new Random();
		int row = rand.nextInt(3);
		int col = rand.nextInt(3);
		moveArray[0] = row;
		moveArray[1] = col;
		System.out.println("agent making random move: " + row + col);
		return moveArray;
	}

	public int[] setMove() {
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		int col = input.nextInt();
		this.moveArray[0] = row;
		this.moveArray[1] = col;
		// input.close();
		return moveArray;
	}

	public int[] getMove() {
		return this.moveArray;
	}

	public void makeMove(int[] moveArray, char mark) {
		board[moveArray[0]][moveArray[1]] = mark;
	}

	public boolean validateMove(int[] moveArray) {
		// move must be on the board and must be in a vacant space
		return !(moveArray[0] > 2 || moveArray[1] > 2 || moveArray[0] < 0 || moveArray[1] < 0
				|| board[moveArray[0]][moveArray[1]] != '-');
	}

	public boolean isSquareWinCritical(char[][] board) {
		char[] winCriticalX = { '-', 'x', 'x' };
		TestGrid tGrid = new TestGrid();
		Arrays.sort(tGrid.getRow(board, 0));
		return (tGrid.getRow(board, 0) == winCriticalX);
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
