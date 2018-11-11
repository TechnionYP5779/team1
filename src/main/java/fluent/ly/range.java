package fluent.ly;

import java.util.*;
//import java.util.stream.*;

public class range {

  boolean empty;
  int from = -1;
<<<<<<< HEAD
  int to = -1;
  boolean infinite = false;


  public int from() {
    return from;
  }

  public static DidFrom from(int i) {
=======
  boolean infinite;

  public static range from(int ¢) {
    // TODO Auto-generated method stub
>>>>>>> 6ae3e018967bc8d7b5c7a9405c6d79a7a3760e77
    return new range() {
      {
        from = ¢;
        empty = false;
        infinite= true;
      }
    }. new DidFrom();
  }

  public boolean isEmpty() {
    return empty;
  }

  public boolean isInfinite() {
    // TODO Auto-generated method stub
    return infinite;
  }


  abstract class RangeIter<T extends RangeIter<T>> implements Iterable<Integer> {

    @Override public Iterator<Integer> iterator() {
      // TODO Auto-generated method stub
      return new Iterator<Integer>() {
        int current = from;

        @Override public boolean hasNext() {
//          System.out.println(to);
          return infinite || ( current < to);
        }

        @Override public Integer next() {
          
          if (!hasNext())
            throw new NoSuchElementException();
          final int $ = current;
          current++;
          return Integer.valueOf($);
        }
      };
    }
    
    abstract T This();

  }
  
  public class DidTo extends RangeIter<DidTo>{

    @Override DidTo This() {
      // TODO Auto-generated method stub
      return this;
    }
    
  }
  
  public class DidFrom extends RangeIter<DidFrom>{
    public DidTo to(final int t) {
      to = t;
      return new DidTo() {
        {
          infinite = false;
          to = t;
        }
      };
    }
    
    @Override DidFrom This() {
      // TODO Auto-generated method stub
      return this;
    }

<<<<<<< HEAD
    public boolean isInfinite() {
      // TODO Auto-generated method stub
      return infinite;
    }

    public boolean isEmpty() {
      // TODO Auto-generated method stub
      return empty;
    }

    public int from() {
      // TODO Auto-generated method stub
      return from;
    }
    
=======
  @SuppressWarnings("static-method") public Iterable<Integer> to(@SuppressWarnings("unused") int to) {
    return null;
//    return new Iterable<Integer>() {
//
//      @Override public Iterator<Integer> iterator() {
//        return new Iterator<>() {
//          int current = from;
//
//          @Override
//          public boolean hasNext() {
//            // validate if there is a next object
//            return current < to;
//          }
//
//          @Override
//          public Integer next() {
//            // get the next object and return it, throw an exception if there is no next object
//            return Integer.valueOf(current++);
//          }
//        };
//      }
//    };
>>>>>>> 6ae3e018967bc8d7b5c7a9405c6d79a7a3760e77
  }
  


  static public DidTo to(int i) {
    // TODO Auto-generated method stub
    return new range() {
      {
        to = i;
      }
    }. new DidTo();
  }


}
