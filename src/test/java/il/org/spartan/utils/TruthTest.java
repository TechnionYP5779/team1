package il.org.spartan.utils;

import java.util.function.*;

import org.junit.*;

@SuppressWarnings({ "static-access", "static-method" }) // to use azzert without
                                                        // warnings
public class TruthTest {
  class Mock implements BooleanSupplier {
    boolean val;

    public Mock(final boolean flag) {
      val = flag;
    }

    @Override public boolean getAsBoolean() {
      return val;
    }
  }

  class MockAssertionError implements BooleanSupplier {
    boolean val;

    @Override public boolean getAsBoolean() {
      throw new AssertionError();
    }
  }

  class MockRunTimeError implements BooleanSupplier {
    boolean val;

    @Override public boolean getAsBoolean() {
      throw new RuntimeException();
    }
  }

  class MockUnknownError implements BooleanSupplier {
    boolean val;

    @Override public boolean getAsBoolean() {
      throw new OutOfMemoryError();
    }
  }

  Mock mockTrue = new Mock(true);
  Mock mockFalse = new Mock(false);
  MockAssertionError mockAssertionError = new MockAssertionError();
  MockRunTimeError mockRunTimeError = new MockRunTimeError();
  MockUnknownError mockUnknownError = new MockUnknownError();

  @Test public void truthOf() {
    Assert.assertEquals(Truth.truthOf(mockTrue), Truth.T);
    Assert.assertEquals(Truth.truthOf(mockFalse), Truth.F);
    Assert.assertEquals(Truth.truthOf(null), Truth.N);
    Assert.assertEquals(Truth.truthOf(mockAssertionError), Truth.X);
    Assert.assertEquals(Truth.truthOf(mockRunTimeError), Truth.R);
    Assert.assertEquals(Truth.truthOf(mockUnknownError), Truth.Ħ);
  }

  @Test public void not() {
    Assert.assertEquals(Truth.T.not(), Truth.F);
    Assert.assertEquals(Truth.F.not(), Truth.T);
    Assert.assertEquals(Truth.N.not(), Truth.N);
  }

  @Test public void or() {
    Assert.assertEquals(Truth.T.or(Truth.F), Truth.T);
    Assert.assertEquals(Truth.F.or(Truth.T), Truth.T);
    Assert.assertEquals(Truth.F.or(Truth.F), Truth.F);
    Assert.assertEquals(Truth.T.or(Truth.T), Truth.T);
    Assert.assertEquals(Truth.N.or(Truth.T), Truth.T);
    Assert.assertEquals(Truth.N.or(Truth.R), Truth.R);
  }

  @Test public void and() {
    Assert.assertEquals(Truth.T.and(Truth.F), Truth.F);
    Assert.assertEquals(Truth.F.and(Truth.T), Truth.F);
    Assert.assertEquals(Truth.F.and(Truth.F), Truth.F);
    Assert.assertEquals(Truth.T.and(Truth.T), Truth.T);
    Assert.assertEquals(Truth.N.and(Truth.T), Truth.T);
    Assert.assertEquals(Truth.N.and(Truth.R), Truth.R);
  }

  @Test public void letterOf() {
    Assert.assertEquals(Truth.letterOf(mockTrue), "true");
    Assert.assertEquals(Truth.letterOf(mockFalse), "false");
    Assert.assertEquals(Truth.letterOf(mockRunTimeError), "Runtime exception");
    Assert.assertEquals(Truth.letterOf(mockAssertionError), "Assertion exception");
    Assert.assertEquals(Truth.letterOf(mockUnknownError), "Throwable of some other kind");
    Assert.assertEquals(Truth.letterOf(null), "Null pointer exception");
  }
}
