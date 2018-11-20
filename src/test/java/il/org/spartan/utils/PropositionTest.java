package il.org.spartan.utils;

import static il.org.spartan.utils.Proposition.*;
import static il.org.spartan.utils.Proposition.not;
import static il.org.spartan.utils.Proposition.that;

import static fluent.ly.azzert.*;

import java.util.function.*;

import org.jetbrains.annotations.*;
import org.junit.*;

import fluent.ly.*;

@SuppressWarnings("static-method") public class PropositionTest {
  @Test public void staticAndLogic() {
    assert AND(() -> true, () -> true).getAsBoolean();
    assert !AND(() -> false, () -> true).getAsBoolean();
    assert !AND(() -> true, () -> false).getAsBoolean();
    assert !AND(() -> false, () -> false).getAsBoolean();
  }

  @Test public void staticOrLogic() {
    assert OR(() -> true, () -> true).getAsBoolean();
    assert OR(() -> false, () -> true).getAsBoolean();
    assert OR(() -> true, () -> false).getAsBoolean();
    assert !OR(() -> false, () -> false).getAsBoolean();
  }

  @Test public void staticNotLogic() {
    assert !not(() -> true).getAsBoolean();
    assert not(() -> false).getAsBoolean();
  }

  @Test public void booleanOpLogic() {
    assert Proposition.T.and(() -> true).eval();
    assert !Proposition.T.and(() -> false).eval();
    assert that(() -> true).and(() -> true).eval();
    assert !that(() -> true).and(() -> false).eval();
    assert Proposition.T.or(() -> true).eval();
    assert Proposition.T.or(() -> false).eval();
    assert that(() -> true).or(() -> true).eval();
    assert that(() -> true).or(() -> false).eval();
    assert !Proposition.F.and(() -> true).eval();
    assert !Proposition.F.and(() -> false).eval();
    assert !that(() -> false).and(() -> true).eval();
    assert !that(() -> false).and(() -> false).eval();
    assert Proposition.F.or(() -> true).eval();
    assert !Proposition.F.or(() -> false).eval();
    assert that(() -> false).or(() -> true).eval();
    assert !that(() -> false).or(() -> false).eval();
  }

  @Test(expected = AssertionError.class) public void failToExecuteDueToAssertionError() {
    Proposition.X.getAsBoolean();
  }

  @Test(expected = NullPointerException.class) public void failToExecuteDueToNullPointerException() {
    Proposition.N.getAsBoolean();
  }

  @Test public void and() {
    assert !new And(() -> true, new @NotNull BooleanSupplier[] {}).and(() -> true).or("Some Name", () -> false).and(() -> true, () -> false)
        .getAsBoolean();
  }

  @Test public void or() {
    assert new Or(() -> true, () -> false).or(() -> false).and("Some Name", () -> true).getAsBoolean();
  }

  @Test public void combineNames() {
    azzert.that(AND("2", () -> true, () -> true, new @NotNull BooleanSupplier[] { () -> true })
        .and(OR("1", () -> true, () -> false, new @NotNull BooleanSupplier[] {})) + "", is("null, 2"));
  }
}
