package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.idiomatic.*;

@SuppressWarnings({ "static-method", "static-access", "null" }) public class idiomaticTest {
  @Test public void testEval() {
    azzert.assertEquals(Integer.valueOf(1), idiomatic.eval(() -> Integer.valueOf(1)).get());
  }

  @Test public void testIncase() {
    azzert.assertEquals(null, idiomatic.incase(false, Integer.valueOf(1)));
    azzert.assertEquals(Integer.valueOf(1), idiomatic.incase(true, Integer.valueOf(1)));
  }

  @Test public void testKatching1() {
    idiomatic.Producer<Integer> thrower = () -> {
      throw new Exception("EVERYTHING IS OK, IT SHOULD BE THROWN");
    };
    try {
      assertNull(idiomatic.katching(thrower));
    } catch (Exception ¢) {
      ¢.printStackTrace();
      fail("Exception uncaught by katching");
    }
  }

  @Test public void testKatching2() {
    idiomatic.Producer<Integer> notThrower = () -> Integer.valueOf(1);
    try {
      azzert.assertNotNull(idiomatic.katching(notThrower));
    } catch (Exception ¢) {
      ¢.printStackTrace();
      fail("there should not have been an Exception");
    }
  }

  @Test public void testQuote() {
    azzert.assertEquals("<null reference>", idiomatic.quote(null));
    azzert.assertEquals("'abc'", idiomatic.quote("abc"));
  }

  @Test public void testRunDoesNotThrow_SanityCheck() {
    idiomatic.Runner runner = idiomatic.run(() -> {
      @SuppressWarnings("unused") int x = 1;
    });
    try {
      runner.run();
      runner.when(false);
      runner.when(true);
      runner.unless(false);
      runner.unless(true);
    } catch (Exception ¢) {
      ¢.printStackTrace();
      fail("Should not throw");
    }
  }

  @Test public void testTake() {
    Storer<Boolean> sto = idiomatic.take(Boolean.TRUE);
    assert unbox.unbox(sto.get());
    azzert.assertNull(sto.when(false));
    assert unbox.unbox(sto.when(true));
    azzert.assertNull(sto.unless(true));
    assert unbox.unbox(sto.unless(false));
  }

  @Test public void testUnlessBoolean() {
    azzert.assertNull(idiomatic.unless(true).eval(Integer.valueOf(1)));
    azzert.assertEquals(Integer.valueOf(1), idiomatic.unless(false).eval(Integer.valueOf(1)));
  }

  @Test public void testUnlessBooleanT() {
    azzert.assertNull(idiomatic.unless(true, Integer.valueOf(2)));
    azzert.assertEquals(Integer.valueOf(2), idiomatic.unless(false, Integer.valueOf(2)));
  }

  @Test public void testWhen() {
    azzert.assertNull(idiomatic.when(false).eval(Integer.valueOf(1)));
    azzert.assertEquals(Integer.valueOf(1), idiomatic.when(true).eval(Integer.valueOf(1)));
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
    assert new Storer<>(Integer.valueOf(5)) != null;
    new Storer<>(Integer.valueOf(5)).when(true);
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
