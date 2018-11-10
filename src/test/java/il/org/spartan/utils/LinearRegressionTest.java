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
  
  @Test public void linearRegressionExactThreeDots() {
    RealNumbersPairList list = new RealNumbersPairList();
    list.record(1.0, 1.0);
    list.record(2.0, 4.0);
    list.record(3.0, 7.0);
    LinearRegression regression = new LinearRegression(list);
    try {
      azzert.assertTrue(regression.getLine().equals(new LinearFunction(3.0, -2.0)));
    } catch (@SuppressWarnings("unused") NotEnoughDots e) {
      // TODO Auto-generated catch block
      azzert.assertTrue(false);
    }
  }
  
  @Test public void linearRegressionNotExactThreeDots() {
    RealNumbersPairList list = new RealNumbersPairList();
    list.record(1.0, 1.0);
    list.record(2.0, 5.0);
    list.record(3.0, 7.0);
    LinearRegression regression = new LinearRegression(list);
    try {
      azzert.assertTrue(regression.getLine().slope >= 2.0 && regression.getLine().slope <= 4.0 );
      azzert.assertTrue(regression.getLine().intercept <= 1.0 && regression.getLine().intercept >= -3.0 );
    } catch (@SuppressWarnings("unused") NotEnoughDots e) {
      // TODO Auto-generated catch block
      azzert.assertTrue(false);
    }
  }
  
  @Test public void linearRegressionTwoSameX() {
    RealNumbersPairList list = new RealNumbersPairList();
    list.record(1.0, 1.0);
    list.record(1.0, 5.0);
    list.record(3.0, 7.0);
    LinearRegression regression = new LinearRegression(list);
    try {
      azzert.assertTrue(regression.getLine().slope >= 1.0 && regression.getLine().slope <= 3.0 );
      azzert.assertTrue(regression.getLine().intercept <= 4.0 && regression.getLine().intercept >= -2.0 );
    } catch (@SuppressWarnings("unused") NotEnoughDots e) {
      // TODO Auto-generated catch block
      azzert.assertTrue(false);
    }
  }
  
  @Test public void linearRegressionBuildFromArrays() {
    /* This test was made in order to increase the loose coupling 
     * of the classes 'RealNumbersPairList' and 'LinearRegression' */
    double xVals[] = {1.0, 3.0, 4.0};
    double yVals[] = {1.0, 9.0, 13.0};
    LinearRegression regression = new LinearRegression(xVals, yVals);
    try {
      azzert.assertTrue(regression.getLine().slope >= 3.5 && regression.getLine().slope <= 4.5 );
      azzert.assertTrue(regression.getLine().intercept <= -2.5 && regression.getLine().intercept >= -3.5 );
    } catch (@SuppressWarnings("unused") Exception e) {
      azzert.assertTrue(false);
    }
  }
}
