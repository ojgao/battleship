import java.util.*;

public class Computer {

	public Computer (Board opponent) {
		opponentBoard = opponent;
	}

	public static Board opponentBoard;

	public void makeGuess() {
		Random r = new Random();
		int guessRow = r.nextInt(10);
		int guessCol = r.nextInt(10);
		int guessRes = opponentBoard.checkHit(guessRow, guessCol);
		while(guessRes == 2) { // already guessed 
			guessRow = r.nextInt(10);
			guessCol = r.nextInt(10);
			guessRes = opponentBoard.checkHit(guessRow, guessCol);
		}
		System.out.println("The computer guessed (" + guessCol + ", " + guessRow + ")");
		opponentBoard.printBoard();
		if (guessRes == 1){
			System.out.println("Computer's shot missed.");
		}
		if (guessRes == 0){
			System.out.println("Computer's shot hits.");
		}
	}

	public boolean isWinner() {
		return opponentBoard.allShipsSunk();
	}
}