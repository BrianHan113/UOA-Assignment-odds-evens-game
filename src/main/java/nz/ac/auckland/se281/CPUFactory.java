package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class CPUFactory {

  public static CPU createCPU(Difficulty difficulty, Choice humanChoice) {
    switch (difficulty) {
      case EASY:
        // Not critical since the strategy for easy CPU is completely random, but this is better for
        // future-proofing, since the EasyCPU strategy could be changed in the future
        if (humanChoice == Choice.EVEN) {
          return new EasyCPU(Choice.ODD);
        } else if (humanChoice == Choice.ODD) {
          return new EasyCPU(Choice.EVEN);
        }
      case MEDIUM:
        if (humanChoice == Choice.EVEN) {
          return new MediumCPU(Choice.ODD);
        } else if (humanChoice == Choice.ODD) {
          return new MediumCPU(Choice.EVEN);
        }
        // case HARD:
        //   return new HardCPU();
      default:
        return null;
    }
  }
}
