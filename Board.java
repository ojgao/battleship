public abstract class Board {
	int[][] board = new int[10][10];

	public void generateBoard() {
		int[] pieceSizes = {2,3,3,4,5};
		for(int i = 0; i < pieceSizes.length; i++) {
			int size = pieceSizes[i];
			int startCol = getStartCol();
			int startRow = getStartRow(size);
			while(!checkValidStart(startRow, startCol)) {
				startRow = getStartRow(size);
				startCol = getStartCol();
			}
			int dir = findValidDirection(startRow, startCol, size);
			while(dir == -1) {
				startRow = getStartRow(size);
				startCol = getStartCol();
				dir = findValidDirection(startRow, startCol, size);
			}
			printBoardIfUser();
			switch (dir) {
				case 1:
					for(int x = 0; x < size; x++){
						board[startRow - x][startCol] = 1;
					}
					break;
				case 2:
					for(int x = 0; x < size; x++){
						board[startRow + x][startCol] = 1;
					}
					break;
				case 3:
					for(int x = 0; x < size; x++){
						board[startRow][startCol - x] = 1;
					}
					break;
				case 4:
					for(int x = 0; x < size; x++){
						board[startRow][startCol + x] = 1;
					}
				default:
					break;
			}
		}
	}

	public boolean checkUnoccupied(int i, int j, int size, int dir) {
		switch (dir) {
			case 1:
				for(int x = 0; x < size; x++) {
					if(board[i - x][j] != 0) {
						return false;
					}
				}
				return true;
			case 2:
				for(int x = 0; x < size; x++) {
					if(board[i + x][j] != 0) {
						return false;
					}
				}
				return true;
			case 3: 
				for(int x = 0; x < size; x++) {
					if(board[i][j - x] != 0) {
						return false;
					}
				}
				return true;
			case 4:
				for(int x = 0; x < size; x++) {
					if(board[i][j + x] != 0) {
						return false;
					}
				}
				return true;
			default:
				return false;
		}
	}

	public boolean checkValidStart(int i, int j) {
		return (board[i][j] == 0);
	}

	public boolean allShipsSunk() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if(board[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	abstract int checkHit(int i, int j);

	abstract void printBoard();

	abstract int getStartRow(int size);

	abstract int getStartCol();

	abstract int findValidDirection(int i, int j, int size);

	abstract void printBoardIfUser();
}