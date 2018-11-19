package il.org.spartan.utils;

public class angle {
  private static final double degToRad = Math.PI / 180;
  public static angle pi = new angle(180);
  public static angle halfPi = new angle(90);
  public double degrees;
  public double radians;

  private angle(final double deg) {
    degrees = deg;
    radians = deg * degToRad;
  }

  public static angle degrees(final double deg) {
    return new angle(deg);
  }

  public static angle radians(final double rad) {
    return new angle(rad / degToRad);
  }

  public angle add(final angle ¢) {
    return new angle(this.degrees + ¢.degrees);
  }

  public angle add(final double deg) {
    return new angle(this.degrees + deg);
  }

  public angle sub(final angle ¢) {
    return new angle(this.degrees - ¢.degrees);
  }

  public angle sub(final double deg) {
    return new angle(this.degrees - deg);
  }

  public static angle negate(final angle ¢) {
    return new angle(-¢.degrees);
  }

  public angle negate() {
    return new angle(-this.degrees);
  }

  public double degrees() {
    return degrees;
  }

  public static angle of(final double deg) {
    return new angle(deg);
  }

  public double radians() {
    return radians;
  }
}
