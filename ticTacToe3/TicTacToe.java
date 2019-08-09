package ticTacToe3;

import java.util.Arrays;

public class TicTacToe {
	public static void main(String[] args) {
		
	/*	char[] array = {'x','x','-'};
		char[] array2 = {'x','x','-'};
		Arrays.sort(array);
		System.out.println(Arrays.toString(array));
		Arrays.sort(array2);
		System.out.println(Arrays.equals(array,array2));*/
		
		GameHandler game = new GameHandler();
		int round = 0;
		System.out.println("TICTACTOE");
		char mark = 'x';

		while (round < 9 && game.gameWon(game.board,mark) == '-') {		
			System.out.println("make your move by entering row coordinate and then column");
			if (round % 2 == 0) {
				mark = 'x';
				game.setAgentMove();
			} else {
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
		System.out.println(game.gameWon(game.board,mark) + " wins");
	}
}
