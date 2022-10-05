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

    public final MapSchema shape(Map<String, BaseSchema> map) {
        clearValidList();
        Predicate<Map> shape = x -> checkValid(map, x);
        addValid(shape);
        return this;
    }

    public final boolean checkValid(Map<String, BaseSchema> map, Map<String, String> data) {

        for (Map.Entry<String, BaseSchema> item : map.entrySet()) {
            String key = item.getKey();
            BaseSchema value = item.getValue();
            String dataValue = data.get(key);
            return value.isValid(dataValue);

        }
        return false;
    }
}
