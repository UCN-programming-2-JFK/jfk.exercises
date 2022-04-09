package jfk.exercises.skeletons.solutions;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

import jfk.exercises.skeletons.eightqueens.model.Board;
import jfk.exercises.skeletons.eightqueens.ui.BoardFrame;
import jfk.exercises.skeletons.sudoku.ui.SudokuWindow;

public class SudokuSolutionWindow extends SudokuWindow {
	private List<Point> diagonalDirections = Arrays.asList(new Point(-1, -1), new Point(1, -1), new Point(-1, 1),
			new Point(1, 1));
	private static final long serialVersionUID = 1L;

	@Override
	protected void solve() {
		trySolve(0);
	}

	private boolean trySolve(int valueIndex) {

		//if solution with stepToTry return true;
		if(valueIndex == 81) {
			System.out.println("Done!");
			System.out.println(sudoku);
			return sudoku.isSolved();
			}

		int x = valueIndex % 9;
		int y = valueIndex / 9;

		//for each possible value v at this step
		for(int valueToTry = 1; valueToTry<= 9; valueToTry++) {
			System.out.println("Index:" + valueIndex + " - trying value: " + valueToTry + " at x:" + x + ", y:" + y + "");
			sudoku.setValue(x,y, valueToTry);
			
			//if valid(v) then result = backtrack(v)
			if(sudoku.isValid()){
				if(trySolve(valueIndex +1)) {
					// if result = success return result
					return true;
				}
			}
		}
		//remove the attempted value
		sudoku.setValue(x,y, 0);
		return false;
	}
}