package il.org.spartan.utils;

public class BigInteger {
  public static final BigInteger ONE = BigInteger.valueOf(1);
  public static final BigInteger ZERO = new BigInteger();
  public static final BigInteger TEN = BigInteger.valueOf(10);
  private final int inner;

  public BigInteger() {
    this.inner = 0;
  }

  private BigInteger(int inner) {
    this.inner = inner;
  }

  public int intValue() {
    return inner;
  }

  public static BigInteger valueOf(int i) {
    return new BigInteger(i);
  }

  public BigInteger step() {
    return this;
  }

  public BigInteger step(BigInteger other) {
    return BigInteger.valueOf(other.inner + this.inner);
  }

  public BigInteger sub(BigInteger other) {
    return BigInteger.valueOf(this.inner - other.inner);
  }

  public BigInteger neg() {
    return BigInteger.valueOf(this.inner * -1);
  }
}
