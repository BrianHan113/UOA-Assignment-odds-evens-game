package nz.ac.auckland.se281;

public class TopStrategy implements Strategy {

  private int numHumanEven;
  private int numHumanOdd;

  public TopStrategy(int numHumanEven, int numHumanOdd) {
    this.numHumanEven = numHumanEven;
    this.numHumanOdd = numHumanOdd;
  }

  public void setNumHumanEven(int numHumanEven) {
    this.numHumanEven = numHumanEven;
  }

  public void setNumHumanOdd(int numHumanOdd) {
    this.numHumanOdd = numHumanOdd;
  }

  @Override
  public int getAction() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getNumFingers'");
  }
}
