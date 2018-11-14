package il.org.spartan.etc;

import il.org.spartan.utils.*;
import static fluent.ly.unbox.*;

public class Rectangle {
  private final Pair<Double, Double> p1;
  private final Pair<Double, Double> p2;
  public double length;
  public double width;

  @SuppressWarnings("null") public Rectangle(Pair<Double, Double> p1, Pair<Double, Double> p2) throws IllegalArgumentException {
    if (p1.first.equals(p2.first) || p1.second.equals(p2.second))
      throw new IllegalArgumentException();
    this.p1 = p1;
    this.p2 = p2;
    length = Math.abs(unbox(p1.first) - unbox(p2.first));
    width = Math.abs(unbox(p1.second) - unbox(p2.second));
  }

  public double area() {
    return width * length;
  }

  public double perim() {
    return 2 * (width + length);
  }

  public Rectangle transpose() {
    final Pair<Double, Double> p1_new = Pair.newPair(p1.second, p1.first), p2_new = Pair.newPair(p2.second, p2.first);
    Rectangle $ = null;
    try {
      $ = new Rectangle(p1_new, p2_new);
    } catch (@SuppressWarnings("unused") final IllegalArgumentException ignore) {
      throw new AssertionError();
    }
    return $;
  }
}
