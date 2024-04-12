package jfk.exercises.solutions;

import java.awt.Point;
import java.util.*;

import jfk.exercises.skeletons.maze.tools.MazeTool;
import jfk.exercises.skeletons.maze.ui.MazeFrame;

public class MazeFrameSolutionWindow extends MazeFrame {

	private static final long serialVersionUID = 1L;

	private Stack<Point> solutionSoFar = new Stack<Point>();

	@Override
	protected void solve() {
		trySolve(maze.getStartingPoint());		
	}

	protected boolean trySolve(Point tileToTry) {
		try {
			panel.setSolution(solutionSoFar);
			panel.repaint();
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		solutionSoFar.push(tileToTry);
		
		// if solution with stepToTry return true;
		if (tileToTry.equals(maze.getEndPoint())) {return true;}

		// if out of possible steps return false
		List<Point> validUntriedNeighbors =	getValidUntriedNeighbors(tileToTry);		

		if(validUntriedNeighbors.size() == 0) System.out.println(tileToTry + " is a dead end! :(");
		// for each possible value v at this step
		for(Point neighbor : validUntriedNeighbors) {
			if(trySolve(neighbor)) {return true;}
		}
		solutionSoFar.pop();
		return false;
	}

	private List<Point> getValidUntriedNeighbors(Point tileToTry) {
		//get all neighbors up, down, left, right
		List<Point> neighbors = MazeTool.getOpenNeighborTilesWithinMazeBorder(maze, tileToTry);

		//remove all neigbors that have already been tried (are already in current solution) 
		for(int tileCounter = neighbors.size()-1; tileCounter >= 0; tileCounter--) {
			Point neighbor = neighbors.get(tileCounter);
			if(solutionSoFar.contains(neighbor)) {
				neighbors.remove(tileCounter);
			}
		}
		//return valid options to go to
		return neighbors;
	}
}