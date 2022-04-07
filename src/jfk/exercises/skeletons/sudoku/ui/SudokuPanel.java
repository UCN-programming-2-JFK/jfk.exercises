package jfk.exercises.skeletons.sudoku.ui;

import java.awt.*;
import javax.swing.JPanel;

import jfk.exercises.skeletons.sudoku.model.Sudoku;

public class SudokuPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private Sudoku sudoku = null;
	
	public Sudoku getSudoku() {
		return sudoku;
	}
	
	public void setSudoku(Sudoku sudoku) {
		this.sudoku = sudoku;
	}
	
	public SudokuPanel() {
		setMinimumSize(new Dimension(720, 720));
		setPreferredSize(getMinimumSize());
	}

	@Override
	public void paint(Graphics g) {
		drawGridAndValues(g);
	}

	private void drawGridAndValues(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		float f = 55.0f;
		g.setFont(g.getFont().deriveFont(f));
		int tileSize = getWidth() / 9;

		markErrorsIfAny(g, tileSize);

		g.setColor(Color.black);

		//draw small cells
		for (int rowCounter = 0; rowCounter < 9; rowCounter++) {
			for (int columnCounter = 0; columnCounter < 9; columnCounter++) {
				g.drawRect(columnCounter * tileSize, rowCounter * tileSize, tileSize, tileSize);
				if (getSudoku().getValue(columnCounter,rowCounter) != 0) {
					g.drawString(getSudoku().getValue(columnCounter,rowCounter) + "",
							columnCounter * tileSize + tileSize / 3, rowCounter * tileSize + tileSize - tileSize / 4);
				}
			}
		}

		//draw thick lines around the 9 3x3 squares
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setStroke(new BasicStroke(7));
		for (int rowCounter = 0; rowCounter < 3; rowCounter++) {
			for (int columnCounter = 0; columnCounter < 3; columnCounter++) {
				g.drawRect(columnCounter * tileSize * 3, rowCounter * tileSize * 3, tileSize * 3, tileSize * 3);
			}
		}
		graphics2d.setStroke(new BasicStroke(1));
	}

	private void markErrorsIfAny(Graphics g, int tileSize) {
		g.setColor(Color.yellow);
		for (int rowCounter = 0; rowCounter < 9; rowCounter++) {
			if (!getSudoku().isRowValid(rowCounter)) {
				g.fillRect(0, rowCounter * tileSize, tileSize * 9, tileSize);
			}
		}

		for (int columnCounter = 0; columnCounter < 9; columnCounter++) {
			if (!getSudoku().isColumnValid(columnCounter)) {
				g.fillRect(columnCounter * tileSize, 0, tileSize, tileSize * 9);
			}
		}

		for (int quadrantYCounter = 0; quadrantYCounter < 3; quadrantYCounter++) {
			for (int quadrantXCounter = 0; quadrantXCounter < 3; quadrantXCounter++) {
				if (!getSudoku().isQuadrantValid(quadrantXCounter, quadrantYCounter)) {
					g.fillRect(quadrantXCounter * tileSize * 3, quadrantYCounter * tileSize * 3, tileSize * 3,
							tileSize * 3);
				}
			}
		}
	}
}