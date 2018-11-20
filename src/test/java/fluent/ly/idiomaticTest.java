package fluent.ly;

import static il.org.spartan.Utils.*;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;
import static fluent.ly.unbox.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.idiomatic.*;

@SuppressWarnings("static-method") public class idiomaticTest {
  @Test public void testEval() {
    azzert.that(idiomatic.eval(() -> box(1)).get(), is(box(1)));
  }

  @Test public void testIncase() {
    azzert.isNull(idiomatic.incase(false, box(1)));
    azzert.that(idiomatic.incase(true, box(1)), is(box(1)));
  }

  @Test public void testKatching1() {
    final idiomatic.Producer<@Nullable Integer> thrower = () -> {
      throw new Exception("EVERYTHING IS OK, IT SHOULD BE THROWN");
    };
    try {
      azzert.isNull(idiomatic.katching(thrower));
    } catch (final Exception ¢) {
      ¢.printStackTrace();
      fail("Exception uncaught by katching");
    }
  }

  @Test public void testKatching2() {
    final idiomatic.Producer<@Nullable Integer> notThrower = () -> cantBeNull(box(1));
    try {
      azzert.notNull(idiomatic.katching(notThrower));
    } catch (final Exception ¢) {
      ¢.printStackTrace();
      fail("there should not have been an Exception");
    }
  }

  @Test public void testQuote() {
    azzert.that(idiomatic.quote(null), is("<null reference>"));
    azzert.that(idiomatic.quote("abc"), is("'abc'"));
  }

  @Test public void testRunDoesNotThrow_SanityCheck() {
    final idiomatic.Runner empty = idiomatic.run(() -> {
      // empty runner
    });
    try {
      empty.run();
      empty.when(false);
      empty.when(true);
      empty.unless(false);
      empty.unless(true);
    } catch (final Exception ¢) {
      ¢.printStackTrace();
      fail("Should not throw");
    }
  }

  @Test public void testTake() {
    final Storer<Boolean> sto = idiomatic.take(Boolean.TRUE);
    assert unbox(sto.get());
    azzert.isNull(sto.when(false));
    assert unbox(sto.when(true));
    azzert.isNull(sto.unless(true));
    assert unbox(sto.unless(false));
  }

  @Test public void testUnlessBoolean() {
    azzert.isNull(idiomatic.unless(true).eval(box(1)));
    azzert.that(idiomatic.unless(false).eval(box(1)), is(box(1)));
  }

  @Test public void testUnlessBooleanT() {
    azzert.isNull(idiomatic.unless(true, box(2)));
    azzert.that(idiomatic.unless(false, box(2)), is(box(2)));
  }

  @Test public void testWhen() {
    azzert.isNull(idiomatic.when(false).eval(box(1)));
    azzert.that(idiomatic.when(true).eval(box(1)), is(box(1)));
  }

  @Test public void use0() {
    assert new Storer<>(this) != null;
  }

  @Test public void use08() {
    azzert.isNull(idiomatic.unless(true).eval(() -> new Object()));
  }

  @Test public void use09() {
    assert idiomatic.unless(false).eval(() -> new Object()) != null;
  }

  @Test public void use1() {
    assert new Storer<>(box(5)) != null;
    new Storer<>(box(5)).when(true);
  }

  @Test public void use10() {
    assert idiomatic.when(true).eval(() -> new Object()) != null;
  }

  @Test public void use11() {
    azzert.isNull(idiomatic.when(false).eval(() -> new Object()));
  }

  @Test public void use2() {
    assert idiomatic.take(this) != null;
    azzert.isNull(idiomatic.take(this).when(false));
  }

  @Test public void use3() {
    azzert.that(idiomatic.take(this).when(true), is(this));
  }

  @Test public void use4() {
    azzert.isNull(idiomatic.take(this).when(false));
  }

  @Test public void use5() {
    azzert.that(idiomatic.take(this).unless(false), is(this));
  }

  @Test public void use6() {
    azzert.isNull(idiomatic.take(this).unless(true));
  }

  @Test public void use7() {
    azzert.isNull(idiomatic.take(this).unless(true));
    azzert.isNull(idiomatic.take(null).unless(true));
    azzert.isNull(idiomatic.take(null).unless(false));
  }
}
