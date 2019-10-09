import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTest {

  @Test
  void emptyPopulationStepsToEmptyPopulation() {
    final ArrayList<Integer> emptyPopulation = new ArrayList<>();
    assertEquals(emptyPopulation, GameOfLife.stepGeneration(emptyPopulation));
  }

  @Test
  public void cellsWithLessThanTwoNeighboursDie() {
    final ArrayList<Integer> initialPopulation = new ArrayList<>();
    initialPopulation.add(2);
    initialPopulation.add(3);
    initialPopulation.add(1);

    final ArrayList<Integer> expectedPopulation = new ArrayList<>();
    expectedPopulation.add(2);
    expectedPopulation.add(3);

    assertEquals(expectedPopulation, GameOfLife.stepGeneration(initialPopulation));
  }

}
