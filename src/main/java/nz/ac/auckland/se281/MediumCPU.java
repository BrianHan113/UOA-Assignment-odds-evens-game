package nz.ac.auckland.se281;

public class MediumCPU extends CPU {

  private TopStrategy topStrategy;

  public MediumCPU(Human human) {
    super(new RandomStrategy(), human);
  }

  @Override
  public int play() {
    numMoves++;

    // Done this way to avoid creating a new TopStrategy object every time play is called
    if (numMoves == 4) {
      topStrategy = new TopStrategy(human);
      setStrategy(topStrategy);
    }

    return strategy.getAction();
  }
}
