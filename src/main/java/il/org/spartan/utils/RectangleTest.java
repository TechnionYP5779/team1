package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;
import il.org.spartan.utils.Rectangle.*;

public class RectangleTest {

  @SuppressWarnings({ "static-method", "unused" }) @Test public void creationFromPairs() throws Exception {
    Pair<Double, Double> p1 = new Pair<Double, Double>(Double.valueOf(1),Double.valueOf(1));
    Pair<Double, Double> p2 = new Pair<Double, Double>(Double.valueOf(2),Double.valueOf(2));
    Rectangle rec;
    
    rec = new Rectangle(p1, p2);
    azzert.notNull(rec);
    
  }
  
  @SuppressWarnings({ "static-method", "unused" }) @Test(expected = IllegalParameters.class) 
  public void illegalCreationOfPoint() throws IllegalParameters {
    Pair<Double, Double> p1 = new Pair<Double, Double>(Double.valueOf(1),Double.valueOf(1));
    Rectangle rec = new Rectangle(p1, p1);
  }
  
  @SuppressWarnings({ "static-method", "unused" }) @Test(expected = IllegalParameters.class) 
  public void illegalCreationOfLineX() throws IllegalParameters {
    Pair<Double, Double> p1 = new Pair<Double, Double>(Double.valueOf(1),Double.valueOf(1));
    Pair<Double, Double> p2 = new Pair<Double, Double>(Double.valueOf(3),Double.valueOf(1));
    Rectangle rec = new Rectangle(p1, p2);
  }
  
  @SuppressWarnings({ "static-method", "unused" }) @Test(expected = IllegalParameters.class) 
  public void illegalCreationOfLineY() throws IllegalParameters {
    Pair<Double, Double> p1 = new Pair<Double, Double>(Double.valueOf(1),Double.valueOf(1));
    Pair<Double, Double> p2 = new Pair<Double, Double>(Double.valueOf(1),Double.valueOf(3));
    Rectangle rec = new Rectangle(p1, p2);
  }

  
  @SuppressWarnings({ "static-method", "static-access" }) @Test public void areaOfRealRect() throws IllegalParameters {
    Rectangle r = new Rectangle(Pair.newPair(Double.valueOf(1.5), Double.valueOf(1.5))
        , Pair.newPair(Double.valueOf(3.0), Double.valueOf(3.0)));
    
    azzert.assertEquals(1.5*1.5, r.area(), 1E-10);
  }
  
  @SuppressWarnings({ "static-method", "static-access" }) @Test public void perimOfRealRect() throws IllegalParameters {
    Rectangle r = new Rectangle(Pair.newPair(Double.valueOf(1.5), Double.valueOf(1.5))
        , Pair.newPair(Double.valueOf(3.0), Double.valueOf(3.0)));
    
    azzert.assertEquals(6.0, r.perim(), 1E-10);
  }
  
  @SuppressWarnings({ "static-method", "static-access" }) @Test public void lengthOfOfRealRect() throws IllegalParameters {
    Rectangle r = new Rectangle(Pair.newPair(Double.valueOf(1.5), Double.valueOf(1.5))
        , Pair.newPair(Double.valueOf(3.0), Double.valueOf(3.0)));
    
    azzert.assertEquals(1.5, r.length, 1E-10);
  }
  
  @SuppressWarnings({ "static-method", "static-access" }) @Test public void widthOfRealRect() throws IllegalParameters {
    Rectangle r = new Rectangle(Pair.newPair(Double.valueOf(1.5), Double.valueOf(1.5))
        , Pair.newPair(Double.valueOf(3.0), Double.valueOf(3.0)));
    
    azzert.assertEquals(1.5, r.width, 1E-10);
  }
  
  @SuppressWarnings({ "static-method", "static-access" }) @Test public void rotate90Degrees() throws IllegalParameters {
    Rectangle r = new Rectangle(Pair.newPair(Double.valueOf(1), Double.valueOf(1))
        , Pair.newPair(Double.valueOf(3), Double.valueOf(2)));
    
    azzert.assertEquals(2, r.length, 1E-10);
    azzert.assertEquals(1, r.width, 1E-10);

    azzert.assertNotNull(r.transpose());
    
    azzert.assertEquals(1, r.transpose().length, 1E-10);
    azzert.assertEquals(2, r.transpose().width, 1E-10);
  }
  
}
