package ticTacToe3;

import java.util.Scanner;

public class Player {

	private String name;
	public int id;
	private char mark;

	public String getName() {
		return this.name;
	}

	public String setName() {
		System.out.println("what is your name?");
		Scanner input = new Scanner(System.in);
		this.name = input.nextLine();
		input.close();
		return name;
	}

	public char getMark() {
		return this.mark;
	}

	public char setMark() {
		if (id == 1) {
			mark = 'x';
		} else {
			mark = 'o';
		}
		return mark;
	}
}
