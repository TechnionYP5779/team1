package il.org.spartan.utils;

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
    int $ = 0;
    for (int ¢ = innerDigits.length - 1; ¢ >= 0; --¢) {
      $ *= 10;
      $ += innerDigits[¢].intValue();
    }
    return $ * signum;
  }

  public long longValue() {
    long $ = 0;
    for (int ¢ = innerDigits.length - 1; ¢ >= 0; --¢) {
      $ *= 10;
      $ += innerDigits[¢].intValue();
    }
    return $ * signum;
  }

  public static BigInteger valueOf(int ¢) {
    return new BigInteger(convertIntToDigitArray(abs(¢)), signum(¢));
  }

  public BigInteger step() {
    return this;
  }

  public BigInteger step(BigInteger other) {
    if (this.signum == 1 && other.signum == -1)
      return this.sub(other.neg());
    if (this.signum == -1 && other.signum == 1)
      return other.sub(this.neg());
    ArrayList<Integer> resultList = new ArrayList<>();
    int maxLength = this.innerDigits.length > other.innerDigits.length ? this.innerDigits.length : other.innerDigits.length, carry = 0;
    for (int i = 0; i < maxLength; ++i) {
      int thisDig = this.innerDigits.length <= i ? 0 : innerDigits[i].intValue(),
          otherDig = other.innerDigits.length <= i ? 0 : other.innerDigits[i].intValue(), immResult = carry + thisDig + otherDig;
      resultList.add(Integer.valueOf(immResult % 10));
      carry = immResult / 10;
    }
    if (carry != 0)
      resultList.add(Integer.valueOf(carry));
    Integer[] $ = new Integer[resultList.size()];
    resultList.toArray($);
    return new BigInteger($, this.signum != 0 ? this.signum : other.signum);
  }

  public BigInteger sub(BigInteger other) {
    if (this.signum == 1 && other.signum == -1 || this.signum == -1 && other.signum == 1)
      return this.step(other.neg());
    ArrayList<Integer> resultList = new ArrayList<>();
    int maxLength = this.innerDigits.length > other.innerDigits.length ? this.innerDigits.length : other.innerDigits.length, borrow = 0;
    for (int i = 0; i < maxLength; ++i) {
      int thisDig = this.innerDigits.length <= i ? 0 : innerDigits[i].intValue(),
          otherDig = other.innerDigits.length <= i ? 0 : other.innerDigits[i].intValue(), immResult = thisDig - borrow - otherDig;
      if (immResult >= 0)
        borrow = 0;
      else {
        immResult += 10;
        borrow = 1;
      }
      resultList.add(Integer.valueOf(immResult));
    }
    if (borrow != 0)
      return other.sub(this).neg();
    Integer[] $ = new Integer[resultList.size()];
    resultList.toArray($);
    return new BigInteger($, this.signum != 0 ? this.signum : other.signum);
  }

  public BigInteger neg() {
    return new BigInteger(this.innerDigits, -this.signum);
  }

  private static Integer[] convertIntToDigitArray(int i) {
    String stringNumber = String.valueOf(i);
    Integer[] $ = new Integer[stringNumber.length()];
    for (int ¢ = $.length - 1; ¢ >= 0; --¢)
      $[¢] = Integer.valueOf(stringNumber.charAt($.length - ¢ - 1) - '0');
    return $;
  }

  private static int signum(int num) {
    return num == 0 ? 0 : num > 0 ? 1 : -1;
  }

  private static int abs(int num) {
    return num > 0 ? num : -num;
  }
}
