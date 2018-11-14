package il.org.spartan.etc;

import java.math.*;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.etc.ArithProgressionBuilder.*;

@SuppressWarnings("static-method") public class ArithProgressionTest {
  @Test public void setupDefualtSeq() {
    ArithProgression seq = new ArithProgressionBuilder().build();
    azzert.assertEquals(seq.next().intValue(), 0);
    azzert.assertEquals(seq.next().intValue(), 0);
    azzert.assertEquals(seq.next().intValue(), 0);
  }
  
  @Test public void emptySeq() {
    ArithProgressionBuilder builder = new ArithProgressionBuilder();
    builder.bound(BigInteger.ZERO);
    assert !builder.build().hasNext();
  }
  
  @Test public void basicArithmeticSeq() {
    ArithProgressionBuilder builder = new ArithProgressionBuilder();
    builder.startsWith(BigInteger.ONE).step(BigInteger.ONE);
    ArithProgression seq = builder.build();
    for (int ¢ = 1; ¢ < 100; ++¢)
      azzert.assertEquals(seq.next().intValue(), ¢);
  }
  
  @Test public void basicBoundedArithmeticSeq() {
    ArithProgressionBuilder builder = new ArithProgressionBuilder();
    builder.startsWith(BigInteger.ONE).step(BigInteger.ONE).bound(BigInteger.TEN);
    ArithProgression seq = builder.build();
    for (int ¢ = 1; ¢ < 11; ++¢)
      azzert.assertEquals(seq.next().intValue(), ¢);
    assert seq.hasNext();
  }
  
  @Test(expected = ArithmeticException.class) public void negativeSeqSize() {
    (new ArithProgressionBuilder()).bound(BigInteger.valueOf(-1));
  }
  
  @Test public void longSeq() {
    ArithProgressionBuilder builder = new ArithProgressionBuilder();
    builder.startsWith(BigInteger.valueOf(Integer.MAX_VALUE)).step(BigInteger.ONE).unbound();
    ArithProgression seq = builder.build();
    for (long ¢ = Integer.MAX_VALUE; ¢ < Integer.MAX_VALUE + 100; ++¢)
      Assert.assertEquals(seq.next().longValue(), ¢);
    assert seq.hasNext();
  }
}
