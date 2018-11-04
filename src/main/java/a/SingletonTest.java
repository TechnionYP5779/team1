package a;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SingletonTest {
    @SuppressWarnings("static-method") @Test
    public void testToList() {
        assertEquals(Arrays.asList("hello"), singleton.list("hello"));
    }

    @SuppressWarnings("static-method") @Test
    public void testToArray() {
        Object[] a = singleton.array("hello");
        assertEquals("hello", a[0]);
        assertEquals(1, a.length);
    }
}
