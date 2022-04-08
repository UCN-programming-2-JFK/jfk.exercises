package jfk.exercises.skeletons.maze.ui;

import java.awt.*;
import javax.swing.*;

import jfk.exercises.skeletons.maze.model.Maze;
import jfk.exercises.skeletons.maze.tools.MazeCreator;

public class MazeFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static MazePanel panel;
	private static int columns = 19, rows = 19, tileSizeInPixels = 32;
	private static Maze maze;

	public static void main(String[] args) {

		MazeFrame window = new MazeFrame();
		window.setTitle("Maze visualizer");
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		maze = MazeCreator.CreateMaze(columns, rows, new Point(1,1), new Point(columns-2, rows-2));
		panel.setMaze(maze);
		solve();
		panel.repaint();
	}

private static void solve() {
	// add code to solve maze, and add solution to MazePanel to show it
	//example code below...
	
	
	//example solution visualization - delete this when you have your solution
	for(int x = 2; x < maze.getColumns()-2; x ++) {
		panel.getSolution().add(new Point(x, 1));
	}
	for(int y = 1; y < maze.getRows()-2; y ++) {
		panel.getSolution().add(new Point(maze.getColumns()-2, y));
	}
}

	public MazeFrame() {
		getRootPane().setLayout(new BorderLayout());
		panel = new MazePanel(columns, rows, tileSizeInPixels);
		JScrollPane scrollPane = new JScrollPane(panel);
		getRootPane().add(scrollPane);
	}
}