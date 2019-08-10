package ticTacToe3;

import java.util.Arrays;

public class TicTacToe {
	public static void main(String[] args) {
		
		/*int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(Arrays.toString(grid[2]));
		int index =0;
		for (int row = 0;row < grid[row].length;row++){
			for (int col = 0; col<grid.length;col++){
				System.out.println(index);
				index++;
			}
		}*/
		
		GameHandler game = new GameHandler();
		int round = 0;
		System.out.println("TICTACTOE");
		char mark = 'x';

		while (round < 9 && game.whoWon(game.board) == '-') {			
			if (round % 2 == 0) {
				mark = 'x';
				game.findAgentMove();
			} else {
				System.out.println("player, make your move by entering row coordinate and then column");
				mark = 'o';
				game.setMove();
			}
			if (game.validateMove(game.getMove()) == true) {
				game.makeMove(game.getMove(), mark);
				round++;
			} else {
				System.out.println("illegal move, pls try again");
			}
			game.printBoard(game.board);
		}
		System.out.println(game.whoWon(game.board) + " wins");
	}
}
