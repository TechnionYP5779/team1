package il.org.spartan.statistics;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.*;

public class StatisticsTest {
  
  //========== CLASS VARIABLES - FOR TESTING ==========
  private final double [] first_integers_sample = new double[] {10.0, 15.0, 15.0, 17.0, 18.0, 21.0};
  private final double first_median = 16.0;
  private final double first_mean = 16.0;
  
  private final double [] second_integer_sample = new double [] {0,0,0,0,0,0};
  private final double second_median = 0;
  private final double second_mean = 0;
  private final double second_variance = 0;
  
  private final double [] third_integer_sample = new double[] {1,2,3,4,5};
  private final double third_median = 3;
  private final double third_mean = 3;
  private final double third_variance = 2.5;
  
  private final Statistics my_statistics = new Statistics() {};
  //=====================================================
  
  @Test public void testMad() {    
    //========== ANOTHER TEST ==========
    double mad2 = Statistics.mad(second_integer_sample);
    assertTrue(mad2 == 0);
    
    //========== ANOTHER TEST ==========
    double mad3 = Statistics.mad(third_integer_sample);
    assertTrue(mad3 >= 1 && mad3 <= 2);
   
  }

  @Test public void testMedian() {
  //========== ANOTHER TEST ==========
    double median1 = Statistics.median(first_integers_sample);
    assertTrue(median1 == 16.0);
    
  //========== ANOTHER TEST ==========
    double median2 = Statistics.median(second_integer_sample);
    assertTrue(median2 == second_median);
    
  //========== ANOTHER TEST ==========
    double median3 = Statistics.median(third_integer_sample);
    assertTrue(median3 == third_median);
  }

//  @Test public void testPrune() {
//    assertTrue(true);
//  }

  @Test public void testSampleMean() {
  //========== ANOTHER TEST ==========
    assertTrue(Statistics.sampleMean(first_integers_sample) == first_mean);
  
    //========== ANOTHER TEST ==========
    assertTrue(Statistics.sampleMean(second_integer_sample) == second_mean);
  
    //========== ANOTHER TEST ==========
    assertTrue(Statistics.sampleMean(third_integer_sample) == third_mean);
  }

  @Test public void testSampleVariance() {
  //========== ANOTHER TEST ==========
    double firstVariance = Statistics.sampleVariance(first_integers_sample);
    assertTrue(firstVariance >= 13 && firstVariance <= 14);
    
  //========== ANOTHER TEST ==========
    assertTrue(Statistics.sampleVariance(second_integer_sample) == second_variance);
    
  //========== ANOTHER TEST ==========
    assertTrue(Statistics.sampleVariance(third_integer_sample) == third_variance);
  }

  @Test public void testIsEmpty() {
  //========== ANOTHER TEST ==========
    assertTrue(my_statistics.isEmpty());
    
  //========== ANOTHER TEST ==========
    my_statistics.n = 7;
    assertTrue(! my_statistics.isEmpty());
    
    //========== ANOTHER TEST ==========
    my_statistics.n = 0;
    assertTrue(my_statistics.isEmpty());
  }

  @Test public void testMax() {
    //========== ANOTHER TEST ==========
    try {
      my_statistics.n = 0;
      double max = my_statistics.max();
      fail("you should have not got here");
    }
    catch(ArithmeticException e) {
      assertTrue(true);
    }
    
    //========== ANOTHER TEST ==========
    my_statistics.n = 3;
    my_statistics.max = 15;
    assertTrue(my_statistics.max() == 15);
  }

  @Test public void testMean() {
    //========== ANOTHER TEST ==========
    try {
      double mean = my_statistics.mean();
    }
    catch(ArithmeticException e) {
      assertTrue(true);
    }
    
    //========== ANOTHER TEST ==========
    my_statistics.n = 6;
    my_statistics.moments[1] = Arrays.stream(first_integers_sample).sum();
    assertTrue(my_statistics.mean() == first_mean);
    
    //========== ANOTHER TEST ==========
    my_statistics.moments[1] = Arrays.stream(second_integer_sample).sum();
    assertTrue(my_statistics.mean() == second_mean);
    
    //========== ANOTHER TEST ==========
    my_statistics.n = 5;
    my_statistics.moments[1] = Arrays.stream(third_integer_sample).sum();
    assertTrue(my_statistics.mean() == third_mean);
  }

  @Test public void testMin() {
    //========== ANOTHER TEST ==========
    try {
      double min = my_statistics.min();
    }
    catch(ArithmeticException e) {
      assertTrue(true);
    }
    
    //========== ANOTHER TEST ==========
    my_statistics.n = 3;
    my_statistics.min = 15;
    assertTrue(my_statistics.min() == 15);
  }

  @Test public void testMissing() {
    //========== ANOTHER TEST ==========
    assertTrue(my_statistics.missing() == 0);
  
    //========== ANOTHER TEST ==========
    int missing_value = 5;
    my_statistics.missing = missing_value;
    assertTrue(my_statistics.missing() == missing_value);
  }

  @Test public void testN() {
    //========== ANOTHER TEST ==========
    assertTrue(my_statistics.n == 0);
  
    //========== ANOTHER TEST ==========
    int nth_value = 7;
    my_statistics.n = nth_value;
    assertTrue(my_statistics.n == nth_value);
  }

//  @Test public void testRelativeError() {
//    fail("Not yet implemented");
//  }

  @Test public void testSd() {
    testVariance();
    assertTrue(2 == my_statistics.sd());
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
    my_statistics.n = 11;
    my_statistics.moments[1] = 11;
    assertTrue(4 == my_statistics.variance());
  }

  @Test public void testCheckEmpty() {
    //========== ANOTHER TEST ==========
    try {
      my_statistics.n = 0;
      my_statistics.checkEmpty();
      fail("YOU SHOULD HAVE RAISED EXCEPTION");
    }
    catch(ArithmeticException e) {
      assertTrue(true);
    }
    
    //========== ANOTHER TEST ==========
    try{
      my_statistics.n = 7;
      my_statistics.checkEmpty();
      assertTrue(true);
    }
    catch (ArithmeticException e) {
      fail("YOU SHOULD HAVE NOT RAISED EXCEPTION");
    }
  }
  
  // =======================================
  // Auxiliary function - check sum functions
  //=======================================
  private void checkSum(int index) {
    my_statistics.moments[index] = 5;
    my_statistics.n = 1;
    if(index == 1)
      assertTrue(5 == my_statistics.sum());
    else
      assertTrue(5 == my_statistics.sum2());
  }
}
