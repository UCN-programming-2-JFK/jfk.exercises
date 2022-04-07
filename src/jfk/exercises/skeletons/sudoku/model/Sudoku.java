package jfk.exercises.skeletons.sudoku.model;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

	private int[][] values = new int[9][9];

	public void setValue(int x, int y, int value) {	values[x][y] = value;}
	public int getValue(int x, int y) {return values[x][y];}
	
	public boolean isValid() {
		for (int quadrantxCounter = 0; quadrantxCounter < 3; quadrantxCounter++) {
			for (int quadrantyCounter = 0; quadrantyCounter < 3; quadrantyCounter++) {
				if (!isQuadrantValid(quadrantxCounter, quadrantyCounter)) {
					return false;
				}
			}
		}
		for (int rowCounter = 0; rowCounter < 9; rowCounter++) {
			if (!isRowValid(rowCounter)) {
				return false;
			}
		}

		for (int columnCounter = 0; columnCounter < 9; columnCounter++) {
			if (!isColumnValid(columnCounter)) {
				return false;
			}
		}

		return true;
	}

	public boolean isSolved() {
		for (int columnCounter = 0; columnCounter < 9; columnCounter++) {
			for (int rowCounter = 0; rowCounter < 9; rowCounter++) {
				int value = values[columnCounter][rowCounter];
				if (value < 1 || value > 9) {
					return false;
				}
			}
		}
		return isValid();
	}

	public boolean isQuadrantValid(int quadrantX, int quadrantY) {

		Set<Integer> set = new HashSet<>();

		for (int quadrantxCounter = 0; quadrantxCounter < 3; quadrantxCounter++) {
			for (int quadrantyCounter = 0; quadrantyCounter < 3; quadrantyCounter++) {
				int x = quadrantX * 3 + quadrantxCounter;
				int y = quadrantY * 3 + quadrantyCounter;
				Integer valueFound = Integer.valueOf((values[x][y]));
				if (valueFound != 0 && !set.add(valueFound)) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isRowValid(int row) {

		Set<Integer> set = new HashSet<>();

		for (int columnCounter = 0; columnCounter < 9; columnCounter++) {
			Integer valueFound = Integer.valueOf((values[columnCounter][row]));
			if (valueFound != 0 && !set.add(valueFound)) {
				return false;
			}
		}

		return true;
	}

	public boolean isColumnValid(int column) {

		Set<Integer> set = new HashSet<>();

		for (int rowCounter = 0; rowCounter < 9; rowCounter++) {
			Integer valueFound = Integer.valueOf((values[column][rowCounter]));
			if (valueFound != 0 && !set.add(valueFound)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int rowCounter = 0; rowCounter < 9; rowCounter++) {
			for (int columnCounter = 0; columnCounter < 9; columnCounter++) {
				String value = values[columnCounter][rowCounter] + "";
				if (value.equals("0")) {
					value = ".";
				}
				builder.append(value);
			}
			builder.append("\n");
		}
		return builder.toString();
	}	
}