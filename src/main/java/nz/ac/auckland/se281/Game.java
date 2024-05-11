package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int currentRound;
  private String playerName;
  private CPU cpu;
  private Choice choice;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.playerName = options[0];
    this.cpu = CPUFactory.createCPU(difficulty, choice);
    this.choice = choice;
    this.currentRound = 0;
  }

  public void play() {

    if (!gameExists()) {
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
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, fingersInput);

    int CPUMove = cpu.play();
    MessageCli.PRINT_INFO_HAND.printMessage(cpu.getName(), Integer.toString(CPUMove));

    String winner = getWinnerOfRound(Integer.parseInt(fingersInput), CPUMove);

    if (Utils.isEven(Integer.parseInt(fingersInput))) {
      cpu.incrementNumHumanEven();
    } else {
      cpu.incrementNumHumanOdd();
    }

    cpu.setHumanWon(winner.equals(playerName));
  }

  public void endGame() {
    if (!gameExists()) {
      return;
    }
  }

  public void showStats() {
    if (!gameExists()) {
      return;
    }

    int numHumanWins = cpu.getNumHumanWins();
    int numCPUWins = currentRound - numHumanWins;

    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, Integer.toString(numHumanWins), Integer.toString(numCPUWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        cpu.getName(), Integer.toString(numCPUWins), Integer.toString(numHumanWins));
  }

  private String getWinnerOfRound(int playerFingers, int CPUfingers) {
    int sum = playerFingers + CPUfingers;
    String outcome = Utils.isEven(sum) ? "EVEN" : "ODD";
    String winner;
    if (this.choice == Choice.EVEN) {
      winner = Utils.isEven(sum) ? playerName : cpu.getName();
    } else {
      winner = Utils.isOdd(sum) ? playerName : cpu.getName();
    }

    MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), outcome, winner);

    if (winner.equals(playerName)) {
      return playerName;
    } else {
      return cpu.getName();
    }
  }

  private Boolean gameExists() {
    if (this.cpu == null) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return false;
    }
    return true;
  }
}
