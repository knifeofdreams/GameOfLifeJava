package io.github.knifeofdreams.gameoflife;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

public class GameOfLifeTest {

  @Test
  void emptyPopulationStepsToEmptyPopulation() {
    final List<Integer> emptyPopulation = List.of();
    assertEquals(emptyPopulation, GameOfLife.stepGeneration(emptyPopulation));
  }

  @Test
  public void cellsWithLessThanTwoNeighboursDie() {
    final List<Integer> initialPopulation = List.of(2, 3, 1);

    final List<Integer> expectedPopulation = List.of(2, 3);

    assertEquals(expectedPopulation, GameOfLife.stepGeneration(initialPopulation));
  }

}
