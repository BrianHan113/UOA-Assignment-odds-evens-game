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
   * @param difficulty
   * @param choice
   * @param options
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

    if (!isGameRunning) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    currentRound++;
    MessageCli.START_ROUND.printMessage(Integer.toString(currentRound));
    MessageCli.ASK_INPUT.printMessage();

    String fingersInput = Utils.scanner.nextLine();
    while (!Utils.isInteger(fingersInput)
        || Integer.parseInt(fingersInput) < 0
        || Integer.parseInt(fingersInput) > 5) {
      MessageCli.INVALID_INPUT.printMessage();
      fingersInput = Utils.scanner.nextLine();
    }
    MessageCli.PRINT_INFO_HAND.printMessage(human.getName(), fingersInput);

    if (Utils.isEven(Integer.parseInt(fingersInput))) {
      human.incrementNumEvenHands();
    } else {
      human.incrementNumOddHands();
    }

    int cpuMove = cpu.play();
    MessageCli.PRINT_INFO_HAND.printMessage(cpu.getName(), Integer.toString(cpuMove));

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
    if (!isGameRunning) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    showStats();

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
    if (!isGameRunning) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        human.getName(), Integer.toString(human.getNumWins()), Integer.toString(cpu.getNumWins()));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        cpu.getName(), Integer.toString(cpu.getNumWins()), Integer.toString(human.getNumWins()));
  }

  /**
   * Determines the winner of the round based on the number of fingers shown by the human player and
   * the computer player.
   *
   * @param playerFingers
   * @param cpuFingers
   * @return the name of the winner of the round
   */
  private String getWinnerOfRound(int playerFingers, int cpuFingers) {
    int sum = playerFingers + cpuFingers;
    String outcome = Utils.isEven(sum) ? "EVEN" : "ODD";
    String winner;
    if (human.getChoice() == Choice.EVEN) {
      winner = Utils.isEven(sum) ? human.getName() : cpu.getName();
    } else {
      winner = Utils.isOdd(sum) ? human.getName() : cpu.getName();
    }

    MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), outcome, winner);

    if (winner.equals(human.getName())) {
      return human.getName();
    } else {
      return cpu.getName();
    }
  }
}
