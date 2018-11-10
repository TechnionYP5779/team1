package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

public class LinearRegressionTest {
  @SuppressWarnings("boxing") @Test public void linearRegressionTwoDots() {
    RealNumbersPairList list = new RealNumbersPairList();
    list.record(0.0, 0.0);
    list.record(5.0, 5.0);
    LinearRegression regression = new LinearRegression(list);
    azzert.assertTrue(regression.getLine().equals(new LinearFunction(1.0, 0.0)));
  }
}
