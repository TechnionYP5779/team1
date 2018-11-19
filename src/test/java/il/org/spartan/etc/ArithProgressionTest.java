package il.org.spartan.etc;

import static fluent.ly.azzert.*;

import java.math.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.etc.ArithProgressionBuilder.*;

@SuppressWarnings("static-method") public class ArithProgressionTest {
  @Test public void setupDefualtSeq() {
    final ArithProgression seq = new ArithProgressionBuilder().build();
    azzert.that(seq.next().intValue(), is(0));
    azzert.that(seq.next().intValue(), is(0));
    azzert.that(seq.next().intValue(), is(0));
  }

  @Test public void emptySeq() {
    final ArithProgressionBuilder builder = new ArithProgressionBuilder();
    builder.bound(BigInteger.ZERO);
    assert !builder.build().hasNext();
  }

  @Test public void basicArithmeticSeq() {
    final ArithProgressionBuilder builder = new ArithProgressionBuilder();
    builder.startsWith(BigInteger.ONE).step(BigInteger.ONE);
    final ArithProgression seq = builder.build();
    for (int ¢ = 1; ¢ < 100; ++¢)
      azzert.that(seq.next().intValue(), is(¢));
  }

  @Test public void basicBoundedArithmeticSeq() {
    final ArithProgressionBuilder builder = new ArithProgressionBuilder();
    builder.startsWith(BigInteger.ONE).step(BigInteger.ONE).bound(BigInteger.TEN);
    final ArithProgression seq = builder.build();
    for (int ¢ = 1; ¢ < 11; ++¢)
      azzert.that(seq.next().intValue(), is(¢));
    assert seq.hasNext();
  }

  @Test(expected = ArithmeticException.class) public void negativeSeqSize() {
    new ArithProgressionBuilder().bound(BigInteger.valueOf(-1));
  }

  @Test public void longSeq() {
    final ArithProgressionBuilder builder = new ArithProgressionBuilder();
    builder.startsWith(BigInteger.valueOf(Integer.MAX_VALUE)).step(BigInteger.ONE).unbound();
    final ArithProgression seq = builder.build();
    for (long ¢ = Integer.MAX_VALUE; ¢ < Integer.MAX_VALUE + 100; ++¢)
      azzert.that(seq.next().longValue(), is(¢));
    assert seq.hasNext();
  }
}
