package il.org.spartan.utils;

import java.util.function.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "static-access", "static-method" }) // to use azzert without
                                                        // warnings
public class TruthTest {
  class Mock implements BooleanSupplier {
    boolean val;

    public Mock(boolean flag) {
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
    azzert.assertEquals(Truth.truthOf(mockTrue), Truth.T);
    azzert.assertEquals(Truth.truthOf(mockFalse), Truth.F);
    azzert.assertEquals(Truth.truthOf(null), Truth.N);
    azzert.assertEquals(Truth.truthOf(mockAssertionError), Truth.X);
    azzert.assertEquals(Truth.truthOf(mockRunTimeError), Truth.R);
    azzert.assertEquals(Truth.truthOf(mockUnknownError), Truth.Ħ);
  }

  @Test public void not() {
    azzert.assertEquals(Truth.T.not(), Truth.F);
    azzert.assertEquals(Truth.F.not(), Truth.T);
    azzert.assertEquals(Truth.N.not(), Truth.N);
  }

  @Test public void or() {
    azzert.assertEquals(Truth.T.or(Truth.F), Truth.T);
    azzert.assertEquals(Truth.F.or(Truth.T), Truth.T);
    azzert.assertEquals(Truth.F.or(Truth.F), Truth.F);
    azzert.assertEquals(Truth.T.or(Truth.T), Truth.T);
    azzert.assertEquals(Truth.N.or(Truth.T), Truth.T);
    azzert.assertEquals(Truth.N.or(Truth.R), Truth.R);
  }

  @Test public void and() {
    azzert.assertEquals(Truth.T.and(Truth.F), Truth.F);
    azzert.assertEquals(Truth.F.and(Truth.T), Truth.F);
    azzert.assertEquals(Truth.F.and(Truth.F), Truth.F);
    azzert.assertEquals(Truth.T.and(Truth.T), Truth.T);
    azzert.assertEquals(Truth.N.and(Truth.T), Truth.T);
    azzert.assertEquals(Truth.N.and(Truth.R), Truth.R);
  }

  @Test public void letterOf() {
    azzert.assertEquals(Truth.letterOf(mockTrue), "true");
    azzert.assertEquals(Truth.letterOf(mockFalse), "false");
    azzert.assertEquals(Truth.letterOf(mockRunTimeError), "Runtime exception");
    azzert.assertEquals(Truth.letterOf(mockAssertionError), "Assertion exception");
    azzert.assertEquals(Truth.letterOf(mockUnknownError), "Throwable of some other kind");
    azzert.assertEquals(Truth.letterOf(null), "Null pointer exception");
  }
}
