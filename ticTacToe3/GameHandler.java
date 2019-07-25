package ticTacToe3;
import java.util.Arrays;

public class GameHandler {
	//this my board
		public char[][] board = {{'-','-','-'},{'-','-','-'},{'-','-','-'}};		 
		
		//puts the mark in the coordinates			
		public void makeMove(int row, int col, char mark) {
			board[row][col] = mark;
			}
		//method to print the board broh
		public static void printBoard(char board[][]) {
			for (int row=0;row<board.length;row++) {
				for (int col =0;col<board[row].length;col++) {
					System.out.print(board[row][col] + "\t");
				}
				System.out.println();		
			}	
		}
		
		public boolean validateMove(int row, int col) {
			//move must be on the board and must be in a vacant space
			if (row > 2 || col > 2 ||row < 0 || col < 0 || board[row][col]!= '-') {
				System.out.println("illegal broh");
				return false;		
			}
			return true;
		}
		
		public boolean gameWon(char[][] board){
			
			//was experimenting with having my checks for end of game happen here
			//using the methods in my testgrid class to check the board
			
			char[] winRowX =  {'x','x','x'};
			char[] winRowO =  {'o','o','o'};
			GameHandler game = new GameHandler();
			TestGrid tGrid = new TestGrid();
			if (Arrays.equals(tGrid.getColumn(game.board, 0), winRowX)){
			return true;
			}
			return false;
		}
}
