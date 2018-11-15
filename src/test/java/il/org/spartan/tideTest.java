package il.org.spartan;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class tideTest {
  @Test @SuppressWarnings("static-access") public void clean() {
    azzert.assertEquals(tide.clean("  Hello  "), "Hello");
  }
  
   @Test public void eq(){
    String s1 = "Hello", s2 = "Hello";
    assert tide.eq(s1, s2);
    s1 = null;
    assert !tide.eq(s1,s2);
    s1 = "Boy";
    assert !tide.eq(s1, s2);
    s2 = null;
    assert !tide.eq(s1, s2);
  }

}
