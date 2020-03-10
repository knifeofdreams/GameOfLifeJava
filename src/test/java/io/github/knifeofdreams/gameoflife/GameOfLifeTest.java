/*
 * Copyright © 2019 Judit Ördög-Andrási <knifeofdreams86@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 */
package io.github.knifeofdreams.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTest {

    @Test
    void emptyPopulationStepsToEmptyPopulation() {
        final List<Cell> emptyPopulation = List.of();
        final GameOfLife game = new GameOfLife(emptyPopulation);
        assertEquals(emptyPopulation, game.stepGeneration());
    }

    @Test
    public void cellsWithLessThanTwoNeighboursDie() {
        final GameOfLife game = new GameOfLife(List.of(new Cell(0, 0, true)));
        assertEquals(List.of(), game.stepGeneration());
    }

    @Test
    public void cellsWith2r3NeighboursLiveToNextGeneration() {
        final Cell cellWithOneNeighbour = new Cell(0, 0, true);
        final Cell cellWithTwoNeighbours1 = new Cell(2, 1, true);
        final Cell cellWithTwoNeighbours2 = new Cell(2, 0, true);
        final Cell cellWithThreeNeighbours = new Cell(1, 1, true);

        final List<Cell> initialPopulation = List.of(
                cellWithOneNeighbour,
                cellWithTwoNeighbours1,
                cellWithTwoNeighbours2,
                cellWithThreeNeighbours
        );

        final List<Cell> expectedPopulation = List.of(
                cellWithTwoNeighbours1,
                cellWithTwoNeighbours2,
                cellWithThreeNeighbours
        );

        final GameOfLife game = new GameOfLife(initialPopulation);

        assertEquals(expectedPopulation, game.stepGeneration());
    }

    @Test
    public void cellsWithMoreThan3NeighboursDie() {
        final Cell cell1 = new Cell(0, 0, true);
        final Cell cell2 = new Cell(1, 1, true);
        final Cell cell3 = new Cell(1, 0, true);
        final Cell cell4 = new Cell(2, 0, true);
        final Cell cell5 = new Cell(2, 1, true);

        final List<Cell> initialPopulation = List.of(
                cell1,
                cell2,
                cell3,
                cell4,
                cell5
        );

        final List<Cell> expectedPopulation = List.of(
                cell1,
                cell4,
                cell5,
                new Cell(1, -1, true),
                new Cell(0, 1, true)
        );

        final GameOfLife game = new GameOfLife(initialPopulation);

        assertEquals(expectedPopulation, game.stepGeneration());
    }

    @Test
    public void testDeadCellWithExactlyThreeLiveNeighboursComesAlive() {
        final Cell cell1 = new Cell(0, 0, true);
        final Cell cell2 = new Cell(1, 1, true);
        final Cell cell3 = new Cell(1, 0, true);

        final List<Cell> initialPopulation = List.of(
                cell1,
                cell2,
                cell3
        );

        final List<Cell> expectedPopulation = List.of(
                cell1,
                cell2,
                cell3,
                new Cell(0, 1, true)
        );

        final GameOfLife game = new GameOfLife(initialPopulation);

        assertEquals(expectedPopulation, game.stepGeneration());
    }

}
