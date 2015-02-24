package gvanderclay;

public class SudokuCell {
	/**Row that the cell is in*/
	private int row;
	
	/**Column that the cell is in*/
	private int column;
	
	/**Box that the cell is in*/
	private int box;
	
	/**Array of other cells that this cell is related to*/
	private SudokuCell[] relatedCells = new SudokuCell[20];
	
	public SudokuCell(int row, int column){
		this.row = row;
		this.column = column;
		setBox();
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getBox(){
		return box;
	}
	
	public SudokuCell[] getRelatedCells() {
		return relatedCells;
	}

	public void setRelatedCells(SudokuCell[] relatedCells) {
		this.relatedCells = relatedCells;
	}
	
	private void setBox(){
		if((this.row >= 0 && this.row <= 2) && 
		   (this.column >= 0 && this.column <= 2)){
					this.box = 1;
		}
		if((this.row >= 0 && this.row <= 2) && 
		   (this.column >= 3 && this.column <= 5)){
					this.box = 2;
		}
		if((this.row >= 0 && this.row <= 2) && 
		   (this.column >= 6 && this.column <= 8)){
					this.box = 3;
		}
		if((this.row >= 3 && this.row <= 5) && 
		   (this.column >= 0 && this.column <= 2)){
					this.box = 4;
		}
		if((this.row >= 3 && this.row <= 5) && 
		   (this.column >= 3 && this.column <= 5)){
					this.box = 5;
		}
		if((this.row >= 3 && this.row <= 5) && 
		   (this.column >= 6 && this.column <= 8)){
					this.box = 6;
		}
		if((this.row >= 6 && this.row <= 8) && 
		   (this.column >= 0 && this.column <= 2)){
					this.box = 7;
		}
		if((this.row >= 6 && this.row <= 8) && 
		   (this.column >= 3 && this.column <= 5)){
					this.box = 8;
		}
		if((this.row >= 6 && this.row <= 8) && 
		   (this.column >= 6 && this.column <= 8)){
					this.box = 9;
		}
	}
}
