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
    return null;
  }
}
