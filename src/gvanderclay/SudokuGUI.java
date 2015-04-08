package gvanderclay;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SudokuGUI {

	private JFrame frame;
	
	private GameBoard game;
	
	private final int SIZE = 9;
	
	private JButton[][] cells;
	
	private JLabel title;
	
	private JButton solveButton;
	
	private JButton resetButton;
	
	private JLabel gameStatus;
	
	private JPanel board;
	
	private JPanel[][] subBoards;
	
	private JPanel grid;
	
	private JPanel buttons;
	
	private ButtonListener listener;
	
	private String instructions;
	
	public SudokuGUI(){
		initialize();
	}
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SudokuGUI window = new SudokuGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JComponent getButtonPanel(){
		grid = new JPanel();
		grid.setLayout(new GridLayout(2,1,0,0));
		buttons = new JPanel();
		instructions = "Left click to increment the cell \nRight "
				+ "click to reset the cell";
		buttons.setLayout(new GridLayout(1,2,0,0));
		solveButton = new JButton("Solve");
		solveButton.setFont(new Font("Ubuntu Medium", Font.PLAIN, 15));
		solveButton.addMouseListener(listener);
		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Ubuntu Medium", Font.PLAIN, 15));
		resetButton.addMouseListener(listener);
		gameStatus = new JLabel(instructions);
		gameStatus.setFont(new Font("Ubuntu Medium", Font.BOLD, 15));
		gameStatus.setHorizontalAlignment(JLabel.CENTER);
		gameStatus.setVerticalAlignment(JLabel.CENTER);
		buttons.add(solveButton);
		buttons.add(resetButton);
		grid.add(gameStatus);
		grid.add(buttons);
		
		
		return grid;
	}
	
	private JComponent getCellPanel() {
		board = new JPanel();
	    board.setBackground(new Color(0, 0, 0));
	    board.setLayout(new GridLayout(3, 3, 5, 5));
	    subBoards = new JPanel[3][3];
	    for(int row = 0; row < 3; row++){
	    	for(int col = 0; col < 3; col++){
	    		subBoards[row][col] = new JPanel();
	    		subBoards[row][col].setLayout(new GridLayout(3, 3, 2, 2));
	    		subBoards[row][col].setBackground(new Color(0, 0, 0));
	    		board.add(subBoards[row][col]);
	    	}
	    }
	    cells = new JButton[SIZE][SIZE];
	    
	    for(int row = 0; row < SIZE; row++){
	    	for(int col = 0; col < SIZE; col++){
	    		cells[row][col] = new JButton("");
	    		cells[row][col].setBackground(new Color(255, 255, 255));
	    		cells[row][col].setForeground(new Color(0, 0, 0));
	    		cells[row][col].setFont(new Font("Ubuntu Medium", Font.PLAIN, 50));
	    		cells[row][col].addMouseListener(listener);
	    		subBoards[row / 3][col / 3].add(cells[row][col]);
	    	}
	    }
	    return board;
	  }
	
	private void refreshBoard(){
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				if(game.getCell(row, col).getValue() == 0){
					cells[row][col].setText("");
				}
				else{
					cells[row][col].setText("" + 
					game.getCell(row, col).getValue());
				}
			}
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		listener = new ButtonListener();
		game = new GameBoard();
		frame.setResizable(false);
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 10));
		frame.getContentPane().add(getCellPanel(), BorderLayout.CENTER);
		title = new JLabel("Sudoku Solver");
		title.setFont(new Font("Ubuntu Medium", Font.PLAIN, 22));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(title, BorderLayout.NORTH);
		frame.getContentPane().add(getButtonPanel(), BorderLayout.SOUTH);
	}
	
	class ButtonListener implements MouseListener {

		/*****************************************
		 * If the mouse is clicked, these actions will be performed
		 *****************************************/
		@Override
		public void mouseClicked(MouseEvent e) {
			for(int row = 0; row < SIZE; row++){
				for(int col = 0; col < SIZE; col++){
					if(e.getSource() == cells[row][col]){
						if(e.getButton() == 1){
							game.getCell(row, col).incValue();
							gameStatus.setText(instructions);
						}
						if(e.getButton() == 3){
							game.getCell(row, col).setValue(0);
							gameStatus.setText(instructions);
						}
					}
				}
			}
			if(e.getSource() == solveButton){
				Solver solve = new Solver(game);
				if(!game.isSolvable()){
					gameStatus.setText("Game is not solvable");
				}
				else{
					solve.solve();
				}
			}
			if(e.getSource() == resetButton){
				game.clearBoard();
				gameStatus.setText(instructions);
			}
			game.printBoard();
			refreshBoard();
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

}

