package gvanderclay;

public class GameBoard {

	/** Permanent size of the board */
	private final int BOARD_SIZE = 9;

	/** 2D array of SudokuCells that represents the GameBoard */
	private SudokuCell[][] gameBoard = new SudokuCell[BOARD_SIZE][BOARD_SIZE];

	/**
	 * Basic constructor that creates the board
	 */
	public GameBoard() {
		createBoard();
	}

	/**
	 * Gets the cell from the given row and column
	 * 
	 * @param row
	 * @param col
	 * @return
	 */
	public SudokuCell getCell(int row, int col) {
		return gameBoard[row][col];
	}

	/**
	 * Clears all numbers from the board
	 */
	public void clearBoard() {
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int column = 0; column < BOARD_SIZE; column++) {
				gameBoard[row][column].setValue(0);
			}
		}
	}

	/** Fills the gameboard with empty SudokuCells */
	private void createBoard() {
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int column = 0; column < BOARD_SIZE; column++) {
				gameBoard[row][column] = new SudokuCell(row, column);
			}
		}
	}

	/** Inserts a value into the gameBoard */
	public void insertValue(int row, int column, int value) {
		if (!isValidInsert(gameBoard[row][column], value))
			return;
		else
			gameBoard[row][column].setValue(value);
	}

	/** Checks if the value can be inserted into the gameBoard */
	public boolean isValidInsert(SudokuCell SudokuCell, int value) {
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int column = 0; column < BOARD_SIZE; column++) {
				if (gameBoard[row][column].isRelated(SudokuCell)
						&& gameBoard[row][column].getValue() == value)
					return false;
			}
		}
		return true;
	}

	/**
	 * Returns a boolean that tells whether the game is solvable or not
	 * 
	 * @return
	 */
	public boolean isSolvable() {
		// Quad nested for loop checks to see if any of the cells are related
		// and if they are related, if they have the same number
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int column = 0; column < BOARD_SIZE; column++) {
				for (int checkRow = 0; checkRow < BOARD_SIZE; checkRow++) {
					for (int checkCol = 0; checkCol < BOARD_SIZE; checkCol++) {
						if (gameBoard[row][column]
								.isRelated(gameBoard[checkRow][checkCol])
								&& gameBoard[row][column].getValue() == gameBoard[checkRow][checkCol]
										.getValue()
								&& gameBoard[row][column].getValue() != 0) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	
	/**
	 * Prints a string version of the board for testing purposes
	 * @return
	 */
	public String printBoard() {
		String board = "";
		for (int row = 0; row < BOARD_SIZE; row++) {
			board += "|";
			for (int column = 0; column < BOARD_SIZE; column++) {
				board += gameBoard[row][column].getValue() + "|";
			}
			board += "\n------------\n";
		}
		return board;
	}

	public static void main(String args[]) {
		GameBoard g = new GameBoard();
		System.out.println(g.printBoard());
		g.insertValue(0, 0, 4);
		System.out.println(g.printBoard());
		g.insertValue(0, 8, 5);
		System.out.println(g.printBoard());
	}
}
