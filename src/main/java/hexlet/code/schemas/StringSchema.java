package hexlet.code.schemas;


import java.util.function.Predicate;

public class StringSchema extends BaseSchema {


    public StringSchema() {
        clearValidList();
    }

    public final StringSchema required() {
        clearValidList();
        Predicate<String> required = x -> x != null && !x.equals("");
        addValid(required);
        return this;
    }

    public final StringSchema contains(String str) {
        Predicate<String> contains = x -> x != null && x.contains(str);
        addValid(contains);
        return this;
    }

    public final void minLength(int number) {
        clearValidList();
        Predicate<String> minLength = x -> x != null && x.length() >= number;
        addValid(minLength);
    }

}

