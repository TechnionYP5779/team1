package fluent.ly;

import java.util.*;

import org.junit.*;

@SuppressWarnings({"static-method" ,"static-access"}) public class theTest {
  
  @Test public void minTest() {
    azzert.assertEquals(the.min(5,3,2),2); 
    }

   @Test public void maxTest() {
    azzert.assertEquals(the.max(5,3,2),5); 
    }
  
   @Test public void sqrTest() {
     azzert.assertEquals(the.sqr(0),0);
     azzert.assertEquals(the.sqr(3),9);
     azzert.assertEquals(the.sqr(2),4);
     azzert.assertEquals(the.sqr(1),1);
   }
   
   @Test public void restTest() {
     azzert.assertEquals(the.rest("hello"),"ello");
     azzert.assertEquals(the.rest("a"),"");
   }
   
   @Test @SuppressWarnings({ "null", "deprecation" }) public void lastTailTest() {
    List<Integer> x = new ArrayList<>();
    x.add(Integer.valueOf(4));
    x.add(Integer.valueOf(5));
    List<Integer> y = new ArrayList<>();
//    x.add(Integer.valueOf(4));
    y.add(Integer.valueOf(5));
    
    azzert.assertEquals(the.last(x), Integer.valueOf(5));
    azzert.assertEquals(the.lastOf(x), Integer.valueOf(5));
    azzert.assertEquals(the.tailOf(x), y);
    azzert.assertEquals(the.lastOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(2) }), 2);
    azzert.assertEquals(the.tailOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(2) }), 
        new Integer[] { Integer.valueOf(2) });
    azzert.assertEquals(the.lastOf("Hello"), 'o');
    azzert.assertEquals(the.tailOf("Hello"), "ello");
    }
   
   @Test public void indexTest() {
    azzert.assertEquals(the.index(1,1,2,3,4), 0);  
    azzert.assertEquals(the.index(4,1,2,3,4), 3);  
    azzert.assertEquals(the.index(5,1,2,3,4), -1);  
   }
   
   @Test public void nilTest() {
     assert (the.nil() == null);
   }
   
   @Test public void nthTest() {
     List<Integer> x = new ArrayList<>();
     x.add(Integer.valueOf(4));
     x.add(Integer.valueOf(5));
     azzert.assertEquals(the.nth(6, x)," #6/2");
   }
   
   @Test public void lastOfTest() {
     List<Integer> x = new ArrayList<>();
//     x.add(Integer.valueOf(4));
     x.add(Integer.valueOf(5));
     for (Integer ¢ : the.lastOf((Iterable<Integer>) x)) 
       azzert.assertEquals( ¢,Integer.valueOf(5) );
     
   }
   
   @Test public void onlyOneOfTest() {
     List<Integer> x = new ArrayList<>();
     x.add(Integer.valueOf(4));
     azzert.assertEquals(the.onlyOneOf(x), Integer.valueOf(4));

     x.add(Integer.valueOf(5));
     azzert.assertEquals(the.onlyOneOf(x), null);
   }
}
