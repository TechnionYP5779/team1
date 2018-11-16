package il.org.spartan.utils;

import static fluent.ly.box.*;

import org.junit.*;
import static fluent.ly.azzert.is;
import fluent.ly.*;
import il.org.spartan.etc.*;

public class OuterTest {
  //===========================================
  //            CLASS VARIABLES
  //===========================================
  Outer<Integer> outer = new Outer<>(box(5));
  Outer<Integer> outer2 = new Outer<>(box(6));
  Outer<Integer> null_outer = new Outer<>(box(7));
//===========================================
  @Before public void setNullOuter(){
    null_outer.set(null);
  }
//===========================================
  @Test @SuppressWarnings("unlikely-arg-type") public void equalsTest() {
    // the warning is because we want to check on two different objects
    assert null_outer.equals(null_outer);
    assert !null_outer.equals(outer);
    Object null_obj = null;
    assert outer.equals(outer);
    assert !outer.equals(null_obj);
    assert !outer.equals(box(5));
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