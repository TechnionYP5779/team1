package il.org.spartan.statistics;

import static org.junit.Assert.*;
import java.util.*;
import org.jetbrains.annotations.*;
import org.junit.*;
import fluent.ly.*;

 public class statisticsTest {
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
   azzert.assertTrue(Statistics.mad(second_integer_sample) == 0);
   
   //========== ANOTHER TEST ==========
     double mad3 = Statistics.mad(third_integer_sample);
     azzert.assertTrue(mad3 >= 1 && mad3 <= 2);
    
   }
 
   @Test public void testMedian() {
   azzert.assertTrue(Statistics.median(first_integers_sample) == 16.0);
     
   azzert.assertTrue(Statistics.median(second_integer_sample) == second_median);
     
   azzert.assertTrue(Statistics.median(third_integer_sample) == third_median);
   }
 
 //  @Test public void testPrune() {
 //    assertTrue(true);
 //  }
 
   @Test public void testSampleMean() {
   azzert.assertTrue(Statistics.sampleMean(first_integers_sample) == first_mean);
   
     azzert.assertTrue(Statistics.sampleMean(second_integer_sample) == second_mean);
   
     azzert.assertTrue(Statistics.sampleMean(third_integer_sample) == third_mean);
   }
 
   @Test public void testSampleVariance() {
   //========== ANOTHER TEST ==========
     double firstVariance = Statistics.sampleVariance(first_integers_sample);
     azzert.assertTrue(firstVariance >= 13 && firstVariance <= 14);
     
   azzert.assertTrue(Statistics.sampleVariance(second_integer_sample) == second_variance);
     
   azzert.assertTrue(Statistics.sampleVariance(third_integer_sample) == third_variance);
   }
 
   @Test public void testIsEmpty() {
   azzert.assertTrue(my_statistics.isEmpty());
     
   //========== ANOTHER TEST ==========
   my_statistics.n = 7;
   azzert.assertFalse(my_statistics.isEmpty());
   
   //========== ANOTHER TEST ==========
     my_statistics.n = 0;
     azzert.assertTrue(my_statistics.isEmpty());
   }
 
   @Test public void testMax() {
     //========== ANOTHER TEST ==========
   try {
     my_statistics.n = 0;
     my_statistics.max();
     fail("you should have not got here");
   }
   catch(@SuppressWarnings("unused") ArithmeticException e) {
     azzert.assertTrue(true);
   }
   
   //========== ANOTHER TEST ==========
     my_statistics.n = 3;
     my_statistics.max = 15;
     azzert.assertTrue(my_statistics.max() == 15);
   }
 
   @Test public void testMean() {
     //========== ANOTHER TEST ==========
   try {
     my_statistics.mean();
   }
   catch(@SuppressWarnings("unused") ArithmeticException e) {
     azzert.assertTrue(true);
   }
   
   //========== ANOTHER TEST ==========
   my_statistics.n = 6;
   my_statistics.moments[1] = Arrays.stream(first_integers_sample).sum();
   azzert.assertTrue(my_statistics.mean() == first_mean);
   
   //========== ANOTHER TEST ==========
   my_statistics.moments[1] = Arrays.stream(second_integer_sample).sum();
   azzert.assertTrue(my_statistics.mean() == second_mean);
   
   //========== ANOTHER TEST ==========
     my_statistics.n = 5;
     my_statistics.moments[1] = Arrays.stream(third_integer_sample).sum();
     azzert.assertTrue(my_statistics.mean() == third_mean);
   }
 
   @Test public void testMin() {
     //========== ANOTHER TEST ==========
   try {
     my_statistics.min();
   }
   catch(@SuppressWarnings("unused") ArithmeticException e) {
     azzert.assertTrue(true);
   }
   
   //========== ANOTHER TEST ==========
     my_statistics.n = 3;
     my_statistics.min = 15;
     azzert.assertTrue(my_statistics.min() == 15);
   }
 
   @Test public void testMissing() {
     azzert.assertTrue(my_statistics.missing() == 0);
   
     //========== ANOTHER TEST ==========
     int missing_value = 5;
     my_statistics.missing = missing_value;
     azzert.assertTrue(my_statistics.missing() == missing_value);
   }
 
   @Test public void testN() {
     azzert.assertTrue(my_statistics.n == 0);
   
     //========== ANOTHER TEST ==========
     int nth_value = 7;
     my_statistics.n = nth_value;
     azzert.assertTrue(my_statistics.n == nth_value);
   }
 
 //  @Test public void testRelativeError() {
 //    fail("Not yet implemented");
 //  }
 
   @Test public void testSd() {
     testVariance();
     azzert.assertTrue(my_statistics.sd() == 2);
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
     azzert.assertTrue(my_statistics.variance() == 4);
   }
 
   @Test public void testCheckEmpty() {
     //========== ANOTHER TEST ==========
   try {
     my_statistics.n = 0;
     my_statistics.checkEmpty();
     fail("YOU SHOULD HAVE RAISED EXCEPTION");
   }
   catch(@SuppressWarnings("unused") ArithmeticException e) {
     azzert.assertTrue(true);
   }
   
   //========== ANOTHER TEST ==========
   try{
     my_statistics.n = 7;
     my_statistics.checkEmpty();
     azzert.assertTrue(true);
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
     double test_res = index == 1 ? my_statistics.sum() : my_statistics.sum2();
     azzert.assertTrue(test_res == 5);
   }
 }
