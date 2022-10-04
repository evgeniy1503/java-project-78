package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema() {
        clearValidList();
    }

    public final void required() {
        clearValidList();
        Predicate required = x -> x instanceof Map;
        addValid(required);
    }

    public final void sizeof(int pair) {
        clearValidList();
        Predicate<Map> sizeof = x -> x.size()  == pair;
        addValid(sizeof);
    }
}
