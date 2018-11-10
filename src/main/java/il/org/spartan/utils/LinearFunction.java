package il.org.spartan.utils;

public class LinearFunction {
  double slope;
  double intercept;
  
  LinearFunction(double slope, double intercept){
    this.slope = slope;
    this.intercept = intercept;
  }
  
  @Override public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof LinearFunction)) {
      return false;
    }
    LinearFunction line = (LinearFunction)o;
    return line.slope == slope && line.intercept == intercept;
  }
}
