package hexlet.code.schemas;


import java.util.Objects;
import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        clearValidList();
    }

    public final void required() {
        clearValidList();
        Predicate<Integer> required = Objects::nonNull;
        addValid(required);
    }

    public final NumberSchema positive() {
        clearValidList();
        Predicate<Integer> positive = x -> x > 0;
        addValid(positive);
        return this;
    }

    public final void range(int from, int to) {
        clearValidList();
        Predicate<Integer> range = x -> from <= x && x <= to;
        addValid(range);
    }


}
