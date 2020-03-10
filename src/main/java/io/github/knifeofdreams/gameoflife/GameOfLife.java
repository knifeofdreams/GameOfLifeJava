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
        Stream<Cell> population = Stream.concat(initialPopulation.stream(), getDeadNeighbours().stream());
        return population
                .filter(cell -> cell.isAlive() && liveNeighbourCount(cell) == 2
                        || cell.isAlive() && liveNeighbourCount(cell) == 3
                        || !cell.isAlive() && liveNeighbourCount(cell) == 3)
                .collect(Collectors.toList());
    }

    private long liveNeighbourCount(Cell assessedCell) {
        return getLiveNeighbours(assessedCell)
                .stream()
                .count();
    }

    private List<Cell> getLiveNeighbours(Cell cell) {
        return initialPopulation
                .stream()
                .filter(populationCell -> areLiveNeighbours(cell, populationCell))
                .collect(Collectors.toList());
    }

    private boolean areLiveNeighbours(Cell comparedCell, Cell cellToCompareTo) {
        return comparedCell != cellToCompareTo
                && cellToCompareTo.isAlive()
                && abs(comparedCell.getX() - cellToCompareTo.getX()) <= 1
                && abs(comparedCell.getY() - cellToCompareTo.getY()) <= 1;
    }

    private List<Cell> getDeadNeighbours() {
        return initialPopulation
                .stream()
                .flatMap(cell -> getDeadNeighbours(cell))
                .filter(cell -> !initialPopulation.contains(cell))
                .distinct()
                .collect(Collectors.toList());
    }

    private Stream<Cell> getDeadNeighbours(Cell cell) {
        return Stream.of(
                new Cell(cell.getX() - 1, cell.getY() - 1, false),
                new Cell(cell.getX(), cell.getY() - 1, false),
                new Cell(cell.getX() + 1, cell.getY() - 1, false),
                new Cell(cell.getX() - 1, cell.getY(), false),
                new Cell(cell.getX() + 1, cell.getY(), false),
                new Cell(cell.getX() - 1, cell.getY() + 1, false),
                new Cell(cell.getX(), cell.getY() + 1, false),
                new Cell(cell.getX() + 1, cell.getY() + 1, false));
    }

}
