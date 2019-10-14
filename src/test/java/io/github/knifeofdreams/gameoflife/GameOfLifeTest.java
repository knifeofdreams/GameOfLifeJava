/*
 * Copyright © 2019 Judit Ördög-Andrási <knifeofdreams86@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 */
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
    final List<Integer> initialPopulation = List.of(2, 0, 0, 2, 1);
    final List<Integer> expectedPopulation = List.of(2, 2);

    assertEquals(expectedPopulation, GameOfLife.stepGeneration(initialPopulation));
  }

  @Test
  public void cellsWith2r3NeighboursLiveToNextGeneration() {
    final List<Integer> initialPopulation = List.of(2, 0, 3, 2, 1);
    final List<Integer> expectedPopulation = List.of(2, 3, 2);

    assertEquals(expectedPopulation, GameOfLife.stepGeneration(initialPopulation));
  }

  @Test
  public void cellsWithMoreThan3NeighboursDie() {
    final List<Integer> initialPopulation = List.of(2, 4, 3, 2, 5, 8);
    final List<Integer> expectedPopulation = List.of(2, 3, 2);

    assertEquals(expectedPopulation, GameOfLife.stepGeneration(initialPopulation));
  }
}
