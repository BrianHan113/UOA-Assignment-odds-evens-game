package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class HardCPU extends CPU {

  private TopStrategy topStrategy;

  public HardCPU(Choice winCondition) {
    super(new RandomStrategy(), winCondition);
  }

  @Override
  public int play() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'play'");
  }
}
