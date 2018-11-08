package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.idiomatic.*;

@SuppressWarnings({ "static-method", "static-access" ,"null"}) 
public class IdiomaticTest {
  @Test public void testEval() {
    azzert.assertEquals(Integer.valueOf(1), idiomatic.eval(() -> Integer.valueOf(1)).get());
  }

  @Test public void testIncase() {
    azzert.assertEquals(null, idiomatic.incase(false, Integer.valueOf(1)));
    azzert.assertEquals(Integer.valueOf(1), idiomatic.incase(true, Integer.valueOf(1)));
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
    azzert.assertTrue(sto.get().booleanValue());
    azzert.assertNull(sto.when(false));
    azzert.assertTrue(sto.when(true).booleanValue());
    azzert.assertNull(sto.unless(true));
    azzert.assertTrue(sto.unless(false).booleanValue());
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
    azzert.assertTrue(new Storer<>(this) != null);
  }

  @Test public void use08() {
    azzert.isNull(idiomatic.unless(true).eval(() -> new Object()));
  }

  @Test public void use09() {
    azzert.assertTrue(idiomatic.unless(false).eval(() -> new Object()) != null);
  }

  @Test public void use1() {
    azzert.assertTrue(new Storer<>(Integer.valueOf(5)) != null);
    new Storer<>(Integer.valueOf(5)).when(true);
  }

  @Test public void use10() {
    azzert.assertTrue(idiomatic.when(true).eval(() -> new Object()) != null);
  }

  @Test public void use11() {
    azzert.isNull(idiomatic.when(false).eval(() -> new Object()));
  }

  @Test public void use2() {
    azzert.assertTrue(idiomatic.take(this) != null);
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
