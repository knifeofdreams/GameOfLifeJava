package io.github.knifeofdreams.gameoflife.gui;

import io.github.knifeofdreams.gameoflife.Cell;
import io.github.knifeofdreams.gameoflife.GameOfLife;
import java.util.List;

public class Life {

  private static final int GENERATION_LENGTH = 1000;

  private final GameOfLifeGrid grid;
  private List<Cell> generation;

  public Life(GameOfLifeGrid grid, List<Cell> initialGeneration) {
    this.grid = grid;
    this.generation = initialGeneration;
  }

  public void start() {
    Thread t = new Thread(this::runLife);
    t.setDaemon(true);
    t.start();
  }

  private void runLife() {
//    grid.updateGeneration(this.generation);
    try {
      while (true) {
        grid.updateGeneration(this.generation);
        Thread.sleep(GENERATION_LENGTH);
        this.generation = new GameOfLife(this.generation).stepGeneration();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
