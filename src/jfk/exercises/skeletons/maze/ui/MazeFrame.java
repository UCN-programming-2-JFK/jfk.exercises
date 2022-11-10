package jfk.exercises.skeletons.maze.ui;

import java.awt.*;
import javax.swing.*;

import jfk.exercises.skeletons.maze.model.Maze;
import jfk.exercises.skeletons.maze.tools.MazeCreator;
import jfk.exercises.skeletons.solutions.MazeFrameSolutionWindow;

public class MazeFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static MazeFrame window;
	protected MazePanel panel;
	private static int columns = 29, rows = 29, tileSizeInPixels = 32;
	protected Maze maze;

	public static void main(String[] args) {

		window = new MazeFrame();
		
		//uncomment the line below to see a possible solution
		//window = new MazeFrameSolutionWindow();
		
		window.setTitle("Maze visualizer");
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		window.maze = MazeCreator.CreateMaze(columns, rows, new Point(1, 1), new Point(columns - 2, rows - 2));
		window.panel.setMaze(window.maze);
		window.solve();
		window.panel.repaint();
	}

	protected void solve() {
		// add code to solve maze, and add solution to MazePanel to show it
		// example code below...

		// example solution visualization - delete this when you have your solution
		for (int x = 2; x < maze.getColumns() - 2; x++) {
			panel.getSolution().add(new Point(x, 1));
		}
		for (int y = 1; y < maze.getRows() - 2; y++) {
			panel.getSolution().add(new Point(maze.getColumns() - 2, y));
		}
	}

	public MazeFrame() {
		getRootPane().setLayout(new BorderLayout());
		panel = new MazePanel(columns, rows, tileSizeInPixels);
		JScrollPane scrollPane = new JScrollPane(panel);
		getRootPane().add(scrollPane);
	}
}