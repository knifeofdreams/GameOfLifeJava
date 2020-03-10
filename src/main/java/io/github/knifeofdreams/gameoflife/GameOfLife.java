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

    private final List<Cell> initialAlivePopulation;

    public GameOfLife(List<Cell> initialPopulation) {
        this.initialAlivePopulation = initialPopulation;
    }

    public List<Cell> stepGeneration() {
        return nextGenerationCandidates()
                .filter(cell -> isAliveWithTwoNeighbours(cell) || liveNeighbourCount(cell) == 3)
                .map(cell -> cell.setAlive(true))
                .distinct()
                .collect(Collectors.toList());
    }

    private Stream<Cell> nextGenerationCandidates() {
        return Stream.concat(initialAlivePopulation.stream(), getDeadCandidates());
    }

    private Stream<Cell> getDeadCandidates() {
        return initialAlivePopulation
                .stream()
                .flatMap(cell -> getDeadNeighbours(cell))
                .filter(cell -> !initialAlivePopulation.contains(cell))
                .distinct();
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

    private boolean isAliveWithTwoNeighbours(Cell cell) {
        return cell.isAlive() && liveNeighbourCount(cell) == 2;
    }

    private long liveNeighbourCount(Cell cell) {
        return getLiveNeighbours(cell).count();
    }

    private Stream<Cell> getLiveNeighbours(Cell cell) {
        return initialAlivePopulation
                .stream()
                .filter(cellInAlivePopulation -> areLiveNeighbours(cell, cellInAlivePopulation));
    }

    private boolean areLiveNeighbours(Cell comparedCell, Cell cellToCompareTo) {
        return cellToCompareTo.isAlive()
                && areNeighbours(comparedCell, cellToCompareTo);
    }

    private boolean areNeighbours(Cell comparedCell, Cell cellToCompareTo) {
        return comparedCell != cellToCompareTo
                && abs(comparedCell.getX() - cellToCompareTo.getX()) <= 1
                && abs(comparedCell.getY() - cellToCompareTo.getY()) <= 1;
    }
}
