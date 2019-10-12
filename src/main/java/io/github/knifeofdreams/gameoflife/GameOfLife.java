package io.github.knifeofdreams.gameoflife;

import java.util.List;
import java.util.stream.Collectors;

public class GameOfLife {

  public static List<Integer> stepGeneration(List<Integer> population) {
    return population
        .stream()
        .filter(neighbours -> neighbours >= 2)
        .collect(Collectors.toList());
  }
}
