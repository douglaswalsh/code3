package ticTacToe3;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameHandler {
	// this my board
	public char[][] board = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
	private int[] moveArray = new int[2];

	public int[] setAgentMove() {
		if (isSquareWinCritical(board)) {
			// set the moveArray to the coordinates of the winning move
			// separate method to get the coordinates?
			//what if instead of the critical method returning a boolean instead it returns the move array
			return moveArray;
		} else {
			Random rand = new Random();
			int row = rand.nextInt(3);
			int col = rand.nextInt(3);
			this.moveArray[0] = row;
			this.moveArray[1] = col;
			return moveArray;
		}
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

	public char gameWon(char[][] board, char mark) {	

		char[] winRow = {mark, mark, mark};

		TestGrid tGrid = new TestGrid();
		for (int i = 0; i < 3; i++) {
			if (Arrays.equals(tGrid.getColumn(board, i), winRow) 
					|| Arrays.equals(tGrid.getRow(board, i), winRow)) {
				return mark;
			}
		}
		if (Arrays.equals(tGrid.getDiagonal1(board), winRow))  {
			return mark;
		}
		if (Arrays.equals(tGrid.getDiagonal2(board), winRow)) {
			return mark;
		}
		return '-';
	}
}
