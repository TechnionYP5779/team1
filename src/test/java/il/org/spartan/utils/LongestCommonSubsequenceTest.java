package il.org.spartan.utils;

import static fluent.ly.azzert.is;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class LongestCommonSubsequenceTest {
  @Test public void testLongestCommonSubsequenceNotNull() {
    azzert.notNull(new LongestCommonSubsequence("abc", "abc"));
  }

  @Test public void testSimilarityWithEmptyString() {
    azzert.that(new LongestCommonSubsequence("", "abc").similarity(), is(0.0));
    azzert.that(new LongestCommonSubsequence("abc", "").similarity(), is(0.0));
  }

  @Test public void testSimilaritySameString() {
    azzert.that(new LongestCommonSubsequence("abc", "abc").similarity(), is(1.0));
  }

  @Test public void testSimilarityTotallyDifferent() {
    azzert.that(new LongestCommonSubsequence("abc", "def").similarity(), is(0.0));
  }

  @Test public void testSimilarityWithSimilarity() {
    // that number is the ratio between the len of the LCS (4) and the average
    // len of the strings (7)
    azzert.that(new LongestCommonSubsequence("aHbHbHa", "aKKKbba").similarity(), is(4.0/7));
  }
}
