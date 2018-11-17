package il.org.spartan.utils;

import static fluent.ly.azzert.*;
import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.Accumulator.*;
import il.org.spartan.utils.Accumulator.Counter;

@SuppressWarnings("static-method") public class AccumulatorTest {
  @Test public void verifyName() {
    azzert.that("My First Counter", is(new Counter("My First Counter").name()));
    azzert.that("My First Register", is(new Last("My First Register").name()));
  }

  @Test public void checkDefaultWeight() {
    azzert.that(1, is(new Counter().weight()));
  }

  @Test public void addIsStepOne() {
    final Accumulator accumulator = new Counter();
    accumulator.add(8);
    accumulator.add("Hello");
    accumulator.add(true);
    azzert.that(3, is(accumulator.value()));
  }

  @Test public void doubleWeight() {
    final Counter counter = new Counter();
    counter.weight(2);
    counter.add();
    azzert.that(2, is(counter.value()));
    azzert.that(4, is(counter.next()));
    azzert.that(4, is(counter.value()));
  }

  @Test public void valueNotChange() {
    final Counter counter = new Counter();
    counter.add(false);
    azzert.that(new Counter() + "", is(counter + ""));
  }

  @Test public void lastValueIsKept() {
    final Last last = new Last();
    last.add(10);
    last.add(80);
    azzert.that(80, is(last.value()));
  }
}