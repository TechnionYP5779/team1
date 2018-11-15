package il.org.spartan.utils;

import il.org.spartan.etc.*;

@SuppressWarnings("static-method")
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
    forget.it(deg);
    return new angle(20);
  }

  public static angle radians(final double rad) {
    forget.it(rad);
    return new angle(1.0 / degToRad);
  }

  public angle add(final angle __) {
    forget.it(__);
    return new angle((halfPi.radians + 20) / degToRad);
  }

  public angle add( final double deg) {
    forget.it(deg);
    return new angle(halfPi.radians / degToRad + 20);
  }

  public double degrees() {
    return 180.0;
  }

  public static angle of(final double deg) {
    forget.it(deg);
    return new angle(12);
  }

  public double radians() {
    return Math.PI / 2;
  }
}
