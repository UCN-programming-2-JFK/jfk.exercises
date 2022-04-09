package jfk.exercises.skeletons.maze.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import jfk.exercises.skeletons.maze.model.Maze;

import java.util.*;

public class MazePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Point lastMousePosition = new Point();
	private Point lastMouseTilePosition = new Point();
	private int tileSize;
	private Maze maze;
	private java.util.List<Point> solution = new ArrayList<Point>();

	public MazePanel(int columns, int rows, int tileSizeInPixels) {
		setTileSize(tileSizeInPixels);
		setMaze(new Maze(columns, rows, new Point(1,1), new Point(columns-2, rows-2)));
		setPreferredSize(new Dimension(getMaze().getColumns() * getTileSize(), getMaze().getRows() * getTileSize()));
	}

	public java.util.List<Point> getSolution() {
		return solution;
	}

	public void setSolution(java.util.List<Point> solution) {
		this.solution = solution;
	}

	@Override
	public void paint(Graphics g) {
		paintMaze(g);
		drawSolution(g);
		paintStartingAndEndingPoints(g);
	}

	private void drawSolution(Graphics g) {
		if(solution== null) {return;}
		for(Point point : solution){
			drawTile(g, point.x, point.y , Color.orange);
		}
	}

	private void paintStartingAndEndingPoints(Graphics g) {
		if(maze.getStartingPoint() != null) {
			g.setColor(Color.green);
			drawTile(g, maze.getStartingPoint().x, maze.getStartingPoint().y , Color.green);
		}
		if(maze.getEndPoint() != null) {
			drawTile(g, maze.getEndPoint().x, maze.getEndPoint().y , Color.red);
		}
	}

	private void paintMaze(Graphics g) {
		Maze maze = getMaze();
		for (int y = 0; y < maze.getRows(); y++) {
			for (int x = 0; x < maze.getColumns(); x++) {
				drawTile(g, x, y , maze.getTiles()[x][y] ? Color.black : Color.white);
			}
		}
	}
	
	private void drawTile(Graphics g, int column, int row, Color color) {
		g.setColor(color);
		g.fillRect(column * getTileSize(), row * getTileSize(), getTileSize(), getTileSize());
	}

	public int getTileSize() {
		return tileSize;
	}

	public void setTileSize(int tileSize) {
		this.tileSize = tileSize;
	}

	public Maze getMaze() {
		return maze;
	}

	public void setMaze(Maze maze) {
		this.maze = maze;
	}
}