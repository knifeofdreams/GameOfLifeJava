/*
 * Copyright © 2019 Judit Ördög-Andrási <knifeofdreams86@gmail.com>
 * This work is free. You can redistribute it and/or modify it under the
 * terms of the Do What The Fuck You Want To Public License, Version 2,
 * as published by Sam Hocevar. See the COPYING file for more details.
 */
package io.github.knifeofdreams.gameoflife;

import java.util.List;
import java.util.stream.Collectors;

public class GameOfLife {

  public static List<Integer> stepGeneration(List<Integer> population) {
    return population
        .stream()
        .filter(neighbours -> neighbours == 2 || neighbours == 3)
        .collect(Collectors.toList());
  }
}
