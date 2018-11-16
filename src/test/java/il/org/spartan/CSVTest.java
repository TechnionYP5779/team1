package il.org.spartan;

import org.jetbrains.annotations.*;
import org.junit.*;
import static fluent.ly.azzert.is;
import java.io.*;
import fluent.ly.*;
import il.org.spartan.etc.*;

@SuppressWarnings("static-method") public class CSVTest {
  enum someEnum {
    A, B;
  }

  @Test public void combineTest() {
    Class<?>[] array = new Class<?>[2];
    array[0] = null;
    array[1] = Integer.class;
    azzert.that(CSV.combine(array), is("null,java.lang.Integer"));
    someEnum[] enum_array = new someEnum[2];
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
      @NotNull String[][] data = new @NotNull String[2][2];
      data[0][0] = "0";
      data[0][1] = "1";
      data[1][0] = "2";
      data[1][1] = "3";
      File my_file = new File("some_file_name.csv");
      CSV.save(my_file, data);
      CSV.load(my_file);
    } catch (IOException __) {
      forget.it(__);
      assert false;
    }
    try {
      if (new File("some_file_name.csv").delete())
        CSV.load(new File("some_file_name.csv"));
      assert false;
    } catch (IOException __) {
      forget.it(__);
      assert true;
    }
  }

  @Test public void unescapeTest() {
    assert CSV.unescape("\\0") == null;
    azzert.that(CSV.unescape(Utils.cantBeNull(CSV.escape("\\a"))), is("\\a"));
    azzert.that(CSV.unescape(Utils.cantBeNull(CSV.escape("\na"))), is("\na"));
    azzert.that(CSV.unescape(Utils.cantBeNull(CSV.escape("\ra"))), is("\ra"));
    azzert.that(CSV.unescape(Utils.cantBeNull(CSV.escape("\ta"))), is("\ta"));
    azzert.that(CSV.unescape(Utils.cantBeNull(CSV.escape(",a"))), is(",a"));
  }

  @Test public void splitToClasses() {
    Class<?>[] array = new Class<?>[2];
    array[0] = String.class;
    array[1] = Integer.class;
    Class<?>[] classes = CSV.splitToClasses(Utils.cantBeNull(CSV.combine(array)));
    azzert.that(classes[0], is(array[0]));
    azzert.that(classes[1], is(array[1]));
    try {
      forget.it(CSV.splitToClasses("noSuchClass"));
      assert false;
    } catch (RuntimeException __) {
      forget.it(__);
      assert true;
    }
  }
}
