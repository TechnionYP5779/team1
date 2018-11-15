package fluent.ly;

import org.junit.*;
import static fluent.ly.string.*;

@SuppressWarnings({"static-method", "static-access"}) public class stringTest {
 
  @Test(expected = NumberFormatException.class) public void testAtod() {
    azzert.assertEquals(2.5, atod("2.5"), 1E-10);
    //will throw
    azzert.assertEquals(2.5, atod("abcde"), 1E-10); 
  }

  @Test(expected = NumberFormatException.class) public void testAtof() {
    azzert.assertEquals(2.5, atof("2.5"), 1E-10);
    //will throw
    azzert.assertEquals(2.5, atof("abcde"), 1E-10); 
  }

  @Test(expected = NumberFormatException.class) public void testAtoi() {
    azzert.assertEquals(-25, atoi("-25"));
    //will throw
    azzert.assertEquals(2, atoi("abcde"), 1E-10);
  }

  @Test(expected = NumberFormatException.class) public void testAtol() {
    azzert.assertEquals(100000L, atol("100000"));
    //will throw
    azzert.assertEquals(2L, atol("abcde"));
  }

  @Test public void testCapitalize() {
    azzert.assertEquals("Camel", capitalize("cAMEL"));
    azzert.assertEquals("", capitalize(""));
  }

  @Test public void testCatStringArray() {
    azzert.assertEquals("a rose by any other name.",
        cat("a ", "rose ", "by ", "any ", "other ", "name."));
  }

  @Test @SuppressWarnings("null") public void testCatStringArrayArray() {
    azzert.assertEquals("12345", cat(new String[] {"1", "2", "3"},
        new String[] {}, new String[] { "4", "5" }));
  }

  @Test public void testDelta() {
    azzert.assertEquals(0, delta(12.3,12.3), 1E-10);
    azzert.assertEquals(1, delta(1,3), 1E-10);
    azzert.assertEquals(Double.NaN, delta(-1,2), 1E-10);
  }

  @Test public void testDtoa() {
    azzert.assertEquals("12.3", dtoa(12.3));
  }

  @Test public void testEq() {
    azzert.assertTrue(eq(null, null));
    azzert.assertFalse(eq(null, "1"));
    azzert.assertFalse(eq("1", null));
    azzert.assertTrue(eq("1", "1"));
  }

  @Test public void testEscChar() {
    azzert.assertEquals("\\n", esc('\n'));
    azzert.assertEquals("\\r", esc('\r'));
    azzert.assertEquals("\\t", esc('\t'));
    azzert.assertEquals("\\f", esc('\f'));
    azzert.assertEquals("\\b", esc('\b'));
    azzert.assertEquals("\\\\", esc('\\'));
    azzert.assertEquals("a",esc('a'));
  }

  @Test public void testEscString() {
    azzert.assertEquals("(null)",esc(null));
    azzert.assertEquals("hello\\n",esc("hello\n"));
  }

  @Test public void testExpandLeadingTabs() {
    //TODO: add test here
  }

  @Test public void testFillIntChar() {
    azzert.assertEquals("", fill(0, 'a'));
    azzert.assertEquals("aaa", fill(3, 'a'));
  }

  @Test public void testFillIntString() {
    azzert.assertEquals("", fill(0, "abc"));
    azzert.assertEquals("abcabcabc", fill(3, "abc"));
  }

  @Test public void testFirst() {
    azzert.assertEquals('a', first("abc"));
  }

  @Test public void testFtoa() {
    azzert.assertEquals("0.0", ftoa(0));
  }

  @Test public void testIsDouble() {
    azzert.assertTrue(isDouble("2.5"));
    azzert.assertFalse(isDouble("abc"));
  }

  @Test public void testIsFloat() {
    azzert.assertTrue(isFloat("2.5"));
    azzert.assertFalse(isFloat("abc"));
  }

  @Test public void testIsInt() {
    azzert.assertTrue(isInt("2"));
    azzert.assertFalse(isInt("2.5"));
    azzert.assertFalse(isInt("abc"));
  }

  @Test public void testIsLong() {
    azzert.assertTrue(isLong("20000"));
    azzert.assertFalse(isLong("abc"));
  }

  @Test public void testItoa() {
    //TODO: add test here
  }

  @Test public void testJavaCase() {
    //TODO: add test here
  }

  @Test public void testLast() {
    //TODO: add test here
  }

  @Test public void testLowCounter() {
    //TODO: add test here
  }

  @Test public void testLtoa() {
    //TODO: add test here
  }

  @Test public void testOrdinal() {
    //TODO: add test here
  }

  @Test public void testParen() {
    //TODO: add test here
  }

  @Test public void testPluralizeIntString() {
    //TODO: add test here
  }

  @Test public void testPluralizeIntStringString() {
    //TODO: add test here
  }

  @Test public void testPrettyStringCollectionOfQ() {
    //TODO: add test here
  }

  @Test public void testPrettyStringStringCollectionOfQ() {
    //TODO: add test here
  }

  @Test public void testQuote() {
    //TODO: add test here
  }

  @Test public void testRepeatIntChar() {
    //TODO: add test here
  }

  @Test public void testRepeatIntString() {
    //TODO: add test here
  }

  @Test public void testSignum() {
    azzert.assertEquals(0, signum(0));
    azzert.assertEquals(1, signum(12345678));
    azzert.assertEquals(-1, signum(-234567));
  }

  @Test public void testSprintfStringObjectArray() {
    //TODO: add test here
  }

  @Test public void testSprintfStringArray() {
    //TODO: add test here
  }

  @Test public void testStrip() {
    //TODO: add test here
  }

  @Test public void testToLines() {
    //TODO: add test here
  }

  @Test public void testUpCounter() {
    //TODO: add test here
  }

  @Test public void testVisualize() {
    //TODO: add test here
  }

  @Test public void testWrapCharString() {
    //TODO: add test here
  }

  @Test public void testWrapStringString() {
    //TODO: add test here
  }
}
