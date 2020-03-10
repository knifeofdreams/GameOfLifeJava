package io.github.knifeofdreams.gameoflife;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void canBeCreatedWithCoordinates() {
        Cell cell = new Cell(0, 1);
    }

    @Test
    void canGetXCoordinate() {
        Cell cell = new Cell(0, 1);
        assertEquals(0, cell.getX());
    }

    @Test
    void canGetYCoordinate() {
        Cell cell = new Cell(0, 1);
        assertEquals(1, cell.getY());
    }


}
