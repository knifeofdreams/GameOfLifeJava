/*
 * Copyright © 2019 Judit Ördög-Andrási <knifeofdreams86@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 */
package io.github.knifeofdreams.gameoflife;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.abs;

public class GameOfLife {

    private final List<Cell> initialPopulation;

    public GameOfLife(List<Cell> initialPopulation) {
        this.initialPopulation = initialPopulation;
    }

    public List<Cell> stepGeneration() {
        final Stream<Cell> cellStream = initialPopulation
                .stream()
                .filter(cell -> neighbourCount(cell) == 2 || neighbourCount(cell) == 3);
        return cellStream
                .collect(Collectors.toList());
    }

    private long neighbourCount(Cell assessedCell) {
        final List<Cell> neighbours = getNeighbours(assessedCell);
        return neighbours
                .stream()
                .count();
    }

    private List<Cell> getNeighbours(Cell cell) {
        return initialPopulation
                .stream()
                .filter(populationCell -> areNeighbours(populationCell, cell))
                .collect(Collectors.toList());
    }

    private boolean areNeighbours(Cell cell1, Cell cell2) {
        return cell1 != cell2
                && abs(cell1.getX() - cell2.getX()) <= 1
                && abs(cell1.getY() - cell2.getY()) <= 1;
    }

}
