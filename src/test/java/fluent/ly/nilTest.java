package fluent.ly;

import static fluent.ly.azzert.*;
import static fluent.ly.box.*;

import java.util.*;
import java.util.function.*;

import org.junit.*;

import fluent.ly.nil.*;

@SuppressWarnings("static-method") public class nilTest {
  
  @Test public void testForgetting() {
    azzert.isNull(nil.forgetting(box(1), box(2)));
    azzert.isNull(nil.forgetting(box(1), "abc"));
    azzert.isNull(nil.forgetting(box(1), box(2.5), "abc", Arrays.asList(box(1), box(2), box(3))));
  }

  static String helperF(final Integer ¢) {
    return ¢ + "";
  }

  @Test public void testGuardingly() {
    final On<Integer, String> ff = nil.guardingly(nilTest::helperF);
    azzert.isNull(ff.on(null));
    azzert.notNull(ff.on(box(1)));
    azzert.that(ff.on(box(11)), is("11"));
  }

  @Test public void testIgnoringBoolean() {
    azzert.isNull(nil.ignoring(true));
    azzert.isNull(nil.ignoring(false));
  }

  @Test public void testIgnoringDouble() {
    azzert.isNull(nil.ignoring(1.5));
    azzert.isNull(nil.ignoring(2.0));
  }

  @Test public void testIgnoringLong() {
    azzert.isNull(nil.ignoring(7034567L));
    azzert.isNull(nil.ignoring(2L));
  }
  
  static String helloString = "Hello";

  @Test public void t() {
    final Integer i1 = nil.guardingly(String::length).on(helloString);
    azzert.that(i1, is(5));
    final Integer i2 = nil.guardingly(String::length).on(nullString);
    azzert.that(i1, is(5));
    isNull(i2);
    final Integer i3 = nil.guardingly(f).on(nullString);
    azzert.that(i1, is(5));
    isNull(i2);
    isNull(i3);
    nil.guardingly(State::getName).on(null);
    nil.guardingly(State::getName).on(californiaCustomer.getAddress().getState());
  }

  String nullString;
  final Customer californiaCustomer = () -> () -> new State() {
    @Override public String getName() {
      return "California";
    }
  };
  final Function<String, Integer> f = String::length;
  final Customer nullAddressCustomer = () -> null;
  final Customer nullNameCustomer = () -> () -> new State() {/***/
  };
  final Customer nullStateCustomer = () -> () -> null;
  final Customer nullStateCustomer1 = () -> () -> null;

  //@formatter:off
  interface Address { State getState(); }
  interface Customer { Address getAddress(); }
  interface State {default String getName() { return null; } }
}
