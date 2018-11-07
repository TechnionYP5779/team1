package a;

import static org.junit.Assert.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

/** Singleton collections.
 * @author Ori Roth
 * @since 2017-04-16 */
public interface singleton {
  /** Singleton list. */
  static <T> @NotNull List<T> list(final T ¢) {
    return as.list(¢);
  }

  /** Singleton array. */
  static <T> T[] array(final T ¢) {
    //ofir's comment
    return as.array(¢);
  }
  
  @SuppressWarnings("static-method") public static class TEST {
    @Test public void testToList() {
      assertEquals(Arrays.asList("hello"), singleton.list("hello"));
    }

    @Test public void testToArray() {
      Object[] a = singleton.array("hello");
      assertEquals("hello", a[0]);
      assertEquals(1, a.length);
    }
  }
  
}



