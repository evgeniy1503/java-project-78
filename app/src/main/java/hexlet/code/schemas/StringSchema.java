package hexlet.code.schemas;


import java.util.function.Predicate;

public class StringSchema extends BaseSchema {

    public StringSchema() {

        addValid(x -> x instanceof String);

    }
    public final StringSchema required() {

        Predicate<String> required = x -> x != null && !(x.isEmpty());
        addValid(required);
        setRequired(true);
        return this;

    }

    public final StringSchema contains(String str) {

        Predicate<String> contains = x -> x.contains(str);
        addValid(contains);
        return this;

    }

    public final void minLength(int number) {

        Predicate<String> minLength = x -> x.length() >= number;
        addValid(minLength);

    }

}

