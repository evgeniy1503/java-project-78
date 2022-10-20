package hexlet.code.schemas;

import java.util.function.Predicate;

public class NumberSchema extends BaseSchema {

    public NumberSchema() {
        addValid(x -> x instanceof Integer);
    }

    public final NumberSchema required() {
        setRequired(true);
        return this;
    }

    public final NumberSchema positive() {
        Predicate<Integer> positive = x -> (x == null || x > 0);
        addValid(positive);
        return this;
    }

    public final void range(int from, int to) {
        Predicate<Integer> range = x -> from <= x && x <= to;
        addValid(range);
    }


}
