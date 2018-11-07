package a;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SingletonTest {
    @Test @SuppressWarnings("static-method") public void testToList() {
      assertEquals(Arrays.asList("hello"), singleton.list("hello"));
    }

    @Test @SuppressWarnings("static-method") public void testToArray() {
      Object[] a = singleton.array("hello");
      assertEquals("hello", a[0]);
      assertEquals(1, a.length);
    }
}
