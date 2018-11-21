package il.org.spartan;

import static fluent.ly.azzert.*;
import static il.org.spartan.Separator.*;
import static fluent.ly.box.*;

import java.io.*;
import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class SeparatorTest {
  
   @Test public void testMain() {
     final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
     System.setOut(new PrintStream(outContent));
     
     final String expected = "abc";
     Separator.main(new @NotNull String[] {"a", "b", "c"});
     azzert.that(expected, is(outContent + ""));
  }

   @Test public void testSeparateByIntArrayString() {
    azzert.that(separateBy(new int[] {}, "$"), is(""));
    azzert.that(separateBy(new int[] {1,2,3}, "$"), is("1$2$3"));
  }

  @Test public void testSeparateByStringTArray() {
    azzert.that(separateBy("#",new @NotNull Integer[] {}), is(""));
    azzert.that(separateBy("#",new @NotNull Integer[] {box(1),box(2),box(3)}), is("1#2#3"));
  }

  @Test public void testWrapStringIterableOfTString() {
    azzert.that(wrap("%", Collections.emptyList(), ","), is(""));
    azzert.that(wrap("%", Arrays.asList(box(1), box(2), box(3), box(4), box(5)), ","), is("%1,2,3,4,5%"));
  }

  @Test public void testWrapStringStringIterableOfTString() {
    azzert.that(wrap("[", "]", Collections.emptyList(), ","), is(""));
    azzert.that(wrap("[", "]", Arrays.asList(box(1), box(2), box(3), box(4), box(5)), ","), is("[1,2,3,4,5]"));
  }

  @Test public void testWrapStringStringTArrayString() {
    azzert.that(wrap("[", "]", new @NotNull Double[] {}, ","), is(""));
    azzert.that(wrap("[", "]", new @NotNull Double[] {box(0.5), box(1.0), box(1.5)}, ","), is("[0.5,1.0,1.5]"));
  }

  @Test public void testSeparatorChar() {
    azzert.notNull(new Separator('@'));
  }

  @Test public void testSeparatorString() {
    azzert.notNull(new Separator("abc"));
  }

  @Test public void testToString() {
    Separator newSep = new Separator('@');
    azzert.that(newSep + "", is(""));
    azzert.that(newSep + "", is("@"));
    newSep = new Separator("abc");
    azzert.that(newSep + "", is(""));
    azzert.that(newSep + "", is("abc"));
  }
}
