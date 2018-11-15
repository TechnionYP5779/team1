package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

import static il.org.spartan.utils.Accumulator.Counter;
import static il.org.spartan.utils.Accumulator.Last;

@SuppressWarnings({ "static-method", "static-access" }) public class AccumulatorTest {
  @Test public void verifyName() {
    azzert.assertEquals("My First Counter", (new Counter("My First Counter")).name());
    azzert.assertEquals("My First Register", (new Last("My First Register")).name());
  }

  @Test public void checkDefaultWeight() {
    azzert.assertEquals(1, (new Counter()).weight());
  }

  @Test public void addIsStepOne() {
    Accumulator accumulator = new Counter();
    accumulator.add(8);
    accumulator.add("Hello");
    accumulator.add(true);
    azzert.assertEquals(3, accumulator.value());
  }

  @Test public void doubleWeight() {
    Counter counter = new Counter();
    counter.weight(2);
    counter.add();
    azzert.assertEquals(2, counter.value());
    azzert.assertEquals(4, counter.next());
    azzert.assertEquals(4, counter.value());
  }
  
  @Test public void valueNotChange() {
    Counter counter = new Counter();
    counter.add(false);
    azzert.assertEquals(new Counter() + "", counter + "");
  }
  
  @Test public void lastValueIsKept() {
    Last last = new Last();
    last.add(10);
    last.add(80);
    azzert.assertEquals(80, last.value());
  }
}