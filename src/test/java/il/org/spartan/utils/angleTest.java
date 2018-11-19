package il.org.spartan.utils;
import static fluent.ly.azzert.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class angleTest {
  @Test public void degress() {
    azzert.that(angle.degrees(20).degrees, is(20.0));
    azzert.that(angle.degrees(30).degrees, is(30.0));
  }

  @Test public void radians() {
    azzert.that(angle.radians(20).radians, is(20.0));
    azzert.that(angle.radians(30).radians, is(30.0));
  }

  @Test public void pi() {
    azzert.that(angle.pi.radians, is(Math.PI));
    azzert.that(angle.pi.degrees, is(180.0));
  }

  @Test public void halfPi() {
    azzert.that(angle.halfPi.radians, is(Math.PI/2));
    azzert.that(angle.halfPi.degrees, is(90.0));
  }

  @Test public void add() {
    azzert.that(angle.halfPi.add(angle.degrees(20)).degrees, is(110.0));
    azzert.that(angle.halfPi.add(20).degrees, is(110.0));
    azzert.that(angle.halfPi.add(angle.halfPi).degrees, is(180.0));
    azzert.that(angle.halfPi.add(90).degrees, is(180.0));
  }
  
  @Test public void sub() {
    azzert.that(angle.halfPi.sub(angle.degrees(20)).degrees, is(70.0));
    azzert.that(angle.halfPi.sub(20).degrees, is(70.0));
    azzert.that(angle.halfPi.sub(angle.halfPi).degrees, is(0.0));
    azzert.that(angle.halfPi.sub(90).degrees, is(0.0));
  }
  
  @Test public void negate() {
    azzert.that(angle.halfPi.negate().degrees, is(-90.0));
    azzert.that(angle.negate(angle.halfPi).degrees, is(-90.0));
    azzert.that(angle.pi.negate().degrees, is(-180.0));
    azzert.that(angle.negate(angle.pi).degrees, is(-180.0));
  }

  @Test public void degrees() {
    azzert.that(angle.pi.degrees(), is(180.0));
    azzert.that(angle.radians(2*Math.PI).degrees(), is(360.0));
  }

  @Test public void of() {
    azzert.that(angle.of(20).degrees(), is(20.0));
    azzert.that(angle.of(100).degrees(), is(100.0));
  }

  @Test public void radians2() {
    azzert.that(angle.pi.radians(), is(Math.PI));
    azzert.that(angle.halfPi.radians(), is(Math.PI/2));
  }
}
