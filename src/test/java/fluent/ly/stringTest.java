package fluent.ly;

import static fluent.ly.string.*;

import java.io.*;
import java.util.*;

import static fluent.ly.azzert.is;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.___.Bug.Assertion.Value.*;
import fluent.ly.___.Bug.Assertion.Value.Numerical.*;
import fluent.ly.___.Bug.Contract.*;

import static il.org.spartan.Utils.*;
import static fluent.ly.box.*;

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
    azzert.assertEquals("10", itoa(10));
  }

  @Test public void testJavaCase() {
    azzert.assertEquals("hELLO!", javaCase("HELLO!"));
    azzert.assertEquals("", javaCase(""));
  }

  @Test(expected = NotNullValue.class) @SuppressWarnings("null") public void testLast1() {
    azzert.assertEquals('c', last("abc"));
    last(null);
  }
  
  @Test(expected = Positive.class) public void testLast2() {
    azzert.assertEquals('c', last("abc"));
    last("");
  }

  @Test public void testLowCounter() {
    azzert.assertEquals("by", lowCounter(50));
    azzert.assertEquals("", lowCounter(-1));
    azzert.assertEquals("a", lowCounter(0));
    azzert.assertEquals("_", lowCounter(-2));
  }

  @Test public void testLtoa() {
    azzert.assertEquals("5000000", ltoa(5000000L));
  }

  @Test(expected = NonNegative.class) public void testOrdinal1() {
    ordinal(-7);
  }
  
  @Test public void testOrdinal2() {
    azzert.that(ordinal(11), is("11th"));
    azzert.that(ordinal(12), is("12th"));
    azzert.that(ordinal(13), is("13th"));
    azzert.that(ordinal(1), is("1st"));
    azzert.that(ordinal(2), is("2nd"));
    azzert.that(ordinal(3), is("3rd"));
    azzert.that(ordinal(24), is("24th"));
  }

  @Test public void testParen() {
    azzert.that(paren("3"), is("(3)"));
  }

  @Test public void testPluralizeIntString() {
    //for good + easy coverage: many cases!
    azzert.that(pluralize(0, "frog"), is("no frogs"));
    azzert.that(pluralize(1, "frog"), is("frog"));
    azzert.that(pluralize(2, "frog"), is("two frogs"));
    azzert.that(pluralize(3, "frog"), is("three frogs"));
    azzert.that(pluralize(4, "frog"), is("four frogs"));
    azzert.that(pluralize(5, "frog"), is("five frogs"));
    azzert.that(pluralize(6, "frog"), is("six frogs"));
    azzert.that(pluralize(7, "frog"), is("seven frogs"));
    azzert.that(pluralize(8, "frog"), is("eight frogs"));
    azzert.that(pluralize(9, "frog"), is("nine frogs"));
    azzert.that(pluralize(10, "frog"), is("10 frogs"));
  }

  @Test public void testPluralizeIntStringString() {
    azzert.that(pluralize(3, "octopus", "octopi"), is("three octopi"));
    azzert.that(pluralize(1, "octopus", "octopi"), is("octopus"));
  }

  @Test public void testPrettyStringCollectionOfQ() {
    azzert.that(pretty("frog", cantBeNull(Collections.emptyList())), is(""));
    azzert.that(pretty("frog", cantBeNull(Arrays.asList("Jimmy"))), is("1 frog: Jimmy\n"));
    azzert.that(pretty("frog", cantBeNull(Arrays.asList("Jimmy", "Polly"))), is("2 frogs:\n\t1) Jimmy\n\t2) Polly\n"));
  }

  @Test public void testPrettyStringStringCollectionOfQ() {
    azzert.that(pretty("octopus", "octopi", null), is(""));
    azzert.that(pretty("octopus", "octopi", Collections.emptyList()), is(""));
    azzert.that(pretty("octopus", "octopi", Arrays.asList("Jimmy")), is("1 octopus: Jimmy\n"));
    azzert.that(pretty("octopus", "octopi", Arrays.asList("Jimmy", "Polly")), is("2 octopi:\n\t1) Jimmy\n\t2) Polly\n"));
  }

  @Test public void testQuote() {
    azzert.that(quote(box(3)), is("\'3\'"));
  }

  @Test public void testRepeatIntChar() {
    Assert.assertEquals("", repeat(0, 'a'));
    Assert.assertEquals("aaa", repeat(3, 'a'));
  }

  @Test public void testRepeatIntString() {
    Assert.assertEquals("", repeat(0, "abc"));
    Assert.assertEquals("abcabcabc", repeat(3, "abc"));
  }

  @Test public void testSignum() {
    azzert.assertEquals(0, signum(0));
    azzert.assertEquals(1, signum(12345678));
    azzert.assertEquals(-1, signum(-234567));
  }

  @Test public void testSprintfStringObjectArray() {
    azzert.that(sprintf("%s%d", "foo", box(17)),
        is("foo17"));
  }

  @Test public void testSprintfStringArray() {
    azzert.that(sprintf(new @NotNull String[] {"%s%s", "foo", "17"}),
        is("foo17"));
    
    azzert.that(sprintf(new @NotNull String[] {"foo17"}),
        is("foo17"));
    
    azzert.that(sprintf(new @NotNull String[] {}),
        is(""));
  }

  @Test(expected = Precondition.class) public void testStrip() {
    azzert.that(strip("jjkk"), is("jk"));
    azzert.that(strip("jk"), is(""));
    azzert.that(strip("j"), is("jk"));
  }

  @Test public void testToLines() throws IOException {
    azzert.that(toLines("a\nb\nc\n"), is(Arrays.asList("a", "b", "c")));
  }

  @Test public void testUpCounter() {
    azzert.assertEquals("BY", upCounter(50));
    azzert.assertEquals("", upCounter(-1));
    azzert.assertEquals("A", upCounter(0));
    azzert.assertEquals("?", upCounter(-2));
  }

  @Test public void testVisualize() {
    azzert.that(visualize("hello world!\n"), is("hello\\sworld!\\n"));
  }

  @Test public void testWrapCharString() {
    azzert.that(wrap('+',"hello"), is("+hello+"));
  }

  @Test public void testWrapStringString() {
    azzert.that(wrap("<ameezing>","hello"), is("<ameezing>hello<ameezing>"));
  }
}
