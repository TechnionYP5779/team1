package fluent.ly;

import java.util.*;

import org.jetbrains.annotations.*;
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
   
   @Test public void lastTailTest() {
     @Nullable List< @Nullable Integer> x = new ArrayList<>();
    x.add(Integer.valueOf(4));
    x.add(Integer.valueOf(5));
    @Nullable List< @Nullable Integer> y = new ArrayList<>();
    y.add(Integer.valueOf(5));
    
    azzert.assertEquals(the.last(x), Integer.valueOf(5));
    azzert.assertEquals(the.lastOf(x), Integer.valueOf(5));
    azzert.assertEquals(the.tailOf(x), y);
    azzert.assertEquals(the.lastOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(2) }), 2);
    azzert.assertEquals(the.tailOf(new Integer[] { Integer.valueOf(5), Integer.valueOf(2) })[0],  Integer.valueOf(2) );
    azzert.assertEquals(the.lastOf("Hello"), 'o');
    azzert.assertEquals(the.tailOf("Hello"), "ello");
    }
   
   @Test public void indexTest() {
    azzert.assertEquals(the.index(1,1,2,3,4), 0);  
    azzert.assertEquals(the.index(4,1,2,3,4), 3);  
    azzert.assertEquals(the.index(5,1,2,3,4), -1);  
   }
   
   @Test public void nilTest() {
     azzert.assertTrue(the.nil()==null); 
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
   
   @Test public void listTest() {
     @Nullable List< @Nullable Integer> x = new ArrayList<>();
     x.add(Integer.valueOf(4));
     x.add(Integer.valueOf(5));
     @Nullable List< @Nullable Integer> y = new ArrayList<>();
     y.add(Integer.valueOf(5));
     azzert.assertTrue(the.penultimateOf(null)==null);
     azzert.assertTrue(the.previous(Integer.valueOf(5),null)==null);
     azzert.assertEquals(the.previous(Integer.valueOf(5),x),Integer.valueOf(4));
     azzert.assertEquals(the.secondOf(x),Integer.valueOf(5));
     azzert.assertEquals(the.rest(Integer.valueOf(3), x),  an.empty.list());
     azzert.assertEquals(the.rest(Integer.valueOf(4), x), y );
     
   }
   
   @Test public void charTest() {
     azzert.assertEquals(the.characterOf("hello"),'o');
     azzert.assertEquals(the.ith("hello",2),'l');
   }
   
}
