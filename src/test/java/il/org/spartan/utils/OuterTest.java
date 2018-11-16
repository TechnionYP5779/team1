package il.org.spartan.utils;

import static fluent.ly.box.*;
import org.junit.*;
import static fluent.ly.azzert.is;
import fluent.ly.*;

public class OuterTest {
  //===========================================
  //            CLASS VARIABLES
  //===========================================
  Outer<Integer> outer = new Outer<>(box(5));
  Outer<Integer> outer2 = new Outer<>(box(6));
  Outer<Integer> null_outer = new Outer<>(box(7));
  @Before public void setNullOuter(){
    null_outer.set(null);
  }
  //===========================================
//  @Test public void cloneTest() {
//    try {
//      assert outer.equals(outer.clone());
//      assert !outer.clone().equals(outer2);
//    }
//    catch(final CloneNotSupportedException __) {
//      forget.it(__);
//      assert false;
//    }
//  }
  //===========================================
  @Test public void equalsTest() {
    // check on null Outer
    assert null_outer.equals(null_outer);
    assert !null_outer.equals(outer);
    // check on not-null outer
    assert outer.equals(outer);
    assert !outer.equals(outer2);
    Object outer3 = outer;
    assert outer.equals(outer3);
    outer3 = new Outer<>(box(5));
    assert outer3.equals(outer);
  }
//===========================================
  @Test public void getTest() {
    azzert.that(outer.get(), is(5));
  }
  //===========================================
  @Test public void hashCodeTest() {
    azzert.that(null_outer.hashCode(),is(0));
    azzert.that(outer.hashCode(),is(box(5).hashCode())); 
  }
  //===========================================
  @Test public void setTest() {
    azzert.that(outer.get(), is(5));
    outer.set(box(7));
    azzert.that(outer.get(), is(7));
  }
  //===========================================
    @Test public void toStringTest() {
      azzert.that(null_outer + "", is("null"));
      azzert.that(outer + "", is("5")); 
    }
}