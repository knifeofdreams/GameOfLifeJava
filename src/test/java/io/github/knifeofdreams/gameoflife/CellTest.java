package io.github.knifeofdreams.gameoflife;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void canBeCreated() {
        Cell cell = new Cell(0, 1, true);
    }

    @Test
    void canGetXCoordinate() {
        Cell cell = new Cell(0, 1, true);
        assertEquals(0, cell.getX());
    }

    @Test
    void canGetYCoordinate() {
        Cell cell = new Cell(0, 1, true);
        assertEquals(1, cell.getY());
    }

    @Test
    void canGetIsAlive() {
        Cell cell = new Cell(0, 1, true);
        assertTrue(cell.isAlive());
    }


}
