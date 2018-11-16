package il.org.spartan;

import org.junit.*;

@SuppressWarnings("static-method") public class tideTest {
  @Test public void clean() {
    Assert.assertEquals(tide.clean("  Hello  "), "Hello");
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
