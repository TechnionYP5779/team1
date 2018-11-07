package il.org.spartan.statistics;

import static il.org.spartan.statistics.MomentUtils.*;
import static org.junit.Assert.*;

import static fluent.ly.box.*;

import java.util.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import il.org.spatan.iteration.*;

/** @author Yossi Gil
 * @since 30/04/2011 */
public abstract class Statistics {
  protected static final int MOMENTS = 4;
  @NotNull protected static final String EMPTY_SEQUENCE = "No elements yet in sequene.";

  public static double mad(final double @NotNull [] ds) {
    final int n = ds.length;
    final double median = median(ds), $[] = new double[n];
    for (int ¢ = 0; ¢ < n; ++¢)
      $[¢] = Math.abs(ds[¢] - median);
    return median($);
  }

  public static double median(final double @NotNull [] ¢) {
    Arrays.sort(¢);
    return (¢[¢.length / 2] + ¢[(¢.length - 1) / 2]) / 2;
  }

  public static double @NotNull [] prune(final double @NotNull [] ds) {
    final @NotNull List<Double> $ = new ArrayList<>();
    final double median = median(ds), mad = mad(ds);
    for (final double ¢ : ds)
      if (median - 2 * mad <= ¢ && ¢ <= median + 2 * mad)
        $.add(box(¢));
    return Iterables.toArray($);
  }

  public static double sampleMean(final double @NotNull [] ds) {
    double $ = 0;
    for (final double ¢ : ds)
      $ += ¢;
    return $ / ds.length;
  }

  /** Compute a <a href=
   * "http://en.wikipedia.org/wiki/Variance#Population_variance_and_sample_variance"
   * >sample variance</a>
   * @param ds the sample
   * @return the sample variance of the parameter */
  public static double sampleVariance(final double @NotNull [] ds) {
    double $ = 0, sum2 = 0;
    for (final double ¢ : ds) {
      $ += ¢;
      sum2 += ¢ * ¢;
    }
    return sum2 / (ds.length - 1) - $ * $ / (ds.length * ds.length - ds.length);
  }

  protected int n;
  protected int missing;
  protected double min;
  protected double max;
  protected final double[] moments = new double[MOMENTS];

  /** @return <code><b>true</b></code> <i>if, and only if</i> one ore more
   *         non-missing values were recorded in the sequence. */
  public final boolean isEmpty() {
    return n() == 0;
  }

  /** @return the largest value of the elements in the sequence
   * @throws ArithmeticException in case this function was called prior to
   *                             recording any elements in the sequence */
  public final double max() throws ArithmeticException {
    checkEmpty();
    return max;
  }

  /** @return the average value of the elements in the sequence
   * @throws ArithmeticException in case this function was called prior to
   *                             recording any elements in the sequence */
  public final double mean() throws ArithmeticException {
    checkEmpty();
    return sum() / n();
  }

  /** @return the smallest value of the elements in the sequence
   * @throws ArithmeticException in case this function was called prior to
   *                             recording any elements in the sequence */
  public final double min() throws ArithmeticException {
    checkEmpty();
    return min;
  }

  /** @return a non-negative integer, giving the number of ''missing'' elements in
   *         the sequence */
  public final int missing() {
    return missing;
  }

  /** Provides the number of elements in this instance.
   * @return a non-negative integer, giving the number of elements in the
   *         sequence */
  public final int n() {
    return n;
  }

  /** @return the relative error of the elements in the sequence, defined as the
   *         standard deviation divided by the mean.
   * @throws ArithmeticException in case this function was called prior to
   *                             recording any elements in the sequence */
  public final double relativeError() {
    return mean() == 0 ? sd() : sd() / Math.abs(mean());
  }

  /** @return the standard deviation of the elements in the sequence
   * @throws ArithmeticException in case this function was called prior to
   *                             recording any elements in the sequence */
  public final double sd() {
    return Math.sqrt(sum2() / n() - sqr(mean()));
  }

  /** @return the sum of all values in the sequence */
  public final double sum() {
    return moments[1];
  }

  /** @return the sum of squares of all values in the sequence */
  public double sum2() {
    return moments[2];
  }

  /** @return the <a href=
   *         "http://en.wikipedia.org/wiki/Variance#Population_variance_and_sample_variance"
   *         >sample variance</a> f the elements in the sequence
   * @throws ArithmeticException in case this function was called prior to
   *                             recording any elements in the sequence */
  public final double v() {
    return sum2() / (n - 1) - sqr(sum()) / (sqr(n) - n);
  }

  public double variance() {
    return sum2() / n() - sqr(mean());
  }

  /** Provides the degrees of freedom offered by this instance.
   * @return a non-negative integer, giving the degree of freedom in the sequence,
   *         i.e., the number of elements - 1.
   * @see #n() */
  public final int ν() {
    return n() - 1;
  }

  protected void checkEmpty() throws ArithmeticException {
    if (isEmpty())
      throw new ArithmeticException(EMPTY_SEQUENCE);
  }
  
  
  
  
  // ==================================================================
  // Tests for statistics
  // ==================================================================
  public static class TEST {
    //========== CLASS VARIABLES - FOR TESTING ==========
    double @NotNull [] first_integers_sample = new double[] {10.0, 15.0, 15.0, 17.0, 18.0, 21.0};
    double first_mean;
    
    double @NotNull [] second_integer_sample  = new double [] {0,0,0,0,0,0};
    double second_median;
    double second_mean;
    double second_variance;
    
