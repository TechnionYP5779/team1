package il.org.spartan.utils;

import org.junit.*;

import fluent.ly.*;

@SuppressWarnings({ "null", "static-method", "static-access" })  public class LongestCommonSubsequenceTest {
  @Test public void testLongestCommonSubsequenceNotNull() {
    azzert.falze(new LongestCommonSubsequence("abc", "abc") == null);
  }

  @Test public void testSimilarityWithEmptyString() {
    azzert.assertEquals(0, (new LongestCommonSubsequence("", "abc")).similarity(), 1E-20);
    azzert.assertEquals(0, (new LongestCommonSubsequence("abc", "")).similarity(), 1E-20);
  }
  
  @Test public void testSimilaritySameString() {
    azzert.assertEquals(1, (new LongestCommonSubsequence("abc", "abc")).similarity(), 1E-20);
  }
  
  @Test public void testSimilarityTotallyDifferent() {
    azzert.assertEquals(0, (new LongestCommonSubsequence("abc", "def")).similarity(), 1E-20);
  }
  
  @Test public void testSimilarityWithSimilarity() {
    //that number is the ratio between the len of the LCS (4) and the average len of the strings (7)
    azzert.assertEquals(0.57142857142, (new LongestCommonSubsequence("aHbHbHa", "aKKKbba")).similarity(), 1E-5);
  }
}
