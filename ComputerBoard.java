import java.util.*;

public class ComputerBoard extends Board {

	public ComputerBoard() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				board[i][j] = 0;
			}
		}
		setUpBoard();
	}

	public void setUpBoard() {
		generateBoard();
	}

	public int getStartRow(int size) {
		Random r = new Random();
		return r.nextInt(10);
	}

	public int getStartCol() {
		Random r = new Random();
		return r.nextInt(10);
	}

	public void printBoardIfUser() {
		return;
	}

	public int findValidDirection(int i, int j, int size) {
		Random r = new Random();
		List<Integer> validDirection = new ArrayList<Integer>();
		if(i - size >= 0 && checkUnoccupied(i, j, size, 1)) {
			validDirection.add(1);
		}
		if(i + size < 10 && checkUnoccupied(i, j, size, 2)) {
			validDirection.add(2);
		}
		if(j - size >= 0 && checkUnoccupied(i, j, size, 3)) {
			validDirection.add(3);
		}
		if(j + size < 10 && checkUnoccupied(i, j, size, 4)) {
			validDirection.add(4);
		}
		if(validDirection.size() == 0) {
			return -1;
		} else {
			return validDirection.get(r.nextInt(validDirection.size()));
		}
	}

	public void printBoard() {
		System.out.println("  0 1 2 3 4 5 6 7 8 9 X");
		for(int i = 0; i < 10; i++) {
			System.out.print(i + " ");
			for(int j = 0; j < 10; j++) {
				switch (board[i][j]) {
					case 0:
					case 1:
						System.out.print("- ");
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
			return 2;
		}
	}

	public boolean checkValidStart(int i, int j) {
		return (board[i][j] == 0);
	}
}