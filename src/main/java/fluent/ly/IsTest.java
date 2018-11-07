package fluent.ly;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class IsTest {
  @SuppressWarnings("static-method") @Test public void testIsNotIn() {
    assertFalse(is.in(Integer.valueOf(1), Integer.valueOf(8), Integer.valueOf(100), Integer.valueOf(2)));
  }
  
  public void testIsIn() {
    assertFalse(is.in(Integer.valueOf(8), Integer.valueOf(8), Integer.valueOf(100), Integer.valueOf(2)));
  }
}
