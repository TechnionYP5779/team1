package a;

import java.util.*;

import org.jetbrains.annotations.*;

import fluent.ly.*;

/** Singleton collections.
 * @author Ori Roth
 * @since 2017-04-16 */
public interface singleton {
  /** Singleton list. */
  static <T> @NotNull List<T> list(@NotNull final T ¢) {
    return as.list(¢);
  }

  /** Singleton array. */
  static <T> T[] array(final T ¢) {
    // ofir's comment
    return as.array(¢);
  }
}
