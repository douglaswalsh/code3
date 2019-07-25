package ticTacToe3;
import java.util.Random;

//this is just experimental for now


public class MoveMaker {
	//gets a random number between 0-9. can use this for the moving
	public void getRand(){
		Random rand = new Random();
		for (int i = 0; i <10; i++){
			int n = rand.nextInt(10);
			System.out.println(n);		
		
		}		
	}
}
