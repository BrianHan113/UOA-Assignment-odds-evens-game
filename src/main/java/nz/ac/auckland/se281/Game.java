package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int currentRound = 0;
  private String playerName;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.playerName = options[0];
  }

  public void play() {
    currentRound++;
    MessageCli.START_ROUND.printMessage(Integer.toString(currentRound));
    MessageCli.ASK_INPUT.printMessage();
  }

  public void endGame() {}

  public void showStats() {}
}
