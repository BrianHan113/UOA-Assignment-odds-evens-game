package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class CpuFactory {

  public static Cpu createCpu(Difficulty difficulty, Human human) {
    switch (difficulty) {
      case EASY:
        // Strictly speaking, the easy CPU doesn't need to know who the human is since it selects
        // moves completely randomly, but we pass it in anyways in case we wish to use a more
        // sophisticated strategy in the future
        return new EasyCpu(human);
      case MEDIUM:
        return new MediumCpu(human);
      case HARD:
        return new HardCpu(human);
      default:
        return null;
    }
  }
}
