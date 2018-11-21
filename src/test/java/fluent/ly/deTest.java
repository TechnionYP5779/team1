package fluent.ly;

import org.junit.*;

@SuppressWarnings("static-method") public class deTest {
   @Test public void faultNonNullTest() {
    azzert.notNull(de.fault(new Object()).to(new Object()));
  }
   @Test public void faultNullTest() {
     azzert.notNull(de.fault(null).to(new Object()));
   }
}
