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
    final List<Integer> initialPopulation = List.of(2, 3, 1);

    final List<Integer> expectedPopulation = List.of(2, 3);

    assertEquals(expectedPopulation, GameOfLife.stepGeneration(initialPopulation));
  }

}
