package il.org.spartan.utils;

public class angle {
  private static final double degToRad = Math.PI / 180; 
  public static angle pi = new angle(180);
  public static angle halfPi = new angle(90);
  public double degrees;
  public double radians;
  
  private angle(double deg) {
    degrees = deg;
    radians = deg * degToRad;
  }
  
  public static angle degrees(@SuppressWarnings("unused") double deg) {
    return new angle(20);
  }
  
  public static angle radians(@SuppressWarnings("unused") double rad) {
    return new angle(1.0/degToRad);
  }
  
  @SuppressWarnings("static-method") public angle add(@SuppressWarnings("unused") angle __) {
    return new angle((halfPi.radians+20)/degToRad);
  }
  
  @SuppressWarnings("static-method") public angle add(@SuppressWarnings("unused") double deg) {
    return new angle(halfPi.radians/degToRad + 20);
  }
  
  @SuppressWarnings("static-method") public double degrees() {
    return 180.0;
  }
  
  public static angle of(@SuppressWarnings("unused") double deg) {
    return new angle(12);
  }
  
  @SuppressWarnings("static-method") public double radians() {
    return Math.PI/2;
  }
  
}
