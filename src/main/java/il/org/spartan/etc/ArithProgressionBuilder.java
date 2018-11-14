package il.org.spartan.etc;

import java.math.*;
import java.util.*;

public class ArithProgressionBuilder {
  private BigInteger startValue = BigInteger.ZERO;
  private BigInteger diff = BigInteger.ZERO;
  private boolean bound;
  private BigInteger size = BigInteger.ZERO;

  public ArithProgressionBuilder unbound() {
    this.bound = false;
    return this;
  }

  public ArithProgressionBuilder bound(final BigInteger count) {
    if (count.compareTo(BigInteger.ZERO) < 0)
      throw new ArithmeticException();
    this.size = count;
    this.bound = true;
    return this;
  }

  public ArithProgressionBuilder step(final BigInteger step) {
    this.diff = step;
    return this;
  }

  public ArithProgressionBuilder startsWith(final BigInteger start) {
    this.startValue = start;
    return this;
  }

  public ArithProgression build() {
    return new ArithProgression(this.startValue, this.diff, this.bound, this.size);
  }

  class ArithProgression implements Iterator<BigInteger> {
    private BigInteger currentValue = BigInteger.ZERO;
    private BigInteger step = BigInteger.ZERO;
    private final boolean isBounded;
    private BigInteger count = BigInteger.ZERO;

    protected ArithProgression(final BigInteger currentValue, final BigInteger step, final boolean isBounded, final BigInteger count) {
      this.currentValue = currentValue;
      this.step = step;
      this.isBounded = isBounded;
      this.count = count;
    }

    @Override public boolean hasNext() {
      return !isBounded || count.compareTo(BigInteger.ZERO) != 0;
    }

    @Override public BigInteger next() {
      if (isBounded && count.compareTo(BigInteger.ZERO) == 0)
        return null;
      if (isBounded)
        count.subtract(BigInteger.ONE);
      final BigInteger $ = currentValue;
      currentValue = currentValue.add(this.step);
      return $;
    }
  }
}
