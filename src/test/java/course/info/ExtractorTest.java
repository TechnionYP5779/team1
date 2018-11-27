package course.info;


import org.junit.*;

public class ExtractorTest {
  
  @Test @SuppressWarnings("static-method") public void test1() {
    Extractor.writeCsvFile("out.csv", Extractor.toCourseObjectList());
  }
}
