package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {

    private final List<Predicate> validList = new ArrayList<>();

    public final boolean isValid(Object obj) {
        if (obj == null || obj.equals("")) {
            return validList.size() == 0;
        }
        for (Predicate predicate : validList) {
            if (!predicate.test(obj)) {
                return false;
            }
        }
        return true;
    }

    public final void addValid(Predicate p) {
        validList.add(p);
    }

    public final void clearValidList() {
        validList.clear();
    }

}
