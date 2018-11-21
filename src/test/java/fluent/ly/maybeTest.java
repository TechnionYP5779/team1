package fluent.ly;

import static fluent.ly.azzert.*;

import org.junit.*;

@SuppressWarnings("static-method") public class maybeTest {
  @Test public void usecase0() {
    isNull(maybe.no().get());
  }

  @Test public void usecase1() {
    isNull(maybe.yes(null).get());
  }

  @Test public void usecase2() {
    azzert.notNull(maybe.yes(new Object()).get() );
  }
  
  @Test public void clearTest() {
    azzert.notNull(maybe.yes(null).clear());
  }
  
  @Test public void missingPresentTest() {
    azzert.that(maybe.yes(new Object()).missing(), is(! maybe.yes(new Object()).present()));
    azzert.that(maybe.yes(null).missing(), is(! maybe.yes(null).present()));
  }
  @Test public void setTest() {
    azzert.notNull(maybe.yes(null).set(null).clear());
  }
}
