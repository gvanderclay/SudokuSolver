package gvanderclay;

public class GameBoard {
	
	/**If the game is solved or not*/
	private boolean isSolved;
	
	/**Permanent size of the board*/
	private final int BOARD_SIZE = 9;
	
	/**2D array of SudokuCells that represents the GameBoard*/
	private SudokuCell[][] gameBoard = new SudokuCell[BOARD_SIZE][BOARD_SIZE];
	
	public GameBoard(){
		createBoard();
		isSolved = false;
	}
	
	/**Fills the gameboard with empty SudokuCells*/
	private void createBoard(){
		for (int row = 0; row < BOARD_SIZE; row++){
			for(int column = 0; column < BOARD_SIZE; column++){
				gameBoard[row][column] = new SudokuCell(row, column);
			}
		}
	}
	
	/**Inserts a value into the gameBoard*/
	public void insertValue(int row, int column, char value){
		if(!isValidInsert(gameBoard[row][column], value) || isSolved)
			return;
		else
			gameBoard[row][column].setValue(value);
		checkIfSolved();
	}
	
	/**Checks if the value can be inserted into the gameBoard*/
	private boolean isValidInsert(SudokuCell SudokuCell, int value){
		for(int row = 0; row < BOARD_SIZE; row++){
			for(int column = 0; column < BOARD_SIZE; column++){
				if(gameBoard[row][column].isRelated(SudokuCell) 
				&& gameBoard[row][column].getValue() == value)
					return false;
			}
		}
		return true;
	}
	
	/**Checks if the board is solved*/
	private void checkIfSolved(){
		for(int row = 0; row < BOARD_SIZE; row++){
			for(int column = 0; column < BOARD_SIZE; column++){
				if(gameBoard[row][column] == null){
					return;
				}
			}
		}
		isSolved = true;
	}
	
	/**Prints a string version of the gameBoard for testing purposes*/
	private String printBoard(){
		String board = "";
		for(int row = 0; row < BOARD_SIZE; row++){
			board += "|";
			for(int column = 0; column < BOARD_SIZE; column++){
				board += gameBoard[row][column].getValue() + "|";
			}
			board += "\n------------\n";
		}
		return board;
	}
	
	public static void main(String args[]){
		GameBoard g = new GameBoard();
		System.out.println(g.printBoard());
		g.insertValue(0,0,'4');
		System.out.println(g.printBoard());
		g.insertValue(0,8,'5');
		System.out.println(g.printBoard());
	}
}
