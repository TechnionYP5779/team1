package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.LinearRegression.*;

@SuppressWarnings("static-method")
public class LinearRegressionTest {
  @Test public void linearRegressionTwoDots() {
    RealNumbersPairList list = new RealNumbersPairList();
    list.record(0.0, 0.0);
    list.record(5.0, 5.0);
    LinearRegression regression = new LinearRegression(list);
    try {
      azzert.assertTrue(regression.getLine().equals(new LinearFunction(1.0, 0.0)));
    } catch (@SuppressWarnings("unused") Exception e) {
      azzert.assertTrue(false);
    }
  }
  
  @Test public void linearRegressionOneDot() {
    RealNumbersPairList list = new RealNumbersPairList();
    list.record(0.0, 0.0);
    LinearRegression regression = new LinearRegression(list);
    try {
      regression.getLine();
    } catch (@SuppressWarnings("unused") NotEnoughDots e) {
      azzert.assertTrue(true);
    }
  }
}
