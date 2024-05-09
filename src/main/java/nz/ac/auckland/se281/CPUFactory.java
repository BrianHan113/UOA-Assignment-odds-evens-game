package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class CPUFactory {

  public static CPU createCPU(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyCPU();
        // case MEDIUM:
        //   return new MediumCPU();
        // case HARD:
        //   return new HardCPU();
      default:
        return null;
    }
  }
}
