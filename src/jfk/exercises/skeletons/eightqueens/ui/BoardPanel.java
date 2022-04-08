package jfk.exercises.skeletons.eightqueens.ui;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import jfk.exercises.skeletons.eightqueens.model.Board;
import jfk.exercises.skeletons.maze.model.Maze;

import java.util.*;

public class BoardPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private int tileSize;
	private Board board;
	private static Color brown = new Color(165, 82, 42);
	private static Color lightBrown = new Color(222, 184, 135);
	private BufferedImage queen;

	public BoardPanel(int tileSizeInPixels) {
		board = new Board();
		queen = loadImage("/graphics/queen.png");
		setTileSize(tileSizeInPixels);
		setPreferredSize(new Dimension(getBoard().getColumns() * getTileSize(), getBoard().getRows() * getTileSize()));
	}

	@Override
	public void paint(Graphics g) {
		drawBoard(g);
	}

	private void drawBoard(Graphics g) {
		//smooth the graphics (edges) for drawing images
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		((Graphics2D) g).setRenderingHints(rh);
		for (int y = 0; y < board.getRows(); y++) {
			for (int x = 0; x < board.getColumns(); x++) {
				//draw the tile background
				drawTile(g, x, y, (x + y) % 2 == 0 ? brown : lightBrown);
				if (board.getHasQueen(x, y)) {
					//draw the queen if there is one
					g.drawImage(queen, x * tileSize, y * tileSize, tileSize, tileSize, null);
				}
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

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	private BufferedImage loadImage(String imagePathOrUrl) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(this.getClass().getResource(imagePathOrUrl));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return image;
	}
}