    double @NotNull [] third_integer_sample = new double[] {1,2,3,4,5};
    double third_median;
    double third_mean;
    double third_variance;
    
    Statistics my_statistics;
    
    //=====================================================
    @Before
    public void initClassVariables() { 
      first_mean = 16.0;
      
      second_variance = second_mean = 0;
      
      third_mean = third_median = 3;
      third_variance = 2.5;
      
      my_statistics = new Statistics() {/*Redundant*/};
    }
    //=====================================================
    
    @Test public void testMad() {
      assert Statistics.mad(second_integer_sample) == 0;
      
      //========== ANOTHER TEST ==========
      double mad3 = Statistics.mad(third_integer_sample);
      assert mad3 >= 1 && mad3 <= 2;
     
    }
  
    @Test public void testMedian() {
    assert Statistics.median(first_integers_sample) == 16.0;
      
    assert Statistics.median(second_integer_sample) == second_median;
      
    assert Statistics.median(third_integer_sample) == third_median;
    }
  
  //  @Test public void testPrune() {
  //    assertTrue(true);
  //  }
  
    @Test public void testSampleMean() {
    assert Statistics.sampleMean(first_integers_sample) == first_mean;
    
      assert Statistics.sampleMean(second_integer_sample) == second_mean;
    
      assert Statistics.sampleMean(third_integer_sample) == third_mean;
    }
  
    @Test public void testSampleVariance() {
    //========== ANOTHER TEST ==========
      double firstVariance = Statistics.sampleVariance(first_integers_sample);
      assert firstVariance >= 13 && firstVariance <= 14;
      
    assert Statistics.sampleVariance(second_integer_sample) == second_variance;
      
    assert Statistics.sampleVariance(third_integer_sample) == third_variance;
    }
  
    @Test public void testIsEmpty() {
    assert my_statistics.isEmpty();
      
    //========== ANOTHER TEST ==========
      my_statistics.n = 7;
      assert !my_statistics.isEmpty();
      
      //========== ANOTHER TEST ==========
      my_statistics.n = 0;
      assert my_statistics.isEmpty();
    }
  
    @Test public void testMax() {
      //========== ANOTHER TEST ==========
      try {
        my_statistics.n = 0;
        my_statistics.max();
        fail("you should have not got here");
      }
      catch(@SuppressWarnings("unused") ArithmeticException e) {
        assert true;
      }
      
      //========== ANOTHER TEST ==========
      my_statistics.n = 3;
      my_statistics.max = 15;
      assert my_statistics.max() == 15;
    }
  
    @Test public void testMean() {
      //========== ANOTHER TEST ==========
      try {
        my_statistics.mean();
      }
      catch(@SuppressWarnings("unused") ArithmeticException e) {
        assert true;
      }
      
      //========== ANOTHER TEST ==========
      my_statistics.n = 6;
      my_statistics.moments[1] = Arrays.stream(first_integers_sample).sum();
      assert my_statistics.mean() == first_mean;
      
      //========== ANOTHER TEST ==========
      my_statistics.moments[1] = Arrays.stream(second_integer_sample).sum();
      assert my_statistics.mean() == second_mean;
      
      //========== ANOTHER TEST ==========
      my_statistics.n = 5;
      my_statistics.moments[1] = Arrays.stream(third_integer_sample).sum();
      assert my_statistics.mean() == third_mean;
    }
  
    @Test public void testMin() {
      //========== ANOTHER TEST ==========
      try {
        my_statistics.min();
      }
      catch(@SuppressWarnings("unused") ArithmeticException e) {
        assert true;
      }
      
      //========== ANOTHER TEST ==========
      my_statistics.n = 3;
      my_statistics.min = 15;
      assert my_statistics.min() == 15;
    }
  
    @Test public void testMissing() {
      assert my_statistics.missing() == 0;
    
      //========== ANOTHER TEST ==========
      int missing_value = 5;
      my_statistics.missing = missing_value;
      assert my_statistics.missing() == missing_value;
    }
  
    @Test public void testN() {
      assert my_statistics.n == 0;
    
      //========== ANOTHER TEST ==========
      int nth_value = 7;
      my_statistics.n = nth_value;
      assert my_statistics.n == nth_value;
    }
  
  //  @Test public void testRelativeError() {
  //    fail("Not yet implemented");
  //  }
  
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
  
  //  @Test public void testV() {
  //    fail("Not yet implemented");
  //  }
  
    @Test public void testVariance() {
      //========== ANOTHER TEST ==========
      my_statistics.moments[2] = 55;
      my_statistics.moments[1] = my_statistics.n = 11;
      assert my_statistics.variance() == 4;
    }
  
    @Test public void testCheckEmpty() {
      //========== ANOTHER TEST ==========
      try {
        my_statistics.n = 0;
        my_statistics.checkEmpty();
        fail("YOU SHOULD HAVE RAISED EXCEPTION");
      }
      catch(@SuppressWarnings("unused") ArithmeticException e) {
        assert true;
      }
      
      //========== ANOTHER TEST ==========
      try{
        my_statistics.n = 7;
        my_statistics.checkEmpty();
        assert true;
      }
      catch (ArithmeticException ¢) {
        fail("YOU SHOULD HAVE NOT RAISED EXCEPTION"+¢.getMessage());
      }
    }
    
    // =======================================
    // Auxiliary function - check sum functions
    //=======================================
    private void checkSum(int index) {
      my_statistics.moments[index] = 5;
      my_statistics.n = 1;
      assert (index == 1 ? my_statistics.sum() : my_statistics.sum2()) == 5;
    }
  }
}
