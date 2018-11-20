package fluent.ly;

import static fluent.ly.idiomatic.*;

import java.util.*;
import java.util.function.*;

import org.jetbrains.annotations.*;

import il.org.spartan.utils.*;

/**
 * @author Yossi Gil
 * @since 2017-04-28 */
public interface list {
  
  /**
   * This class is a representation of a unary operator over a list
   * e.g.: max of a list is a unary operator over a list
   * 
   * @author shai
   *
   * @param <T>
   * 
   */
  interface Operator<T> extends UnaryOperator<List<T>> {
    /**/}

  /**
   * This class is a convenient representation of a List of unary list operators. It allows
   * construction via a list of Operators or a copy c'tor.
   * The empty c'tor builds an empty list of operators.
   * 
   * @author shai
   *
   * @param <T>
   */
  class Operators<T> extends Outer<List<Operator<T>>> {
    /* Construction of an empty list of operators*/
    public Operators() {
      super(an.empty.list());
    }
    
    /* Construction via a list of operators*/
    public Operators(final List<Operator<T>> inner) {
      super(inner);
    }

    /* Construction via the same type - copying*/
    public Operators(final Operators<T> other) {
      this(other != null ? other.inner : an.empty.list());
    }
  }

  /**
   * This class extends the 'operator list' functionality by allowing it to also create and
   * register basic operators - append and prepend 
   * 
   * @author shai
   *
   * @param <T>
   */
  class PrependOrAppend<T> extends ToCallExpected<T> {
    public PrependOrAppend() {
      this(null);
    }

    public PrependOrAppend(final Operators<T> other) {
      super(other);
    }

    /* Register the append operator*/
    public ToCallExpected<T> append(final T x) {
      inner.add(λ -> {
        λ.add(x);
        return λ;
      });
      return new ToCallExpected<>(this);
    }

    /* Register the prepend operator*/
    public ToCallExpected<T> prepend(final T t) {
      inner.add(λ -> {
        λ.add(0, t);
        return λ;
      });
      return new ToCallExpected<>(this);
    }
  }

  /**
   * A class extending Operators with extended functionality 
   * such as applying and basic operator creation
   * 
   * @author shai
   *
   * @param <T>
   */
  class ToCallExpected<T> extends Operators<T> {
    public ToCallExpected(final Operators<T> other) {
      super(other);
    }

   /**
     *  A function transforming this instance to an 'Prepend or Append'.
     * 
     * @return an instance which will only allow the addition of a new operator,
     *  this operator is 'append' or 'prepend' - two unary functions on  a list.
     */
    public PrependOrAppend<T> to() {
      return new PrependOrAppend<>(this);
    }

    /**
     * Applying the operators stored on a list
     * 
     * @param xs - a list of elements
     * @return a new list, which is the combined results of applying all the operators on xs
     */
    public List<T> to(final List<T> xs) {
      List<T> $ = new ArrayList<>(xs);
      for (final Operator<T> ¢ : inner)
        $ = ¢.apply($);
      return $;
    }
  }

  /**
   * Creates a new operator list for List<T>, containing only one operator.
   * That operator will append ¢ to the end of the list.
   * 
   * @param <T>
   * @param ¢ - an element of the list's type.
   * @return - a new operator list of size one
   */
  static <T> ToCallExpected<T> append(final T ¢) {
    return new PrependOrAppend<T>().append(¢);
  }

  /**
   * Creates a new operator list for List<T>, containing only one operator.
   * That operator will add ¢ to the beginning of the list.
   * It is named 'prepend'
   * 
   * @param <T>
   * @param ¢ - an element of the list's type.
   * @return - a new operator list of size one
   */
  static <T> ToCallExpected<T> prepend(final T ¢) {
    return new PrependOrAppend<T>().prepend(¢);
  }

  /** @param <T> JD
   * @param ¢ a list
   * @return an operator returning the last item in a list or <code><b>null</b></code> if the parameter is
   *         <code><b>null</b></code> or empty */
  static <T> @Nullable T penultimate(final List<T> ¢) {
    return eval(() -> ¢.get(¢.size() - 2)).unless(¢ == null || ¢.size() < 2);
  }
}
