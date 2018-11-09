package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class BigIntegerTest {
  private BigInteger bigInteger = null;

  @Before public void setupBigInteger() {
    this.bigInteger = new BigInteger();
  }

  @Test public void initBigInteger() {
    azzert.assertEquals(this.bigInteger.intValue(), 0);
  }

  @Test public void buildFunction() {
    azzert.assertEquals(BigInteger.valueOf(1).intValue(), BigInteger.ONE.intValue());
  }

  @Test public void defaultStepZero() {
    this.bigInteger = this.bigInteger.step();
    azzert.assertEquals(this.bigInteger.intValue(), 0);
  }

  @Test public void fluentOperations() {
    this.bigInteger = this.bigInteger.step(BigInteger.ONE).step(BigInteger.ONE);
    azzert.assertEquals(this.bigInteger.intValue(), 2);
  }

  @Test public void operationsDoNotAffectInstance() {
    BigInteger other = this.bigInteger.step(BigInteger.ONE);
    azzert.assertEquals(this.bigInteger.intValue(), 0);
    azzert.assertEquals(other.intValue(), 1);
  }

  @Test public void variousOperations() {
    this.bigInteger = this.bigInteger.step(BigInteger.TEN).sub(BigInteger.valueOf(5));
    azzert.assertEquals(this.bigInteger.intValue(), 5);
  }

  @Test public void introduceNeg() {
    azzert.assertEquals(this.bigInteger.intValue(), this.bigInteger.neg().intValue());
    azzert.assertEquals(BigInteger.ONE.neg().intValue(), BigInteger.valueOf(-1).intValue());
    azzert.assertEquals(BigInteger.ONE.neg().neg().intValue(), BigInteger.ONE.intValue());
  }

  @Test public void canExtendIntBoundaries() {
    this.bigInteger = BigInteger.valueOf(Integer.MAX_VALUE);
    azzert.assertTrue(this.bigInteger.step(BigInteger.ONE).longValue() > 0);
  }

  @Test public void mixAddAndSub() {
    azzert.assertEquals(BigInteger.ONE.step(BigInteger.TEN).intValue(), BigInteger.valueOf(11).intValue());
    azzert.assertEquals(BigInteger.valueOf(-15).step(BigInteger.ONE).intValue(), BigInteger.valueOf(-14).intValue());
    azzert.assertEquals(BigInteger.ONE.step(BigInteger.valueOf(-15)).intValue(), BigInteger.valueOf(-14).intValue());
    azzert.assertEquals(BigInteger.valueOf(-15).step(BigInteger.valueOf(-15)).intValue(), BigInteger.valueOf(-30).intValue());
    
    azzert.assertEquals(BigInteger.ONE.sub(BigInteger.TEN).intValue(), BigInteger.valueOf(-9).intValue());
    azzert.assertEquals(BigInteger.TEN.sub(BigInteger.valueOf(15)).intValue(),BigInteger.valueOf(-5).intValue());
    azzert.assertEquals(BigInteger.valueOf(-20).sub(BigInteger.valueOf(45)).intValue(),BigInteger.valueOf(-65).intValue());
    azzert.assertEquals(BigInteger.valueOf(-100).sub(BigInteger.valueOf(-150)).intValue(),BigInteger.valueOf(50).intValue());
  }
}
