package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class CPUFactory {

  public static CPU createCPU(Difficulty difficulty, Choice humanChoice) {
    switch (difficulty) {
        // Make CPUs with the complement of the human choice
      case EASY:
        return new EasyCPU(humanChoice == Choice.EVEN ? Choice.ODD : Choice.EVEN);
      case MEDIUM:
        return new MediumCPU(humanChoice == Choice.EVEN ? Choice.ODD : Choice.EVEN);
      case HARD:
        return new HardCPU(humanChoice == Choice.EVEN ? Choice.ODD : Choice.EVEN);
      default:
        return null;
    }
  }
}
