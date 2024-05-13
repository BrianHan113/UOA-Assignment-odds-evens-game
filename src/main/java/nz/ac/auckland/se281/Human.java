package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/**
 * Represents a human player in the game. Includes useful information about past moves, which the
 * strategies can use
 */
public class Human {

  private String name;
  private Choice choice;
  private int numWins;
  private int numEvenHands;
  private int numOddHands;

  /**
   * Constructor for Human class, initializes the human player with a name and choice (Even or Odd).
   *
   * @param name the name of the human player
   * @param choice the choice of the human player (Even or Odd)
   */
  public Human(String name, Choice choice) {
    this.name = name;
    this.choice = choice;
    this.numWins = 0;
    this.numEvenHands = 0;
    this.numOddHands = 0;
  }

  public int getNumEvenHands() {
    return numEvenHands;
  }

  public int getNumOddHands() {
    return numOddHands;
  }

  public void incrementNumEvenHands() {
    this.numEvenHands++;
  }

  public void incrementNumOddHands() {
    this.numOddHands++;
  }

  public void incrementNumWins() {
    this.numWins++;
  }

  public int getNumWins() {
    return numWins;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Choice getChoice() {
    return choice;
  }
}
