package jfk.exercises.skeletons.sudoku.ui;

import javax.swing.*;

import jfk.exercises.skeletons.sudoku.model.Sudoku;

public class SudokuWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private static SudokuWindow window;
	private static Sudoku sudoku = new Sudoku();
	private static SudokuPanel panel = new SudokuPanel();

	public static void main(String[] args) {
		window = new SudokuWindow();
		window.setTitle("JSudoku solver");
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		panel.setSudoku(sudoku);
		window.add(panel);

		window.setVisible(true);
		window.setResizable(false);
		window.pack();

		solve();
		panel.repaint();
	}

	private static void solve() {

		// add your sudoku solving algorithm here

		// remove this sample code, which shows how to set values in the sudoku
		sudoku.setValue(2, 1, 3);
		sudoku.setValue(3, 4, 5);
		sudoku.setValue(5, 6, 8);
		sudoku.setValue(1, 6, 8);

		// call panel.repaint(); if you need to see results along the way
	}
}