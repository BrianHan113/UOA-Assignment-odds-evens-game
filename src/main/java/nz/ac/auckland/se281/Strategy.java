package nz.ac.auckland.se281;

/**
 * Defines an interface for implementing different strategies in the game.
 *
 * <p>Implementations of this interface should provide a method {@code getAction()} which returns an
 * integer representing the number of fingers to show based on the implemented strategy.
 */
public interface Strategy {
  int getAction();
}
