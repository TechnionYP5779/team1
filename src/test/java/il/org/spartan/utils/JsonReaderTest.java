package il.org.spartan.utils;

import org.junit.Test;

import fluent.ly.*;

public class JsonReaderTest {
  @Test @SuppressWarnings("static-method") public void test1() {

      azzert.notNull(JsonReader.readJsonFromUrl("https://storage.googleapis.com/repy-176217.appspot.com/latest.json"));
      
  }
}
