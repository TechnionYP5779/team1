package il.org.spartan.utils;

import static org.junit.Assume.*;

import java.util.*;

public class BigInteger {
  public static final BigInteger ONE = BigInteger.valueOf(1);
  public static final BigInteger ZERO = new BigInteger();
  public static final BigInteger TEN = BigInteger.valueOf(10);
  // innerDigits[0] is the ones digit
  // innerDigits[1] is the tens digit and so on...
  private final Integer[] innerDigits;
  private final int signum;

  public BigInteger() {
    this.innerDigits = new Integer[] { Integer.valueOf(0) };
    this.signum = 0;
  }

  private BigInteger(Integer[] inner, int signum) {
    this.innerDigits = inner;
    this.signum = signum;
  }

  public int intValue() {
    int value = 0;
    for (int i = innerDigits.length - 1; i >= 0; i--) {
      value *= 10;
      value += innerDigits[i].intValue();
    }
    return value * signum;
  }

  public long longValue() {
    long value = 0;
    for (int i = innerDigits.length - 1; i >= 0; i--) {
      value *= 10;
      value += innerDigits[i].intValue();
    }
    return value * signum;
  }

  public static BigInteger valueOf(int i) {
    return new BigInteger(convertIntToDigitArray(abs(i)), signum(i));
  }

  public BigInteger step() {
    return this;
  }

  public BigInteger step(BigInteger other) {
    if (this.signum == 1 && other.signum == -1)
      return this.sub(other.neg());
    else if (this.signum == -1 && other.signum == 1)
      return other.sub(this.neg());
    ArrayList<Integer> resultList = new ArrayList<>();
    int maxLength = this.innerDigits.length > other.innerDigits.length ? this.innerDigits.length : other.innerDigits.length;
    int carry = 0;
    for (int i = 0; i < maxLength; i++) {
      int thisDig = this.innerDigits.length <= i ? 0 : innerDigits[i].intValue();
      int otherDig = other.innerDigits.length <= i ? 0 : other.innerDigits[i].intValue();
      int immResult = carry + thisDig + otherDig;
      resultList.add(Integer.valueOf(immResult % 10));
      carry = immResult / 10;
    }
    if (carry != 0)
      resultList.add(Integer.valueOf(carry));
    Integer[] resultArray = new Integer[resultList.size()];
    resultList.toArray(resultArray);
    return new BigInteger(resultArray, this.signum != 0 ? this.signum : other.signum);
  }

  public BigInteger sub(BigInteger other) {
    if (this.signum == 1 && other.signum == -1)
      return this.step(other.neg());
    else if (this.signum == -1 && other.signum == 1)
      return this.step(other.neg());
    ArrayList<Integer> resultList = new ArrayList<>();
    int maxLength = this.innerDigits.length > other.innerDigits.length ? this.innerDigits.length : other.innerDigits.length;
    int borrow = 0;
    for (int i = 0; i < maxLength; i++) {
      int thisDig = this.innerDigits.length <= i ? 0 : innerDigits[i].intValue();
      int otherDig = other.innerDigits.length <= i ? 0 : other.innerDigits[i].intValue();
      int immResult = thisDig - otherDig - borrow;
      if (immResult < 0) {
        immResult += 10;
        borrow = 1;
      } else {
        borrow = 0;
      }
      resultList.add(Integer.valueOf(immResult));
    }
    if (borrow != 0) {
      return other.sub(this).neg();
    }
    Integer[] resultArray = new Integer[resultList.size()];
    resultList.toArray(resultArray);
    return new BigInteger(resultArray, this.signum != 0 ? this.signum : other.signum);
  }

  public BigInteger neg() {
    return new BigInteger(this.innerDigits, this.signum * -1);
  }

  private static Integer[] convertIntToDigitArray(int n) {
    String stringNumber = String.valueOf(n);
    Integer[] digits = new Integer[stringNumber.length()];
    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i] = Integer.valueOf(stringNumber.charAt(digits.length - 1 - i) - '0');
    }
    return digits;
  }

  private static int signum(int num) {
    if (num == 0)
      return 0;
    return num > 0 ? 1 : -1;
  }

  private static int abs(int num) {
    return num > 0 ? num : -num;
  }
}
