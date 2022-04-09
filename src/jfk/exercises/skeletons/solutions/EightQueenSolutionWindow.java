package jfk.exercises.skeletons.solutions;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

import jfk.exercises.skeletons.eightqueens.model.Board;
import jfk.exercises.skeletons.eightqueens.ui.BoardFrame;

public class EightQueenSolutionWindow extends BoardFrame {
	private List<Point> diagonalDirections = Arrays.asList(new Point(-1, -1), new Point(1, -1), new Point(-1, 1),
			new Point(1, 1));
	private static final long serialVersionUID = 1L;

	@Override
	protected void solve() {
		board.clear();
		trySolve(0);
	}

	private boolean trySolve(int valueIndex) {

		// if solution with stepToTry return true;
		if (numberOfQueensOnBoard(board) == 8) {
			System.out.println("Done!");
			return true;
		}

		// if out of possible steps return false;
		if (valueIndex == 64) {
			return false;
		}

		int x = valueIndex % board.getColumns();
		int y = valueIndex / board.getRows();

		// for each possible value v at this step
		System.out.println("Index:" + valueIndex + " - trying WITH a queen at x:" + x + ", y:" + y + "");
		board.setHasQueen(x, y);

		//if valid(v) then result = backtrack(v)
		//if result = success return result
		if (isValid(board)) {
			if (trySolve(valueIndex + 1)) {return true;}
		}
		
		//for each possible value v at this step 
		board.setHasQueen(x, y, false);
		System.out.println("Index:" + valueIndex + " - trying WITHOUT a queen at x:" + x + ", y:" + y + "");
		//if valid(v) then result = backtrack(v)
		//if result = success return result
		if (trySolve(valueIndex + 1)) {return true;}
		return false;
	}

	private int numberOfQueensOnBoard(Board board) {
		int numberOfQueens = 0;
		for (Point point : board) {
			if (board.getHasQueen(point)) {
				numberOfQueens++;
			}
		}
		return numberOfQueens;
	}

	private boolean isValid(Board board) {
		for (int x = 0; x < board.getColumns(); x++) {
			for (int y = 0; y < board.getRows(); y++) {
				if (board.getHasQueen(x, y)) {
					System.out.println("isValid(" + x + "," + y + ")");
					if (!queenPositionIsValid(x, y)) {
						return false;
					}
				}
			}
		}
		return true;

	}

	private boolean queenPositionIsValid(int x, int y) {

		if (getNumberOfOtherQueensInAttackLanes(x, y) > 0) {
			return false;
		}
		return true;
	}

	private int getNumberOfOtherQueensInAttackLanes(int x, int y) {
		int numberOfOtherQueensInAttackLanes = 0;
		for (Point point : getPotentialProblemSquares(new Point(x, y))) {
			if (board.getHasQueen(point)) {
				numberOfOtherQueensInAttackLanes++;
			}
		}
		return numberOfOtherQueensInAttackLanes;
	}

	private List<Point> getPotentialProblemSquares(Point queen) {

		List<Point> potentialProblemSquares = new ArrayList<Point>();
		for (int x = 0; x < board.getColumns(); x++) {
			Point potentialProblem = new Point(x, queen.y);
			if (!queen.equals(potentialProblem)) {
				potentialProblemSquares.add(potentialProblem);
			}
		}

		for (int y = 0; y < board.getRows(); y++) {
			Point potentialProblem = new Point(queen.x, y);
			if (!queen.equals(potentialProblem)) {
				potentialProblemSquares.add(potentialProblem);
			}
		}
		for (Point direction : diagonalDirections) {

			Point pointToCheck = new Point(queen.x, queen.y);
			while (isInsideBoard(pointToCheck)) {
				if (!pointToCheck.equals(queen)) {
					potentialProblemSquares.add(new Point(pointToCheck));
				}
				pointToCheck.translate(direction.x, direction.y);
			}
		}
		return potentialProblemSquares;
	}

	private boolean isInsideBoard(Point pointToCheck) {
		return pointToCheck.x >= 0 && pointToCheck.x < board.getColumns() && pointToCheck.y >= 0
				&& pointToCheck.y < board.getRows();
	}
}