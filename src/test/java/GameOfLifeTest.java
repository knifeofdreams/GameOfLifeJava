import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTest {

  @Test
  void emptyPopulationStepsToEmptyPopulation() {
    final ArrayList<Integer> emptyPopulation = new ArrayList<Integer>();
    assertEquals(emptyPopulation, GameOfLife.stepGeneration(emptyPopulation));
  }

}
