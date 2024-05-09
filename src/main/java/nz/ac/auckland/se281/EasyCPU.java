package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class EasyCPU extends CPU {

  public EasyCPU(Choice winCondition) {
    super(new RandomStrategy(), winCondition);
  }

  @Override
  public int play() {
    return strategy.getAction();
  }
}
