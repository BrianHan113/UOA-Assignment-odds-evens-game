package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class CPUFactory {

  public static CPU createCPU(Difficulty difficulty, Human human) {
    switch (difficulty) {
      case EASY:
        // Strictly speaking, the easy CPU doesn't need to know who the human is since it selects
        // moves completely randomly, but we pass it in anyways in case we wish to use a more
        // sophisticated strategy in the future
        return new EasyCPU(human);
      case MEDIUM:
        return new MediumCPU(human);
      case HARD:
        return new HardCPU(human);
      default:
        return null;
    }
  }
}
