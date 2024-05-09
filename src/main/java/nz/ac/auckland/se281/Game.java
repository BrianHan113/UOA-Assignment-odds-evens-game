package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int currentRound = 0;
  private String playerName;
  private CPU cpu;
  private Choice choice;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    this.playerName = options[0];
    this.cpu = CPUFactory.createCPU(difficulty);
    this.choice = choice;
  }

  public void play() {
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

    int CPUfingers = cpu.getNumFingers();
    MessageCli.PRINT_INFO_HAND.printMessage(cpu.getName(), Integer.toString(CPUfingers));

    getResultOfRound(Integer.parseInt(fingersInput), CPUfingers);
  }

  public void endGame() {}

  public void showStats() {}

  private void getResultOfRound(int playerFingers, int CPUfingers) {
    int sum = playerFingers + CPUfingers;
    String outcome = sum % 2 == 0 ? "EVEN" : "ODD";
    String winner;
    if (this.choice == Choice.EVEN) {
      winner = Utils.isEven(sum) ? playerName : cpu.getName();
    } else {
      winner = Utils.isOdd(sum) ? playerName : cpu.getName();
    }

    MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(sum), outcome, winner);
  }
}
