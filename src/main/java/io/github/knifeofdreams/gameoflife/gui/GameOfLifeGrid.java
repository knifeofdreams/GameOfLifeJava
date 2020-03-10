package io.github.knifeofdreams.gameoflife.gui;

import io.github.knifeofdreams.gameoflife.Cell;
import io.github.knifeofdreams.gameoflife.GameOfLife;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.Timer;

public class GameOfLifeGrid extends JComponent {

  private static final int GRID_SIZE = 10;
  private static final int GENERATION_LENGTH = 333;

  private List<Cell> generation;

  public GameOfLifeGrid(List<Cell> initialGeneration) {
    this.generation = initialGeneration;
    setPreferredSize(new Dimension(800, 800));
  }

  public void startTimer() {
    Timer timer = new Timer(GENERATION_LENGTH, this::nextGeneration);
    timer.setRepeats(true);
    timer.start();
  }

  private void nextGeneration(ActionEvent actionEvent) {
    generation = new GameOfLife(generation).stepGeneration();
    updateUI();
  }

  @Override
  protected void paintComponent(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillRect(0, 0, g.getClipBounds().width, g.getClipBounds().height);
    g.setColor(Color.LIGHT_GRAY);
    drawHorizontalGrid(g);
    drawVerticalGrid(g);
    g.setColor(Color.BLACK);
    drawGeneration(g);

  }

  private void drawGeneration(Graphics g) {
    generation.stream()
        .filter(Cell::isAlive)
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
    for (int y = 0; y < g.getClipBounds().height; y+=GRID_SIZE) {
      g.drawLine(0, y, width, y);
    }
  }
}
