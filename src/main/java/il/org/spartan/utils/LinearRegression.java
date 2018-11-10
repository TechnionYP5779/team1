package il.org.spartan.utils;

@SuppressWarnings("boxing") public class LinearRegression {
  double[] xVals;
  double[] yVals;
  
  public class NotEnoughDots extends Exception {
    private static final long serialVersionUID = 1L;
    // End of list exception
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
  }
  
  public LinearFunction getLine() throws NotEnoughDots {
    if(xVals.length <= 1) throw new NotEnoughDots();
    if(xVals.length == 2) {
      double slope = (yVals[1] - yVals[0])/(xVals[1] - xVals[0]);
      double intercept = yVals[0] - slope*xVals[0];
      return new LinearFunction(slope, intercept);
    }
    
    // Compute the average of the dots
    double xSum = 0.0, ySum = 0.0, xSquaredSum = 0.0;
    for (int i = 0; i < xVals.length; i++) {
      xSum += xVals[i];
      ySum += yVals[i];
      xSquaredSum += xVals[i] * xVals[i];
    }
    double xAvg = xSum / xVals.length;
    double yAvg = ySum / yVals.length;
    
    // Compute the squared distance from the average
    double xxAvgDistance = 0.0, yyAvgDistance = 0.0, pointsAvgDistance = 0.0;
    for (int i = 0; i < xVals.length; i++) {
      xxAvgDistance += (xVals[i] - xAvg) * (xVals[i] - xAvg);
      yyAvgDistance += (yVals[i] - yAvg) * (yVals[i] - yAvg);
      pointsAvgDistance += (xVals[i] - xAvg) * (yVals[i] - yAvg);
    }
    
    double slope = pointsAvgDistance / xxAvgDistance;
    double intercept = yAvg - slope * xAvg;
    return new LinearFunction(slope, intercept);
  }
  
  
}
