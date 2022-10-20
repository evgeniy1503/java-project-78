package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {


    public MapSchema() {
        addValid(x -> x instanceof Map<?, ?>);
    }

    public final void required() {
        setRequired(true);
    }



    public final void sizeof(int size) {
        Predicate<Map> sizeof = x -> x.size()  == size;
        addValid(sizeof);
    }

    public final MapSchema shape(Map<String, BaseSchema> map) {
        Predicate<Map> shape = x -> checkValid(x, map);
        addValid(shape);
        return this;
    }

    public final boolean checkValid(Map<String, String> data, Map<String, BaseSchema> map) {

        for (Map.Entry<String, BaseSchema> item : map.entrySet()) {
            String key = item.getKey();
            if (data.containsKey(key) && !(item.getValue().isValid(data.get(key)))) {
                return false;
            }
        }

        return true;
    }
}
