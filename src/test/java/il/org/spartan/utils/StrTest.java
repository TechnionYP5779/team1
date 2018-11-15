package il.org.spartan.utils;

import org.junit.*;
import fluent.ly.*;
import il.org.spartan.Utils;

@SuppressWarnings("static-access") // to use azzert without warnings
public class StrTest {
  Str empty_str = new Str();
  Str valued_Str = new Str("Hello world!");
  
  @Test public void setTest() {
    assert !valued_Str.isEmptyx();
    azzert.assertNotEquals(Utils.cantBeNull(valued_Str.inner()), "newValue");
    valued_Str.set("newValue");
    assert !valued_Str.isEmptyx();
    azzert.assertEquals(valued_Str.inner(), "newValue");
  }
  
  @Test public void innerTest() {
    azzert.assertEquals(valued_Str.inner(), "Hello world!");
    azzert.assertEquals(empty_str.inner(), null);
  }
  
  @Test public void isEmptyTest() {
    assert !valued_Str.isEmptyx();
    assert empty_str.isEmptyx();
  }
  @Test public void notEmptyTest() {
    assert valued_Str.notEmpty();
    assert !empty_str.notEmpty();
  }
}