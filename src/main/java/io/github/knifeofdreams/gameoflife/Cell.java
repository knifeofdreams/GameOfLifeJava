package io.github.knifeofdreams.gameoflife;

import java.util.Objects;

public class Cell {
    private int x;
    private int y;
    private boolean isAlive;

    public Cell(int x, int y, boolean isAlive) {
        this.x = x;
        this.y = y;
        this.isAlive = isAlive;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Cell setAlive(boolean alive) {
        isAlive = alive;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return x == cell.x &&
                y == cell.y &&
                isAlive == cell.isAlive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
