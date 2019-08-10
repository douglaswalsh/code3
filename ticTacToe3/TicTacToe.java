package ticTacToe3;

public class TicTacToe {
	public static void main(String[] args) {
		GameHandler game = new GameHandler();
		int round = 0;
		System.out.println("TICTACTOE");
		char mark;

		while (round < 9 && game.whoWon(game.board) == '-') {
			if (round % 2 == 0) {
				mark = 'x';
				game.setAgentMove();
			} else {
				System.out.println("player, make your move by entering row coordinate and then column");
				mark = 'o';
				game.setPlayerMove();
			}
			if (game.validateMove(game.getMove()) == true) {
				game.makeMove(game.getMove(), mark);
				round++;
				game.printBoard(game.board);
			} else if (mark == 'o') {
				System.out.println("illegal move, pls try again");
			}
		}
		if (game.whoWon(game.board) == '-') {
			System.out.println("it's a draw");
		} else {
			System.out.println(game.whoWon(game.board) + " wins");
		}
	}
}
