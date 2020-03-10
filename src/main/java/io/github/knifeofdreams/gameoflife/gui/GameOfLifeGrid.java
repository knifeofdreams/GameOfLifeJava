package io.github.knifeofdreams.gameoflife.gui;

import io.github.knifeofdreams.gameoflife.Cell;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

public class GameOfLifeGrid extends JComponent {

  private static final int GRID_SIZE = 10;

  private List<Cell> generation = List.of();

  public GameOfLifeGrid() {
    setPreferredSize(new Dimension(800, 800));
  }

  public void updateGeneration(List<Cell> generation) {
    this.generation = generation;
    SwingUtilities.invokeLater(this::repaint);
  }

  @Override
  protected void paintComponent(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);
    g.setColor(Color.LIGHT_GRAY);
    drawHorizontalGrid(g);
    drawVerticalGrid(g);
    drawGeneration(g);
  }

  private void drawGeneration(Graphics g) {
    g.setColor(Color.BLACK);
    generation.stream()
        .filter(Cell::isAlive)
        .forEach(cell -> {
          g.fillRect(cell.getX() * GRID_SIZE, cell.getY() * GRID_SIZE, GRID_SIZE, GRID_SIZE);
        });
    g.setColor(Color.GREEN);
    generation.stream()
        .filter(cell -> !cell.isAlive())
        .forEach(cell -> {
          g.fillRect(cell.getX() * GRID_SIZE, cell.getY() * GRID_SIZE, GRID_SIZE, GRID_SIZE);
        });
  }

  private void drawHorizontalGrid(Graphics g) {
    var height = g.getClipBounds().height;
    for (int x = 0; x < g.getClipBounds().width; x += GRID_SIZE) {
      g.drawLine(x, 0, x, height);
    }
  }

  private void drawVerticalGrid(Graphics g) {
    var width = g.getClipBounds().width;
    for (int y = 0; y < g.getClipBounds().height; y += GRID_SIZE) {
      g.drawLine(0, y, width, y);
    }
  }
}
