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

@SuppressWarnings("static-method") public class stringTest {
  @Test(expected = NumberFormatException.class) public void testAtod() {
    azzert.that(atod("2.5"), is(2.5));
    // will throw
    azzert.notNull(box(atod("abcde")));
  }

  @Test(expected = NumberFormatException.class) public void testAtof() {
    azzert.that(atof("2.5"), is(2.5));
    // will throw
    azzert.notNull(box(atof("abcde")));
  }

  @Test(expected = NumberFormatException.class) public void testAtoi() {
    azzert.that(-25, is(atoi("-25")));
    // will throw
    azzert.notNull(box(atoi("abcde")));
  }

  @Test(expected = NumberFormatException.class) public void testAtol() {
    azzert.that(100000L, is(atol("100000")));
    // will throw
    azzert.that(2L, is(atol("abcde")));
  }

  @Test public void testCapitalize() {
    azzert.that("Camel", is(capitalize("cAMEL")));
    azzert.that("", is(capitalize("")));
  }

  @Test public void testCatStringArray() {
    azzert.that("a rose by any other name.", is(cat("a ", "rose ", "by ", "any ", "other ", "name.")));
  }

  @Test public void testCatStringArrayArray() {
    azzert.that(cat(new @NotNull String[] { "1", "2", "3" }, new @NotNull String[] {}, new @NotNull String[] { "4", "5" })
        , is("12345"));
  }

  @Test public void testDelta() {
    azzert.that(delta(12.3, 12.3), is(0.0));
    azzert.that(delta(1, 3), is(1.0));
    azzert.that(delta(-1, 2), is(Double.NaN));
  }

  @Test public void testDtoa() {
    azzert.that("12.3", is(dtoa(12.3)));
  }

  @Test public void testEq() {
    assert eq(null, null);
    assert !eq(null, "1");
    assert !eq("1", null);
    assert eq("1", "1");
  }

  @Test public void testEscChar() {
    azzert.that("\\n", is(esc('\n')));
    azzert.that("\\r", is(esc('\r')));
    azzert.that("\\t", is(esc('\t')));
    azzert.that("\\f", is(esc('\f')));
    azzert.that("\\b", is(esc('\b')));
    azzert.that("\\\\", is(esc('\\')));
    azzert.that("a", is(esc('a')));
  }

  @Test public void testEscString() {
    azzert.that("(null)", is(esc(null)));
    azzert.that("hello\\n", is(esc("hello\n")));
  }

  @Test public void testFillIntChar() {
    azzert.that("", is(fill(0, 'a')));
    azzert.that("aaa", is(fill(3, 'a')));
  }

  @Test public void testFillIntString() {
    azzert.that("", is(fill(0, "abc")));
    azzert.that("abcabcabc", is(fill(3, "abc")));
  }

  @Test public void testFirst() {
    azzert.that('a', is(first("abc")));
  }

  @Test public void testFtoa() {
    azzert.that("0.0", is(ftoa(0)));
  }

  @Test public void testIsDouble() {
    assert (isDouble("2.5"));
    assert !(isDouble("abc"));
  }

  @Test public void testIsFloat() {
    assert (isFloat("2.5"));
    assert !(isFloat("abc"));
  }

  @Test public void testIsInt() {
    assert (isInt("2"));
    assert !(isInt("2.5"));
    assert !(isInt("abc"));
  }

  @Test public void testIsLong() {
    assert (isLong("20000"));
    assert !(isLong("abc"));
  }

  @Test public void testItoa() {
    azzert.that("10", is(itoa(10)));
  }

  @Test public void testJavaCase() {
    azzert.that("hELLO!", is(javaCase("HELLO!")));
    azzert.that("", is(javaCase("")));
  }

  @Test(expected = NotNullValue.class) @SuppressWarnings("null") public void testLast1() {
    azzert.that('c', is(last("abc")));
    last(null);
  }

  @Test(expected = Positive.class) public void testLast2() {
    azzert.that('c', is(last("abc")));
    last("");
  }

  @Test public void testLowCounter() {
    azzert.that("by", is(lowCounter(50)));
    azzert.that("", is(lowCounter(-1)));
    azzert.that("a", is(lowCounter(0)));
    azzert.that("_", is(lowCounter(-2)));
  }

  @Test public void testLtoa() {
    azzert.that("5000000", is(ltoa(5000000L)));
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
    // for good + easy coverage: many cases!
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
    azzert.that("", is(repeat(0, 'a')));
    azzert.that("aaa", is(repeat(3, 'a')));
  }

  @Test public void testRepeatIntString() {
    azzert.that("", is(repeat(0, "abc")));
    azzert.that("abcabcabc", is(repeat(3, "abc")));
  }

  @Test public void testSignum() {
    azzert.that(0, is(signum(0)));
    azzert.that(1, is(signum(12345678)));
    azzert.that(-1, is(signum(-234567)));
  }

  @Test public void testSprintfStringObjectArray() {
    azzert.that(sprintf("%s%d", "foo", box(17)), is("foo17"));
  }

  @Test public void testSprintfStringArray() {
    azzert.that(sprintf(new @NotNull String[] { "%s%s", "foo", "17" }), is("foo17"));
    azzert.that(sprintf(new @NotNull String[] { "foo17" }), is("foo17"));
    azzert.that(sprintf(new @NotNull String[] {}), is(""));
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
    azzert.that("BY", is(upCounter(50)));
    azzert.that("", is(upCounter(-1)));
    azzert.that("A", is(upCounter(0)));
    azzert.that("?", is(upCounter(-2)));
  }

  @Test public void testVisualize() {
    azzert.that(visualize("hello world!\n"), is("hello\\sworld!\\n"));
  }

  @Test public void testWrapCharString() {
    azzert.that(wrap('+', "hello"), is("+hello+"));
  }

  @Test public void testWrapStringString() {
    azzert.that(wrap("<ameezing>", "hello"), is("<ameezing>hello<ameezing>"));
  }
}
