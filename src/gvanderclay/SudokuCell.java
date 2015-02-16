package gvanderclay;

public class SudokuCell {
	/**Row that the cell is in*/
	private int row;
	
	/**Column that the cell is in*/
	private int column;
	
	/**Array of other cells that this cell is related to*/
	private SudokuCell[] relatedCells = new SudokuCell[20];
	
	public SudokuCell(int row, int column){
		row = this.row;
	}
}
