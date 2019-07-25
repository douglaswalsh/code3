package ticTacToe3;
import java.util.Arrays;

public class TicTacToe {
	public static void main(String[] args) {
		boolean gameOver = false;
		char[] winArray =  {'x','x','x'};
		// TODO Auto-generated method stub
		GameHandler game = new GameHandler();
		//yo im init my testGrid method too cos i want to use it's methods real good
		TestGrid tGrid = new TestGrid();
		
		//while !gameOver make moves
		game.printBoard(game.board);
		game.makeMove(0,0,'x');
		game.printBoard(game.board);
		game.makeMove(1,0,'x');
		game.printBoard(game.board);
		game.makeMove(2,0,'x');
		game.printBoard(game.board);
		System.out.println(tGrid.getColumn(game.board, 0));
		System.out.println(gameOver);
		if (Arrays.equals(tGrid.getColumn(game.board, 0), winArray) ||
				Arrays.equals(tGrid.getColumn(game.board, 1), winArray) ||
				Arrays.equals(tGrid.getColumn(game.board, 2), winArray) ||
				Arrays.equals(tGrid.getRow(game.board, 0), winArray) ||
				Arrays.equals(tGrid.getRow(game.board, 1), winArray) ||
				Arrays.equals(tGrid.getRow(game.board, 2), winArray) ||
				Arrays.equals(tGrid.getDiagonal1(game.board), winArray) ||
				Arrays.equals(tGrid.getDiagonal1(game.board), winArray) 
				)  {
			gameOver = true;
		}
		System.out.println(gameOver);
		if (gameOver == true){
			System.out.println("game OVER. THE END");
		}
		//after evry mfkin round check if game is won 
		//System.out.println(tGrid.getColumn(game.board, 0));
		//TestGrid tGrid = new TestGrid();
		//System.out.println(Arrays.toString(tGrid.getColumn(tGrid.grid, 0)));
		//System.out.println(Arrays.toString(tGrid.getDiagonal1(tGrid.grid)));
	}
}
