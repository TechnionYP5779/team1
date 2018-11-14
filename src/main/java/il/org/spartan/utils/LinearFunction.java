package il.org.spartan.utils;

public class LinearFunction {
  double slope;
  double intercept;

  LinearFunction(final double slope, final double intercept) {
    this.slope = slope;
    this.intercept = intercept;
  }

  @Override public boolean equals(final Object ¢) {
    return ¢ == this || ¢ instanceof LinearFunction && ((LinearFunction) ¢).slope == slope && ((LinearFunction) ¢).intercept == intercept;
  }

  @Override public int hashCode() {
    return super.hashCode();
  }
}
