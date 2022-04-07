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
		MouseAdapter adapter = getMouseAdapter();
		addMouseListener(adapter);
		addMouseMotionListener(adapter);
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
		drawCursor(g);
		paintStartingAndEndingPoints(g);
		drawSolution(g);
	}

	private void drawSolution(Graphics g) {
		if(solution== null) {return;}
		for(Point point : solution){
			drawTile(g, point.x, point.y , Color.yellow);
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

	private void drawCursor(Graphics g) {
		g.setColor(Color.red);
		g.drawRect(lastMouseTilePosition.x * getTileSize(), lastMouseTilePosition.y * getTileSize(), getTileSize() - 1,
				getTileSize() - 1);
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

	private void updateMousePosition(MouseEvent e) {
		lastMousePosition = e.getPoint();
		Point possibleTilePosition = getTilePositionFromLastMousePosition();
		if (getMaze().contains(possibleTilePosition)) {
			lastMouseTilePosition = possibleTilePosition;
		}
		repaint();
	}

	private Point getTilePositionFromLastMousePosition() {
		int mouseColumn = lastMousePosition.x / getTileSize();
		int mouseRow = lastMousePosition.y / getTileSize();
		return new Point(mouseColumn, mouseRow);
	}
	
	private void updateTileBasedOnMousePress(MouseEvent e) {
		updateMousePosition(e);
		if (SwingUtilities.isLeftMouseButton(e)) {
			if(e.getModifiersEx() == InputEvent.CTRL_DOWN_MASK) {
					getMaze().setStartingPoint(lastMouseTilePosition);
					getMaze().getTiles()[lastMouseTilePosition.x][lastMouseTilePosition.y] = false;
				}
			else if(e.getModifiersEx() == InputEvent.SHIFT_DOWN_MASK) {
				getMaze().setEndPoint(lastMouseTilePosition);
				getMaze().getTiles()[lastMouseTilePosition.x][lastMouseTilePosition.y] = false;
			}
			else	{
				getMaze().getTiles()[lastMouseTilePosition.x][lastMouseTilePosition.y] = true;	
			}
		} else if (SwingUtilities.isRightMouseButton(e)) {
			getMaze().getTiles()[lastMouseTilePosition.x][lastMouseTilePosition.y] = false;
		}
		repaint();
	}
	
	private MouseAdapter getMouseAdapter() {
		return new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				updateMousePosition(e);
			}
			
			public void mouseClicked(MouseEvent e) {
				updateTileBasedOnMousePress(e);							
			}
			
			@Override
			public void mouseMoved(MouseEvent e) {
				updateMousePosition(e);
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				updateTileBasedOnMousePress(e);
			}
		};
	}
}