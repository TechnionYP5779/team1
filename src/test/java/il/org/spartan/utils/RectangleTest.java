package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;
@SuppressWarnings("static-method")
public class RectangleTest {
  @Test public void creationFromPairs() throws Exception {
    azzert.notNull(new Rectangle(new Pair<>(Double.valueOf(1), Double.valueOf(1)), new Pair<>(Double.valueOf(2), Double.valueOf(2))));
  }

  @Test(expected = IllegalArgumentException.class) @SuppressWarnings("unused") public void illegalCreationOfPoint()
      throws IllegalArgumentException {
    final Pair<Double, Double> p1 = new Pair<>(Double.valueOf(1), Double.valueOf(1));
    new Rectangle(p1, p1);
  }

  @Test(expected = IllegalArgumentException.class) @SuppressWarnings("unused") public void illegalCreationOfLineX()
      throws IllegalArgumentException {
    new Rectangle(new Pair<>(Double.valueOf(1), Double.valueOf(1)), new Pair<>(Double.valueOf(3), Double.valueOf(1)));
  }

  @Test(expected = IllegalArgumentException.class) @SuppressWarnings("unused") public void illegalCreationOfLineY()
      throws IllegalArgumentException {
    new Rectangle(new Pair<>(Double.valueOf(1), Double.valueOf(1)), new Pair<>(Double.valueOf(1), Double.valueOf(3)));
  }

  @Test public void areaOfRealRect() throws IllegalArgumentException {
    Assert.assertEquals(2.25,
        new Rectangle(Pair.newPair(Double.valueOf(1.5), Double.valueOf(1.5)), Pair.newPair(Double.valueOf(3.0), Double.valueOf(3.0))).area(), 1E-10);
  }

  @Test public void perimOfRealRect() throws IllegalArgumentException {
    Assert.assertEquals(6.0,
        new Rectangle(Pair.newPair(Double.valueOf(1.5), Double.valueOf(1.5)), Pair.newPair(Double.valueOf(3.0), Double.valueOf(3.0))).perim(), 1E-10);
  }

  @Test public void lengthOfOfRealRect() throws IllegalArgumentException {
    Assert.assertEquals(1.5,
        new Rectangle(Pair.newPair(Double.valueOf(1.5), Double.valueOf(1.5)), Pair.newPair(Double.valueOf(3.0), Double.valueOf(3.0))).length, 1E-10);
  }

  @Test public void widthOfRealRect() throws IllegalArgumentException {
    Assert.assertEquals(1.5,
        new Rectangle(Pair.newPair(Double.valueOf(1.5), Double.valueOf(1.5)), Pair.newPair(Double.valueOf(3.0), Double.valueOf(3.0))).width, 1E-10);
  }

  @Test public void rotate90Degrees() throws IllegalArgumentException {
    final Rectangle r = new Rectangle(Pair.newPair(Double.valueOf(1), Double.valueOf(1)), Pair.newPair(Double.valueOf(3), Double.valueOf(2)));
    Assert.assertEquals(2, r.length, 1E-10);
    Assert.assertEquals(1, r.width, 1E-10);
    Assert.assertNotNull(r.transpose());
    Assert.assertEquals(1, r.transpose().length, 1E-10);
    Assert.assertEquals(2, r.transpose().width, 1E-10);
  }
}
