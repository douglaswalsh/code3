package ticTacToe3;


public class TicTacToe {
	public static void main(String[] args) {
		int round = 0;
		GameHandler game = new GameHandler();
		Player pOne = new Player();
		pOne.id = 1;
		pOne.setMark();
		Player pTwo = new Player();
		pTwo.id = 2;
		pTwo.setMark();
		System.out.println("welcome to TICTACTOE, here's a board");
		game.printBoard(game.board);

		while (round < 8 && game.gameWon(game.board) == false) {
			
			if (round == 0 || round == 2 || round == 4 || round == 6 || round == 8) {
				System.out.println("Player 1, make your move by entering row coordinate and then column");
				game.setMove();
				if (game.validateMove(game.getMove()) == true) {
					game.makeMove(game.getMove(), pOne.getMark());
					round++;
					game.printBoard(game.board);
					//System.out.println("is the game over? " + game.gameWon(game.board));
				} else {
					System.out.println("illegal move, pls try again");
				}
			} else {
				System.out.println("Player 2, make your move");
				game.setMove();
				if (game.validateMove(game.getMove()) == true) {
					game.makeMove(game.getMove(), pTwo.getMark());
					round++;
					game.printBoard(game.board);
					//System.out.println("is the game over? " + game.gameWon(game.board));
				} else {
					System.out.println("illegal move, pls try again");
				}
			}
		}
		if (game.gameWon(game.board) == true){
			System.out.println("game over");
		}
	}
}
