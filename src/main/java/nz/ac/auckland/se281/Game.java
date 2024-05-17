package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int currentRound;
  private Cpu cpu;
  private boolean isGameRunning;
  private Human human;

  /**
   * Starts a new game with the given CPU difficulty, choice (Even or Odd), and player name.
   *
   * @param difficulty the difficulty level of the CPU
   * @param choice the choice of the human player (Even or Odd)
   * @param options an array of strings containing the player name as the first element
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.human = new Human(options[0], choice);
    this.cpu = CpuFactory.createCpu(difficulty, this.human);
    this.currentRound = 0;

    this.isGameRunning = true;
  }

  /**
   * Plays a round of the game, prompts the human player to enter a number of fingers, generates the
   * number of fingers played by the computer player, and determines the winner of the round.
   *
   * <p>If the game is not currently running, a message indicating that the game has not started
   * will be printed, and the method will return without playing a round.
   */
  public void play() {

    // If there isnt currently a game, print error message and return
    if (!isGameRunning) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    currentRound++;
    MessageCli.START_ROUND.printMessage(Integer.toString(currentRound));
    MessageCli.ASK_INPUT.printMessage();

    // Keep asking for number of fingers from user until a valid input is given
    String fingersInput = Utils.scanner.nextLine();
    while (!Utils.isInteger(fingersInput)
        || Integer.parseInt(fingersInput) < 0
        || Integer.parseInt(fingersInput) > 5) {
      MessageCli.INVALID_INPUT.printMessage();
      fingersInput = Utils.scanner.nextLine();
    }
    MessageCli.PRINT_INFO_HAND.printMessage(human.getName(), fingersInput);

    // Play the CPU move before updating human stats, since the CPU should only know previous human
    // moves, not the current move (cheating)
    int cpuMove = cpu.play();
    MessageCli.PRINT_INFO_HAND.printMessage(cpu.getName(), Integer.toString(cpuMove));

    // Update the number of even and odd hands thrown by the human
    if (Utils.isEven(Integer.parseInt(fingersInput))) {
      human.incrementNumEvenHands();
    } else {
      human.incrementNumOddHands();
    }

    // Determine the winner of the round and update relevant statistics
    String winner = getWinnerOfRound(Integer.parseInt(fingersInput), cpuMove);
    if (winner.equals(human.getName())) {
      human.incrementNumWins();
      cpu.setWonLastGame(false);
    } else {
      cpu.setWonLastGame(true);
      cpu.incrementNumWins();
    }
  }

  /**
   * Ends the current game and displays the final results, including the number of wins/losses for
   * the human player and the computer player.
   *
   * <p>If the game is not currently running, a message indicating that the game has not started
   * will be printed, and the method will return without doing anything.
   */
  public void endGame() {

    // If there isnt currently a game, print error message and return
    if (!isGameRunning) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    showStats();

    // Print the winner of the game, and end the game
    if (human.getNumWins() > cpu.getNumWins()) {
      MessageCli.PRINT_END_GAME.printMessage(human.getName());
    } else if (human.getNumWins() < cpu.getNumWins()) {
      MessageCli.PRINT_END_GAME.printMessage(cpu.getName());
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    this.isGameRunning = false;
  }

  /**
   * Displays the current game statistics, including the number of wins for the human player and the
   * computer player.
   *
   * <p>If the game is not currently running, a message indicating that the game has not started
   * will be printed, and the method will return without displaying any statistics.
   */
  public void showStats() {
    // If there isnt currently a game, print error message and return
    if (!isGameRunning) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Print the number of wins and losses for each player
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        human.getName(), Integer.toString(human.getNumWins()), Integer.toString(cpu.getNumWins()));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        cpu.getName(), Integer.toString(cpu.getNumWins()), Integer.toString(human.getNumWins()));
  }

  /**
   * Determines the winner of the round based on the number of fingers shown by the human player and
   * the computer player.
   *
   * @param playerFingers the number of fingers shown by the human player
   * @param cpuFingers the number of fingers shown by the computer player
   * @return the name of the winner of the round
   */
  private String getWinnerOfRound(int playerFingers, int cpuFingers) {

    // Determine if the sum is even or odd
    int sum = playerFingers + cpuFingers;
    String outcome = Utils.isEven(sum) ? "EVEN" : "ODD";

    // Determine the winner of the round
    String winner;
    if (human.getChoice() == Choice.EVEN) {
      winner = Utils.isEven(sum) ? human.getName() : cpu.getName();
    } else {
      winner = Utils.isOdd(sum) ? human.getName() : cpu.getName();
    }

    MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), outcome, winner);

    return winner;
  }
}
