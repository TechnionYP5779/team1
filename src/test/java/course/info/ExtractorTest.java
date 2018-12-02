package course.info;


import org.junit.*;


public class ExtractorTest {
  
  @Ignore @Test @SuppressWarnings("static-method") public void test1() {
    Extractor.writeCsvFile("out.csv", Extractor.getCourseData());
  }
  
  @Ignore @Test @SuppressWarnings("static-method") public void test2() {
    Extractor.getCourseData();
  }
}
