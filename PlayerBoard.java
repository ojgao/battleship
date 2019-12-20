
import java.util.*;

public class PlayerBoard extends ComputerBoard {

	public static boolean randomize = false;

	public void setUpBoard() {
		Scanner console = new Scanner(System.in);
		System.out.println();
		System.out.println();
		System.out.println("Welcome to BattleShip! Please set up your ships.");
		System.out.println("If you would like the computer to randomize your board, press R now. Otherwise, press any other key.");
		String input = console.next();
		input = input.toLowerCase();
		if(input.equals("r")) {
			randomize = true;
		} 
		generateBoard();
		System.out.println();
		System.out.println("Your board :");
		printBoard();
	}

	public int getStartRow(int size) {
		if(randomize) {
			return super.getStartRow(size);
		} else {
			System.out.println("Your ship is of size "+ size);
			System.out.println("Please enter the Y coordinate of its placement from 0 to 9.");
			Scanner console = new Scanner(System.in);
			String starting = console.next();
			while (cont(starting)==false){
				System.out.println("Input invalid. Please try again.");
				starting = console.next();
			}
			int start = Integer.parseInt(starting);

			return start;
		}
	}

	public int getStartCol() {
		if(randomize) {
			return super.getStartCol();
		} else {
			printBoard();
			System.out.println("Please enter the X coordinate of its placement from 0 to 9.");
			Scanner console = new Scanner(System.in);
			String starting = console.next();
			while (cont(starting)==false){
				System.out.println("Input invalid. Please try again.");
				starting = console.next();
			}
			int start = Integer.parseInt(starting);
			return start;
		}
	}

	public int findValidDirection(int i, int j, int size) {
		if(randomize) {
			return super.findValidDirection(i, j, size);
		} else {
			System.out.println("Enter the direction of your ship : 1 for up, 2 for down, 3 for left, 4 for right");
			Scanner console = new Scanner(System.in);
			String starting = console.next();
			while (cont(starting)==false){
				System.out.println("Input invalid. Please try again.");
				starting = console.next();
			}
			int dir = Integer.parseInt(starting);
			while (dir < 1 || dir > 4){
				System.out.println("Input invalid. Please try again.");
				dir = console.nextInt();
			}
			switch (dir) {
				case 1:
					if(i - size >= 0 && checkUnoccupied(i, j, size, dir)) {
						return dir;
					}
					System.out.println("Boat does not fit. Please try again.");
					return -1;
				case 2:
					if(i + size >= 0 && checkUnoccupied(i, j, size, dir)) {
						return dir;
					}
					System.out.println("Boat does not fit. Please try again.");
					return -1;
				case 3:
					if(j - size >= 0 && checkUnoccupied(i, j, size, dir)) {
						return dir;
					}
					System.out.println("Boat does not fit. Please try again.");
					return -1;
				case 4:
					if(j + size >= 0 && checkUnoccupied(i, j, size, dir)) {
						return dir;
					}
					System.out.println("Boat does not fit. Please try again.");
					return -1;
				default: 
					System.out.println("Boat does not fit. Please try again.");
					return -1;
			}
		}
	}

	public void printBoard() {
		System.out.println("  0 1 2 3 4 5 6 7 8 9 X");
		for(int i= 0; i < 10; i++) {
			System.out.print(i + " ");
			for(int j = 0; j < 10; j++) {
				switch (board[i][j]) {
					case 0: 
						System.out.print("- ");
						break;
					case 1: 
						System.out.print("O ");
						break;
					case 2: 
						System.out.print("X ");
						break;
					case 3: 
						System.out.print("* ");
						break;
					default:
						break;
				}
			}
			System.out.println();
		}
		System.out.println("Y");
	}

	public int checkHit(int i, int j) {
		if(board[i][j] == 1) {
			board[i][j] = 2;
			return 0;
		} else if (board[i][j] == 0) {
			board[i][j] = 3;
			return 1;
		} else {
			System.out.println("You already tried this spot! Pick again.");
			return 2;
		}
	}

	public boolean checkValidStart(int i, int j) {
		if(board[i][j] == 0){
			return true;
		} else {
			if (randomize == false){
			System.out.println("Start point is already occupied. Please try again.");
		}
			return false;
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
}