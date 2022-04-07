package jfk.exercises.skeletons.maze.tools;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import jfk.exercises.skeletons.maze.model.Maze;


public class MazeCreator{

	public static Maze CreateMaze(int columns, int rows, Point startingPoint, Point endPoint) {
		Maze mazeToExcavate = new Maze(columns, rows, startingPoint, endPoint);
		MazeCreator excavator = new MazeCreator(mazeToExcavate);
		while(! excavator.isDone()) {
			excavator.excavateNext();
		}
		return mazeToExcavate;
	}
	
	private Random random = new Random();
	private Maze maze;
	private Point currentPoint;
	private Stack<Point> tilesToCheck = new Stack<Point>();
	
	private Point getCurrentPoint() {
		return currentPoint;
	}
	
	private void setCurrentPoint(Point currentPoint) {
		this.currentPoint = currentPoint;
	}
	
	private void setMaze(Maze mazeToExcavate) {
		this.maze = mazeToExcavate;
	}
	
	private Maze getMaze() {
		return this.maze;
	}
	private Random getRandom() {
		return this.random;
	}

	private boolean isDone() {
		return getTilesToCheck().size() == 0;
	}
	
	public List<Point> getTilesToCheck() {
		return tilesToCheck;
	}

	private MazeCreator(Maze mazeToExcavate) {
		setMaze(mazeToExcavate);
		currentPoint = maze.getStartingPoint();
		mazeToExcavate.setAllTiles(true);
		tilesToCheck.push(getCurrentPoint());
	}
		
	private void excavateNext() {		
		
		getMaze().setTile(getCurrentPoint(), false);
		
		List<Point> validNeighbors = MazeTool.getValidNeighbors(getMaze(), getCurrentPoint());
			
		if(validNeighbors.size() > 0 && !getCurrentPoint().equals(getMaze().getEndPoint())) {
			tilesToCheck.push(getCurrentPoint());
			setCurrentPoint(validNeighbors.get(getRandom().nextInt(validNeighbors.size())));
		}
		else
			{
				setCurrentPoint( tilesToCheck.pop());
			}
		
	}
}