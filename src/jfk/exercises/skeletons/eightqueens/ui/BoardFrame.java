package jfk.exercises.skeletons.eightqueens.ui;

import java.awt.*;
import javax.swing.*;

import jfk.exercises.skeletons.eightqueens.model.Board;
import jfk.exercises.skeletons.maze.model.Maze;
import jfk.exercises.skeletons.maze.tools.MazeCreator;

public class BoardFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static BoardPanel panel;
	private static int tileSizeInPixels = 64;
	private static Board board = new Board();

	public static void main(String[] args) {

		BoardFrame window = new BoardFrame();
		window.setTitle("8 Queens problem solver");
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		solve();
		panel.repaint();
	}

	private static void solve() {
		// add code to solve the 8 queens problem,
		// and add solution (queen placement) to "board" to show it

		// example solution visualization - delete this when you have your solution
		board.setHasQueen(1, 5);
		board.setHasQueen(3, 1);
		board.setHasQueen(7, 4);
	}

	public BoardFrame() {
		getRootPane().setLayout(new BorderLayout());
		panel = new BoardPanel(tileSizeInPixels);
		panel.setBoard(board);
		JScrollPane scrollPane = new JScrollPane(panel);
		getRootPane().add(scrollPane);
	}
}