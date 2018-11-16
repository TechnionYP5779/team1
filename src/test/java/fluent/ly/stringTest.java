package fluent.ly;

import static fluent.ly.string.*;

import org.jetbrains.annotations.*;
import org.junit.*;

@SuppressWarnings({ "static-method", "static-access" }) public class stringTest {
  @Test(expected = NumberFormatException.class) public void testAtod() {
    Assert.assertEquals(2.5, atod("2.5"), 1E-10);
    // will throw
    Assert.assertEquals(2.5, atod("abcde"), 1E-10);
  }

  @Test(expected = NumberFormatException.class) public void testAtof() {
    Assert.assertEquals(2.5, atof("2.5"), 1E-10);
    // will throw
    Assert.assertEquals(2.5, atof("abcde"), 1E-10);
  }

  @Test(expected = NumberFormatException.class) public void testAtoi() {
    azzert.assertEquals(-25, atoi("-25"));
    // will throw
    Assert.assertEquals(2, atoi("abcde"), 1E-10);
  }

  @Test(expected = NumberFormatException.class) public void testAtol() {
    Assert.assertEquals(100000L, atol("100000"));
    // will throw
    Assert.assertEquals(2L, atol("abcde"));
  }

  @Test public void testCapitalize() {
    Assert.assertEquals("Camel", capitalize("cAMEL"));
    Assert.assertEquals("", capitalize(""));
  }

  @Test public void testCatStringArray() {
    Assert.assertEquals("a rose by any other name.", cat("a ", "rose ", "by ", "any ", "other ", "name."));
  }

  @Test public void testCatStringArrayArray() {
    Assert.assertEquals("12345", cat(new @NotNull String[] { "1", "2", "3" }, new @NotNull String[] {}, new @NotNull String[] { "4", "5" }));
  }

  @Test public void testDelta() {
    Assert.assertEquals(0, delta(12.3, 12.3), 1E-10);
    Assert.assertEquals(1, delta(1, 3), 1E-10);
    Assert.assertEquals(Double.NaN, delta(-1, 2), 1E-10);
  }

  @Test public void testDtoa() {
    Assert.assertEquals("12.3", dtoa(12.3));
  }

  @Test public void testEq() {
    azzert.assertTrue(eq(null, null));
    azzert.assertFalse(eq(null, "1"));
    azzert.assertFalse(eq("1", null));
    azzert.assertTrue(eq("1", "1"));
  }

  @Test public void testEscChar() {
    Assert.assertEquals("\\n", esc('\n'));
    Assert.assertEquals("\\r", esc('\r'));
    Assert.assertEquals("\\t", esc('\t'));
    Assert.assertEquals("\\f", esc('\f'));
    Assert.assertEquals("\\b", esc('\b'));
    Assert.assertEquals("\\\\", esc('\\'));
    Assert.assertEquals("a", esc('a'));
  }

  @Test public void testEscString() {
    Assert.assertEquals("(null)", esc(null));
    Assert.assertEquals("hello\\n", esc("hello\n"));
  }

  @Test public void testExpandLeadingTabs() {
    // TODO: add test here
  }

  @Test public void testFillIntChar() {
    Assert.assertEquals("", fill(0, 'a'));
    Assert.assertEquals("aaa", fill(3, 'a'));
  }

  @Test public void testFillIntString() {
    Assert.assertEquals("", fill(0, "abc"));
    Assert.assertEquals("abcabcabc", fill(3, "abc"));
  }

  @Test public void testFirst() {
    azzert.assertEquals('a', first("abc"));
  }

  @Test public void testFtoa() {
    Assert.assertEquals("0.0", ftoa(0));
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
    // TODO: add test here
  }

  @Test public void testJavaCase() {
    // TODO: add test here
  }

  @Test public void testLast() {
    // TODO: add test here
  }

  @Test public void testLowCounter() {
    // TODO: add test here
  }

  @Test public void testLtoa() {
    // TODO: add test here
  }

  @Test public void testOrdinal() {
    // TODO: add test here
  }

  @Test public void testParen() {
    // TODO: add test here
  }

  @Test public void testPluralizeIntString() {
    // TODO: add test here
  }

  @Test public void testPluralizeIntStringString() {
    // TODO: add test here
  }

  @Test public void testPrettyStringCollectionOfQ() {
    // TODO: add test here
  }

  @Test public void testPrettyStringStringCollectionOfQ() {
    // TODO: add test here
  }

  @Test public void testQuote() {
    // TODO: add test here
  }

  @Test public void testRepeatIntChar() {
    // TODO: add test here
  }

  @Test public void testRepeatIntString() {
    // TODO: add test here
  }

  @Test public void testSignum() {
    azzert.assertEquals(0, signum(0));
    azzert.assertEquals(1, signum(12345678));
    azzert.assertEquals(-1, signum(-234567));
  }

  @Test public void testSprintfStringObjectArray() {
    // TODO: add test here
  }

  @Test public void testSprintfStringArray() {
    // TODO: add test here
  }

  @Test public void testStrip() {
    // TODO: add test here
  }

  @Test public void testToLines() {
    // TODO: add test here
  }

  @Test public void testUpCounter() {
    // TODO: add test here
  }

  @Test public void testVisualize() {
    // TODO: add test here
  }

  @Test public void testWrapCharString() {
    // TODO: add test here
  }

  @Test public void testWrapStringString() {
    // TODO: add test here
  }
}
