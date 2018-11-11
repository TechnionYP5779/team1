package il.org.spartan.utils;

import org.junit.*;

@SuppressWarnings("static-method")  public class angleTest {
  @Test public void degress() {
    assert angle.degrees(20).degrees == 20;
  }
  
  @Test public void radians() {
    assert angle.radians(1).radians == 1;
  }
  
  @Test public void pi() {
    assert angle.pi.radians == Math.PI;
  }
  
  @Test public void halfPi() {
    assert angle.halfPi.radians == Math.PI/2;
  }
  
  @Test public void add() {
    assert angle.halfPi.add(angle.degrees(20)).radians == (Math.PI/2+20);
    assert angle.halfPi.add(20).degrees == 110;
  }
  
  @Test public void degrees() {
    assert angle.pi.degrees() == 180;
  }
  
  @Test public void of() {
    assert angle.of(20).degrees() == 180;
  }
  
  @Test public void radians2() {
    assert angle.pi.radians() == Math.PI/2;
  }
  
}
