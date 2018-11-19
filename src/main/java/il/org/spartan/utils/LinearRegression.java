package il.org.spartan.utils;

import static fluent.ly.unbox.*;

public class LinearRegression {
  double[] xVals;
  double[] yVals;
  double R2;

  public class NotEnoughDots extends Exception {
    private static final long serialVersionUID = 1;
  }

  public class InfiniteSlopeFunction extends Exception {
    private static final long serialVersionUID = 1;
    double xVal;

    InfiniteSlopeFunction(final double x) {
      xVal = x;
    }
  }

  LinearRegression(final RealNumbersPairList list) {
    xVals = new double[list.size()];
    yVals = new double[list.size()];
    int index = 0;
    for (final Pair<Double, Double> point : list) {
      xVals[index] = unbox(point.first);
      yVals[index++] = unbox(point.second);
    }
    R2 = 0.0;
  }

  LinearRegression(final double[] x, final double[] y) {
    final int length = x.length > y.length ? y.length : x.length;
    xVals = new double[length];
    yVals = new double[length];
    for (int ¢ = 0; ¢ < length; ++¢) {
      xVals[¢] = x[¢];
      yVals[¢] = y[¢];
    }
  }

  public LinearFunction getLine() throws NotEnoughDots, InfiniteSlopeFunction {
    if (xVals.length <= 1)
      throw new NotEnoughDots();
    if (allPointsHaveTheSameX())
      throw new InfiniteSlopeFunction(xVals[0]);
    double xSum = 0.0, ySum = 0.0;
    for (int ¢ = 0; ¢ < xVals.length; ++¢) {
      xSum += xVals[¢];
      ySum += yVals[¢];
    }
    final double xAvg = xSum / xVals.length, yAvg = ySum / yVals.length;
    double xxAvgDistance = 0.0, yyAvgDistance = 0.0, pointsAvgDistance = 0.0;
    for (int ¢ = 0; ¢ < xVals.length; ++¢) {
      xxAvgDistance += (xVals[¢] - xAvg) * (xVals[¢] - xAvg);
      yyAvgDistance += (yVals[¢] - yAvg) * (yVals[¢] - yAvg);
      pointsAvgDistance += (xVals[¢] - xAvg) * (yVals[¢] - yAvg);
    }
    final double $ = pointsAvgDistance / xxAvgDistance, intercept = yAvg - $ * xAvg;
    double ssr = 0.0;
    for (final double xVal : xVals)
      ssr += (intercept + $ * xVal - yAvg) * (intercept + $ * xVal - yAvg);
    R2 = ssr / yyAvgDistance;
    return new LinearFunction($, intercept);
  }

  public double getR2Measurement() {
    return R2;
  }

  private boolean allPointsHaveTheSameX() {
    if (xVals.length <= 1)
      return true;
    final double value = xVals[0];
    for (final double x : xVals)
      if (x != value)
        return false;
    return true;
  }
}
