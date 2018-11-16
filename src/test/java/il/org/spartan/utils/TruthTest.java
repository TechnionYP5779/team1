package il.org.spartan.utils;

import static fluent.ly.azzert.*;

import java.util.function.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method")
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
    azzert.that(Truth.truthOf(mockTrue), is(Truth.T));
    azzert.that(Truth.truthOf(mockFalse), is(Truth.F));
    azzert.that(Truth.truthOf(null), is(Truth.N));
    azzert.that(Truth.truthOf(mockAssertionError), is(Truth.X));
    azzert.that(Truth.truthOf(mockRunTimeError), is(Truth.R));
    azzert.that(Truth.truthOf(mockUnknownError), is(Truth.Ħ));
  }

  @Test public void not() {
    azzert.that(Truth.T.not(), is(Truth.F));
    azzert.that(Truth.F.not(), is(Truth.T));
    azzert.that(Truth.N.not(), is(Truth.N));
  }

  @Test public void or() {
    azzert.that(Truth.T.or(Truth.F), is(Truth.T));
    azzert.that(Truth.F.or(Truth.T), is(Truth.T));
    azzert.that(Truth.F.or(Truth.F), is(Truth.F));
    azzert.that(Truth.T.or(Truth.T), is(Truth.T));
    azzert.that(Truth.N.or(Truth.T), is(Truth.T));
    azzert.that(Truth.N.or(Truth.R), is(Truth.R));
  }

  @Test public void and() {
    azzert.that(Truth.T.and(Truth.F), is(Truth.F));
    azzert.that(Truth.F.and(Truth.T), is(Truth.F));
    azzert.that(Truth.F.and(Truth.F), is(Truth.F));
    azzert.that(Truth.T.and(Truth.T), is(Truth.T));
    azzert.that(Truth.N.and(Truth.T), is(Truth.T));
    azzert.that(Truth.N.and(Truth.R), is(Truth.R));
  }

  @Test public void letterOf() {
    azzert.that(Truth.letterOf(mockTrue), is("true"));
    azzert.that(Truth.letterOf(mockFalse), is("false"));
    azzert.that(Truth.letterOf(mockRunTimeError), is("Runtime exception"));
    azzert.that(Truth.letterOf(mockAssertionError), is("Assertion exception"));
    azzert.that(Truth.letterOf(mockUnknownError), is("Throwable of some other kind"));
    azzert.that(Truth.letterOf(null), is("Null pointer exception"));
  }
}
