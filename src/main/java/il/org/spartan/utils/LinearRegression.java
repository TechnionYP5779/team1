package il.org.spartan.utils;

@SuppressWarnings("boxing") public class LinearRegression {
  double[] xVals;
  double[] yVals;
  double R2;
  
  public class NotEnoughDots extends Exception {
    private static final long serialVersionUID = 1L;
  }
  
  public class InfiniteSlopeFunction extends Exception {
    private static final long serialVersionUID = 1L;
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
      yVals[index] = point.second;
      index++;
    }
    R2 = 0.0;
  }
  
  LinearRegression(double[] x, double[] y){
    int length = x.length <= y.length ? x.length : y.length;
    xVals = new double[length];
    yVals = new double[length];
    for(int i = 0; i < length; i++) {
      xVals[i] = x[i];
      yVals[i] = y[i];
    }
  }
  
  public LinearFunction getLine() throws NotEnoughDots, InfiniteSlopeFunction {
    if(xVals.length <= 1) throw new NotEnoughDots();
    
    if(allDotsHaveTheSameX()) {
      throw new InfiniteSlopeFunction(xVals[0]);
    }
    
    // Compute the average of the dots
    double xSum = 0.0;
    double ySum = 0.0;
    for (int i = 0; i < xVals.length; i++) {
      xSum += xVals[i];
      ySum += yVals[i];
    }
    double xAvg = xSum / xVals.length;
    double yAvg = ySum / yVals.length;
    
    // Compute the squared distance from the average
    double xxAvgDistance = 0.0;
    double yyAvgDistance = 0.0;
    double pointsAvgDistance = 0.0;
    for (int i = 0; i < xVals.length; i++) {
      xxAvgDistance += (xVals[i] - xAvg) * (xVals[i] - xAvg);
      yyAvgDistance += (yVals[i] - yAvg) * (yVals[i] - yAvg);
      pointsAvgDistance += (xVals[i] - xAvg) * (yVals[i] - yAvg);
    }
    
    double slope = pointsAvgDistance / xxAvgDistance;
    double intercept = yAvg - slope * xAvg;
    
    double ssr = 0.0;      // regression sum of squares
    for (int i = 0; i < xVals.length; i++) {
        double fit = slope*xVals[i] + intercept;
        ssr += (fit - yAvg) * (fit - yAvg);
    }
    R2 = ssr / yyAvgDistance;
    
    return new LinearFunction(slope, intercept);
  }
  
  public double getR2Measurement() {
    return R2;
  }

  private boolean allDotsHaveTheSameX() {
    if(xVals.length <= 1) return true;
    double value = xVals[0];
    for(double x : xVals) {
      if(x != value) return false;
    }
    return true;
  }
}
