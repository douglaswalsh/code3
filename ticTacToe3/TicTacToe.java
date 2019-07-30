package ticTacToe3;

import java.util.Arrays;

public class TicTacToe {
	public static void main(String[] args) {
		GameHandler game = new GameHandler();
		TestGrid tGrid = new TestGrid();
		 while (!game.gameWon(game.board)){
				game.printBoard(game.board);
				game.makeMove(0, 0, 'x');
				game.printBoard(game.board);
				game.makeMove(1, 0, 'x');
				game.printBoard(game.board);
				game.makeMove(2, 0, 'x');
				game.printBoard(game.board);
		 }
		if (game.gameWon(game.board)){
			System.out.println("Game OVER THE END");
		}
		else {
			System.out.println("keep playin");
		}

	}
}
