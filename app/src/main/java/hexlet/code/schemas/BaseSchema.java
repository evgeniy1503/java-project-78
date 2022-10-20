package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public abstract class BaseSchema {

    private final List<Predicate> validList = new ArrayList<>();


    private boolean isRequired = false;

    public final boolean isValid(Object obj) {

        if (!isRequired && (obj == null || obj.equals(""))) {
            return true;
        }

        if (isRequired && obj == null) {
            return false;
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


    public final void setRequired(boolean required) {
        this.isRequired = required;
    }

}
