package fluent.ly;

import static org.junit.Assert.*;

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

  @SuppressWarnings("static-method") @Test public void testRunDoesNotThrow() {
    Runnable r = () -> {@SuppressWarnings("unused") int x = 1;};
    idiomatic.Runner runner = idiomatic.run(r);
    try{
      runner.run();    
    } catch(Exception e) {
      e.printStackTrace();
      fail("Should not throw");
    }
  }

  @SuppressWarnings("static-method") @Test public void testTake() {
    Storer<Boolean> sto = idiomatic.take(Boolean.valueOf(true));
    assertTrue(sto.get().booleanValue());
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
}
