package gvanderclay;

public class SudokuCell {
	/**Row that the cell is in*/
	private int row;
	
	/**Column that the cell is in*/
	private int column;
	
	/**Box that the cell is in*/
	private int box;
	
	/**Value that is inside of the cell*/
	private int value;
	
	/**
	 * Basic constructor that assigns the cell to a row and column
	 * @param row
	 * @param column
	 */
	public SudokuCell(int row, int column){
		this.row = row;
		this.column = column;
		setBox();
		value = 0;
	}

	/**
	 * Sets the cell as 0 which means that it has no number assigned to it
	 */
	public void unAssign(){
		this.value = 0;
	}
	
	/**
	 * Checks if a cell is related to another cell
	 * @param compare Cell being compared
	 * @return
	 */
	public boolean isRelated(SudokuCell compare){
		// this would mean they are the same cell
		if(this.row == compare.getRow() 
		&& this.column == compare.getColumn() 
		&& this.box == compare.getBox()){
			return false;
		}
		if(this.row == compare.getRow())
			return true;
		if(this.column == compare.getColumn())
			return true;
		// if the cells are in the same 3x3 box
		if(this.box == compare.getBox())
			return true;
		return false;
	}
	
	/**
	 * Returns the row of the cell
	 * @return
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Sets the row of the cell
	 * @param row
	 */
	public void setRow(int row) {
		this.row = row;
	}

	/**
	 * Gets the column of the cell
	 * @return
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Sets the column of the cell
	 * @param column
	 */
	public void setColumn(int column) {
		this.column = column;
	}
	
	/**
	 * Get the value that is contained in the cell
	 * @return
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Sets the value in the cell
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	/**
	 * Increments the value of the cell by 1
	 */
	public void incValue(){
		if(this.value < 9){
			this.value++;
		}
		else{
			this.value = 0;
		}
	}

	/**
	 * Gets which 3x3 box the cell is contained in
	 * @return
	 */
	public int getBox(){
		return box;
	}
	
	/**
	 * Sets the box that the cell is contained in
	 */
	private void setBox(){
		if((this.row >= 0 && this.row <= 2) && 
		   (this.column >= 0 && this.column <= 2)){
					this.box = 1;
					return;
		}
		if((this.row >= 0 && this.row <= 2) && 
		   (this.column >= 3 && this.column <= 5)){
					this.box = 2;
					return;
		}
		if((this.row >= 0 && this.row <= 2) && 
		   (this.column >= 6 && this.column <= 8)){
					this.box = 3;
					return;
		}
		if((this.row >= 3 && this.row <= 5) && 
		   (this.column >= 0 && this.column <= 2)){
					this.box = 4;
					return;
		}
		if((this.row >= 3 && this.row <= 5) && 
		   (this.column >= 3 && this.column <= 5)){
					this.box = 5;
					return;
		}
		if((this.row >= 3 && this.row <= 5) && 
		   (this.column >= 6 && this.column <= 8)){
					this.box = 6;
					return;
		}
		if((this.row >= 6 && this.row <= 8) && 
		   (this.column >= 0 && this.column <= 2)){
					this.box = 7;
					return;
		}
		if((this.row >= 6 && this.row <= 8) && 
		   (this.column >= 3 && this.column <= 5)){
					this.box = 8;
					return;
		}
		if((this.row >= 6 && this.row <= 8) && 
		   (this.column >= 6 && this.column <= 8)){
					this.box = 9;
					return;
		}
	}
}
