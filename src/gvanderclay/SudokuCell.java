package gvanderclay;

public class SudokuCell {
	/**Row that the cell is in*/
	private int row;
	
	/**Column that the cell is in*/
	private int column;
	
	/**Box that the cell is in*/
	private int box;
	
	/**Value that is inside of the cell*/
	private char value;
	
	public SudokuCell(int row, int column){
		this.row = row;
		this.column = column;
		setBox();
		value = ' ';
	}

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
		if(this.box == compare.getBox())
			return true;
		return false;
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
	
	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public int getBox(){
		return box;
	}
	
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
