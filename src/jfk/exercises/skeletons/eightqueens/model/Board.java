package jfk.exercises.skeletons.eightqueens.model;

import java.awt.Point;
import java.util.Iterator;

public class Board implements Iterable<Point> {

	private int columns = 8, rows = 8;
	private boolean[][] tiles = new boolean[columns][rows];
	
	public int getColumns() {
		return columns;
	}

	public int getRows() {
		return rows;
	}

	public boolean[][] getTiles() {
		return tiles;
	}

	public void setTiles(boolean[][] tiles) {
		this.tiles = tiles;
	}

	public void clear() {
		for (Point tile : this) {
			setHasQueen(tile, false);
		}
	}

	public void setHasQueen(int column, int row, boolean hasQueen) {
		getTiles()[column][row] = hasQueen;
	}
	
	public void setHasQueen(int column, int row) {
		setHasQueen(column, row, true);
	}

	public boolean getHasQueen(int column, int row) {
		return getTiles()[column][row];
	}
	
	public boolean getHasQueen(Point point) {
		return getTiles()[point.x][point.y];
	}

	public void setHasQueen(Point tile, boolean blocked) {
		setHasQueen(tile.x, tile.y, blocked);
	}

	@Override
	public Iterator<Point> iterator() {

		return new Iterator<Point>() {

			private int tileIndex = 0;

			@Override
			public boolean hasNext() {
				return tileIndex < getColumns() * getRows();
			}

			@Override
			public Point next() {
				Point currentPoint = new Point(tileIndex % getColumns(), tileIndex / getColumns());
				tileIndex++;
				return currentPoint;
			}
		};
	}
}