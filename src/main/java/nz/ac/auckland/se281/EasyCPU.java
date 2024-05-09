package nz.ac.auckland.se281;

public class EasyCPU extends CPU {

  public EasyCPU() {
    super(new RandomStrategy());
  }

  @Override
  public int getNumFingers() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getNumFingers'");
  }
}
