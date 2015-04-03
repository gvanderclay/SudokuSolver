package gvanderclay;

public class Solver {

	private GameBoard game;
	
	private final int UNASSIGNED = 0;
	
	private final int BOARD_SIZE = 9;
	
	public Solver(GameBoard game){
		this.game = game;
	}
	
	public boolean solve(){
		int[] unassignedCell = findUnassignedCell();
		if(unassignedCell[0] == -1){
			return true;
		}
		int row = unassignedCell[0];
		int col = unassignedCell[1];
		
		for(int num = 1; num <= BOARD_SIZE; num++){
			if(game.isValidInsert(game.getCell(row, col), num)){
				game.insertValue(row, col, num);
				
				if(solve()){
					return true;
				}
				
				game.getCell(row, col).unAssign();
			}
			
			
		}
		return false;
	}
	
	private int[] findUnassignedCell(){
		for (int row = 0; row < BOARD_SIZE; row++){
	        for (int col = 0; col < BOARD_SIZE; col++){
	            if (game.getCell(row, col).getValue() == UNASSIGNED){
	            	int[] unassignedCell = {row,col};
	            	return unassignedCell;
	            }
	        }
		}
		int[] unassignedCell = {-1,-1};
		return unassignedCell;
	}
	
	public static void main(String[] args){
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
		Solver solver = new Solver(game);
		solver.solve();
		System.out.println(game.printBoard());
	}
}
