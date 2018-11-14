package il.org.spartan.etc;

import org.junit.*;
import il.org.spartan.utils.*;
import fluent.ly.*;

public class RectangleTest {

  @Test @SuppressWarnings({ "static-method", "unused" }) public void creationFromPairs() throws Exception {
    azzert.notNull(new Rectangle(new Pair<Double, Double>(Double.valueOf(1), Double.valueOf(1)), new Pair<Double, Double>(Double.valueOf(2), Double.valueOf(2))));
  }
  
  @Test(expected = IllegalArgumentException.class) @SuppressWarnings({ "static-method", "unused" }) public void illegalCreationOfPoint()
      throws IllegalArgumentException {
    Pair<Double, Double> p1 = new Pair<Double, Double>(Double.valueOf(1), Double.valueOf(1));
    new Rectangle(p1, p1);
  }
  
  @Test(expected = IllegalArgumentException.class) @SuppressWarnings({ "static-method", "unused" }) public void illegalCreationOfLineX()
      throws IllegalArgumentException {
    new Rectangle(new Pair<Double, Double>(Double.valueOf(1), Double.valueOf(1)), new Pair<Double, Double>(Double.valueOf(3), Double.valueOf(1)));
  }
  
  @Test(expected = IllegalArgumentException.class) @SuppressWarnings({ "static-method", "unused" }) public void illegalCreationOfLineY()
      throws IllegalArgumentException {
    new Rectangle(new Pair<Double, Double>(Double.valueOf(1), Double.valueOf(1)), new Pair<Double, Double>(Double.valueOf(1), Double.valueOf(3)));
  }

  
  @Test @SuppressWarnings({ "static-method", "static-access" }) public void areaOfRealRect() throws IllegalArgumentException {
    azzert.assertEquals(2.25,
        (new Rectangle(Pair.newPair(Double.valueOf(1.5), Double.valueOf(1.5)), Pair.newPair(Double.valueOf(3.0), Double.valueOf(3.0)))).area(),
        1E-10);
  }
  
  @Test @SuppressWarnings({ "static-method", "static-access" }) public void perimOfRealRect() throws IllegalArgumentException {
    azzert.assertEquals(6.0,
        (new Rectangle(Pair.newPair(Double.valueOf(1.5), Double.valueOf(1.5)), Pair.newPair(Double.valueOf(3.0), Double.valueOf(3.0)))).perim(),
        1E-10);
  }
  
  @Test @SuppressWarnings({ "static-method", "static-access" }) public void lengthOfOfRealRect() throws IllegalArgumentException {
    azzert.assertEquals(1.5,
        (new Rectangle(Pair.newPair(Double.valueOf(1.5), Double.valueOf(1.5)), Pair.newPair(Double.valueOf(3.0), Double.valueOf(3.0)))).length,
        1E-10);
  }
  
  @Test @SuppressWarnings({ "static-method", "static-access" }) public void widthOfRealRect() throws IllegalArgumentException {
    azzert.assertEquals(1.5,
        (new Rectangle(Pair.newPair(Double.valueOf(1.5), Double.valueOf(1.5)), Pair.newPair(Double.valueOf(3.0), Double.valueOf(3.0)))).width, 1E-10);
  }
  
  @Test @SuppressWarnings({ "static-method", "static-access" }) public void rotate90Degrees() throws IllegalArgumentException {
    Rectangle r = new Rectangle(Pair.newPair(Double.valueOf(1), Double.valueOf(1)), Pair.newPair(Double.valueOf(3), Double.valueOf(2)));
    azzert.assertEquals(2, r.length, 1E-10);
    azzert.assertEquals(1, r.width, 1E-10);
    azzert.assertNotNull(r.transpose());
    azzert.assertEquals(1, r.transpose().length, 1E-10);
    azzert.assertEquals(2, r.transpose().width, 1E-10);
  }
  
}
