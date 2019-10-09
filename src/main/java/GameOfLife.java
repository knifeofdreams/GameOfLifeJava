import java.util.ArrayList;
import java.util.stream.Collectors;

public class GameOfLife {

  public static ArrayList<Integer> stepGeneration(ArrayList<Integer> population) {
    return population
        .stream()
        .filter(neighbours -> neighbours >= 2)
        .collect(Collectors
                     .toCollection(ArrayList::new));
  }
}
