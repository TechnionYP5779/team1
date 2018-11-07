package il.org.spartan.utils;

public class Rectangle {

  @SuppressWarnings("serial") public class IllegalParameters extends Exception {
    //for when the points actually create a line or a point
  }
  
  private Pair<Double, Double> p1;
  private Pair<Double, Double> p2;
  
  public double length;
  public double width;

  public Rectangle(Pair<Double, Double> p1, Pair<Double, Double> p2) throws IllegalParameters {
    if(p1.first.equals(p2.first) || p1.second.equals(p2.second)) throw new IllegalParameters();
    
    this.p1 = p1;
    this.p2 = p2;
    
    length = Math.abs(p1.first.doubleValue() - p2.first.doubleValue());
    width = Math.abs(p1.second.doubleValue() - p2.second.doubleValue());
    
  }
  

  public double area() {
    return length*width;
  }

  public double perim() {
    return 2*(length + width);
  }


  public Rectangle transpose() {
    Pair<Double, Double> p1_new = Pair.newPair(p1.second, p1.first);
    Pair<Double, Double> p2_new = Pair.newPair(p2.second, p2.first);
    
    Rectangle newRec = null;
    
    try {
      newRec =  new Rectangle(p1_new, p2_new);
    } catch (@SuppressWarnings("unused") IllegalParameters ignore) {
      throw new AssertionError();
    }
  
    return newRec;
  }
  
  
}
