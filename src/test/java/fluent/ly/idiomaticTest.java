package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.idiomatic.*;

@SuppressWarnings({ "static-method", "null" }) public class idiomaticTest {
  @Test public void testEval() {
    Assert.assertEquals(Integer.valueOf(1), idiomatic.eval(() -> Integer.valueOf(1)).get());
  }

  @Test public void testIncase() {
    Assert.assertEquals(null, idiomatic.incase(false, Integer.valueOf(1)));
    Assert.assertEquals(Integer.valueOf(1), idiomatic.incase(true, Integer.valueOf(1)));
  }

  @Test public void testKatching1() {
    final idiomatic.Producer<Integer> thrower = () -> {
      throw new Exception("EVERYTHING IS OK, IT SHOULD BE THROWN");
    };
    try {
      assertNull(idiomatic.katching(thrower));
    } catch (final Exception ¢) {
      ¢.printStackTrace();
      fail("Exception uncaught by katching");
    }
  }

  @Test public void testKatching2() {
    final idiomatic.Producer<Integer> notThrower = () -> Integer.valueOf(1);
    try {
      Assert.assertNotNull(idiomatic.katching(notThrower));
    } catch (final Exception ¢) {
      ¢.printStackTrace();
      fail("there should not have been an Exception");
    }
  }

  @Test public void testQuote() {
    Assert.assertEquals("<null reference>", idiomatic.quote(null));
    Assert.assertEquals("'abc'", idiomatic.quote("abc"));
  }

  @Test public void testRunDoesNotThrow_SanityCheck() {
    final idiomatic.Runner runner = idiomatic.run(() -> {

    });
    try {
      runner.run();
      runner.when(false);
      runner.when(true);
      runner.unless(false);
      runner.unless(true);
    } catch (final Exception ¢) {
      ¢.printStackTrace();
      fail("Should not throw");
    }
  }

  @Test public void testTake() {
    final Storer<Boolean> sto = idiomatic.take(Boolean.TRUE);
    assert unbox.unbox(sto.get());
    azzert.assertNull(sto.when(false));
    assert unbox.unbox(sto.when(true));
    azzert.assertNull(sto.unless(true));
    assert unbox.unbox(sto.unless(false));
  }

  @Test public void testUnlessBoolean() {
    azzert.assertNull(idiomatic.unless(true).eval(Integer.valueOf(1)));
    Assert.assertEquals(Integer.valueOf(1), idiomatic.unless(false).eval(Integer.valueOf(1)));
  }

  @Test public void testUnlessBooleanT() {
    azzert.assertNull(idiomatic.unless(true, Integer.valueOf(2)));
    Assert.assertEquals(Integer.valueOf(2), idiomatic.unless(false, Integer.valueOf(2)));
  }

  @Test public void testWhen() {
    azzert.assertNull(idiomatic.when(false).eval(Integer.valueOf(1)));
    Assert.assertEquals(Integer.valueOf(1), idiomatic.when(true).eval(Integer.valueOf(1)));
  }

  @Test public void use0() {
    assert new Storer<>(this) != null;
  }

  @Test public void use08() {
    isNull(idiomatic.unless(true).eval(() -> new Object()));
  }

  @Test public void use09() {
    assert idiomatic.unless(false).eval(() -> new Object()) != null;
  }

  @Test public void use1() {
    assert new Storer<>(Integer.valueOf(5)) != null;
    new Storer<>(Integer.valueOf(5)).when(true);
  }

  @Test public void use10() {
    assert idiomatic.when(true).eval(() -> new Object()) != null;
  }

  @Test public void use11() {
    isNull(idiomatic.when(false).eval(() -> new Object()));
  }

  @Test public void use2() {
    assert idiomatic.take(this) != null;
    isNull(idiomatic.take(this).when(false));
  }

  @Test public void use3() {
    azzert.that(idiomatic.take(this).when(true), is(this));
  }

  @Test public void use4() {
    isNull(idiomatic.take(this).when(false));
  }

  @Test public void use5() {
    azzert.that(idiomatic.take(this).unless(false), is(this));
  }

  @Test public void use6() {
    isNull(idiomatic.take(this).unless(true));
  }

  @Test public void use7() {
    isNull(idiomatic.take(this).unless(true));
    isNull(idiomatic.take(null).unless(true));
    isNull(idiomatic.take(null).unless(false));
  }
}
