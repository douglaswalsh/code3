package ticTacToe3;

import java.util.Arrays;
import java.util.Scanner;

public class GameHandler {
	// this my board
	public char[][] board = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
	private int[] moveArray = new int[2];
	
	public int[] setMove(){
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		int col = input.nextInt();
		this.moveArray[0] = row;
		this.moveArray[1] = col;
		//input.close();
		return moveArray;	
	}
	
	public int[] getMove(){
		return this.moveArray;
	}
	
	public void makeMove(int[] moveArray, char mark) {
			board[moveArray[0]][moveArray[1]] = mark;
	}

	public boolean validateMove(int[] moveArray) {
		// move must be on the board and must be in a vacant space
		return !(moveArray[0] > 2 || moveArray[1] > 2 || moveArray[0] < 0 || moveArray[1] < 0 || board[moveArray[0]][moveArray[1]] != '-');
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
		
		TestGrid tGrid = new TestGrid();
		for (int i = 0; i < 3; i++) {
			if (Arrays.equals(tGrid.getColumn(board, i), winRowX) 
					|| Arrays.equals(tGrid.getColumn(board, i), winRowO)
					|| Arrays.equals(tGrid.getRow(board, i), winRowX)
					|| Arrays.equals(tGrid.getRow(board, i), winRowO)) {
				return true;
			}
		}
		if (Arrays.equals(tGrid.getDiagonal1(board), winRowX) 
				|| Arrays.equals(tGrid.getDiagonal1(board), winRowO)) {
			return true;
		}
		if (Arrays.equals(tGrid.getDiagonal2(board), winRowX) 
				|| Arrays.equals(tGrid.getDiagonal2(board), winRowO)) {
			return true;
		}
		return false;
	}
}
