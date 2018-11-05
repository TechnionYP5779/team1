package fluent.ly;

import static org.junit.Assert.*;

import static fluent.ly.azzert.*;

import java.util.function.*;

import org.junit.*;

import fluent.ly.idiomatic.*;

public class idiomaticTest {
  @SuppressWarnings({ "static-method", "null" }) @Test public void testEval() {
    Supplier<Integer> s = () -> Integer.valueOf(1);
    assertEquals(Integer.valueOf(1), idiomatic.eval(s).get());
  }

  @SuppressWarnings("static-method") @Test public void testIncase() {
    assertEquals(null, idiomatic.incase(true == false, Integer.valueOf(1)));
    assertEquals(Integer.valueOf(1), idiomatic.incase(true, Integer.valueOf(1)));
  }

  @SuppressWarnings({ "null", "static-method" }) @Test public void testKatching1() {
    idiomatic.Producer<Integer> thrower = () -> {throw new Exception("EVERYTHING IS OK, IT SHOULD BE THROWN");};
    try {
      assertNull(idiomatic.katching(thrower));
    } catch(Exception e) {
      e.printStackTrace();
      fail("Exception uncaught by katching");
    }
 }
  
  @SuppressWarnings({ "null", "static-method" }) @Test public void testKatching2() {
    idiomatic.Producer<Integer> notThrower = () -> Integer.valueOf(1);
    
    try {
      assertNotNull(idiomatic.katching(notThrower));
    } catch(Exception e) {
      e.printStackTrace();
      fail("there should not have been an Exception");
    }
    
  }

  @SuppressWarnings("static-method") @Test public void testQuote() {
    assertEquals( "<null reference>" , idiomatic.quote(null));
    assertEquals("'abc'", idiomatic.quote("abc"));
  }

  @SuppressWarnings("static-method") @Test public void testRunDoesNotThrow_SanityCheck() {
    Runnable r = () -> {@SuppressWarnings("unused") int x = 1;};
    idiomatic.Runner runner = idiomatic.run(r);
    try{
      runner.run();
      runner.when(false);
      runner.when(true);
      runner.unless(false);
      runner.unless(true);
    } catch(Exception e) {
      e.printStackTrace();
      fail("Should not throw");
    }
  }

  @SuppressWarnings({ "static-method", "null" }) @Test public void testTake() {
    Storer<Boolean> sto = idiomatic.take(Boolean.valueOf(true));
    assertTrue(sto.get().booleanValue());
    assertNull(sto.when(false));
    assertTrue(sto.when(true).booleanValue());
    assertNull(sto.unless(true));
    assertTrue(sto.unless(false).booleanValue());
  }

  @SuppressWarnings("static-method") @Test public void testUnlessBoolean() {
    assertNull(idiomatic.unless(true).eval(Integer.valueOf(1)));
    assertEquals(Integer.valueOf(1), idiomatic.unless(false).eval(Integer.valueOf(1)));
  }

  @SuppressWarnings("static-method") @Test public void testUnlessBooleanT() {
    assertNull(idiomatic.unless(true, Integer.valueOf(2)));
    assertEquals(Integer.valueOf(2), idiomatic.unless(false, Integer.valueOf(2)));
  }

  @SuppressWarnings("static-method") @Test public void testWhen() {
    assertNull(idiomatic.when(false).eval(Integer.valueOf(1)));
    assertEquals(Integer.valueOf(1), idiomatic.when(true).eval(Integer.valueOf(1)));
  }
  
  @Test public void use0() {
    assert new Storer<>(this) != null;
  }

  @SuppressWarnings("static-method") @Test public void use08() {
    azzert.isNull(idiomatic.unless(true).eval(() -> new Object()));
  }

  @SuppressWarnings("static-method") @Test public void use09() {
    assert idiomatic.unless(false).eval(() -> new Object()) != null;
  }

  @Test public void use1() {
    assert new Storer<>(this) != null;
    new Storer<>(this).when(true);
  }

  @SuppressWarnings("static-method") @Test public void use10() {
    assert idiomatic.when(true).eval(() -> new Object()) != null;
  }

  @SuppressWarnings("static-method") @Test public void use11() {
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
