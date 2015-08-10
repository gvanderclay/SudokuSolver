package gvanderclay;

public class Solver {

	/**
	 * Game that will be solved
	 */
	private GameBoard game;

	/**
	 * Number that means a cell is unassigned
	 */
	private final int UNASSIGNED = 0;

	/**
	 * Size of the columns and rows in the board
	 */
	private final int BOARD_SIZE = 9;

	/**
	 * Constructor of the solver that is connected to a game
	 * 
	 * @param game
	 */
	public Solver(GameBoard game) {
		this.game = game;
	}

	/**
	 * Solves the game
	 * 
	 * @return if the game is solvable or not
	 */
	public boolean solve() {
		// finds the unassigend cells in the board
		int[] unassignedCell = findUnassignedCell();
		// if none of the cells are unassigned, then the board is solved
		if (unassignedCell[0] == -1) {
			return true;
		}
		// Sets the row and column as the first unassigned cell
		int row = unassignedCell[0];
		int col = unassignedCell[1];

		// loops through 1-9 to check if certain number inserts are valid
		for (int num = 1; num <= BOARD_SIZE; num++) {
			if (game.isValidInsert(game.getCell(row, col), num)) {
				game.insertValue(row, col, num);

				// recursive call to the function to assign new cells
				if (solve()) {
					return true;
				}

				// if a certain insert doesn't work, it will unassign numbers
				game.getCell(row, col).unAssign();
			}

		}
		return false;
	}

	/**
	 * Finds the first unassigned cell on the board
	 * 
	 * @return array of the coordinates of the unassigend cell in form
	 *         {row,column}
	 */
	private int[] findUnassignedCell() {
		for (int row = 0; row < BOARD_SIZE; row++) {
			for (int col = 0; col < BOARD_SIZE; col++) {
				if (game.getCell(row, col).getValue() == UNASSIGNED) {
					int[] unassignedCell = { row, col };
					return unassignedCell;
				}
			}
		}
		// if there are no unassigned cells, return {-1, -1}
		int[] unassignedCell = { -1, -1 };
		return unassignedCell;
	}

	public static void main(String[] args) {
		GameBoard game = new GameBoard();
		game.insertValue(0, 2, 3);
		game.insertValue(0, 5, 6);
		game.insertValue(1, 0, 2);
		game.insertValue(1, 1, 8);
		game.insertValue(1, 8, 4);
		game.insertValue(2, 4, 2);
		game.insertValue(2, 5, 8);
		game.insertValue(2, 6, 3);
		game.insertValue(3, 1, 3);
		game.insertValue(3, 5, 9);
		game.insertValue(3, 7, 4);
		game.insertValue(4, 2, 6);
		game.insertValue(4, 3, 7);
		game.insertValue(4, 5, 4);
		game.insertValue(4, 6, 5);
		game.insertValue(5, 1, 2);
		game.insertValue(5, 3, 1);
		game.insertValue(5, 7, 7);
		game.insertValue(6, 2, 7);
		game.insertValue(6, 3, 8);
		game.insertValue(6, 4, 3);
		game.insertValue(7, 0, 3);
		game.insertValue(7, 7, 9);
		game.insertValue(7, 8, 8);
		game.insertValue(8, 3, 4);
		game.insertValue(8, 6, 1);
		System.out.println(game.printBoard());
		Solver solver = new Solver(game);
		solver.solve();
		System.out.println(game.printBoard());
	}
}
