package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StringSchema {

    private List<String> substrings = new ArrayList<>();
    private boolean contains = false;
    private boolean isEmpty = true;





    public boolean isValid(String text) {

        if (isEmpty && (text == null ||text.equals(""))) {
            return true;
        }

        if (!isEmpty && !text.isEmpty() && !contains) {
            return true;
        }
        if (contains) {
            for (String str : substrings) {
                if (!text.contains(str)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }


    public void required() {
        this.isEmpty = false;
    }

    public StringSchema contains(String str) {
        contains = true;
        substrings.add(str);
        return this;
    }

}

