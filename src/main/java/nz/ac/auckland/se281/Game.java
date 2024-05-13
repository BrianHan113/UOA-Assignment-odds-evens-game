package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int currentRound;
  private Cpu cpu;
  private boolean isGameRunning;
  private Human human;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.human = new Human(options[0], choice);
    this.cpu = CpuFactory.createCPU(difficulty, this.human);
    this.currentRound = 0;

    this.isGameRunning = true;
  }

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

    int CPUMove = cpu.play();
    MessageCli.PRINT_INFO_HAND.printMessage(cpu.getName(), Integer.toString(CPUMove));

    String winner = getWinnerOfRound(Integer.parseInt(fingersInput), CPUMove);

    if (winner.equals(human.getName())) {
      human.incrementNumWins();
      cpu.setWonLastGame(false);
    } else {
      cpu.setWonLastGame(true);
      cpu.incrementNumWins();
    }
  }

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

  private String getWinnerOfRound(int playerFingers, int CPUfingers) {
    int sum = playerFingers + CPUfingers;
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
