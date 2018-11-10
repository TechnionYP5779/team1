package il.org.spartan.utils;

@SuppressWarnings("boxing") public class LinearRegression {
  double[] xVals;
  double[] yVals;
  double R2;
  
  public class NotEnoughDots extends Exception {
    private static final long serialVersionUID = 1;
  }
  
  public class InfiniteSlopeFunction extends Exception {
    private static final long serialVersionUID = 1;
    double xVal;
    InfiniteSlopeFunction(double x){
      xVal = x;
    }
  }
  
  LinearRegression(RealNumbersPairList list){
    xVals = new double[list.size()];
    yVals = new double[list.size()];
    int index = 0;
    for(Pair<Double, Double> point : list) {
      xVals[index] = point.first;
      yVals[index++] = point.second;
    }
    R2 = 0.0;
  }
  
  LinearRegression(double[] x, double[] y){
    int length = x.length > y.length ? y.length : x.length;
    xVals = new double[length];
    yVals = new double[length];
    for(int ¢ = 0; ¢ < length; ++¢) {
      xVals[¢] = x[¢];
      yVals[¢] = y[¢];
    }
  }
  
  public LinearFunction getLine() throws NotEnoughDots, InfiniteSlopeFunction {
    if(xVals.length <= 1) throw new NotEnoughDots();
    
    if(allPointsHaveTheSameX())
      throw new InfiniteSlopeFunction(xVals[0]);
    
    double xSum = 0.0, ySum = 0.0;
    for (int ¢ = 0; ¢ < xVals.length; ++¢) {
      xSum += xVals[¢];
      ySum += yVals[¢];
    }
    double xAvg = xSum / xVals.length, yAvg = ySum / yVals.length, xxAvgDistance = 0.0, yyAvgDistance = 0.0, pointsAvgDistance = 0.0;
    for (int ¢ = 0; ¢ < xVals.length; ++¢) {
      xxAvgDistance += (xVals[¢] - xAvg) * (xVals[¢] - xAvg);
      yyAvgDistance += (yVals[¢] - yAvg) * (yVals[¢] - yAvg);
      pointsAvgDistance += (xVals[¢] - xAvg) * (yVals[¢] - yAvg);
    }
    
    double $ = pointsAvgDistance / xxAvgDistance, intercept = yAvg - $ * xAvg, ssr = 0.0;
    for (int i = 0; i < xVals.length; ++i) {
        double fit = intercept + $ * xVals[i];
        ssr += (fit - yAvg) * (fit - yAvg);
    }
    R2 = ssr / yyAvgDistance;
    
    return new LinearFunction($, intercept);
  }
  
  public double getR2Measurement() {
    return R2;
  }

  private boolean allPointsHaveTheSameX() {
    if(xVals.length <= 1) return true;
    double value = xVals[0];
    for(double x : xVals)
      if (x != value)
        return false;
    return true;
  }
}
