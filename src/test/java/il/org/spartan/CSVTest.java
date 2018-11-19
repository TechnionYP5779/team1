package il.org.spartan;

import static fluent.ly.azzert.*;
import static il.org.spartan.Utils.*;

import java.io.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class CSVTest {
  enum someEnum {
    A, B;
  }

  @Test public void combineTest() {
    final Class<?>[] array = new Class<?>[2];
    array[0] = null;
    array[1] = Integer.class;
    azzert.that(CSV.combine(array), is("null,java.lang.Integer"));
    final someEnum[] enum_array = new someEnum[2];
    enum_array[0] = someEnum.A;
    enum_array[1] = null;
    azzert.that(CSV.combine(enum_array), is("A,null"));
  }

  @Test public void escapeTest() {
    azzert.that(CSV.escape(null), is("\\0"));
    azzert.that(CSV.escape("\\a"), is("\\\\a"));
    azzert.that(CSV.escape("\na"), is("\\na"));
    azzert.that(CSV.escape("\ra"), is("\\ra"));
    azzert.that(CSV.escape("\ta"), is("\\ta"));
    azzert.that(CSV.escape(",a"), is("\\.a"));
  }

  @Test public void loadTest() {
    try {
      @NotNull final String[][] data = new @NotNull String[2][2];
      data[0][0] = "0";
      data[0][1] = "1";
      data[1][0] = "2";
      data[1][1] = "3";
      final File my_file = new File("some_file_name.csv");
      CSV.save(my_file, data);
      CSV.load(my_file);
    } catch (final IOException __) {
      forget.it(__);
      assert false;
    }
    try {
      if (new File("some_file_name.csv").delete())
        CSV.load(new File("some_file_name.csv"));
      assert false;
    } catch (final IOException __) {
      forget.it(__);
      assert true;
    }
  }

  @Test public void unescapeTest() {
    assert CSV.unescape("\\0") == null;
    azzert.that(CSV.unescape(cantBeNull(CSV.escape("\\a"))), is("\\a"));
    azzert.that(CSV.unescape(cantBeNull(CSV.escape("\na"))), is("\na"));
    azzert.that(CSV.unescape(cantBeNull(CSV.escape("\ra"))), is("\ra"));
    azzert.that(CSV.unescape(cantBeNull(CSV.escape("\ta"))), is("\ta"));
    azzert.that(CSV.unescape(cantBeNull(CSV.escape(",a"))), is(",a"));
  }

  @Test public void splitToClasses() {
    final Class<?>[] array = new Class<?>[2];
    array[0] = String.class;
    array[1] = Integer.class;
    final Class<?>[] classes = CSV.splitToClasses(cantBeNull(CSV.combine(array)));
    azzert.that(classes[0], is(array[0]));
    azzert.that(classes[1], is(array[1]));
    try {
      forget.it(CSV.splitToClasses("noSuchClass"));
      assert false;
    } catch (final RuntimeException __) {
      forget.it(__);
      assert true;
    }
  }

  @Test public void splitTest() {
    azzert.that(CSV.split(cantBeNull(String.valueOf(""))).length, is(0));
  }

  @Test public void enumSplitTest() {
    final someEnum[] enum_array = new someEnum[1];
    enum_array[0] = someEnum.A;
    azzert.that(CSV.split(someEnum.class, cantBeNull(CSV.combine(enum_array)))[0] + "", is("A"));
  }
}
