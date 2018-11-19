package il.org.spartan;

import static fluent.ly.azzert.*;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class tideTest {
  @Test public void clean() {
    azzert.that(tide.clean("  Hello  "), is("Hello"));
  }

  @Test public void eq() {
    final String s1 = "Hello", s2 = "Hello";
    assert tide.eq(s1, s2);
    assert !tide.eq(null, s2);
    assert !tide.eq("Boy", s2);
    assert !tide.eq(s1, null);
    assert tide.eq(null, null);
  }
}
