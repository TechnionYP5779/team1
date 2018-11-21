package fluent.ly;

import static org.junit.Assert.*;

import org.junit.*;
import static fluent.ly.box.*;
import static fluent.ly.azzert.*;

@SuppressWarnings("static-method") public class zeroTest {
  @Test public void testForgettingReturnsZero() {
    azzert.that(zero.forgetting(box(1), box(2)), is(0));
  }

  @Test public void testForgetBooleanReturnsZero() {
    azzert.that(zero.forget(false), is(0));
  }

  @Test public void testForgetDoubleReturnsZero() {
    azzert.that(zero.forget(0.5), is(0));
  }

  @Test public void testForgetLongReturnsZero() {
    azzert.that(zero.forget(1L), is(0));
  }
}
