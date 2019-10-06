import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOfLifeTest {

  @Test
  void life_the_universe_and_everything() {
    int expected = 42;
    int actual = GameOfLife.answer();
    assertEquals(expected, actual);
  }

}
