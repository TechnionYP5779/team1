package il.org.spartan.etc;

import static fluent.ly.box.*;
import static fluent.ly.azzert.is;
import org.junit.*;

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
    azzert.that(new Rectangle(Pair.newPair(box(1.5), box(1.5)), Pair.newPair(box(3.0), box(3.0))).area(), is(2.25));
  }

  @Test public void perimOfRealRect() throws IllegalArgumentException {
    azzert.that(new Rectangle(Pair.newPair(box(1.5), box(1.5)), Pair.newPair(box(3.0), box(3.0))).perim(), is(6.0));
  }

  @Test public void lengthOfOfRealRect() throws IllegalArgumentException {
    azzert.that(new Rectangle(Pair.newPair(box(1.5), box(1.5)), Pair.newPair(box(3.0), box(3.0))).length, is(1.5));
  }

  @Test public void widthOfRealRect() throws IllegalArgumentException {
    azzert.that(new Rectangle(Pair.newPair(box(1.5), box(1.5)), Pair.newPair(box(3.0), box(3.0))).width,is(1.5));
  }

  @Test public void rotate90Degrees() throws IllegalArgumentException {
    final Rectangle r = new Rectangle(Pair.newPair(box(1.0), box(1.0)), Pair.newPair(box(3.0), box(2.0)));
    azzert.that(r.length, is(2.0));
    azzert.that(r.width, is(1.0));
    azzert.notNull(r.transpose());
    azzert.that(r.transpose().length, is(1.0));
    azzert.that(r.transpose().width, is(2.0));
  }
}
