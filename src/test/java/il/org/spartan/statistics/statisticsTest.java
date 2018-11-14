package il.org.spartan.statistics;

import static fluent.ly.azzert.fail;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

public class statisticsTest {
  // ========== CLASS VARIABLES - FOR TESTING ==========
  double @NotNull [] first_integers_sample = new double[] { 10.0, 15.0, 15.0, 17.0, 18.0, 21.0 };
  double first_mean;
  double @NotNull [] second_integer_sample = new double[] { 0, 0, 0, 0, 0, 0 };
  double second_median;
  double second_mean;
  double second_variance;
  double @NotNull [] third_integer_sample = new double[] { 1, 2, 3, 4, 5 };
  double third_median;
  double third_mean;
  double third_variance;
  Statistics my_statistics;

  // =====================================================
  @Before public void initClassVariables() {
    first_mean = 16.0;
    second_variance = second_mean = 0;
    third_mean = third_median = 3;
    third_variance = 2.5;
    my_statistics = new Statistics() {
      /* Redundant */};
  }
  // =====================================================

  @Test public void testMad() {
    assert Statistics.mad(second_integer_sample) == 0;
    // ========== ANOTHER TEST ==========
    final double mad3 = Statistics.mad(third_integer_sample);
    assert mad3 >= 1 && mad3 <= 2;
  }

  @Test public void testMedian() {
    assert Statistics.median(first_integers_sample) == 16.0;
    assert Statistics.median(second_integer_sample) == second_median;
    assert Statistics.median(third_integer_sample) == third_median;
  }

  // @Test public void testPrune() {
  // assertTrue(true);
  // }
  @Test public void testSampleMean() {
    assert Statistics.sampleMean(first_integers_sample) == first_mean;
    assert Statistics.sampleMean(second_integer_sample) == second_mean;
    assert Statistics.sampleMean(third_integer_sample) == third_mean;
  }

  @Test public void testSampleVariance() {
    // ========== ANOTHER TEST ==========
    final double firstVariance = Statistics.sampleVariance(first_integers_sample);
    assert firstVariance >= 13 && firstVariance <= 14;
    assert Statistics.sampleVariance(second_integer_sample) == second_variance;
    assert Statistics.sampleVariance(third_integer_sample) == third_variance;
  }

  @Test public void testIsEmpty() {
    assert my_statistics.isEmpty();
    // ========== ANOTHER TEST ==========
    my_statistics.n = 7;
    assert !my_statistics.isEmpty();
    // ========== ANOTHER TEST ==========
    my_statistics.n = 0;
    assert my_statistics.isEmpty();
  }

  @Test public void testMax() {
    // ========== ANOTHER TEST ==========
    try {
      my_statistics.n = 0;
      my_statistics.max();
      fail("you should have not got here");
    } catch (@SuppressWarnings("unused") final ArithmeticException e) {
      assert true;
    }
    // ========== ANOTHER TEST ==========
    my_statistics.n = 3;
    my_statistics.max = 15;
    assert my_statistics.max() == 15;
  }

  @Test public void testMean() {
    // ========== ANOTHER TEST ==========
    try {
      my_statistics.mean();
    } catch (@SuppressWarnings("unused") final ArithmeticException e) {
      assert true;
    }
    // ========== ANOTHER TEST ==========
    my_statistics.n = 6;
    my_statistics.moments[1] = Arrays.stream(first_integers_sample).sum();
    assert my_statistics.mean() == first_mean;
    // ========== ANOTHER TEST ==========
    my_statistics.moments[1] = Arrays.stream(second_integer_sample).sum();
    assert my_statistics.mean() == second_mean;
    // ========== ANOTHER TEST ==========
    my_statistics.n = 5;
    my_statistics.moments[1] = Arrays.stream(third_integer_sample).sum();
    assert my_statistics.mean() == third_mean;
  }

  @Test public void testMin() {
    // ========== ANOTHER TEST ==========
    try {
      my_statistics.min();
    } catch (@SuppressWarnings("unused") final ArithmeticException e) {
      assert true;
    }
    // ========== ANOTHER TEST ==========
    my_statistics.n = 3;
    my_statistics.min = 15;
    assert my_statistics.min() == 15;
  }

  @Test public void testMissing() {
    assert my_statistics.missing() == 0;
    // ========== ANOTHER TEST ==========
    final int missing_value = 5;
    my_statistics.missing = missing_value;
    assert my_statistics.missing() == missing_value;
  }

  @Test public void testN() {
    assert my_statistics.n == 0;
    // ========== ANOTHER TEST ==========
    final int nth_value = 7;
    my_statistics.n = nth_value;
    assert my_statistics.n == nth_value;
  }

  // @Test public void testRelativeError() {
  // fail("Not yet implemented");
  // }
  @Test public void testSd() {
    testVariance();
    assert my_statistics.sd() == 2;
  }

  @Test public void testSum() {
    checkSum(1);
  }

  @Test public void testSum2() {
    checkSum(2);
  }

  // @Test public void testV() {
  // fail("Not yet implemented");
  // }
  @Test public void testVariance() {
    // ========== ANOTHER TEST ==========
    my_statistics.moments[2] = 55;
    my_statistics.moments[1] = my_statistics.n = 11;
    assert my_statistics.variance() == 4;
  }

  @Test public void testCheckEmpty() {
    // ========== ANOTHER TEST ==========
    try {
      my_statistics.n = 0;
      my_statistics.checkEmpty();
      fail("YOU SHOULD HAVE RAISED EXCEPTION");
    } catch (@SuppressWarnings("unused") final ArithmeticException e) {
      assert true;
    }
    // ========== ANOTHER TEST ==========
    try {
      my_statistics.n = 7;
      my_statistics.checkEmpty();
      assert true;
    } catch (final ArithmeticException ¢) {
      fail("YOU SHOULD HAVE NOT RAISED EXCEPTION" + ¢.getMessage());
    }
  }

  // =======================================
  // Auxiliary function - check sum functions
  // =======================================
  private void checkSum(int index) {
    my_statistics.moments[index] = 5;
    my_statistics.n = 1;
    assert (index == 1 ? my_statistics.sum() : my_statistics.sum2()) == 5;
  }
}
