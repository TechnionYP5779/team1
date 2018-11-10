package il.org.spartan.utils;

import org.junit.*;

public class LinearRegressionTest {
  @SuppressWarnings("boxing") @Test public void linearRegressionTwoDots() {
    RealNumbersPairList list = new RealNumbersPairList();
    list.record(0.0, 0.0);
    list.record(5.0, 5.0);
    LinearRegression regression = new LinearRegression(list);
  }
}
