package io.github.knifeofdreams.gameoflife.gui;

import io.github.knifeofdreams.gameoflife.Cell;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Main implements Runnable {

  public static void main(String[] args) {
    EventQueue.invokeLater(new Main());
  }

  @Override
  public void run() {

    GameOfLifeGrid gameOfLifeGrid = new GameOfLifeGrid(createInitialGeneration());

    JFrame frame = new JFrame("Game Of Life");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    frame.setContentPane(createContentPane(gameOfLifeGrid));

    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);

    EventQueue.invokeLater(gameOfLifeGrid::startTimer);
  }

  private List<Cell> createInitialGeneration() {
    return List.of(
        new Cell(1, 5, true),
        new Cell(1, 6, true),
        new Cell(2, 5, true),
        new Cell(2, 6, true),
        new Cell(11, 5, true),
        new Cell(11, 6, true),
        new Cell(11, 7, true),
        new Cell(12, 4, true),
        new Cell(12, 8, true),
        new Cell(13, 3, true),
        new Cell(13, 9, true),
        new Cell(14, 3, true),
        new Cell(14, 9, true),
        new Cell(15, 6, true),
        new Cell(16, 4, true),
        new Cell(16, 8, true),
        new Cell(17, 5, true),
        new Cell(17, 6, true),
        new Cell(17, 7, true),
        new Cell(18, 6, true),
        new Cell(21, 3, true),
        new Cell(21, 4, true),
        new Cell(21, 5, true),
        new Cell(22, 3, true),
        new Cell(22, 4, true),
        new Cell(22, 5, true),
        new Cell(23, 2, true),
        new Cell(23, 6, true),
        new Cell(25, 1, true),
        new Cell(25, 2, true),
        new Cell(25, 6, true),
        new Cell(25, 7, true),
        new Cell(35, 3, true),
        new Cell(35, 4, true),
        new Cell(36, 3, true),
        new Cell(36, 4, true)
    );
  }

  private JPanel createContentPane(GameOfLifeGrid gameOfLifeGrid) {
    JPanel panel = new JPanel(new BorderLayout());
    panel.setBorder(
        BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(6, 6, 6, 6),
            BorderFactory.createBevelBorder(BevelBorder.LOWERED)));

    panel.add(gameOfLifeGrid, BorderLayout.CENTER);

    return panel;
  }
}
