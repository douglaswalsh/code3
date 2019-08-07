package ticTacToe3;

public class TicTacToe {
	public static void main(String[] args) {
		GameHandler game = new GameHandler();
		int round = 0;
		System.out.println("TICTACTOE");

		while (round < 9 && game.gameWon(game.board) == false) {
			char mark;
			System.out.println("make your move by entering row coordinate and then column");
			game.setMove();
			if (game.validateMove(game.getMove()) == true) {
				if (round % 2 == 0) {
					mark = 'x';
				} else {
					mark = 'o';
				}
				game.makeMove(game.getMove(), mark);
				round++;
			} else {
				System.out.println("illegal move, pls try again");
			}
			game.printBoard(game.board);
		}
			System.out.println("game over");
	}
}
