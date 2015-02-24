package gvanderclay;

public class GameBoard {
	/**Permanent size of the board*/
	private final int BOARD_SIZE = 9;
	
	/**2D array of SudokuCells that represents the GameBoard*/
	private SudokuCell[][] gameBoard = new SudokuCell[BOARD_SIZE][BOARD_SIZE];
	
	public GameBoard(){
		createBoard();
	}
	
	private void createBoard(){
		for (int row = 0; row < BOARD_SIZE; row++){
			for(int column = 0; column < BOARD_SIZE; column++){
				gameBoard[row][column] = new SudokuCell(row, column);
			}
		}
	}
	
	public void insertValue(SudokuCell SudokuCell, int value){
		if(!isValidInsert(SudokuCell, value))
			return;
		else
			SudokuCell.setValue(value);
	}
	
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
}
