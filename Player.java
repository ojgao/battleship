import java.util.*;

public class Player{

	public Player (Board opponent) {
		opponentBoard = opponent;
	}

	public static Board opponentBoard;

	public void makeGuess(){
		opponentBoard.printBoard();
		System.out.println("Please enter the X coordinate of your attack.");
		Scanner console = new Scanner(System.in);
		String starting = console.next();
		while (cont(starting)==false){
			System.out.println("Input invalid. Please try again.");
			starting = console.next();
		}
		int attackcoordinateX = Integer.parseInt(starting);
		System.out.println("Please enter the Y coordinate of your attack.");
		starting = console.next();
		while (cont(starting)==false){
			System.out.println("Input invalid. Please try again.");
			starting = console.next();
		}
		int attackcoordinateY = Integer.parseInt(starting);
		int result = opponentBoard.checkHit(attackcoordinateY, attackcoordinateX);
		while (result == 2){
			System.out.println("Input already guessed. Please try again.");
			System.out.println("Please enter the X coordinate of your attack.");
			attackcoordinateX = console.nextInt();
			while (attackcoordinateX < 0 || attackcoordinateX > 9 ){
				System.out.println("Input invalid. Please try again.");
				attackcoordinateX = console.nextInt();
			}
			System.out.println("Please enter the Y coordinate of your attack.");
			attackcoordinateY = console.nextInt();
			while (attackcoordinateY < 0 || attackcoordinateY > 9 ){
				System.out.println("Input invalid. Please try again.");
				attackcoordinateY = console.nextInt();
			}
			result = opponentBoard.checkHit(attackcoordinateX, attackcoordinateY);
		}
		if (result == 1){
			opponentBoard.printBoard();
			System.out.println("Shot missed.");

		}
		if (result == 0){
			opponentBoard.printBoard();
			System.out.println("Boat hit.");
		}
	}

	public boolean cont(String x){
		try {
			int n = Integer.parseInt(x);
			if(n < 0 || n > 9) {
				return false;
		   	}
		   	return true; 
		} catch(NumberFormatException e) { 
		 	return false;
		}
	}

	public boolean isWinner() {
		return opponentBoard.allShipsSunk();
	}
}