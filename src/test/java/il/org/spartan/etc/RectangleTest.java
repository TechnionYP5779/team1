package il.org.spartan.etc;

import org.junit.*;
import static fluent.ly.box.*;

import fluent.ly.*;
import il.org.spartan.utils.*;

@SuppressWarnings("static-method") public class RectangleTest {
  @Test public void creationFromPairs() throws Exception {
    azzert.notNull(new Rectangle(new Pair<>(box(1.0), box(1.0)), new Pair<>(box(2.0), box(2.0))));
  }

  @Test(expected = IllegalArgumentException.class) public void illegalCreationOfPoint() throws IllegalArgumentException {
    final Pair<Double, Double> p1 = new Pair<>(box(1.0), box(1.0));
    forget.it(new Rectangle(p1, p1));
  }

  @Test(expected = IllegalArgumentException.class) public void illegalCreationOfLineX() throws IllegalArgumentException {
    forget.it(new Rectangle(new Pair<>(box(1.0), box(1.0)), new Pair<>(box(3.0), box(1.0))));
  }

  @Test(expected = IllegalArgumentException.class) public void illegalCreationOfLineY() throws IllegalArgumentException {
    forget.it(new Rectangle(new Pair<>(box(1.0), box(1.0)), new Pair<>(box(1.0), box(3.0))));
  }

  @Test public void areaOfRealRect() throws IllegalArgumentException {
    Assert.assertEquals(2.25, new Rectangle(Pair.newPair(box(1.5), box(1.5)), Pair.newPair(box(3.0), box(3.0))).area(), 1E-10);
  }

  @Test public void perimOfRealRect() throws IllegalArgumentException {
    Assert.assertEquals(6.0, new Rectangle(Pair.newPair(box(1.5), box(1.5)), Pair.newPair(box(3.0), box(3.0))).perim(), 1E-10);
  }

  @Test public void lengthOfOfRealRect() throws IllegalArgumentException {
    Assert.assertEquals(1.5, new Rectangle(Pair.newPair(box(1.5), box(1.5)), Pair.newPair(box(3.0), box(3.0))).length, 1E-10);
  }

  @Test public void widthOfRealRect() throws IllegalArgumentException {
    Assert.assertEquals(1.5, new Rectangle(Pair.newPair(box(1.5), box(1.5)), Pair.newPair(box(3.0), box(3.0))).width, 1E-10);
  }

  @Test public void rotate90Degrees() throws IllegalArgumentException {
    final Rectangle r = new Rectangle(Pair.newPair(box(1.0), box(1.0)), Pair.newPair(box(3.0), box(2.0)));
    Assert.assertEquals(2, r.length, 1E-10);
    Assert.assertEquals(1, r.width, 1E-10);
    Assert.assertNotNull(r.transpose());
    Assert.assertEquals(1, r.transpose().length, 1E-10);
    Assert.assertEquals(2, r.transpose().width, 1E-10);
  }
}
