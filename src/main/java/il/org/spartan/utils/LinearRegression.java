package il.org.spartan.utils;

@SuppressWarnings("boxing") public class LinearRegression {
  double[] xVals;
  double[] yVals;
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
}
